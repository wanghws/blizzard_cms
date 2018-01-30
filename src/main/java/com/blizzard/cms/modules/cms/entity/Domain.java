/**
 * Copyright &copy; 2017 demo.com All rights reserved.
 */
package com.blizzard.cms.modules.cms.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.blizzard.cms.commons.entity.FrameworkEntity;

/**
 * 域名管理Entity
 * @author https://github.com/wanghws
 * @version 2018-01-30
 */
public class Domain extends FrameworkEntity<Domain> {

	private String path;		// 路径
	private String domain;		// 域名

	@Length(min=0, max=128, message="路径长度必须介于 0 和 128 之间")
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	@Length(min=0, max=256, message="域名长度必须介于 0 和 256 之间")
	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

}