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

package com.liferay.headless.commerce.admin.catalog.client.serdes.v1_0;

import com.liferay.headless.commerce.admin.catalog.client.dto.v1_0.ProductSpecification;
import com.liferay.headless.commerce.admin.catalog.client.json.BaseJSONParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

/**
 * @author Zoltán Takács
 * @generated
 */
@Generated("")
public class ProductSpecificationSerDes {

	public static ProductSpecification toDTO(String json) {
		ProductSpecificationJSONParser productSpecificationJSONParser =
			new ProductSpecificationJSONParser();

		return productSpecificationJSONParser.parseToDTO(json);
	}

	public static ProductSpecification[] toDTOs(String json) {
		ProductSpecificationJSONParser productSpecificationJSONParser =
			new ProductSpecificationJSONParser();

		return productSpecificationJSONParser.parseToDTOs(json);
	}

	public static String toJSON(ProductSpecification productSpecification) {
		if (productSpecification == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (productSpecification.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(productSpecification.getId());
		}

		if (productSpecification.getOptionCategoryId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"optionCategoryId\": ");

			sb.append(productSpecification.getOptionCategoryId());
		}

		if (productSpecification.getPriority() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"priority\": ");

			sb.append(productSpecification.getPriority());
		}

		if (productSpecification.getProductId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"productId\": ");

			sb.append(productSpecification.getProductId());
		}

		if (productSpecification.getSpecificationId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"specificationId\": ");

			sb.append(productSpecification.getSpecificationId());
		}

		if (productSpecification.getSpecificationKey() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"specificationKey\": ");

			sb.append("\"");

			sb.append(_escape(productSpecification.getSpecificationKey()));

			sb.append("\"");
		}

		if (productSpecification.getValue() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"value\": ");

			sb.append(_toJSON(productSpecification.getValue()));
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		ProductSpecificationJSONParser productSpecificationJSONParser =
			new ProductSpecificationJSONParser();

		return productSpecificationJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		ProductSpecification productSpecification) {

		if (productSpecification == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (productSpecification.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(productSpecification.getId()));
		}

		if (productSpecification.getOptionCategoryId() == null) {
			map.put("optionCategoryId", null);
		}
		else {
			map.put(
				"optionCategoryId",
				String.valueOf(productSpecification.getOptionCategoryId()));
		}

		if (productSpecification.getPriority() == null) {
			map.put("priority", null);
		}
		else {
			map.put(
				"priority", String.valueOf(productSpecification.getPriority()));
		}

		if (productSpecification.getProductId() == null) {
			map.put("productId", null);
		}
		else {
			map.put(
				"productId",
				String.valueOf(productSpecification.getProductId()));
		}

		if (productSpecification.getSpecificationId() == null) {
			map.put("specificationId", null);
		}
		else {
			map.put(
				"specificationId",
				String.valueOf(productSpecification.getSpecificationId()));
		}

		if (productSpecification.getSpecificationKey() == null) {
			map.put("specificationKey", null);
		}
		else {
			map.put(
				"specificationKey",
				String.valueOf(productSpecification.getSpecificationKey()));
		}

		if (productSpecification.getValue() == null) {
			map.put("value", null);
		}
		else {
			map.put("value", String.valueOf(productSpecification.getValue()));
		}

		return map;
	}

	public static class ProductSpecificationJSONParser
		extends BaseJSONParser<ProductSpecification> {

		@Override
		protected ProductSpecification createDTO() {
			return new ProductSpecification();
		}

		@Override
		protected ProductSpecification[] createDTOArray(int size) {
			return new ProductSpecification[size];
		}

		@Override
		protected void setField(
			ProductSpecification productSpecification,
			String jsonParserFieldName, Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					productSpecification.setId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "optionCategoryId")) {
				if (jsonParserFieldValue != null) {
					productSpecification.setOptionCategoryId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "priority")) {
				if (jsonParserFieldValue != null) {
					productSpecification.setPriority(
						Double.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "productId")) {
				if (jsonParserFieldValue != null) {
					productSpecification.setProductId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "specificationId")) {
				if (jsonParserFieldValue != null) {
					productSpecification.setSpecificationId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "specificationKey")) {
				if (jsonParserFieldValue != null) {
					productSpecification.setSpecificationKey(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "value")) {
				if (jsonParserFieldValue != null) {
					productSpecification.setValue(
						(Map)ProductSpecificationSerDes.toMap(
							(String)jsonParserFieldValue));
				}
			}
		}

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		for (String[] strings : BaseJSONParser.JSON_ESCAPE_STRINGS) {
			string = string.replace(strings[0], strings[1]);
		}

		return string;
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\":");

			Object value = entry.getValue();

			Class<?> valueClass = value.getClass();

			if (value instanceof Map) {
				sb.append(_toJSON((Map)value));
			}
			else if (valueClass.isArray()) {
				Object[] values = (Object[])value;

				sb.append("[");

				for (int i = 0; i < values.length; i++) {
					sb.append("\"");
					sb.append(_escape(values[i]));
					sb.append("\"");

					if ((i + 1) < values.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(entry.getValue()));
				sb.append("\"");
			}
			else {
				sb.append(String.valueOf(entry.getValue()));
			}

			if (iterator.hasNext()) {
				sb.append(",");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}