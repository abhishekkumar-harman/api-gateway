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

package org.eclipse.ecsp.restclient;

import org.eclipse.ecsp.utils.logger.IgniteLogger;
import org.eclipse.ecsp.utils.logger.IgniteLoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Configuration class for RestTemplate.
 */
@Configuration
public class RestTemplateConfig {
    private static final IgniteLogger LOGGER = IgniteLoggerFactory.getLogger(RestTemplateConfig.class);

    /**
     * Create and returns the object of RestTemplate.
     *
     * @param builder rest template builder.
     * @return RestTemplate Object
     */
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        // add rest error handler
        builder.errorHandler(new RestTemplateErrorHandler());
        // add log interceptor
        if (LOGGER.isDebugEnabled()) {
            builder.additionalInterceptors(new RestTemplateLogInterceptor());
        }
        return builder.build();
    }

}
