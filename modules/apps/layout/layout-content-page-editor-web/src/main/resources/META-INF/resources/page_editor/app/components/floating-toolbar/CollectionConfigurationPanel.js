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

import ClayForm, {ClaySelectWithOption} from '@clayui/form';
import React from 'react';

import CollectionSelector from '../../../common/components/CollectionSelector';
import {COLLECTION_LIST_FORMATS} from '../../config/constants/collectionListFormats';
import {LAYOUT_DATA_ITEM_DEFAULT_CONFIGURATIONS} from '../../config/constants/layoutDataItemDefaultConfigurations';
import {LAYOUT_DATA_ITEM_TYPES} from '../../config/constants/layoutDataItemTypes';
import selectPrefixedSegmentsExperienceId from '../../selectors/selectPrefixedSegmentsExperienceId';
import {useDispatch, useSelector} from '../../store/index';
import updateItemConfig from '../../thunks/updateItemConfig';

export const CollectionConfigurationPanel = ({item}) => {
	const dispatch = useDispatch();
	const segmentsExperienceId = useSelector(
		selectPrefixedSegmentsExperienceId
	);

	const collectionConfig = {
		...LAYOUT_DATA_ITEM_DEFAULT_CONFIGURATIONS[
			LAYOUT_DATA_ITEM_TYPES.collection
		],
		...item.config,
	};

	const handleConfigurationChanged = itemConfig => {
		dispatch(
			updateItemConfig({
				itemConfig,
				itemId: item.itemId,
				segmentsExperienceId,
			})
		);
	};

	return (
		<>
			<ClayForm.Group small>
				<CollectionSelector
					collectionTitle={collectionConfig.collection.title}
					label={Liferay.Language.get('collection')}
					onCollectionSelect={collection =>
						handleConfigurationChanged({
							collection,
						})
					}
				/>
			</ClayForm.Group>
			<ClayForm.Group small>
				<label htmlFor="collectionListFormat">
					{Liferay.Language.get('list-format')}
				</label>
				<ClaySelectWithOption
					aria-label={Liferay.Language.get('list-format')}
					id="collectionListFormat"
					onChange={({target: {value}}) =>
						handleConfigurationChanged({
							listFormat: value,
						})
					}
					options={[
						{
							label: Liferay.Language.get('stacked'),
							value: COLLECTION_LIST_FORMATS.stacked,
						},
						{
							label: Liferay.Language.get('grid'),
							value: COLLECTION_LIST_FORMATS.grid,
						},
					]}
					value={collectionConfig.listFormat}
				/>
			</ClayForm.Group>
			<ClayForm.Group small>
				<label htmlFor="collectionNumberOfItems">
					{Liferay.Language.get('max-number-of-items')}
				</label>
				<ClaySelectWithOption
					aria-label={Liferay.Language.get('max-number-of-items')}
					id="collectionNumberOfItems"
					onChange={({target: {value}}) =>
						handleConfigurationChanged({
							numberOfItems: value,
						})
					}
					options={[{label: '3'}, {label: '5'}, {label: '10'}]}
					value={collectionConfig.numberOfItems}
				/>
			</ClayForm.Group>
		</>
	);
};
