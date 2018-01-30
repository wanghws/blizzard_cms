package com.blizzard.cms.modules.cms.entity;

import java.io.Serializable;
import java.util.List;
import com.blizzard.cms.commons.entity.FrameworkEntity;


public class Domain extends FrameworkEntity<Domain>{

	private String path;	//路径
	private String domain;	//域名

	private List<Channel> channelList;
	
	public List<Channel> getChannelList() {
		return channelList;
	}
	public void setChannelList(List<Channel> channelList) {
		this.channelList = channelList;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public void setPath(String path){
		this.path = path;
	}
	public String getPath(){
		return this.path;
	}
		
}
