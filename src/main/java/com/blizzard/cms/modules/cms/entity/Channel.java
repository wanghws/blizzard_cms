/**
 * Copyright &copy; 2017 demo.com All rights reserved.
 */
package com.blizzard.cms.modules.cms.entity;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.blizzard.cms.commons.entity.FrameworkEntity;

/**
 * 频道管理Entity
 * @author https://github.com/wanghws
 * @version 2018-01-30
 */
public class Channel extends FrameworkEntity<Channel> {

	private Long parentId;		// 父级ID
	private Long domainId;		// 域ID
	private Long templateId;		// 模板ID
	private String path;		// 路径
	private String name;		// 名称
	private String htmlName;		// html名称
	private Integer displayStatus;		// display_status
	private Integer pageStatus;		// page_status
	private Integer status;		// 状态 0:正常,1:禁用
	private Long createUser;		// 创建用户ID
	private Date createTime;		// 创建时间
	
	public Channel() {
		super();
	}

	public Channel(Long id){
		super(id);
	}

	@NotNull(message="父级ID不能为空")
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	
	@NotNull(message="域ID不能为空")
	public Long getDomainId() {
		return domainId;
	}

	public void setDomainId(Long domainId) {
		this.domainId = domainId;
	}
	
	@NotNull(message="模板ID不能为空")
	public Long getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}
	
	@Length(min=1, max=128, message="路径长度必须介于 1 和 128 之间")
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	@Length(min=1, max=128, message="名称长度必须介于 1 和 128 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=1, max=128, message="html名称长度必须介于 1 和 128 之间")
	public String getHtmlName() {
		return htmlName;
	}

	public void setHtmlName(String htmlName) {
		this.htmlName = htmlName;
	}
	
	@NotNull(message="display_status不能为空")
	public Integer getDisplayStatus() {
		return displayStatus;
	}

	public void setDisplayStatus(Integer displayStatus) {
		this.displayStatus = displayStatus;
	}
	
	@NotNull(message="page_status不能为空")
	public Integer getPageStatus() {
		return pageStatus;
	}

	public void setPageStatus(Integer pageStatus) {
		this.pageStatus = pageStatus;
	}
	
	@NotNull(message="状态 0:正常,1:禁用不能为空")
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	@NotNull(message="创建用户ID不能为空")
	public Long getCreateUser() {
		return createUser;
	}

	public void setCreateUser(Long createUser) {
		this.createUser = createUser;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="创建时间不能为空")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}