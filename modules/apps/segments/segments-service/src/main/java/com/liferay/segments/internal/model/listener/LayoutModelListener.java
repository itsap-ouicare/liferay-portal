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

package com.liferay.segments.internal.model.listener;

import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.service.ClassNameLocalService;
import com.liferay.segments.model.SegmentsExperience;
import com.liferay.segments.service.SegmentsExperienceLocalService;

import java.util.Objects;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author David Arques
 */
@Component(service = ModelListener.class)
public class LayoutModelListener extends BaseModelListener<Layout> {

	@Override
	public void onAfterCreate(Layout layout) throws ModelListenerException {
		if (!_isContentLayout(layout)) {
			return;
		}

		try {
			_segmentsExperienceLocalService.addDefaultSegmentsExperience(
				layout.getGroupId(),
				_classNameLocalService.getClassNameId(Layout.class),
				layout.getPlid());
		}
		catch (Exception e) {
			throw new ModelListenerException(e);
		}
	}

	@Override
	public void onAfterRemove(Layout layout) throws ModelListenerException {
		if (!_isContentLayout(layout)) {
			return;
		}

		try {
			_segmentsExperienceLocalService.deleteSegmentsExperiences(
				layout.getGroupId(),
				_classNameLocalService.getClassNameId(Layout.class),
				layout.getPlid());
		}
		catch (Exception e) {
			throw new ModelListenerException(e);
		}
	}

	@Override
	public void onAfterUpdate(Layout layout) throws ModelListenerException {
		if (!_isContentLayout(layout)) {
			return;
		}

		try {
			SegmentsExperience segmentsExperience =
				_segmentsExperienceLocalService.fetchDefaultSegmentsExperience(
					layout.getGroupId(),
					_classNameLocalService.getClassNameId(Layout.class),
					layout.getPlid());

			if (segmentsExperience != null) {
				return;
			}

			_segmentsExperienceLocalService.addDefaultSegmentsExperience(
				layout.getGroupId(),
				_classNameLocalService.getClassNameId(Layout.class),
				layout.getPlid());
		}
		catch (Exception e) {
			throw new ModelListenerException(e);
		}
	}

	private boolean _isContentLayout(Layout layout) {
		if (Objects.equals(layout.getType(), LayoutConstants.TYPE_CONTENT)) {
			return true;
		}

		return false;
	}

	@Reference
	private ClassNameLocalService _classNameLocalService;

	@Reference
	private SegmentsExperienceLocalService _segmentsExperienceLocalService;

}