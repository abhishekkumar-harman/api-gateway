/********************************************************************************
 * Copyright (c) 2023-24 Harman International
 *
 * <p>Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * <p>http://www.apache.org/licenses/LICENSE-2.0
 *
 * <p>Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and\
 * limitations under the License.
 *
 * <p>SPDX-License-Identifier: Apache-2.0
 ********************************************************************************/

package org.eclipse.ecsp.gateway.config;

import org.eclipse.ecsp.utils.logger.IgniteLogger;
import org.eclipse.ecsp.utils.logger.IgniteLoggerFactory;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import java.net.InetSocketAddress;

/**
 * Class to get the hostname from server web exchange object.
 */
@Service
public class RequestKeyResolver implements KeyResolver {

    /**
     * Creates a logger instance.
     */
    private static final IgniteLogger LOGGER
            = IgniteLoggerFactory.getLogger(RequestKeyResolver.class);

    /**
     * method to return the host name.
     *
     * @param exchange ServerWebExchange object
     * @return hostname returns hostname from ServerWebExchange object
     */
    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
        InetSocketAddress remoteAddress = exchange
                .getRequest().getRemoteAddress();
        if (remoteAddress == null) {
            LOGGER.error("Remote Address is null");
            return Mono.empty();
        }
        String hostName = remoteAddress.getHostName();
        LOGGER.debug("Client Key -> {}", hostName);
        return Mono.just(hostName);
    }
}