/**
 * Copyright &copy; 2017 demo.com All rights reserved.
 */
package com.blizzard.cms.modules.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blizzard.cms.commons.utils.Page;
import com.blizzard.cms.commons.service.FrameworkService;
import com.blizzard.cms.modules.cms.entity.TemplateHistory;
import com.blizzard.cms.modules.cms.dao.TemplateHistoryDao;

/**
 * 模板历史管理Service
 * @author https://github.com/wanghws
 * @version 2018-01-30
 */
@Service
public class TemplateHistoryService extends FrameworkService<TemplateHistoryDao, TemplateHistory> {

	public TemplateHistory get(Long id) {
		if(null==id)return null;
		return super.get(id);
	}
	
	public List<TemplateHistory> findList(TemplateHistory templateHistory) {
		return super.findList(templateHistory);
	}
	
	public Page<TemplateHistory> findPage(Page<TemplateHistory> page, TemplateHistory templateHistory) {
		return super.findPage(page, templateHistory);
	}
	
	@Transactional(readOnly = false)
	public void save(TemplateHistory templateHistory) {
		super.save(templateHistory);
	}
	
	@Transactional(readOnly = false)
	public void delete(TemplateHistory templateHistory) {
		super.delete(templateHistory);
	}
	
}