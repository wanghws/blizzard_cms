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
import com.blizzard.cms.modules.cms.entity.Channel;
import com.blizzard.cms.modules.cms.service.ChannelService;

/**
 * 频道管理Controller
 * @author https://github.com/wanghws
 * @version 2018-01-30
 */
@Controller
@RequestMapping(value = "channel")
public class ChannelController extends BaseController {

	@Autowired
	private ChannelService channelService;
	
	@ModelAttribute
	public Channel get(@RequestParam(required=false) Long id) {
		Channel entity = null;

		entity = channelService.get(id);

		if (entity == null){
			return new Channel();
		}
		return entity;
	}
	
	@RequiresPermissions("channel:list")
	@RequestMapping(value = "list")
	public String list(Channel channel, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Channel> page = channelService.findPage(new Page<Channel>(request, response), channel); 
		model.addAttribute("page", page);
		return "modules/cms/channelList";
	}

	@RequiresPermissions("channel:form")
	@RequestMapping(value = "form")
	public String form(Channel channel, Model model) {
		model.addAttribute("channel", channel);
		return "modules/cms/channelForm";
	}

	@RequiresPermissions("channel:save")
	@RequestMapping(value = "save")
	public String save(Channel channel, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, channel)){
			return form(channel, model);
		}
		channelService.save(channel);
		addMessage(redirectAttributes, "保存频道成功");
		return "redirect:/channel/list?repage";
	}
	
	@RequiresPermissions("channel:delete")
	@RequestMapping(value = "delete")
	public String delete(Channel channel, RedirectAttributes redirectAttributes) {
		channel.setStatus(0);
		channelService.update(channel);
		addMessage(redirectAttributes, "删除频道成功");
		return "redirect:/channel/list?repage";
	}

}