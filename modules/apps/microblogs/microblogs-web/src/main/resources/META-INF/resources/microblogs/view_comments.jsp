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

<%@ include file="/init.jsp" %>

<%
String tabs1 = ParamUtil.getString(request, "tabs1", "timeline");

int cur = ParamUtil.getInteger(request, SearchContainer.DEFAULT_CUR_PARAM);

long parentMicroblogsEntryId = ParamUtil.getLong(request, "parentMicroblogsEntryId");

List<MicroblogsEntry> microblogsEntries = MicroblogsEntryLocalServiceUtil.getParentMicroblogsEntryMicroblogsEntries(MicroblogsEntryConstants.TYPE_REPLY, parentMicroblogsEntryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, new EntryCreateDateComparator(true));

request.setAttribute(WebKeys.MICROBLOGS_ENTRIES, microblogsEntries);

PortletURL microblogsEntriesURL = PortletURLBuilder.createRenderURL(
	renderResponse
).setMVCPath(
	"/microblogs/view.jsp"
).setParameter(
	"tabs1", tabs1
).setParameter(
	"cur", String.valueOf(cur)
).setWindowState(
	WindowState.NORMAL
).build();

request.setAttribute(WebKeys.MICROBLOGS_ENTRIES_URL, microblogsEntriesURL);
%>

<div class="comments-container-content">

	<%
	request.setAttribute("view_comments.jsp-comment", "true");
	request.setAttribute("view_comments.jsp-parentMicroblogsEntryId", parentMicroblogsEntryId);
	%>

	<c:if test="<%= !microblogsEntries.isEmpty() %>">
		<liferay-util:include page="/microblogs/view_microblogs_entries.jsp" servletContext="<%= application %>" />
	</c:if>

	<c:if test="<%= MicroblogsPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_ENTRY) %>">
		<liferay-util:include page="/microblogs/edit_microblogs_entry.jsp" servletContext="<%= application %>" />
	</c:if>
</div>