/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 */

import {ALIGN_POSITIONS} from 'frontend-js-web';
import PropTypes from 'prop-types';
import React, {useContext} from 'react';

import {StoreStateContext} from '../../context/StoreContext';
import Keywords from '../Keywords';
import TotalCount from '../TotalCount';

export default function KeywordsDetail({currentPage}) {
	const {trafficShare, trafficVolume} = useContext(StoreStateContext);

	return (
		<div className="c-p-3 traffic-source-detail">
			<TotalCount
				className="mb-2"
				label={Liferay.Util.sub(Liferay.Language.get('traffic-volume'))}
				popoverAlign={ALIGN_POSITIONS.Bottom}
				popoverHeader={Liferay.Language.get('traffic-volume')}
				popoverMessage={Liferay.Language.get(
					'traffic-volume-is-the-number-of-page-views-coming-from-one-channel'
				)}
				popoverPosition="bottom"
				value={trafficVolume}
			/>

			<TotalCount
				className="mb-4"
				label={Liferay.Util.sub(Liferay.Language.get('traffic-share'))}
				percentage={true}
				popoverHeader={Liferay.Language.get('traffic-share')}
				popoverMessage={Liferay.Language.get(
					'traffic-share-is-the-percentage-of-traffic-sent-to-your-page-by-one-channel'
				)}
				value={trafficShare}
			/>

			<Keywords currentPage={currentPage} />
		</div>
	);
}

KeywordsDetail.proptypes = {
	currentPage: PropTypes.object.isRequired,
};
