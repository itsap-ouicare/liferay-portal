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

import {useTimeout} from 'frontend-js-react-web';
import PropTypes from 'prop-types';
import React, {useEffect, useReducer, useRef, useState} from 'react';

import NodeList from './NodeList';
import TreeviewCard from './TreeviewCard';
import TreeviewContext from './TreeviewContext';
import TreeviewLabel from './TreeviewLabel';

/**
 * Adds parent, sibling and child links to make tree traversal in any
 * direction easy.
 */
function addLinks(nodes, parentId = null) {
	return nodes.map((node, i) => {
		const [previous, next] = [nodes[i - 1], nodes[i + 1]];

		const children = node.children ? addLinks(node.children, node.id) : [];

		return {
			...node,
			children,
			nextSiblingId: next != null ? next.id : null,
			parentId,
			previousSiblingId: previous != null ? previous.id : null
		};
	});
}

function filterNodes(nodes, filterQuery) {
	if (!filterQuery) {
		return null;
	}

	filterQuery = filterQuery.toLowerCase();

	const filteredNodes = [];

	nodes.forEach(node => {
		if (node.name.toLowerCase().indexOf(filterQuery) !== -1) {
			filteredNodes.push({
				...node,
				children: []
			});
		}

		filteredNodes.push(...filterNodes(node.children, filterQuery));
	});

	return filteredNodes;
}

/**
 * Finds the deepest visible node in the subtree rooted at `node`.
 */
function getLastVisible(node) {
	const childCount = node.children.length;

	if (!node.expanded || !childCount) {
		return node;
	} else {
		return getLastVisible(node.children[childCount - 1]);
	}
}

function init({
	filterQuery,
	initialNodes,
	initialSelectedNodeIds,
	multiSelection
}) {
	const selectedNodeIds = new Set(initialSelectedNodeIds);

	const nodeMap = {};

	const nodes = addLinks(initialNodes).map(node => {
		return visit(
			node,
			node => {
				const expanded = node.children.some(child => {
					return child.expanded || child.selected;
				});

				const selected = selectedNodeIds.has(node.id);

				return {
					...node,
					expanded,
					selected
				};
			},
			nodeMap
		);
	});

	return {
		active: false,
		filterQuery,
		filteredNodes: filterNodes(nodes, filterQuery),
		focusedNodeId: null,
		multiSelection,
		nodeMap,
		nodes,
		selectedNodeIds
	};
}

function updateNode(state, id, callback) {
	const {nodeMap} = state;

	if (!nodeMap[id]) {
		throw new Error(`Could not get node with id ${id}`); // undefined
	}

	let node = callback(nodeMap[id]);

	if (node === nodeMap[id]) {
		// Node didn't change, so leave state as-is.
		return state.nodes;
	}

	nodeMap[id] = node;

	// Walk back to root updating subtrees.
	while (node.parentId) {
		const parent = nodeMap[node.parentId];

		node = {
			...parent,
			children: parent.children.map(child => {
				return child.id === node.id ? node : child;
			})
		};

		nodeMap[node.id] = node;
	}

	return state.nodes.map(child => {
		return child.id === node.id ? node : child;
	});
}

