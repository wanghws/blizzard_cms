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
import com.blizzard.cms.modules.cms.entity.PageFragment;
import com.blizzard.cms.modules.cms.service.PageFragmentService;

/**
 * 页面碎片管理Controller
 * @author https://github.com/wanghws
 * @version 2018-01-30
 */
@Controller
@RequestMapping(value = "pageFragment")
public class PageFragmentController extends BaseController {

	@Autowired
	private PageFragmentService pageFragmentService;
	
	@ModelAttribute
	public PageFragment get(@RequestParam(required=false) Long id) {
		PageFragment entity = null;

		entity = pageFragmentService.get(id);

		if (entity == null){
			return new PageFragment();
		}
		return entity;
	}
	
	@RequiresPermissions("pageFragment:list")
	@RequestMapping(value = "list")
	public String list(PageFragment pageFragment, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<PageFragment> page = pageFragmentService.findPage(new Page<PageFragment>(request, response), pageFragment); 
		model.addAttribute("page", page);
		return "modules/cms/pageFragmentList";
	}

	@RequiresPermissions("pageFragment:form")
	@RequestMapping(value = "form")
	public String form(PageFragment pageFragment, Model model) {
		model.addAttribute("pageFragment", pageFragment);
		return "modules/cms/pageFragmentForm";
	}

	@RequiresPermissions("pageFragment:save")
	@RequestMapping(value = "save")
	public String save(PageFragment pageFragment, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, pageFragment)){
			return form(pageFragment, model);
		}
		pageFragmentService.save(pageFragment);
		addMessage(redirectAttributes, "保存页面碎片成功");
		return "redirect:/pageFragment/list?repage";
	}
	
	@RequiresPermissions("pageFragment:delete")
	@RequestMapping(value = "delete")
	public String delete(PageFragment pageFragment, RedirectAttributes redirectAttributes) {
		pageFragment.setStatus(0);
		pageFragmentService.update(pageFragment);
		addMessage(redirectAttributes, "删除页面碎片成功");
		return "redirect:/pageFragment/list?repage";
	}

}