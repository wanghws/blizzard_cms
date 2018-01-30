package com.blizzard.cms.modules.cms.entity;

import com.blizzard.cms.commons.entity.FrameworkEntity;

import java.util.List;

public class Channel extends FrameworkEntity<Channel> {

	private String name;
	private String path;
	private Long domainId;
	private Long templateId;
	private Long parentId;
	private Integer displayStatus;
	private Integer pageStatus;
	private String htmlName;
	
	public Long getParentId() {
		return null==this.parentId?0:this.parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = (null==parentId?0:parentId);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Long getDomainId() {
		return domainId;
	}

	public void setDomainId(Long domainId) {
		this.domainId = domainId;
	}

	public Long getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}

	public String getHtmlName() {
		return htmlName;
	}

	public void setHtmlName(String htmlName) {
		this.htmlName = htmlName;
	}

	public Integer getDisplayStatus() {
		return displayStatus;
	}

	public void setDisplayStatus(Integer displayStatus) {
		this.displayStatus = displayStatus;
	}

	public Integer getPageStatus() {
		return pageStatus;
	}

	public void setPageStatus(Integer pageStatus) {
		this.pageStatus = pageStatus;
	}

	public String getDomainName(List<Domain> list ){
		for(Domain domain:list){
			if(domain.getId().longValue()==this.getDomainId().longValue()){
				return domain.getDomain();
			}
		}
		return "";
	}
}
