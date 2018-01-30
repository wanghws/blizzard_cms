/**
 * Copyright &copy; 2017 demo.com All rights reserved.
 */
package com.blizzard.cms.modules.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blizzard.cms.commons.utils.Page;
import com.blizzard.cms.commons.service.FrameworkService;
import com.blizzard.cms.modules.cms.entity.Channel;
import com.blizzard.cms.modules.cms.dao.ChannelDao;

/**
 * 频道管理Service
 * @author https://github.com/wanghws
 * @version 2018-01-30
 */
@Service
public class ChannelService extends FrameworkService<ChannelDao, Channel> {

	public Channel get(Long id) {
		if(null==id)return null;
		return super.get(id);
	}
	
	public List<Channel> findList(Channel channel) {
		return super.findList(channel);
	}
	
	public Page<Channel> findPage(Page<Channel> page, Channel channel) {
		return super.findPage(page, channel);
	}
	
	@Transactional(readOnly = false)
	public void save(Channel channel) {
		super.save(channel);
	}
	
	@Transactional(readOnly = false)
	public void delete(Channel channel) {
		super.delete(channel);
	}
	
}