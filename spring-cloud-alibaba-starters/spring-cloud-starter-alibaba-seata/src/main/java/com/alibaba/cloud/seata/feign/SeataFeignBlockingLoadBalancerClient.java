/*
 * Copyright 2013-2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alibaba.cloud.seata.feign;

import java.io.IOException;

import feign.Client;
import feign.Request;
import feign.Response;

import org.springframework.cloud.loadbalancer.blocking.client.BlockingLoadBalancerClient;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.cloud.openfeign.loadbalancer.FeignBlockingLoadBalancerClient;

/**
 * @author yuhuangbin
 */
public class SeataFeignBlockingLoadBalancerClient
		extends FeignBlockingLoadBalancerClient {

	public SeataFeignBlockingLoadBalancerClient(Client delegate,
												BlockingLoadBalancerClient loadBalancerClient,
												LoadBalancerClientFactory loadBalancerClientFactory,
												SeataFeignObjectWrapper seataFeignObjectWrapper) {
		super((Client) seataFeignObjectWrapper.wrap(delegate), loadBalancerClient, loadBalancerClientFactory);
	}

	@Override
	public Response execute(Request request, Request.Options options) throws IOException {
		return super.execute(request, options);
	}

}
