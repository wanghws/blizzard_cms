package com.blizzard.cms.modules.cms.entity;

import com.blizzard.cms.commons.entity.FrameworkEntity;


public class Task extends FrameworkEntity<Task>{

	private Long schedulerId;
	private Long pageId;
	private Integer type;
	private Integer schedulerType;
	private String callbackUrl;

	public Long getSchedulerId() {
		return schedulerId;
	}

	public void setSchedulerId(Long schedulerId) {
		this.schedulerId = schedulerId;
	}

	public Long getPageId() {
		return pageId;
	}

	public void setPageId(Long pageId) {
		this.pageId = pageId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getSchedulerType() {
		return schedulerType;
	}

	public void setSchedulerType(Integer schedulerType) {
		this.schedulerType = schedulerType;
	}

	public String getCallbackUrl() {
		return callbackUrl;
	}

	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}
}
