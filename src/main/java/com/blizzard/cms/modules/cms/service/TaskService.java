/**
 * Copyright &copy; 2017 demo.com All rights reserved.
 */
package com.blizzard.cms.modules.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blizzard.cms.commons.utils.Page;
import com.blizzard.cms.commons.service.FrameworkService;
import com.blizzard.cms.modules.cms.entity.Task;
import com.blizzard.cms.modules.cms.dao.TaskDao;

/**
 * 任务管理Service
 * @author https://github.com/wanghws
 * @version 2018-01-30
 */
@Service
public class TaskService extends FrameworkService<TaskDao, Task> {

	public Task get(Long id) {
		if(null==id)return null;
		return super.get(id);
	}
	
	public List<Task> findList(Task task) {
		return super.findList(task);
	}
	
	public Page<Task> findPage(Page<Task> page, Task task) {
		return super.findPage(page, task);
	}
	
	@Transactional(readOnly = false)
	public void save(Task task) {
		super.save(task);
	}
	
	@Transactional(readOnly = false)
	public void delete(Task task) {
		super.delete(task);
	}
	
}