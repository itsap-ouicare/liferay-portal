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

import {cleanup, render} from '@testing-library/react';
import userEvent from '@testing-library/user-event';
import React from 'react';

import TotalCount from '../../../src/main/resources/META-INF/resources/js/components/TotalCount';

import '@testing-library/jest-dom/extend-expect';

describe('TotalCount', () => {
	afterEach(cleanup);

	it('renders text, help text and total count number', () => {
		const testProps = {
			label: 'Total Views',
			popoverHeader: 'Total Views',
			popoverMessage:
				'This number refers to the total number of views since the content was published.',
			value: 9999,
		};

		const {getByRole, getByText} = render(
			<TotalCount
				dataProvider={testProps.dataProvider}
				label={testProps.label}
				popoverHeader={testProps.popoverHeader}
				popoverMessage={testProps.popoverMessage}
				value={testProps.value}
			/>
		);

		expect(getByText('9,999')).toBeInTheDocument();

		const label = getByText(testProps.label);
		expect(label).toBeInTheDocument();

		const helpTextIcon = getByRole('presentation');

		userEvent.click(helpTextIcon);

		getByText(
			'This number refers to the total number of views since the content was published.'
		);
	});

	it('renders a dash instead of total count number when there is an error', () => {
		const testProps = {
			label: 'Total Views',
			popoverHeader: 'Total Views',
			popoverMessage:
				'This number refers to the total number of views since the content was published.',
			value: {undefined},
		};

		const {getByText} = render(
			<TotalCount
				dataProvider={testProps.dataProvider}
				label={testProps.label}
				popoverHeader={testProps.popoverHeader}
				popoverMessage={testProps.popoverMessage}
			/>
		);

		expect(getByText('-')).toBeInTheDocument();
	});
});
