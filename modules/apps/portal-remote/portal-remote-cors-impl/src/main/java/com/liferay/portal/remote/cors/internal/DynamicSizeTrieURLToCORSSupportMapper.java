/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.remote.cors.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Arthur Chan
 * @author Carlos Sierra Andrés
 */
public class DynamicSizeTrieURLToCORSSupportMapper
	extends BaseTrieURLToCORSSupportMapper {

	public DynamicSizeTrieURLToCORSSupportMapper(
		Map<String, CORSSupport> corsSupports) {

		_extensionTrieNode = _trieNodeHeap.nextAvailableTrieNode();
		_wildCardTrieNode = _trieNodeHeap.nextAvailableTrieNode();

		for (Map.Entry<String, CORSSupport> entry : corsSupports.entrySet()) {
			put(entry.getValue(), entry.getKey());
		}
	}

	@Override
	protected CORSSupport getExtensionCORSSupport(String urlPath) {
		TrieNode currentTrieNode = null;
		TrieNode previousTrieNode = _extensionTrieNode;

		for (int i = 0; i < urlPath.length(); ++i) {
			int index = urlPath.length() - 1 - i;

			char character = urlPath.charAt(index);

			if (character == '/') {
				break;
			}

			currentTrieNode = previousTrieNode.getNextTrieNode(character);

			if (currentTrieNode == null) {
				break;
			}

			if (urlPath.charAt(index) == '.') {
				TrieNode nextTrieNode = currentTrieNode.getNextTrieNode('*');

				if ((nextTrieNode != null) && nextTrieNode.isEnd()) {
					return nextTrieNode.getCORSSupport();
				}
			}

			previousTrieNode = currentTrieNode;
		}

		return null;
	}

	@Override
	protected CORSSupport getWildcardCORSSupport(String urlPath) {
		boolean onlyExact = false;
		boolean onlyWildcard = false;

		if (urlPath.charAt(0) != '/') {
			onlyExact = true;
		}
		else if ((urlPath.length() > 1) &&
				 (urlPath.charAt(urlPath.length() - 2) == '/') &&
				 (urlPath.charAt(urlPath.length() - 1) == '*')) {

			onlyWildcard = true;
		}

		CORSSupport corsSupport = null;
		TrieNode currentTrieNode = null;
		TrieNode previousTrieNode = _wildCardTrieNode;

		for (int i = 0; i < urlPath.length(); ++i) {
			currentTrieNode = previousTrieNode.getNextTrieNode(urlPath.charAt(i));

			if (currentTrieNode == null) {
				break;
			}

			if (!onlyExact && (urlPath.charAt(i) == '/')) {
				TrieNode nextTrieNode = currentTrieNode.getNextTrieNode('*');

				if ((nextTrieNode != null) && nextTrieNode.isEnd()) {
					corsSupport = nextTrieNode.getCORSSupport();
				}
			}

			previousTrieNode = currentTrieNode;
		}

		if (currentTrieNode != null) {
			if (onlyExact) {
				if (!currentTrieNode.isEnd()) {
					return null;
				}

				return currentTrieNode.getCORSSupport();
			}

			if (!onlyWildcard && currentTrieNode.isEnd()) {
				return currentTrieNode.getCORSSupport();
			}

			currentTrieNode = currentTrieNode.getNextTrieNode('/');

			if (currentTrieNode != null) {
				currentTrieNode = currentTrieNode.getNextTrieNode('*');

				if ((currentTrieNode != null) && currentTrieNode.isEnd()) {
					corsSupport = currentTrieNode.getCORSSupport();
				}
			}
		}

		return corsSupport;
	}

	@Override
	protected void put(
		CORSSupport corsSupport, String urlPattern, boolean wildcard) {

		TrieNode previousTrieNode = null;

		if (wildcard) {
			previousTrieNode = _wildCardTrieNode;
		}
		else {
			previousTrieNode = _extensionTrieNode;
		}

		TrieNode currentTrieNode = null;

		for (int i = 0; i < urlPattern.length(); ++i) {
			int index = i;

			if (!wildcard) {
				index = urlPattern.length() - 1 - i;
			}

			currentTrieNode = previousTrieNode.getNextTrieNode(urlPattern.charAt(index));

			if (currentTrieNode == null) {
				TrieNode nextTrieNode = _trieNodeHeap.nextAvailableTrieNode();

				currentTrieNode = previousTrieNode.setNextTrieNode(
					urlPattern.charAt(index), nextTrieNode);
			}

			previousTrieNode = currentTrieNode;
		}

		if (currentTrieNode != null) {
			currentTrieNode.setCORSSupport(corsSupport);
		}
	}

	private final TrieNode _extensionTrieNode;
	private final TrieNodeHeap _trieNodeHeap = new TrieNodeHeap();
	private final TrieNode _wildCardTrieNode;

	private class TrieNode {

		public TrieNode() {
			_trieNodes = new ArrayList<>(ASCII_CHARACTER_RANGE);

			for (int i = 0; i < ASCII_CHARACTER_RANGE; ++i) {
				_trieNodes.add(null);
			}
		}

		public CORSSupport getCORSSupport() {
			return _corsSupport;
		}

		public boolean isEnd() {
			if (_corsSupport != null) {
				return true;
			}

			return false;
		}

		public TrieNode getNextTrieNode(char character) {
			return _trieNodes.get(character - ASCII_PRINTABLE_OFFSET);
		}

		public void setCORSSupport(CORSSupport corsSupport) {
			_corsSupport = corsSupport;
		}

		public TrieNode setNextTrieNode(char character, TrieNode nextTrieNode) {
			_trieNodes.set(character - ASCII_PRINTABLE_OFFSET, nextTrieNode);

			return nextTrieNode;
		}

		private CORSSupport _corsSupport;
		private final List<TrieNode> _trieNodes;

	}

	private class TrieNodeHeap {

		public TrieNodeHeap() {
			for (int i = 0; i < _SIZE; ++i) {
				_trieNodes.add(new TrieNode());
			}
		}

		public TrieNode nextAvailableTrieNode() {
			if (_nextAvailableTrieNodeIndex >= _trieNodes.size()) {
				_trieNodes.ensureCapacity(_trieNodes.size() + _SIZE);

				for (int i = 0; i < _SIZE; ++i) {
					_trieNodes.add(new TrieNode());
				}
			}

			return _trieNodes.get(_nextAvailableTrieNodeIndex++);
		}

		private static final int _SIZE = 1024;

		private int _nextAvailableTrieNodeIndex;
		private ArrayList<TrieNode> _trieNodes = new ArrayList<>(_SIZE);

	}

}