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

package com.liferay.commerce.product.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CPDefinitionLocalService}.
 *
 * @author Marco Leo
 * @see CPDefinitionLocalService
 * @generated
 */
public class CPDefinitionLocalServiceWrapper
	implements CPDefinitionLocalService,
			   ServiceWrapper<CPDefinitionLocalService> {

	public CPDefinitionLocalServiceWrapper(
		CPDefinitionLocalService cpDefinitionLocalService) {

		_cpDefinitionLocalService = cpDefinitionLocalService;
	}

	/**
	 * Adds the cp definition to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CPDefinitionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cpDefinition the cp definition
	 * @return the cp definition that was added
	 */
	@Override
	public com.liferay.commerce.product.model.CPDefinition addCPDefinition(
		com.liferay.commerce.product.model.CPDefinition cpDefinition) {

		return _cpDefinitionLocalService.addCPDefinition(cpDefinition);
	}

	@Override
	public com.liferay.commerce.product.model.CPDefinition addCPDefinition(
			String externalReferenceCode, long groupId, long userId,
			java.util.Map<java.util.Locale, String> nameMap,
			java.util.Map<java.util.Locale, String> shortDescriptionMap,
			java.util.Map<java.util.Locale, String> descriptionMap,
			java.util.Map<java.util.Locale, String> urlTitleMap,
			java.util.Map<java.util.Locale, String> metaTitleMap,
			java.util.Map<java.util.Locale, String> metaDescriptionMap,
			java.util.Map<java.util.Locale, String> metaKeywordsMap,
			String productTypeName, boolean ignoreSKUCombinations,
			boolean shippable, boolean freeShipping, boolean shipSeparately,
			double shippingExtraPrice, double width, double height,
			double depth, double weight, long cpTaxCategoryId,
			boolean taxExempt, boolean telcoOrElectronics,
			String ddmStructureKey, boolean published, int displayDateMonth,
			int displayDateDay, int displayDateYear, int displayDateHour,
			int displayDateMinute, int expirationDateMonth,
			int expirationDateDay, int expirationDateYear,
			int expirationDateHour, int expirationDateMinute,
			boolean neverExpire, String defaultSku, boolean subscriptionEnabled,
			int subscriptionLength, String subscriptionType,
			com.liferay.portal.kernel.util.UnicodeProperties
				subscriptionTypeSettingsUnicodeProperties,
			long maxSubscriptionCycles, boolean deliverySubscriptionEnabled,
			int deliverySubscriptionLength, String deliverySubscriptionType,
			com.liferay.portal.kernel.util.UnicodeProperties
				deliverySubscriptionTypeSettingsUnicodeProperties,
			long deliveryMaxSubscriptionCycles,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cpDefinitionLocalService.addCPDefinition(
			externalReferenceCode, groupId, userId, nameMap,
			shortDescriptionMap, descriptionMap, urlTitleMap, metaTitleMap,
			metaDescriptionMap, metaKeywordsMap, productTypeName,
			ignoreSKUCombinations, shippable, freeShipping, shipSeparately,
			shippingExtraPrice, width, height, depth, weight, cpTaxCategoryId,
			taxExempt, telcoOrElectronics, ddmStructureKey, published,
			displayDateMonth, displayDateDay, displayDateYear, displayDateHour,
			displayDateMinute, expirationDateMonth, expirationDateDay,
			expirationDateYear, expirationDateHour, expirationDateMinute,
			neverExpire, defaultSku, subscriptionEnabled, subscriptionLength,
			subscriptionType, subscriptionTypeSettingsUnicodeProperties,
			maxSubscriptionCycles, deliverySubscriptionEnabled,
			deliverySubscriptionLength, deliverySubscriptionType,
			deliverySubscriptionTypeSettingsUnicodeProperties,
			deliveryMaxSubscriptionCycles, serviceContext);
	}

	@Override
	public com.liferay.commerce.product.model.CPDefinition addCPDefinition(
			String externalReferenceCode, long groupId, long userId,
			java.util.Map<java.util.Locale, String> nameMap,
			java.util.Map<java.util.Locale, String> shortDescriptionMap,
			java.util.Map<java.util.Locale, String> descriptionMap,
			java.util.Map<java.util.Locale, String> urlTitleMap,
			java.util.Map<java.util.Locale, String> metaTitleMap,
			java.util.Map<java.util.Locale, String> metaDescriptionMap,
			java.util.Map<java.util.Locale, String> metaKeywordsMap,
			String productTypeName, boolean ignoreSKUCombinations,
			boolean shippable, boolean freeShipping, boolean shipSeparately,
			double shippingExtraPrice, double width, double height,
			double depth, double weight, long cpTaxCategoryId,
			boolean taxExempt, boolean telcoOrElectronics,
			String ddmStructureKey, boolean published, int displayDateMonth,
			int displayDateDay, int displayDateYear, int displayDateHour,
			int displayDateMinute, int expirationDateMonth,
			int expirationDateDay, int expirationDateYear,
			int expirationDateHour, int expirationDateMinute,
			boolean neverExpire, String defaultSku, boolean subscriptionEnabled,
			int subscriptionLength, String subscriptionType,
			com.liferay.portal.kernel.util.UnicodeProperties
				subscriptionTypeSettingsUnicodeProperties,
			long maxSubscriptionCycles,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cpDefinitionLocalService.addCPDefinition(
			externalReferenceCode, groupId, userId, nameMap,
			shortDescriptionMap, descriptionMap, urlTitleMap, metaTitleMap,
			metaDescriptionMap, metaKeywordsMap, productTypeName,
			ignoreSKUCombinations, shippable, freeShipping, shipSeparately,
			shippingExtraPrice, width, height, depth, weight, cpTaxCategoryId,
			taxExempt, telcoOrElectronics, ddmStructureKey, published,
			displayDateMonth, displayDateDay, displayDateYear, displayDateHour,
			displayDateMinute, expirationDateMonth, expirationDateDay,
			expirationDateYear, expirationDateHour, expirationDateMinute,
			neverExpire, defaultSku, subscriptionEnabled, subscriptionLength,
			subscriptionType, subscriptionTypeSettingsUnicodeProperties,
			maxSubscriptionCycles, serviceContext);
	}

	@Override
	public void checkCPDefinitions()
		throws com.liferay.portal.kernel.exception.PortalException {

		_cpDefinitionLocalService.checkCPDefinitions();
	}

	@Override
	public com.liferay.commerce.product.model.CPDefinition copyCPDefinition(
			long cpDefinitionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cpDefinitionLocalService.copyCPDefinition(cpDefinitionId);
	}

	@Override
	public com.liferay.commerce.product.model.CPDefinition copyCPDefinition(
			long cpDefinitionId, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cpDefinitionLocalService.copyCPDefinition(
			cpDefinitionId, groupId);
	}

	/**
	 * Creates a new cp definition with the primary key. Does not add the cp definition to the database.
	 *
	 * @param CPDefinitionId the primary key for the new cp definition
	 * @return the new cp definition
	 */
	@Override
	public com.liferay.commerce.product.model.CPDefinition createCPDefinition(
		long CPDefinitionId) {

		return _cpDefinitionLocalService.createCPDefinition(CPDefinitionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cpDefinitionLocalService.createPersistedModel(primaryKeyObj);
	}

	@Override
	public void deleteAssetCategoryCPDefinition(
			long cpDefinitionId, long categoryId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		_cpDefinitionLocalService.deleteAssetCategoryCPDefinition(
			cpDefinitionId, categoryId, serviceContext);
	}

	/**
	 * Deletes the cp definition from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CPDefinitionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cpDefinition the cp definition
	 * @return the cp definition that was removed
	 * @throws PortalException
	 */
	@Override
	public com.liferay.commerce.product.model.CPDefinition deleteCPDefinition(
			com.liferay.commerce.product.model.CPDefinition cpDefinition)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cpDefinitionLocalService.deleteCPDefinition(cpDefinition);
	}

	/**
	 * Deletes the cp definition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CPDefinitionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param CPDefinitionId the primary key of the cp definition
	 * @return the cp definition that was removed
	 * @throws PortalException if a cp definition with the primary key could not be found
	 */
	@Override
	public com.liferay.commerce.product.model.CPDefinition deleteCPDefinition(
			long CPDefinitionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cpDefinitionLocalService.deleteCPDefinition(CPDefinitionId);
	}

	@Override
	public void deleteCPDefinitions(long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_cpDefinitionLocalService.deleteCPDefinitions(companyId);
	}

	@Override
	public void deleteCPDefinitions(long cProductId, int status) {
		_cpDefinitionLocalService.deleteCPDefinitions(cProductId, status);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cpDefinitionLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _cpDefinitionLocalService.dslQuery(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _cpDefinitionLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _cpDefinitionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.product.model.impl.CPDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _cpDefinitionLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.product.model.impl.CPDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _cpDefinitionLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _cpDefinitionLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _cpDefinitionLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.commerce.product.model.CPDefinition fetchCPDefinition(
		long CPDefinitionId) {

		return _cpDefinitionLocalService.fetchCPDefinition(CPDefinitionId);
	}

	@Override
	public com.liferay.commerce.product.model.CPDefinition
		fetchCPDefinitionByCProductExternalReferenceCode(
			String externalReferenceCode, long companyId) {

		return _cpDefinitionLocalService.
			fetchCPDefinitionByCProductExternalReferenceCode(
				externalReferenceCode, companyId);
	}

	@Override
	public com.liferay.commerce.product.model.CPDefinition
		fetchCPDefinitionByCProductId(long cProductId) {

		return _cpDefinitionLocalService.fetchCPDefinitionByCProductId(
			cProductId);
	}

	/**
	 * Returns the cp definition matching the UUID and group.
	 *
	 * @param uuid the cp definition's UUID
	 * @param groupId the primary key of the group
	 * @return the matching cp definition, or <code>null</code> if a matching cp definition could not be found
	 */
	@Override
	public com.liferay.commerce.product.model.CPDefinition
		fetchCPDefinitionByUuidAndGroupId(String uuid, long groupId) {

		return _cpDefinitionLocalService.fetchCPDefinitionByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.commerce.product.model.CPDefinitionLocalization
		fetchCPDefinitionLocalization(long CPDefinitionId, String languageId) {

		return _cpDefinitionLocalService.fetchCPDefinitionLocalization(
			CPDefinitionId, languageId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _cpDefinitionLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the cp definition with the primary key.
	 *
	 * @param CPDefinitionId the primary key of the cp definition
	 * @return the cp definition
	 * @throws PortalException if a cp definition with the primary key could not be found
	 */
	@Override
	public com.liferay.commerce.product.model.CPDefinition getCPDefinition(
			long CPDefinitionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cpDefinitionLocalService.getCPDefinition(CPDefinitionId);
	}

	/**
	 * Returns the cp definition matching the UUID and group.
	 *
	 * @param uuid the cp definition's UUID
	 * @param groupId the primary key of the group
	 * @return the matching cp definition
	 * @throws PortalException if a matching cp definition could not be found
	 */
	@Override
	public com.liferay.commerce.product.model.CPDefinition
			getCPDefinitionByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cpDefinitionLocalService.getCPDefinitionByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public java.util.Map<java.util.Locale, String>
		getCPDefinitionDescriptionMap(long cpDefinitionId) {

		return _cpDefinitionLocalService.getCPDefinitionDescriptionMap(
			cpDefinitionId);
	}

	@Override
	public com.liferay.commerce.product.model.CPDefinitionLocalization
			getCPDefinitionLocalization(long CPDefinitionId, String languageId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cpDefinitionLocalService.getCPDefinitionLocalization(
			CPDefinitionId, languageId);
	}

	@Override
	public java.util.List<String> getCPDefinitionLocalizationLanguageIds(
		long cpDefinitionId) {

		return _cpDefinitionLocalService.getCPDefinitionLocalizationLanguageIds(
			cpDefinitionId);
	}

	@Override
	public java.util.List
		<com.liferay.commerce.product.model.CPDefinitionLocalization>
			getCPDefinitionLocalizations(long CPDefinitionId) {

		return _cpDefinitionLocalService.getCPDefinitionLocalizations(
			CPDefinitionId);
	}

	@Override
	public java.util.Map<java.util.Locale, String>
		getCPDefinitionMetaDescriptionMap(long cpDefinitionId) {

		return _cpDefinitionLocalService.getCPDefinitionMetaDescriptionMap(
			cpDefinitionId);
	}

	@Override
	public java.util.Map<java.util.Locale, String>
		getCPDefinitionMetaKeywordsMap(long cpDefinitionId) {

		return _cpDefinitionLocalService.getCPDefinitionMetaKeywordsMap(
			cpDefinitionId);
	}

	@Override
	public java.util.Map<java.util.Locale, String> getCPDefinitionMetaTitleMap(
		long cpDefinitionId) {

		return _cpDefinitionLocalService.getCPDefinitionMetaTitleMap(
			cpDefinitionId);
	}

	@Override
	public java.util.Map<java.util.Locale, String> getCPDefinitionNameMap(
		long cpDefinitionId) {

		return _cpDefinitionLocalService.getCPDefinitionNameMap(cpDefinitionId);
	}

	/**
	 * Returns a range of all the cp definitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.product.model.impl.CPDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cp definitions
	 * @param end the upper bound of the range of cp definitions (not inclusive)
	 * @return the range of cp definitions
	 */
	@Override
	public java.util.List<com.liferay.commerce.product.model.CPDefinition>
		getCPDefinitions(int start, int end) {

		return _cpDefinitionLocalService.getCPDefinitions(start, end);
	}

	@Override
	public java.util.List<com.liferay.commerce.product.model.CPDefinition>
		getCPDefinitions(long groupId, boolean subscriptionEnabled) {

		return _cpDefinitionLocalService.getCPDefinitions(
			groupId, subscriptionEnabled);
	}

	@Override
	public java.util.List<com.liferay.commerce.product.model.CPDefinition>
		getCPDefinitions(long groupId, int status, int start, int end) {

		return _cpDefinitionLocalService.getCPDefinitions(
			groupId, status, start, end);
	}

	@Override
	public java.util.List<com.liferay.commerce.product.model.CPDefinition>
		getCPDefinitions(
			long groupId, int status, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.commerce.product.model.CPDefinition>
					orderByComparator) {

		return _cpDefinitionLocalService.getCPDefinitions(
			groupId, status, start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.liferay.commerce.product.model.CPDefinition>
		getCPDefinitions(
			long groupId, String productTypeName, String languageId, int status,
			int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.commerce.product.model.CPDefinition>
					orderByComparator) {

		return _cpDefinitionLocalService.getCPDefinitions(
			groupId, productTypeName, languageId, status, start, end,
			orderByComparator);
	}

	/**
	 * Returns all the cp definitions matching the UUID and company.
	 *
	 * @param uuid the UUID of the cp definitions
	 * @param companyId the primary key of the company
	 * @return the matching cp definitions, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.liferay.commerce.product.model.CPDefinition>
		getCPDefinitionsByUuidAndCompanyId(String uuid, long companyId) {

		return _cpDefinitionLocalService.getCPDefinitionsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of cp definitions matching the UUID and company.
	 *
	 * @param uuid the UUID of the cp definitions
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of cp definitions
	 * @param end the upper bound of the range of cp definitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching cp definitions, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.liferay.commerce.product.model.CPDefinition>
		getCPDefinitionsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.commerce.product.model.CPDefinition>
					orderByComparator) {

		return _cpDefinitionLocalService.getCPDefinitionsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of cp definitions.
	 *
	 * @return the number of cp definitions
	 */
	@Override
	public int getCPDefinitionsCount() {
		return _cpDefinitionLocalService.getCPDefinitionsCount();
	}

	@Override
	public int getCPDefinitionsCount(
		long groupId, boolean subscriptionEnabled) {

		return _cpDefinitionLocalService.getCPDefinitionsCount(
			groupId, subscriptionEnabled);
	}

	@Override
	public int getCPDefinitionsCount(long groupId, int status) {
		return _cpDefinitionLocalService.getCPDefinitionsCount(groupId, status);
	}

	@Override
	public int getCPDefinitionsCount(
		long groupId, String productTypeName, String languageId, int status) {

		return _cpDefinitionLocalService.getCPDefinitionsCount(
			groupId, productTypeName, languageId, status);
	}

	@Override
	public java.util.Map<java.util.Locale, String>
		getCPDefinitionShortDescriptionMap(long cpDefinitionId) {

		return _cpDefinitionLocalService.getCPDefinitionShortDescriptionMap(
			cpDefinitionId);
	}

	@Override
	public com.liferay.commerce.product.model.CPAttachmentFileEntry
			getDefaultImage(long cpDefinitionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cpDefinitionLocalService.getDefaultImage(cpDefinitionId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _cpDefinitionLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.search.facet.Facet>
		getFacets(
			String filterFields, String filterValues,
			com.liferay.portal.kernel.search.SearchContext searchContext) {

		return _cpDefinitionLocalService.getFacets(
			filterFields, filterValues, searchContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _cpDefinitionLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 #getLayoutUuid(long, long)}
	 */
	@Deprecated
	@Override
	public String getLayoutUuid(long cpDefinitionId) {
		return _cpDefinitionLocalService.getLayoutUuid(cpDefinitionId);
	}

	@Override
	public String getLayoutUuid(long groupId, long cpDefinitionId) {
		return _cpDefinitionLocalService.getLayoutUuid(groupId, cpDefinitionId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _cpDefinitionLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cpDefinitionLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.Map<java.util.Locale, String> getUrlTitleMap(
		long cpDefinitionId) {

		return _cpDefinitionLocalService.getUrlTitleMap(cpDefinitionId);
	}

	@Override
	public String getUrlTitleMapAsXML(long cpDefinitionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cpDefinitionLocalService.getUrlTitleMapAsXML(cpDefinitionId);
	}

	@Override
	public boolean hasChildCPDefinitions(long cpDefinitionId) {
		return _cpDefinitionLocalService.hasChildCPDefinitions(cpDefinitionId);
	}

	@Override
	public boolean isPublishedCPDefinition(
		com.liferay.commerce.product.model.CPDefinition cpDefinition) {

		return _cpDefinitionLocalService.isPublishedCPDefinition(cpDefinition);
	}

	@Override
	public boolean isPublishedCPDefinition(long cpDefinitionId) {
		return _cpDefinitionLocalService.isPublishedCPDefinition(
			cpDefinitionId);
	}

	@Override
	public boolean isVersionable(
		com.liferay.commerce.product.model.CPDefinition cpDefinition) {

		return _cpDefinitionLocalService.isVersionable(cpDefinition);
	}

	@Override
	public boolean isVersionable(long cpDefinitionId) {
		return _cpDefinitionLocalService.isVersionable(cpDefinitionId);
	}

	@Override
	public boolean isVersionable(
		long cpDefinitionId,
		javax.servlet.http.HttpServletRequest httpServletRequest) {

		return _cpDefinitionLocalService.isVersionable(
			cpDefinitionId, httpServletRequest);
	}

	@Override
	public void maintainVersionThreshold(long cProductId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_cpDefinitionLocalService.maintainVersionThreshold(cProductId);
	}

	@Override
	public com.liferay.portal.kernel.search.BaseModelSearchResult
		<com.liferay.commerce.product.model.CPDefinition> searchCPDefinitions(
				long companyId, long[] groupIds, String keywords, int status,
				int start, int end, com.liferay.portal.kernel.search.Sort sort)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _cpDefinitionLocalService.searchCPDefinitions(
			companyId, groupIds, keywords, status, start, end, sort);
	}

	@Override
	public com.liferay.portal.kernel.search.BaseModelSearchResult
		<com.liferay.commerce.product.model.CPDefinition> searchCPDefinitions(
				long companyId, long[] groupIds, String keywords,
				String filterFields, String filterValues, int start, int end,
				com.liferay.portal.kernel.search.Sort sort)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _cpDefinitionLocalService.searchCPDefinitions(
			companyId, groupIds, keywords, filterFields, filterValues, start,
			end, sort);
	}

	@Override
	public void updateAsset(
			long userId,
			com.liferay.commerce.product.model.CPDefinition cpDefinition,
			long[] assetCategoryIds, String[] assetTagNames,
			long[] assetLinkEntryIds, Double priority)
		throws com.liferay.portal.kernel.exception.PortalException {

		_cpDefinitionLocalService.updateAsset(
			userId, cpDefinition, assetCategoryIds, assetTagNames,
			assetLinkEntryIds, priority);
	}

	/**
	 * Updates the cp definition in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CPDefinitionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cpDefinition the cp definition
	 * @return the cp definition that was updated
	 */
	@Override
	public com.liferay.commerce.product.model.CPDefinition updateCPDefinition(
		com.liferay.commerce.product.model.CPDefinition cpDefinition) {

		return _cpDefinitionLocalService.updateCPDefinition(cpDefinition);
	}

	@Override
	public com.liferay.commerce.product.model.CPDefinition updateCPDefinition(
			long cpDefinitionId,
			java.util.Map<java.util.Locale, String> nameMap,
			java.util.Map<java.util.Locale, String> shortDescriptionMap,
			java.util.Map<java.util.Locale, String> descriptionMap,
			java.util.Map<java.util.Locale, String> urlTitleMap,
			java.util.Map<java.util.Locale, String> metaTitleMap,
			java.util.Map<java.util.Locale, String> metaDescriptionMap,
			java.util.Map<java.util.Locale, String> metaKeywordsMap,
			boolean ignoreSKUCombinations, boolean shippable,
			boolean freeShipping, boolean shipSeparately,
			double shippingExtraPrice, double width, double height,
			double depth, double weight, long cpTaxCategoryId,
			boolean taxExempt, boolean telcoOrElectronics,
			String ddmStructureKey, boolean published, int displayDateMonth,
			int displayDateDay, int displayDateYear, int displayDateHour,
			int displayDateMinute, int expirationDateMonth,
			int expirationDateDay, int expirationDateYear,
			int expirationDateHour, int expirationDateMinute,
			boolean neverExpire,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cpDefinitionLocalService.updateCPDefinition(
			cpDefinitionId, nameMap, shortDescriptionMap, descriptionMap,
			urlTitleMap, metaTitleMap, metaDescriptionMap, metaKeywordsMap,
			ignoreSKUCombinations, shippable, freeShipping, shipSeparately,
			shippingExtraPrice, width, height, depth, weight, cpTaxCategoryId,
			taxExempt, telcoOrElectronics, ddmStructureKey, published,
			displayDateMonth, displayDateDay, displayDateYear, displayDateHour,
			displayDateMinute, expirationDateMonth, expirationDateDay,
			expirationDateYear, expirationDateHour, expirationDateMinute,
			neverExpire, serviceContext);
	}

	@Override
	public com.liferay.commerce.product.model.CPDefinition updateCPDefinition(
			long cpDefinitionId,
			java.util.Map<java.util.Locale, String> nameMap,
			java.util.Map<java.util.Locale, String> shortDescriptionMap,
			java.util.Map<java.util.Locale, String> descriptionMap,
			java.util.Map<java.util.Locale, String> urlTitleMap,
			java.util.Map<java.util.Locale, String> metaTitleMap,
			java.util.Map<java.util.Locale, String> metaDescriptionMap,
			java.util.Map<java.util.Locale, String> metaKeywordsMap,
			boolean ignoreSKUCombinations, String ddmStructureKey,
			boolean published, int displayDateMonth, int displayDateDay,
			int displayDateYear, int displayDateHour, int displayDateMinute,
			int expirationDateMonth, int expirationDateDay,
			int expirationDateYear, int expirationDateHour,
			int expirationDateMinute, boolean neverExpire,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cpDefinitionLocalService.updateCPDefinition(
			cpDefinitionId, nameMap, shortDescriptionMap, descriptionMap,
			urlTitleMap, metaTitleMap, metaDescriptionMap, metaKeywordsMap,
			ignoreSKUCombinations, ddmStructureKey, published, displayDateMonth,
			displayDateDay, displayDateYear, displayDateHour, displayDateMinute,
			expirationDateMonth, expirationDateDay, expirationDateYear,
			expirationDateHour, expirationDateMinute, neverExpire,
			serviceContext);
	}

	@Override
	public com.liferay.commerce.product.model.CPDefinition
			updateCPDefinitionAccountGroupFilter(
				long cpDefinitionId, boolean enable)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cpDefinitionLocalService.updateCPDefinitionAccountGroupFilter(
			cpDefinitionId, enable);
	}

	@Override
	public com.liferay.commerce.product.model.CPDefinition
			updateCPDefinitionCategorization(
				long cpDefinitionId,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cpDefinitionLocalService.updateCPDefinitionCategorization(
			cpDefinitionId, serviceContext);
	}

	@Override
	public com.liferay.commerce.product.model.CPDefinition
			updateCPDefinitionChannelFilter(long cpDefinitionId, boolean enable)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cpDefinitionLocalService.updateCPDefinitionChannelFilter(
			cpDefinitionId, enable);
	}

	@Override
	public com.liferay.commerce.product.model.CPDefinition
			updateCPDefinitionIgnoreSKUCombinations(
				long cpDefinitionId, boolean ignoreSKUCombinations,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cpDefinitionLocalService.
			updateCPDefinitionIgnoreSKUCombinations(
				cpDefinitionId, ignoreSKUCombinations, serviceContext);
	}

	@Override
	public com.liferay.commerce.product.model.CPDefinitionLocalization
			updateCPDefinitionLocalization(
				com.liferay.commerce.product.model.CPDefinition cpDefinition,
				String languageId, String name, String shortDescription,
				String description, String metaTitle, String metaDescription,
				String metaKeywords)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cpDefinitionLocalService.updateCPDefinitionLocalization(
			cpDefinition, languageId, name, shortDescription, description,
			metaTitle, metaDescription, metaKeywords);
	}

	@Override
	public java.util.List
		<com.liferay.commerce.product.model.CPDefinitionLocalization>
				updateCPDefinitionLocalizations(
					com.liferay.commerce.product.model.CPDefinition
						cpDefinition,
					java.util.Map<String, String> nameMap,
					java.util.Map<String, String> shortDescriptionMap,
					java.util.Map<String, String> descriptionMap,
					java.util.Map<String, String> metaTitleMap,
					java.util.Map<String, String> metaDescriptionMap,
					java.util.Map<String, String> metaKeywordsMap)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _cpDefinitionLocalService.updateCPDefinitionLocalizations(
			cpDefinition, nameMap, shortDescriptionMap, descriptionMap,
			metaTitleMap, metaDescriptionMap, metaKeywordsMap);
	}

	@Override
	public void updateCPDefinitionsByCPTaxCategoryId(long cpTaxCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_cpDefinitionLocalService.updateCPDefinitionsByCPTaxCategoryId(
			cpTaxCategoryId);
	}

	@Override
	public com.liferay.commerce.product.model.CPDefinition
			updateExternalReferenceCode(
				String externalReferenceCode, long cpDefinitionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cpDefinitionLocalService.updateExternalReferenceCode(
			externalReferenceCode, cpDefinitionId);
	}

	@Override
	public com.liferay.commerce.product.model.CPDefinition updateShippingInfo(
			long cpDefinitionId, boolean shippable, boolean freeShipping,
			boolean shipSeparately, double shippingExtraPrice, double width,
			double height, double depth, double weight,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cpDefinitionLocalService.updateShippingInfo(
			cpDefinitionId, shippable, freeShipping, shipSeparately,
			shippingExtraPrice, width, height, depth, weight, serviceContext);
	}

	@Override
	public com.liferay.commerce.product.model.CPDefinition updateStatus(
			long userId, long cpDefinitionId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			java.util.Map<String, java.io.Serializable> workflowContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cpDefinitionLocalService.updateStatus(
			userId, cpDefinitionId, status, serviceContext, workflowContext);
	}

	@Override
	public com.liferay.commerce.product.model.CPDefinition
			updateSubscriptionInfo(
				long cpDefinitionId, boolean subscriptionEnabled,
				int subscriptionLength, String subscriptionType,
				com.liferay.portal.kernel.util.UnicodeProperties
					subscriptionTypeSettingsUnicodeProperties,
				long maxSubscriptionCycles, boolean deliverySubscriptionEnabled,
				int deliverySubscriptionLength, String deliverySubscriptionType,
				com.liferay.portal.kernel.util.UnicodeProperties
					deliverySubscriptionTypeSettingsUnicodeProperties,
				long deliveryMaxSubscriptionCycles)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cpDefinitionLocalService.updateSubscriptionInfo(
			cpDefinitionId, subscriptionEnabled, subscriptionLength,
			subscriptionType, subscriptionTypeSettingsUnicodeProperties,
			maxSubscriptionCycles, deliverySubscriptionEnabled,
			deliverySubscriptionLength, deliverySubscriptionType,
			deliverySubscriptionTypeSettingsUnicodeProperties,
			deliveryMaxSubscriptionCycles);
	}

	/**
	 * @deprecated As of Athanasius (7.3.x)
	 */
	@Deprecated
	@Override
	public com.liferay.commerce.product.model.CPDefinition
			updateSubscriptionInfo(
				long cpDefinitionId, boolean subscriptionEnabled,
				int subscriptionLength, String subscriptionType,
				com.liferay.portal.kernel.util.UnicodeProperties
					subscriptionTypeSettingsUnicodeProperties,
				long maxSubscriptionCycles,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cpDefinitionLocalService.updateSubscriptionInfo(
			cpDefinitionId, subscriptionEnabled, subscriptionLength,
			subscriptionType, subscriptionTypeSettingsUnicodeProperties,
			maxSubscriptionCycles, serviceContext);
	}

	@Override
	public com.liferay.commerce.product.model.CPDefinition
			updateTaxCategoryInfo(
				long cpDefinitionId, long cpTaxCategoryId, boolean taxExempt,
				boolean telcoOrElectronics)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cpDefinitionLocalService.updateTaxCategoryInfo(
			cpDefinitionId, cpTaxCategoryId, taxExempt, telcoOrElectronics);
	}

	@Override
	public com.liferay.commerce.product.model.CPDefinition upsertCPDefinition(
			String externalReferenceCode, long groupId, long userId,
			java.util.Map<java.util.Locale, String> nameMap,
			java.util.Map<java.util.Locale, String> shortDescriptionMap,
			java.util.Map<java.util.Locale, String> descriptionMap,
			java.util.Map<java.util.Locale, String> urlTitleMap,
			java.util.Map<java.util.Locale, String> metaTitleMap,
			java.util.Map<java.util.Locale, String> metaDescriptionMap,
			java.util.Map<java.util.Locale, String> metaKeywordsMap,
			String productTypeName, boolean ignoreSKUCombinations,
			boolean shippable, boolean freeShipping, boolean shipSeparately,
			double shippingExtraPrice, double width, double height,
			double depth, double weight, long cpTaxCategoryId,
			boolean taxExempt, boolean telcoOrElectronics,
			String ddmStructureKey, boolean published, int displayDateMonth,
			int displayDateDay, int displayDateYear, int displayDateHour,
			int displayDateMinute, int expirationDateMonth,
			int expirationDateDay, int expirationDateYear,
			int expirationDateHour, int expirationDateMinute,
			boolean neverExpire, String defaultSku, boolean subscriptionEnabled,
			int subscriptionLength, String subscriptionType,
			com.liferay.portal.kernel.util.UnicodeProperties
				subscriptionTypeSettingsUnicodeProperties,
			long maxSubscriptionCycles, boolean deliverySubscriptionEnabled,
			int deliverySubscriptionLength, String deliverySubscriptionType,
			com.liferay.portal.kernel.util.UnicodeProperties
				deliverySubscriptionTypeSettingsUnicodeProperties,
			long deliveryMaxSubscriptionCycles,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cpDefinitionLocalService.upsertCPDefinition(
			externalReferenceCode, groupId, userId, nameMap,
			shortDescriptionMap, descriptionMap, urlTitleMap, metaTitleMap,
			metaDescriptionMap, metaKeywordsMap, productTypeName,
			ignoreSKUCombinations, shippable, freeShipping, shipSeparately,
			shippingExtraPrice, width, height, depth, weight, cpTaxCategoryId,
			taxExempt, telcoOrElectronics, ddmStructureKey, published,
			displayDateMonth, displayDateDay, displayDateYear, displayDateHour,
			displayDateMinute, expirationDateMonth, expirationDateDay,
			expirationDateYear, expirationDateHour, expirationDateMinute,
			neverExpire, defaultSku, subscriptionEnabled, subscriptionLength,
			subscriptionType, subscriptionTypeSettingsUnicodeProperties,
			maxSubscriptionCycles, deliverySubscriptionEnabled,
			deliverySubscriptionLength, deliverySubscriptionType,
			deliverySubscriptionTypeSettingsUnicodeProperties,
			deliveryMaxSubscriptionCycles, serviceContext);
	}

	@Override
	public com.liferay.commerce.product.model.CPDefinition upsertCPDefinition(
			String externalReferenceCode, long groupId, long userId,
			java.util.Map<java.util.Locale, String> nameMap,
			java.util.Map<java.util.Locale, String> shortDescriptionMap,
			java.util.Map<java.util.Locale, String> descriptionMap,
			java.util.Map<java.util.Locale, String> urlTitleMap,
			java.util.Map<java.util.Locale, String> metaTitleMap,
			java.util.Map<java.util.Locale, String> metaDescriptionMap,
			java.util.Map<java.util.Locale, String> metaKeywordsMap,
			String productTypeName, boolean ignoreSKUCombinations,
			boolean shippable, boolean freeShipping, boolean shipSeparately,
			double shippingExtraPrice, double width, double height,
			double depth, double weight, long cpTaxCategoryId,
			boolean taxExempt, boolean telcoOrElectronics,
			String ddmStructureKey, boolean published, int displayDateMonth,
			int displayDateDay, int displayDateYear, int displayDateHour,
			int displayDateMinute, int expirationDateMonth,
			int expirationDateDay, int expirationDateYear,
			int expirationDateHour, int expirationDateMinute,
			boolean neverExpire, String defaultSku, boolean subscriptionEnabled,
			int subscriptionLength, String subscriptionType,
			com.liferay.portal.kernel.util.UnicodeProperties
				subscriptionTypeSettingsUnicodeProperties,
			long maxSubscriptionCycles,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cpDefinitionLocalService.upsertCPDefinition(
			externalReferenceCode, groupId, userId, nameMap,
			shortDescriptionMap, descriptionMap, urlTitleMap, metaTitleMap,
			metaDescriptionMap, metaKeywordsMap, productTypeName,
			ignoreSKUCombinations, shippable, freeShipping, shipSeparately,
			shippingExtraPrice, width, height, depth, weight, cpTaxCategoryId,
			taxExempt, telcoOrElectronics, ddmStructureKey, published,
			displayDateMonth, displayDateDay, displayDateYear, displayDateHour,
			displayDateMinute, expirationDateMonth, expirationDateDay,
			expirationDateYear, expirationDateHour, expirationDateMinute,
			neverExpire, defaultSku, subscriptionEnabled, subscriptionLength,
			subscriptionType, subscriptionTypeSettingsUnicodeProperties,
			maxSubscriptionCycles, serviceContext);
	}

	@Override
	public CPDefinitionLocalService getWrappedService() {
		return _cpDefinitionLocalService;
	}

	@Override
	public void setWrappedService(
		CPDefinitionLocalService cpDefinitionLocalService) {

		_cpDefinitionLocalService = cpDefinitionLocalService;
	}

	private CPDefinitionLocalService _cpDefinitionLocalService;

}