/**
 * Copyright &copy; 2017 demo.com All rights reserved.
 */
package com.blizzard.cms.modules.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blizzard.cms.commons.utils.Page;
import com.blizzard.cms.commons.service.FrameworkService;
import com.blizzard.cms.modules.cms.entity.HtmlPage;
import com.blizzard.cms.modules.cms.dao.HtmlPageDao;

/**
 * 页面管理Service
 * @author https://github.com/wanghws
 * @version 2018-01-30
 */
@Service
public class HtmlPageService extends FrameworkService<HtmlPageDao, HtmlPage> {

	public HtmlPage get(Long id) {
		if(null==id)return null;
		return super.get(id);
	}
	
	public List<HtmlPage> findList(HtmlPage htmlPage) {
		return super.findList(htmlPage);
	}
	
	public Page<HtmlPage> findPage(Page<HtmlPage> page, HtmlPage htmlPage) {
		return super.findPage(page, htmlPage);
	}
	
	@Transactional(readOnly = false)
	public void save(HtmlPage htmlPage) {
		super.save(htmlPage);
	}
	
	@Transactional(readOnly = false)
	public void delete(HtmlPage htmlPage) {
		super.delete(htmlPage);
	}
	
}