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
import com.blizzard.cms.modules.cms.entity.Template;
import com.blizzard.cms.modules.cms.service.TemplateService;

/**
 * 模板管理Controller
 * @author https://github.com/wanghws
 * @version 2018-01-30
 */
@Controller
@RequestMapping(value = "template")
public class TemplateController extends BaseController {

	@Autowired
	private TemplateService templateService;
	
	@ModelAttribute
	public Template get(@RequestParam(required=false) Long id) {
		Template entity = null;

		entity = templateService.get(id);

		if (entity == null){
			return new Template();
		}
		return entity;
	}
	
	@RequiresPermissions("template:list")
	@RequestMapping(value = "list")
	public String list(Template template, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Template> page = templateService.findPage(new Page<Template>(request, response), template); 
		model.addAttribute("page", page);
		return "modules/cms/templateList";
	}

	@RequiresPermissions("template:form")
	@RequestMapping(value = "form")
	public String form(Template template, Model model) {
		model.addAttribute("template", template);
		return "modules/cms/templateForm";
	}

	@RequiresPermissions("template:save")
	@RequestMapping(value = "save")
	public String save(Template template, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, template)){
			return form(template, model);
		}
		templateService.save(template);
		addMessage(redirectAttributes, "保存模板成功");
		return "redirect:/template/list?repage";
	}
	
	@RequiresPermissions("template:delete")
	@RequestMapping(value = "delete")
	public String delete(Template template, RedirectAttributes redirectAttributes) {
		template.setStatus(0);
		templateService.update(template);
		addMessage(redirectAttributes, "删除模板成功");
		return "redirect:/template/list?repage";
	}

}