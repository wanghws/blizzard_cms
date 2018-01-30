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
import com.blizzard.cms.modules.cms.entity.Fragment;
import com.blizzard.cms.modules.cms.service.FragmentService;

/**
 * 碎片管理Controller
 * @author https://github.com/wanghws
 * @version 2018-01-30
 */
@Controller
@RequestMapping(value = "fragment")
public class FragmentController extends BaseController {

	@Autowired
	private FragmentService fragmentService;
	
	@ModelAttribute
	public Fragment get(@RequestParam(required=false) Long id) {
		Fragment entity = null;

		entity = fragmentService.get(id);

		if (entity == null){
			return new Fragment();
		}
		return entity;
	}
	
	@RequiresPermissions("fragment:list")
	@RequestMapping(value = "list")
	public String list(Fragment fragment, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Fragment> page = fragmentService.findPage(new Page<Fragment>(request, response), fragment); 
		model.addAttribute("page", page);
		return "modules/cms/fragmentList";
	}

	@RequiresPermissions("fragment:form")
	@RequestMapping(value = "form")
	public String form(Fragment fragment, Model model) {
		model.addAttribute("fragment", fragment);
		return "modules/cms/fragmentForm";
	}

	@RequiresPermissions("fragment:save")
	@RequestMapping(value = "save")
	public String save(Fragment fragment, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, fragment)){
			return form(fragment, model);
		}
		fragmentService.save(fragment);
		addMessage(redirectAttributes, "保存碎片成功");
		return "redirect:/fragment/list?repage";
	}
	
	@RequiresPermissions("fragment:delete")
	@RequestMapping(value = "delete")
	public String delete(Fragment fragment, RedirectAttributes redirectAttributes) {
		fragment.setStatus(0);
		fragmentService.update(fragment);
		addMessage(redirectAttributes, "删除碎片成功");
		return "redirect:/fragment/list?repage";
	}

}