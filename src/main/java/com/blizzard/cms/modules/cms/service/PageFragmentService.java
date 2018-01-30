/**
 * Copyright &copy; 2017 demo.com All rights reserved.
 */
package com.blizzard.cms.modules.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blizzard.cms.commons.utils.Page;
import com.blizzard.cms.commons.service.FrameworkService;
import com.blizzard.cms.modules.cms.entity.PageFragment;
import com.blizzard.cms.modules.cms.dao.PageFragmentDao;

/**
 * 页面碎片管理Service
 * @author https://github.com/wanghws
 * @version 2018-01-30
 */
@Service
public class PageFragmentService extends FrameworkService<PageFragmentDao, PageFragment> {

	public PageFragment get(Long id) {
		if(null==id)return null;
		return super.get(id);
	}
	
	public List<PageFragment> findList(PageFragment pageFragment) {
		return super.findList(pageFragment);
	}
	
	public Page<PageFragment> findPage(Page<PageFragment> page, PageFragment pageFragment) {
		return super.findPage(page, pageFragment);
	}
	
	@Transactional(readOnly = false)
	public void save(PageFragment pageFragment) {
		super.save(pageFragment);
	}
	
	@Transactional(readOnly = false)
	public void delete(PageFragment pageFragment) {
		super.delete(pageFragment);
	}
	
}