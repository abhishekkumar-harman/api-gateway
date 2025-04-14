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

package org.eclipse.ecsp.gateway.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * ApiService.
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@JsonInclude(value = Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiService implements Comparable<ApiService> {
    /**
     * name of the service.
     */
    private String name;
    /**
     * Url of thr service.
     */
    private String url;
    /**
     * description of thr service.
     */
    private String description;

    /**
     * overrided compareTo method to compare ApiService Objects.
     *
     * @param obj the object to be compared.
     * @return positive number if true or 0 if false
     */
    @Override
    public int compareTo(ApiService obj) {
        if (obj != null) {
            if (this.name != null) {
                return this.name.compareTo(obj.name);
            } else if (this.url != null) {
                return this.url.compareTo(obj.url);
            } else if (this.description != null) {
                return this.description.compareTo(obj.description);
            }
        }
        return 1;
    }

}