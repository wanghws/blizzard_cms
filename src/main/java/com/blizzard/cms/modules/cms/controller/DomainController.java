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
import com.blizzard.cms.modules.cms.entity.Domain;
import com.blizzard.cms.modules.cms.service.DomainService;

/**
 * 域名管理Controller
 * @author https://github.com/wanghws
 * @version 2018-01-30
 */
@Controller
@RequestMapping(value = "domain")
public class DomainController extends BaseController {

	@Autowired
	private DomainService domainService;
	
	@ModelAttribute
	public Domain get(@RequestParam(required=false) Long id) {
		Domain entity = null;

		entity = domainService.get(id);

		if (entity == null){
			return new Domain();
		}
		return entity;
	}
	
	@RequiresPermissions("domain:list")
	@RequestMapping(value = "list")
	public String list(Domain domain, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Domain> page = domainService.findPage(new Page<Domain>(request, response), domain); 
		model.addAttribute("page", page);
		return "modules/cms/domainList";
	}

	@RequiresPermissions("domain:form")
	@RequestMapping(value = "form")
	public String form(Domain domain, Model model) {
		model.addAttribute("domain", domain);
		return "modules/cms/domainForm";
	}

	@RequiresPermissions("domain:save")
	@RequestMapping(value = "save")
	public String save(Domain domain, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, domain)){
			return form(domain, model);
		}
		domainService.save(domain);
		addMessage(redirectAttributes, "保存域名成功");
		return "redirect:/domain/list?repage";
	}
	
	@RequiresPermissions("domain:delete")
	@RequestMapping(value = "delete")
	public String delete(Domain domain, RedirectAttributes redirectAttributes) {
		domain.setStatus(0);
		domainService.update(domain);
		addMessage(redirectAttributes, "删除域名成功");
		return "redirect:/domain/list?repage";
	}

}