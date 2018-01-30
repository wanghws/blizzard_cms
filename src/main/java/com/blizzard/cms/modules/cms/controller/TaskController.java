/**
 * Copyright &copy; 2017 demo.com All rights reserved.
 */
package com.blizzard.cms.modules.cms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.blizzard.cms.commons.config.Global;
import com.blizzard.cms.commons.utils.Page;
import com.blizzard.cms.commons.web.BaseController;
import com.blizzard.cms.commons.utils.StringUtils;
import com.blizzard.cms.modules.cms.entity.Task;
import com.blizzard.cms.modules.cms.service.TaskService;

/**
 * 任务管理Controller
 * @author https://github.com/wanghws
 * @version 2018-01-30
 */
@Controller
@RequestMapping(value = "task")
public class TaskController extends BaseController {

	@Autowired
	private TaskService taskService;
	
	@ModelAttribute
	public Task get(@RequestParam(required=false) Long id) {
		Task entity = null;

		entity = taskService.get(id);

		if (entity == null){
			return new Task();
		}
		return entity;
	}
	
	@RequiresPermissions("task:list")
	@RequestMapping(value = "list")
	public String list(Task task, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Task> page = taskService.findPage(new Page<Task>(request, response), task); 
		model.addAttribute("page", page);
		return "modules/cms/taskList";
	}

	@RequiresPermissions("task:form")
	@RequestMapping(value = "form")
	public String form(Task task, Model model) {
		model.addAttribute("task", task);
		return "modules/cms/taskForm";
	}

	@RequiresPermissions("task:save")
	@RequestMapping(value = "save")
	public String save(Task task, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, task)){
			return form(task, model);
		}
		taskService.save(task);
		addMessage(redirectAttributes, "保存任务成功");
		return "redirect:/task/list?repage";
	}
	
	@RequiresPermissions("task:delete")
	@RequestMapping(value = "delete")
	public String delete(Task task, RedirectAttributes redirectAttributes) {
		task.setStatus(0);
		taskService.update(task);
		addMessage(redirectAttributes, "删除任务成功");
		return "redirect:/task/list?repage";
	}

}