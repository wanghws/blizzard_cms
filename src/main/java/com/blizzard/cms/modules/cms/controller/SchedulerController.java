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
import com.blizzard.cms.commons.persistence.Page;
import com.blizzard.cms.commons.web.BaseController;
import com.blizzard.cms.commons.utils.StringUtils;
import com.blizzard.cms.modules.cms.entity.Scheduler;
import com.blizzard.cms.modules.cms.service.SchedulerService;

/**
 * 计划管理Controller
 * @author https://github.com/wanghws
 * @version 2018-01-30
 */
@Controller
@RequestMapping(value = "scheduler")
public class SchedulerController extends BaseController {

	@Autowired
	private SchedulerService schedulerService;
	
	@ModelAttribute
	public Scheduler get(@RequestParam(required=false) Long id) {
		Scheduler entity = null;

		entity = schedulerService.get(id);

		if (entity == null){
			return new Scheduler();
		}
		return entity;
	}
	
	@RequiresPermissions("scheduler:list")
	@RequestMapping(value = "list")
	public String list(Scheduler scheduler, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Scheduler> page = schedulerService.findPage(new Page<Scheduler>(request, response), scheduler); 
		model.addAttribute("page", page);
		return "modules/cms/schedulerList";
	}

	@RequiresPermissions("scheduler:form")
	@RequestMapping(value = "form")
	public String form(Scheduler scheduler, Model model) {
		model.addAttribute("scheduler", scheduler);
		return "modules/cms/schedulerForm";
	}

	@RequiresPermissions("scheduler:save")
	@RequestMapping(value = "save")
	public String save(Scheduler scheduler, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, scheduler)){
			return form(scheduler, model);
		}
		schedulerService.save(scheduler);
		addMessage(redirectAttributes, "保存计划成功");
		return "redirect:/scheduler/list?repage";
	}
	
	@RequiresPermissions("scheduler:delete")
	@RequestMapping(value = "delete")
	public String delete(Scheduler scheduler, RedirectAttributes redirectAttributes) {
		scheduler.setStatus(0);
		schedulerService.update(scheduler);
		addMessage(redirectAttributes, "删除计划成功");
		return "redirect:/scheduler/list?repage";
	}

}