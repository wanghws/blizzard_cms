/**
 * Copyright &copy; 2017 demo.com All rights reserved.
 */
package com.blizzard.cms.modules.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blizzard.cms.commons.utils.Page;
import com.blizzard.cms.commons.service.FrameworkService;
import com.blizzard.cms.modules.cms.entity.Scheduler;
import com.blizzard.cms.modules.cms.dao.SchedulerDao;

/**
 * 计划管理Service
 * @author https://github.com/wanghws
 * @version 2018-01-30
 */
@Service
public class SchedulerService extends FrameworkService<SchedulerDao, Scheduler> {

	public Scheduler get(Long id) {
		if(null==id)return null;
		return super.get(id);
	}
	
	public List<Scheduler> findList(Scheduler scheduler) {
		return super.findList(scheduler);
	}
	
	public Page<Scheduler> findPage(Page<Scheduler> page, Scheduler scheduler) {
		return super.findPage(page, scheduler);
	}
	
	@Transactional(readOnly = false)
	public void save(Scheduler scheduler) {
		super.save(scheduler);
	}
	
	@Transactional(readOnly = false)
	public void delete(Scheduler scheduler) {
		super.delete(scheduler);
	}
	
}