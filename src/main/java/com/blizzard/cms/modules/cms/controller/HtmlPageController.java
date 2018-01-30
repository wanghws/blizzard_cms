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
import com.blizzard.cms.modules.cms.entity.HtmlPage;
import com.blizzard.cms.modules.cms.service.HtmlPageService;

/**
 * 页面管理Controller
 * @author https://github.com/wanghws
 * @version 2018-01-30
 */
@Controller
@RequestMapping(value = "htmlPage")
public class HtmlPageController extends BaseController {

	@Autowired
	private HtmlPageService htmlPageService;
	
	@ModelAttribute
	public HtmlPage get(@RequestParam(required=false) Long id) {
		HtmlPage entity = null;

		entity = htmlPageService.get(id);

		if (entity == null){
			return new HtmlPage();
		}
		return entity;
	}
	
	@RequiresPermissions("htmlPage:list")
	@RequestMapping(value = "list")
	public String list(HtmlPage htmlPage, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<HtmlPage> page = htmlPageService.findPage(new Page<HtmlPage>(request, response), htmlPage); 
		model.addAttribute("page", page);
		return "modules/cms/htmlPageList";
	}

	@RequiresPermissions("htmlPage:form")
	@RequestMapping(value = "form")
	public String form(HtmlPage htmlPage, Model model) {
		model.addAttribute("htmlPage", htmlPage);
		return "modules/cms/htmlPageForm";
	}

	@RequiresPermissions("htmlPage:save")
	@RequestMapping(value = "save")
	public String save(HtmlPage htmlPage, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, htmlPage)){
			return form(htmlPage, model);
		}
		htmlPageService.save(htmlPage);
		addMessage(redirectAttributes, "保存页面成功");
		return "redirect:/htmlPage/list?repage";
	}
	
	@RequiresPermissions("htmlPage:delete")
	@RequestMapping(value = "delete")
	public String delete(HtmlPage htmlPage, RedirectAttributes redirectAttributes) {
		htmlPage.setStatus(0);
		htmlPageService.update(htmlPage);
		addMessage(redirectAttributes, "删除页面成功");
		return "redirect:/htmlPage/list?repage";
	}

}