/**
 * Copyright &copy; 2017 demo.com All rights reserved.
 */
package com.blizzard.cms.modules.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blizzard.cms.commons.utils.Page;
import com.blizzard.cms.commons.service.FrameworkService;
import com.blizzard.cms.modules.cms.entity.FragmentHistory;
import com.blizzard.cms.modules.cms.dao.FragmentHistoryDao;

/**
 * 碎片历史管理Service
 * @author https://github.com/wanghws
 * @version 2018-01-30
 */
@Service
public class FragmentHistoryService extends FrameworkService<FragmentHistoryDao, FragmentHistory> {

	public FragmentHistory get(Long id) {
		if(null==id)return null;
		return super.get(id);
	}
	
	public List<FragmentHistory> findList(FragmentHistory fragmentHistory) {
		return super.findList(fragmentHistory);
	}
	
	public Page<FragmentHistory> findPage(Page<FragmentHistory> page, FragmentHistory fragmentHistory) {
		return super.findPage(page, fragmentHistory);
	}
	
	@Transactional(readOnly = false)
	public void save(FragmentHistory fragmentHistory) {
		super.save(fragmentHistory);
	}
	
	@Transactional(readOnly = false)
	public void delete(FragmentHistory fragmentHistory) {
		super.delete(fragmentHistory);
	}
	
}