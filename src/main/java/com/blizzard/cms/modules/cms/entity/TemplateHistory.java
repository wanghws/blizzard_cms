package com.blizzard.cms.modules.cms.entity;

import com.blizzard.cms.commons.entity.FrameworkEntity;

import java.io.Serializable;
import java.util.Date;


public class TemplateHistory extends FrameworkEntity<TemplateHistory>{

	private Long templateId;

	private String content;


	public Long getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
