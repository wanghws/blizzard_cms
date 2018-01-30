/**
 * Copyright &copy; 2017 demo.com All rights reserved.
 */
package com.blizzard.cms.modules.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blizzard.cms.commons.utils.Page;
import com.blizzard.cms.commons.service.FrameworkService;
import com.blizzard.cms.modules.cms.entity.Template;
import com.blizzard.cms.modules.cms.dao.TemplateDao;

/**
 * 模板管理Service
 * @author https://github.com/wanghws
 * @version 2018-01-30
 */
@Service
public class TemplateService extends FrameworkService<TemplateDao, Template> {

	public Template get(Long id) {
		if(null==id)return null;
		return super.get(id);
	}
	
	public List<Template> findList(Template template) {
		return super.findList(template);
	}
	
	public Page<Template> findPage(Page<Template> page, Template template) {
		return super.findPage(page, template);
	}
	
	@Transactional(readOnly = false)
	public void save(Template template) {
		super.save(template);
	}
	
	@Transactional(readOnly = false)
	public void delete(Template template) {
		super.delete(template);
	}
	
}