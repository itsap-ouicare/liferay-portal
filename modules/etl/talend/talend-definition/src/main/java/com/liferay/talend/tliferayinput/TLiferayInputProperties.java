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

package com.liferay.talend.tliferayinput;

import com.liferay.talend.LiferayBaseComponentDefinition;
import com.liferay.talend.connection.LiferayConnectionProperties;
import com.liferay.talend.connection.LiferayConnectionResourceBaseProperties;
import com.liferay.talend.exception.ExceptionUtils;
import com.liferay.talend.runtime.LiferaySourceOrSinkRuntime;
import com.liferay.talend.runtime.ValidatedSoSSandboxRuntime;
import com.liferay.talend.utils.PropertiesUtils;
import com.liferay.talend.utils.URIUtils;

import java.io.IOException;

import java.net.URI;

import java.util.Collections;
import java.util.Set;

import org.apache.avro.Schema;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.talend.components.api.component.PropertyPathConnector;
import org.talend.daikon.properties.PresentationItem;
import org.talend.daikon.properties.ValidationResult;
import org.talend.daikon.properties.ValidationResultMutable;
import org.talend.daikon.properties.presentation.Form;
import org.talend.daikon.properties.presentation.Widget;

/**
 * @author Zoltán Takács
 */
public class TLiferayInputProperties
	extends LiferayConnectionResourceBaseProperties {

	public TLiferayInputProperties(String name) {
		super(name);
	}

	/**
	 * Refreshes form after "Guess Schema" button was processed
	 *
	 * @review
	 */
	public void afterGuessSchema() {
		if (_log.isDebugEnabled()) {
			_log.debug("Selected Endpoint: " + resource.endpoint.getValue());
		}

		refreshLayout(getForm(Form.MAIN));
	}

	@Override
	public void refreshLayout(Form form) {
		super.refreshLayout(form);

		String formName = form.getName();

		if (formName.equals(Form.MAIN) ||
			formName.equals(LiferayConnectionProperties.FORM_WIZARD)) {

			PropertiesUtils.setHidden(form, guessSchema, true);
		}
	}

	@Override
	public void setupLayout() {
		super.setupLayout();

		Form mainForm = getForm(Form.MAIN);

		Widget guessButtonWidget = Widget.widget(guessSchema);

		guessButtonWidget.setLongRunning(true);
		guessButtonWidget.setWidgetType(Widget.BUTTON_WIDGET_TYPE);

		mainForm.addRow(guessButtonWidget);
	}

	@Override
	public void setupProperties() {
		super.setupProperties();
	}

	public ValidationResult validateGuessSchema() {
		ValidatedSoSSandboxRuntime validatedSoSSandboxRuntime =
			LiferayBaseComponentDefinition.initializeSandboxedRuntime(
				getEffectiveLiferayConnectionProperties());

		ValidationResultMutable validationResultMutable =
			validatedSoSSandboxRuntime.getValidationResultMutable();

		if (validationResultMutable.getStatus() ==
				ValidationResult.Result.ERROR) {

			return validationResultMutable;
		}

		LiferaySourceOrSinkRuntime liferaySourceOrSinkRuntime =
			validatedSoSSandboxRuntime.getLiferaySourceOrSinkRuntime();

		if (validationResultMutable.getStatus() == ValidationResult.Result.OK) {
			try {
				URI resourceURI = URIUtils.setPaginationLimitOnURL(
					resource.endpoint.getValue(), 1);

				String resourceCollectionType = "type";

				Schema runtimeSchema =
					liferaySourceOrSinkRuntime.getResourceSchemaByType(
						resourceCollectionType);

				resource.main.schema.setValue(runtimeSchema);
			}
			catch (IOException ioe) {
				return ExceptionUtils.exceptionToValidationResult(ioe);
			}
		}

		return validationResultMutable;
	}

	public transient PresentationItem guessSchema = new PresentationItem(
		"guessSchema");

	@Override
	protected Set<PropertyPathConnector> getAllSchemaPropertiesConnectors(
		boolean outputConnectors) {

		if (outputConnectors) {
			return Collections.singleton(mainConnector);
		}

		return Collections.<PropertyPathConnector>emptySet();
	}

	private static final Logger _log = LoggerFactory.getLogger(
		TLiferayInputProperties.class);

	private static final long serialVersionUID = 8010931662185868407L;

}