<%--
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
--%>

<%@ include file="/display/init.jsp" %>

<%
boolean exactMatch = GetterUtil.getBoolean(renderRequest.getAttribute(KBWebKeys.KNOWLEDGE_BASE_EXACT_MATCH), true);
String[] searchKeywords = (String[])renderRequest.getAttribute(KBWebKeys.KNOWLEDGE_BASE_SEARCH_KEYWORDS);
%>

<div id="<portlet:namespace />message-container"></div>

<c:choose>
	<c:when test="<%= searchKeywords == null %>">
		<c:if test="<%= !exactMatch %>">
			<div class="alert alert-info">
				<liferay-ui:message key="the-article-you-requested-was-not-found.-this-similar-article-may-be-useful-to-you" />
			</div>
		</c:if>

		<div class="kb-article-container">
			<liferay-util:include page="/admin/common/view_article.jsp" servletContext="<%= application %>" />
		</div>
	</c:when>
	<c:otherwise>
		<div class="alert alert-warning">
			<liferay-ui:message key="the-article-you-requested-was-not-found" />

			<%
			String searchPortletId = PortletProviderUtil.getPortletId(PortalSearchApplicationType.Search.CLASS_NAME, PortletProvider.Action.VIEW);

			PortletURL portletURL = PortletURLBuilder.createLiferayPortletURL(
				liferayPortletResponse, searchPortletId, PortletRequest.RENDER_PHASE
			).setRedirect(
				currentURL
			).setParameter(
				"struts_action", "/search/search"
			).setParameter(
				"keywords", StringUtil.merge(searchKeywords, StringPool.SPACE)
			).setPortletMode(
				PortletMode.VIEW
			).setWindowState(
				WindowState.MAXIMIZED
			).build();
			%>

			<aui:a href="<%= portletURL.toString() %>" label='<%= LanguageUtil.get(request, "search-for-a-similar-article") %>' />
		</div>
	</c:otherwise>
</c:choose>