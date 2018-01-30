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
import com.blizzard.cms.modules.cms.entity.FragmentHistory;
import com.blizzard.cms.modules.cms.service.FragmentHistoryService;

/**
 * 碎片历史管理Controller
 * @author https://github.com/wanghws
 * @version 2018-01-30
 */
@Controller
@RequestMapping(value = "fragmentHistory")
public class FragmentHistoryController extends BaseController {

	@Autowired
	private FragmentHistoryService fragmentHistoryService;
	
	@ModelAttribute
	public FragmentHistory get(@RequestParam(required=false) Long id) {
		FragmentHistory entity = null;

		entity = fragmentHistoryService.get(id);

		if (entity == null){
			return new FragmentHistory();
		}
		return entity;
	}
	
	@RequiresPermissions("fragmentHistory:list")
	@RequestMapping(value = "list")
	public String list(FragmentHistory fragmentHistory, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<FragmentHistory> page = fragmentHistoryService.findPage(new Page<FragmentHistory>(request, response), fragmentHistory); 
		model.addAttribute("page", page);
		return "modules/cms/fragmentHistoryList";
	}

	@RequiresPermissions("fragmentHistory:form")
	@RequestMapping(value = "form")
	public String form(FragmentHistory fragmentHistory, Model model) {
		model.addAttribute("fragmentHistory", fragmentHistory);
		return "modules/cms/fragmentHistoryForm";
	}

	@RequiresPermissions("fragmentHistory:save")
	@RequestMapping(value = "save")
	public String save(FragmentHistory fragmentHistory, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, fragmentHistory)){
			return form(fragmentHistory, model);
		}
		fragmentHistoryService.save(fragmentHistory);
		addMessage(redirectAttributes, "保存碎片历史成功");
		return "redirect:/fragmentHistory/list?repage";
	}
	
	@RequiresPermissions("fragmentHistory:delete")
	@RequestMapping(value = "delete")
	public String delete(FragmentHistory fragmentHistory, RedirectAttributes redirectAttributes) {
		fragmentHistory.setStatus(0);
		fragmentHistoryService.update(fragmentHistory);
		addMessage(redirectAttributes, "删除碎片历史成功");
		return "redirect:/fragmentHistory/list?repage";
	}

}