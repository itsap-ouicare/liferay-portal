/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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

package com.liferay.portal.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.MimeTypes;
import com.liferay.portal.kernel.util.Validator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.tika.Tika;
import org.apache.tika.io.TikaInputStream;

/**
 * @author Jorge Ferrer
 * @author Brian Wing Shun Chan
 * @author Alexander Chow
 */
public class MimeTypesImpl implements MimeTypes {

	public String getContentType(File file) {
		try {
			return getContentType(new FileInputStream(file), file.getName());
		}
		catch (FileNotFoundException fnfe) {
			return getContentType(file.getName());
		}
	}

	public String getContentType(InputStream inputStream, String fileName) {
		if ((inputStream == null) && Validator.isNull(fileName)) {
			return ContentTypes.APPLICATION_OCTET_STREAM;
		}

		String contentType = null;

		try {
			Tika tika = new Tika();

			contentType = tika.detect(
				TikaInputStream.get(inputStream), fileName);

			if (contentType.contains("tika")) {
				if (_log.isDebugEnabled()) {
					_log.debug("Retrieved invalid content type " + contentType);
				}

				contentType = getContentType(fileName);
			}

			if (contentType.contains("tika")) {
				if (_log.isDebugEnabled()) {
					_log.debug("Retrieved invalid content type " + contentType);
				}

				contentType = ContentTypes.APPLICATION_OCTET_STREAM;
			}
		}
		catch (Exception e) {
			_log.error(e, e);

			contentType = ContentTypes.APPLICATION_OCTET_STREAM;
		}

		return contentType;
	}

	public String getContentType(String fileName) {
		if (Validator.isNull(fileName)) {
			return ContentTypes.APPLICATION_OCTET_STREAM;
		}

		try {
			Tika tika = new Tika();

			String contentType = tika.detect(fileName);

			if (!contentType.contains("tika")) {
				return contentType;
			}
			else if (_log.isDebugEnabled()) {
				_log.debug("Retrieved invalid content type " + contentType);
			}
		}
		catch (Exception e) {
			_log.error(e, e);
		}

		return ContentTypes.APPLICATION_OCTET_STREAM;
	}

	private static Log _log = LogFactoryUtil.getLog(MimeTypesImpl.class);

}