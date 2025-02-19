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

import '@testing-library/jest-dom/extend-expect';
import {cleanup, render} from '@testing-library/react';
import React from 'react';

import TrafficSources from '../../../src/main/resources/META-INF/resources/js/components/TrafficSources';
import {StoreContextProvider} from '../../../src/main/resources/META-INF/resources/js/context/StoreContext';

const noop = () => {};

const mockLanguageTag = 'en-US';

describe('TrafficSources', () => {
	afterEach(cleanup);

	it('displays the traffic sources with buttons to view keywords', () => {
		const mockTrafficSources = [
			{
				countryKeywords: [
					{
						countryCode: 'us',
						countryName: 'United States',
						keywords: [],
					},
					{
						countryCode: 'es',
						countryName: 'Spain',
						keywords: [],
					},
				],
				helpMessage: 'Testing Help Message',
				name: 'testing',
				share: '30.0',
				title: 'Testing',
				value: 32178,
			},
			{
				countryKeywords: [
					{
						countryCode: 'us',
						countryName: 'United States',
						keywords: [],
					},
					{
						countryCode: 'es',
						countryName: 'Spain',
						keywords: [],
					},
				],
				helpMessage: 'Second Testing Help Message',
				name: 'second-testing',
				share: '70.0',
				title: 'Second Testing',
				value: 278256,
			},
		];

		const {getByText} = render(
			<StoreContextProvider
				value={{
					languageTag: mockLanguageTag,
					trafficSources: mockTrafficSources,
				}}
			>
				<TrafficSources onTrafficSourceClick={noop} />
			</StoreContextProvider>
		);

		const button1 = getByText('Testing');

		expect(button1).toBeInTheDocument();
		expect(button1).not.toBeDisabled();
		expect(button1).toHaveAttribute('type', 'button');
		expect(getByText('32,178')).toBeInTheDocument();

		const button2 = getByText('Second Testing');

		expect(button2).toBeInTheDocument();
		expect(button2).not.toBeDisabled();
		expect(button2).toHaveAttribute('type', 'button');
		expect(getByText('278,256')).toBeInTheDocument();
	});

	it('displays the traffic sources without buttons to view keywords when the value is 0', () => {
		const mockTrafficSources = [
			{
				countryKeywords: [
					{
						countryCode: 'us',
						countryName: 'United States',
						keywords: [],
					},
					{
						countryCode: 'es',
						countryName: 'Spain',
						keywords: [],
					},
				],
				helpMessage: 'Testing Help Message',
				name: 'testing',
				share: '0.0',
				title: 'Testing',
				value: 0,
			},
			{
				countryKeywords: [
					{
						countryCode: 'us',
						countryName: 'United States',
						keywords: [],
					},
					{
						countryCode: 'es',
						countryName: 'Spain',
						keywords: [],
					},
				],
				helpMessage: 'Second Testing Help Message',
				name: 'second-testing',
				share: '0.0',
				title: 'Second Testing',
				value: 0,
			},
		];

		const {getAllByText, getByText} = render(
			<StoreContextProvider
				value={{
					languageTag: mockLanguageTag,
					trafficSources: mockTrafficSources,
				}}
			>
				<TrafficSources onTrafficSourceClick={noop} />
			</StoreContextProvider>
		);

		const text1 = getByText('Testing');

		expect(text1).toBeInTheDocument();
		expect(text1).not.toHaveAttribute('type', 'button');

		const text2 = getByText('Second Testing');

		expect(text2).toBeInTheDocument();
		expect(text2).not.toHaveAttribute('type', 'button');

		const zeroValues = getAllByText('0');

		expect(zeroValues.length).toBe(2);
	});

	it('displays the traffic sources without buttons to view keywords when the value is 0 and there are country keywords', () => {
		const mockTrafficSources = [
			{
				countryKeywords: [
					{
						countryCode: 'us',
						countryName: 'United States',
						keywords: [],
					},
					{
						countryCode: 'es',
						countryName: 'Spain',
						keywords: [],
					},
				],
				helpMessage: 'Testing Help Message',
				name: 'testing',
				share: '80.0',
				title: 'Testing',
				value: 345,
			},
			{
				helpMessage: 'Second Testing Help Message',
				name: 'second-testing',
				share: '0.0',
				title: 'Second Testing',
				value: 0,
			},
			{
				helpMessage: 'Third Testing Help Message',
				name: 'third-testing',
				share: '20.0',
				title: 'Third Testing',
				value: 77,
			},
		];

		const {getAllByText, getByText} = render(
			<StoreContextProvider
				value={{
					languageTag: mockLanguageTag,
					trafficSources: mockTrafficSources,
				}}
			>
				<TrafficSources onTrafficSourceClick={noop} />
			</StoreContextProvider>
		);

		const text1 = getByText('Testing');

		expect(text1).toBeInTheDocument();
		expect(text1).toHaveAttribute('type', 'button');

		const text2 = getByText('Second Testing');

		expect(text2).toBeInTheDocument();
		expect(text2).not.toHaveAttribute('type', 'button');

		const zeroValues = getAllByText('0');
		expect(zeroValues.length).toBe(2);

		const text3 = getByText('Third Testing');

		expect(text3).toBeInTheDocument();
		expect(text3).not.toHaveAttribute('type', 'button');
	});

	it('displays a dash instead of value when there is an endpoint error', () => {
		const mockTrafficSources = [
			{
				helpMessage: 'Testing Help Message',
				name: 'testing',
				title: 'Testing',
			},
			{
				helpMessage: 'Second Testing Help Message',
				name: 'second-testing',
				title: 'Second Testing',
			},
		];

		const {getAllByText, getByText} = render(
			<StoreContextProvider
				value={{
					languageTag: mockLanguageTag,
					trafficSources: mockTrafficSources,
				}}
			>
				<TrafficSources onTrafficSourceClick={noop} />
			</StoreContextProvider>
		);

		const text1 = getByText('Testing');
		const text2 = getByText('Second Testing');

		const dashValues = getAllByText('-');
		expect(dashValues.length).toBe(2);

		expect(text1).not.toHaveAttribute('type', 'button');
		expect(text2).not.toHaveAttribute('type', 'button');
	});

	it('displays a message informing the user that there is no incoming traffic from search engines yet', () => {
		const mockTrafficSources = [
			{
				countryKeywords: [],
				helpMessage: 'Testing Help Message',
				name: 'testing',
				share: '0.0',
				title: 'Testing',
				value: 0,
			},
			{
				countryKeywords: [],
				helpMessage: 'Second Testing Help Message',
				name: 'second-testing',
				share: '0.0',
				title: 'Second Testing',
				value: 0,
			},
		];

		const {getAllByText, getByText} = render(
			<StoreContextProvider
				value={{
					languageTag: mockLanguageTag,
					trafficSources: mockTrafficSources,
				}}
			>
				<TrafficSources onTrafficSourceClick={noop} />
			</StoreContextProvider>
		);

		expect(getByText('Testing')).toBeInTheDocument();
		expect(getByText('Second Testing')).toBeInTheDocument();

		const zeroValues = getAllByText('0');
		expect(zeroValues.length).toBe(2);

		expect(
			getByText(
				'your-page-has-no-incoming-traffic-from-traffic-channels-yet'
			)
		).toBeInTheDocument();
	});
});