function reducer(state, action) {
	const {filteredNodes, nodeMap} = state;

	const nodes = filteredNodes || state.nodes;

	switch (action.type) {
		case 'ACTIVATE': {
			const focusedNodeId =
				state.focusedNodeId || (nodes[0] && nodes[0].id);

			return {
				...state,
				active: true,
				focusedNodeId
			};
		}

		case 'DEACTIVATE':
			return {
				...state,
				active: false
			};

		case 'COLLAPSE':
			// eg double click
			if (!filteredNodes) {
				return {
					...state,
					nodes: updateNode(state, action.nodeId, node => {
						return node.expanded
							? {
									...node,
									expanded: false
							  }
							: node;
					})
				};
			}
			break;

		case 'SELECT_ROOT':
			{
				const rootId = nodes[0] && nodes[0].id;

				if (state.focusedNodeId !== rootId) {
					return {
						...state,
						focusedNodeId: rootId
					};
				}
			}
			break;

		case 'SELECT_NEXT_VISIBLE':
			{
				let node = nodeMap[action.nodeId];

				if (filteredNodes) {
					for (let i = 0; i < filteredNodes.length - 1; i++) {
						if (filteredNodes[i].id === state.focusedNodeId) {
							node = nodes[i + 1];
							break;
						}
					}
				} else {
					while (node) {
						if (node.id !== action.nodeId) {
							// Not the first iteration and we found a match: done.
							break;
						}

						if (node.expanded && node.children.length) {
							// Expanded, so go to first visible child.
							node = node.children[0];
							break;
						}

						// No visible children, so go to first visible sibling.
						if (node.nextSiblingId) {
							node = nodeMap[node.nextSiblingId];
							continue;
						}

						// As last resort, go to parent's sibling.
						if (node.parentId) {
							const nextId = nodeMap[node.parentId].nextSiblingId;

							if (nextId) {
								node = nodeMap[nextId];
								continue;
							}
						}

						// Give up.
						node = null;
						break;
					}
				}

				if (node) {
					return {
						...state,
						focusedNodeId: node.id
					};
				}
			}
			break;

		case 'SELECT_PREVIOUS_VISIBLE':
			{
				let node = nodeMap[action.nodeId];

				if (filteredNodes) {
					for (let i = 1; i < filteredNodes.length; i++) {
						if (filteredNodes[i].id === state.focusedNodeId) {
							node = nodes[i - 1];
							break;
						}
					}
				} else {
					while (node) {
						if (node.id !== action.nodeId) {
							break;
						}

						if (node.previousSiblingId) {
							node = getLastVisible(
								nodeMap[node.previousSiblingId]
							);

							break;
						} else {
							// Go to parent.
							node = nodeMap[node.parentId];
							break;
						}
					}
				}

				if (node) {
					return {
						...state,
						focusedNodeId: node.id
					};
				}
			}
			break;

		case 'SELECT_LAST_VISIBLE':
			{
				const lastIndex = nodes.length - 1;

				let lastId;

				if (filteredNodes) {
					lastId = nodes[lastIndex] && nodes[lastIndex].id;
				} else {
					let node = nodes[lastIndex];

					while (node) {
						if (node.children.length && node.expanded) {
							node = node.children[node.children.length - 1];
						} else {
							break;
						}
					}

					lastId = node && node.id;
				}

				if (lastId && state.focusedNodeId !== lastId) {
					return {
						...state,
						focusedNodeId: lastId
					};
				}
			}
			break;

		case 'TOGGLE_EXPANDED':
			// Toggles the expanded or collapsed state of the selected
			// parent node. eg. by double clicking; doesn't select a child.
			if (!filteredNodes) {
				return {
					...state,
					nodes: updateNode(state, action.nodeId, node => {
						return {
							...node,
							expanded: !node.expanded
						};
					})
				};
			}
			break;

		case 'EXPAND_ALL':
			{
				if (!filteredNodes) {
					const nodes = state.nodes.map(node =>
						visit(
							node,
							node =>
								!node.expanded
									? {
											...node,
											expanded: true
									  }
									: node,
							nodeMap
						)
					);

					return {
						...state,
						nodes
					};
				}
			}
			break;

		case 'FILTER':
			return {
				...state,
				filterQuery: action.filterQuery,
				filteredNodes: filterNodes(state.nodes, action.filterQuery),
				focusedNodeId: null
			};

		case 'FOCUS':
			if (action.nodeId !== state.focusedNodeId) {
				return {
					...state,
					focusedNodeId: action.nodeId
				};
			}
			break;

		case 'COLLAPSE_PARENT':
			{
				// Collapse the currently selected parent node if it is
				// expanded; otherwise move to the previous parent node
				// (if possible).
				if (!filteredNodes) {
					const node = nodeMap[action.nodeId];

					if (node.expanded) {
						return {
							...state,
							nodes: updateNode(state, action.nodeId, node => {
								return {
									...node,
									expanded: false
								};
							})
						};
					} else if (node.parentId) {
						return {
							...state,
							focusedNodeId: node.parentId
						};
					}
				}
			}
			break;

		case 'EXPAND_AND_ENTER':
			{
				// Expand the currently selected parent node if it is closed;
				// move to the first child list item if it was already expanded.
				if (!filteredNodes) {
					const node = nodeMap[action.nodeId];

					if (!node.expanded) {
						return {
							...state,
							nodes: updateNode(state, action.nodeId, node => {
								return {
									...node,
									expanded: true
								};
							})
						};
					} else if (node.children.length) {
						return {
							...state,
							focusedNodeId: node.children[0].id
						};
					}
				}
			}
			break;

		case 'TOGGLE_SELECT': {
			const id = action.nodeId;

			if (!nodeMap[id].disabled) {
				const {multiSelection} = state;

				let {selectedNodeIds} = state;

				if (selectedNodeIds.has(id)) {
					selectedNodeIds = new Set(
						[...selectedNodeIds].filter(
							selectedId => selectedId !== id
						)
					);
				} else if (multiSelection) {
					selectedNodeIds = new Set([...selectedNodeIds, id]);
				} else {
					selectedNodeIds = new Set([id]);
				}

				return {
					...state,
					focusedNodeId: id,
					nodes: state.nodes.map(node =>
						visit(
							node,
							node => {
								if (
									node.selected !==
									selectedNodeIds.has(node.id)
								) {
									return {
										...node,
										selected: !node.selected
									};
								} else {
									return node;
								}
							},
							nodeMap
						)
					),
					selectedNodeIds
				};
			}
			break;
		}

		case 'EXIT':
			// Navigate away from tree.
			break;

		default:
			break;
	}

	return state;
}

