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
import com.blizzard.cms.modules.cms.entity.TemplateHistory;
import com.blizzard.cms.modules.cms.service.TemplateHistoryService;

/**
 * 模板历史管理Controller
 * @author https://github.com/wanghws
 * @version 2018-01-30
 */
@Controller
@RequestMapping(value = "templateHistory")
public class TemplateHistoryController extends BaseController {

	@Autowired
	private TemplateHistoryService templateHistoryService;
	
	@ModelAttribute
	public TemplateHistory get(@RequestParam(required=false) Long id) {
		TemplateHistory entity = null;

		entity = templateHistoryService.get(id);

		if (entity == null){
			return new TemplateHistory();
		}
		return entity;
	}
	
	@RequiresPermissions("templateHistory:list")
	@RequestMapping(value = "list")
	public String list(TemplateHistory templateHistory, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TemplateHistory> page = templateHistoryService.findPage(new Page<TemplateHistory>(request, response), templateHistory); 
		model.addAttribute("page", page);
		return "modules/cms/templateHistoryList";
	}

	@RequiresPermissions("templateHistory:form")
	@RequestMapping(value = "form")
	public String form(TemplateHistory templateHistory, Model model) {
		model.addAttribute("templateHistory", templateHistory);
		return "modules/cms/templateHistoryForm";
	}

	@RequiresPermissions("templateHistory:save")
	@RequestMapping(value = "save")
	public String save(TemplateHistory templateHistory, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, templateHistory)){
			return form(templateHistory, model);
		}
		templateHistoryService.save(templateHistory);
		addMessage(redirectAttributes, "保存模板历史成功");
		return "redirect:/templateHistory/list?repage";
	}
	
	@RequiresPermissions("templateHistory:delete")
	@RequestMapping(value = "delete")
	public String delete(TemplateHistory templateHistory, RedirectAttributes redirectAttributes) {
		templateHistory.setStatus(0);
		templateHistoryService.update(templateHistory);
		addMessage(redirectAttributes, "删除模板历史成功");
		return "redirect:/templateHistory/list?repage";
	}

}