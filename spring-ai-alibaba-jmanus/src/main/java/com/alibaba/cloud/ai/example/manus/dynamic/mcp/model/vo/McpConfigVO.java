/*
 * Copyright 2025 the original author or authors.
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
package com.alibaba.cloud.ai.example.manus.dynamic.mcp.model.vo;

import com.alibaba.cloud.ai.example.manus.dynamic.mcp.model.po.McpConfigEntity;
import com.alibaba.cloud.ai.example.manus.dynamic.mcp.model.po.McpConfigType;

import java.util.ArrayList;
import java.util.List;

/**
 * VO object for frontend display of McpConfig
 */
public class McpConfigVO {

	private Long id;

	private String mcpServerName;

	private McpConfigType connectionType;

	private String connectionConfig;

	private List<String> toolNames; // Add tool name list for frontend display

	public McpConfigVO() {
	}

	public McpConfigVO(McpConfigEntity entity) {
		this.id = entity.getId();
		this.mcpServerName = entity.getMcpServerName();
		this.connectionType = entity.getConnectionType();
		this.connectionConfig = entity.getConnectionConfig();
		this.toolNames = new ArrayList<>(); // Initialize as empty list, may need to get
											// from other places in actual use
	}

	// Static method to convert VO list to entity list
	public static List<McpConfigVO> fromEntities(List<McpConfigEntity> entities) {
		List<McpConfigVO> vos = new ArrayList<>();
		if (entities != null) {
			for (McpConfigEntity entity : entities) {
				vos.add(new McpConfigVO(entity));
			}
		}
		return vos;
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMcpServerName() {
		return mcpServerName;
	}

	public void setMcpServerName(String mcpServerName) {
		this.mcpServerName = mcpServerName;
	}

	public McpConfigType getConnectionType() {
		return connectionType;
	}

	public void setConnectionType(McpConfigType connectionType) {
		this.connectionType = connectionType;
	}

	public String getConnectionConfig() {
		return connectionConfig;
	}

	public void setConnectionConfig(String connectionConfig) {
		this.connectionConfig = connectionConfig;
	}

	public List<String> getToolNames() {
		return toolNames;
	}

	public void setToolNames(List<String> toolNames) {
		this.toolNames = toolNames;
	}

	@Override
	public String toString() {
		return "McpConfigVO{" + "id=" + id + ", mcpServerName='" + mcpServerName + '\'' + ", connectionType="
				+ connectionType + ", connectionConfig='" + connectionConfig + '\'' + ", toolNames=" + toolNames + '}';
	}

}
