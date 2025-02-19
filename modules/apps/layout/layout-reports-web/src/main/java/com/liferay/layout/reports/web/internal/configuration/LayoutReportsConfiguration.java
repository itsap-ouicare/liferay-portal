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

package com.liferay.layout.reports.web.internal.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Sarai Díaz
 */
@ExtendedObjectClassDefinition(
	category = "pages", scope = ExtendedObjectClassDefinition.Scope.COMPANY
)
@Meta.OCD(
	id = "com.liferay.layout.reports.web.internal.configuration.LayoutReportsConfiguration",
	localization = "content/Language",
	name = "layout-reports-configuration-name"
)
public interface LayoutReportsConfiguration {

	@Meta.AD(deflt = "false", required = false)
	public boolean enabled();

	@Meta.AD(required = false)
	public String apiKey();

}