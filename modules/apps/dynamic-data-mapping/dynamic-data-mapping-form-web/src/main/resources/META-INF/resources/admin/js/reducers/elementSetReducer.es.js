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

import {FieldUtil} from 'dynamic-data-mapping-form-builder';
import {FormSupport, PagesVisitor} from 'dynamic-data-mapping-form-renderer';

import {EVENT_TYPES} from '../eventTypes.es';

/**
 * NOTE: This is a literal copy of the old LayoutProvider logic. Small changes
 * were made only to adapt to the reducer.
 */
export default (state, action) => {
	switch (action.type) {
		case EVENT_TYPES.ELEMENT_SET_ADD: {
			const {fieldSetPages, indexes} = action.payload;
			const {pages} = state;
			const {pageIndex, rowIndex} = indexes;

			const visitor = new PagesVisitor(fieldSetPages);

			const newFieldsetPages = visitor.mapFields((field) => {
				const name = FieldUtil.generateFieldName(
					pages,
					field.fieldName
				);

				const settingsContextVisitor = new PagesVisitor(
					field.settingsContext.pages
				);

				return {
					...field,
					fieldName: name,
					fieldReference: name,
					settingsContext: {
						...field.settingsContext,
						pages: settingsContextVisitor.mapFields(
							(settingsContextField) => {
								if (
									settingsContextField.fieldName ===
										'fieldReference' ||
									settingsContextField.fieldName === 'name'
								) {
									settingsContextField = {
										...settingsContextField,
										value: name,
									};
								}

								return settingsContextField;
							}
						),
					},
				};
			});

			return {
				pages: pages.map((page, index) => {
					if (index === pageIndex) {
						const rows = FormSupport.removeEmptyRows(pages, index);

						return {
							...page,
							rows: [
								...rows.slice(0, rowIndex + 1),
								...newFieldsetPages[0].rows,
								...rows.slice(rowIndex + 1),
							],
						};
					}

					return page;
				}),
			};
		}
		default:
			return state;
	}
};
