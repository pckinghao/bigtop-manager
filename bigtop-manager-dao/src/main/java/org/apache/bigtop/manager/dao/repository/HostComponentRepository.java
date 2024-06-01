/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.bigtop.manager.dao.repository;

import org.apache.bigtop.manager.dao.entity.HostComponent;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HostComponentRepository extends JpaRepository<HostComponent, Long> {

    List<HostComponent> findAllByComponentClusterIdAndComponentComponentName(Long clusterId, String componentName);

    HostComponent findByComponentClusterIdAndComponentComponentNameAndHostHostname(Long clusterId, String componentName,
                                                                                   String hostnames);

    List<HostComponent> findAllByComponentClusterIdAndComponentComponentNameAndHostHostnameIn(Long clusterId,
                                                                                              String componentName,
                                                                                              List<String> hostnames);

    List<HostComponent> findAllByComponentClusterId(Long clusterId);

    HostComponent findByComponentComponentNameAndHostHostname(String componentName, String hostName);

    List<HostComponent> findAllByComponentClusterIdAndHostId(Long clusterId, Long componentId);

    List<HostComponent> findAllByComponentClusterIdAndComponentServiceId(Long clusterId, Long serviceId);

    List<HostComponent> findAllByComponentServiceId(Long serviceId);
}
