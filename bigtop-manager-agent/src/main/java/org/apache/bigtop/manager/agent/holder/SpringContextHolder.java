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
package org.apache.bigtop.manager.agent.holder;

import org.apache.bigtop.manager.agent.executor.CommandExecutor;
import org.apache.bigtop.manager.agent.ws.AgentWebSocketHandler;

import java.util.Map;

import jakarta.annotation.Nonnull;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
public class SpringContextHolder implements ApplicationContextAware {

    @Getter
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(@Nonnull ApplicationContext applicationContext) {
        SpringContextHolder.applicationContext = applicationContext;
    }

    public static AgentWebSocketHandler getAgentWebSocket() {
        return applicationContext.getBean(AgentWebSocketHandler.class);
    }

    public static Map<String, CommandExecutor> getCommandExecutors() {
        return applicationContext.getBeansOfType(CommandExecutor.class);
    }
}