/**
 * Visits the tree represented by `node`, passing each visited node to
 * `callback`, which should return an updated node and update the `nodeMap`
 * cache.
 *
 * If `callback` returns the same node, no actual copies are made.
 */
function visit(node, callback, nodeMap) {
	const {children} = node;

	let nextChildren;

	for (let i = 0; i < children.length; i++) {
		const child = children[i];
		const updated = visit(child, callback, nodeMap);

		if (nextChildren) {
			nextChildren.push(updated);
		} else if (updated !== child) {
			nextChildren = children.slice(0, i).concat([updated]);
		}
	}

	const nextNode = callback(
		nextChildren ? {...node, children: nextChildren} : node
	);

	if (nextNode !== node) {
		nodeMap[nextNode.id] = nextNode;
	}

	return nextNode;
}

function Treeview({
	NodeComponent,
	filterQuery,
	initialSelectedNodeIds,
	multiSelection,
	nodes: initialNodes,
	onSelectedNodesChange
}) {
	const delay = useTimeout();

	const focusTimer = useRef();

	const [, setHasFocus] = useState(false);

	const [state, dispatch] = useReducer(
		reducer,
		{
			filterQuery,
			initialNodes,
			initialSelectedNodeIds,
			multiSelection
		},
		init
	);

	const {filteredNodes, nodes, selectedNodeIds} = state;

	useEffect(() => {
		dispatch({filterQuery, type: 'FILTER'});
	}, [filterQuery]);

	useEffect(() => {
		if (onSelectedNodesChange) {
			onSelectedNodesChange(selectedNodeIds);
		}
	}, [onSelectedNodesChange, selectedNodeIds]);

	const cancelTimer = () => {
		if (focusTimer.current) {
			focusTimer.current();
			focusTimer.current = null;
		}
	};

	const handleFocus = () => {
		cancelTimer();

		setHasFocus(hadFocus => {
			if (!hadFocus) {
				dispatch({type: 'ACTIVATE'});
			}

			return true;
		});
	};

	const handleBlur = () => {
		cancelTimer();

		// Due to React's event bubbling, we may get a "focus" event
		// immediately after this "blur" (eg. when moving around inside
		// the treeview); so, we defer this state update until the next
		// tick, giving us a chance to cancel it if needed.
		focusTimer.current = delay(() => {
			setHasFocus(hadFocus => {
				if (hadFocus) {
					dispatch({type: 'DEACTIVATE'});
				}

				return false;
			});
		}, 0);
	};

	return (
		<TreeviewContext.Provider value={{dispatch, state}}>
			<NodeList
				NodeComponent={NodeComponent}
				nodes={filteredNodes || nodes}
				onBlur={handleBlur}
				onFocus={handleFocus}
				role="tree"
				tabIndex={0}
			/>
		</TreeviewContext.Provider>
	);
}

Treeview.defaultProps = {
	NodeComponent: TreeviewLabel,
	multiSelection: true
};

Treeview.propTypes = {
	NodeComponent: PropTypes.func,
	initialSelectedNodeIds: PropTypes.arrayOf(PropTypes.string),
	multiSelection: PropTypes.bool,
	nodes: PropTypes.arrayOf(
		PropTypes.shape({
			children: PropTypes.array,
			id: PropTypes.string.isRequired
		})
	).isRequired,
	onSelectedNodesChange: PropTypes.func
};

Treeview.Card = TreeviewCard;
Treeview.Label = TreeviewLabel;

export default Treeview;
