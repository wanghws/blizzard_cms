package com.blizzard.cms.modules.cms.entity;

import java.io.Serializable;


public class DynamicFragment implements Serializable{

	private Long channelId;
	private String orderByStr;
	private int limit;
	private int cur;
	private int sumPages;
	private String city;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getCur() {
		return cur;
	}
	public void setCur(int cur) {
		this.cur = cur;
	}
	public int getSumPages() {
		return sumPages;
	}
	public void setSumPages(int sumPages) {
		this.sumPages = sumPages;
	}
	public void setChannelId(Long channelId){
		this.channelId = channelId;
	}
	public Long getChannelId(){
		return this.channelId;
	}
	public void setOrderByStr(String orderByStr){
		this.orderByStr = orderByStr;
	}
	public String getOrderByStr(){
		return this.orderByStr;
	}
	public void setLimit(int limit){
		this.limit = limit;
	}
	public int getLimit(){
		return this.limit;
	}

}
