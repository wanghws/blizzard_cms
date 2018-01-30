package com.blizzard.cms.modules.cms.entity;

import com.blizzard.cms.commons.entity.FrameworkEntity;
import com.blizzard.cms.commons.utils.DateUtils;
import com.blizzard.cms.commons.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HtmlPage extends FrameworkEntity<HtmlPage> {

	private String title;
	private String keyword;
	private String content;
	private String htmlName;
	private Long showUrl;
	private Long templateId;
	private Long channelId;
	private Long categoryId ;
	private String description;
	private Long jsonType;
	private String name;
	private Long parentId;
	
	
	
	
	private Long updateSchedulerId;
	private Long pubSchedulerId;
	private String beginTime;
	private String endTime;
	private String buildPath;
	private String buildName;
	private String templatePath;
	private String channelIds;
	private String pubTime;
	private String source;
	private String navigation;
	private HtmlPage prePage;
	private HtmlPage nextPage;
	private List<Map<String,Object>> contextList;
	private String url;
	private List<HtmlPage> randList;
	private String domain;
	private String domainId;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Long getJsonType() {
		return jsonType;
	}

	public void setJsonType(Long jsonType) {
		this.jsonType = jsonType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Long getUpdateSchedulerId() {
		return updateSchedulerId;
	}

	public void setUpdateSchedulerId(Long updateSchedulerId) {
		this.updateSchedulerId = updateSchedulerId;
	}

	public Long getPubSchedulerId() {
		return pubSchedulerId;
	}

	public void setPubSchedulerId(Long pubSchedulerId) {
		this.pubSchedulerId = pubSchedulerId;
	}

	public void setContextList(List<Map<String, Object>> contextList) {
		this.contextList = contextList;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<HtmlPage> getRandList() {
		return randList;
	}

	public void setRandList(List<HtmlPage> randList) {
		this.randList = randList;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getDomainId() {
		return domainId;
	}

	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}

	//


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getHtmlName() {
		return htmlName;
	}

	public void setHtmlName(String htmlName) {
		this.htmlName = htmlName;
	}

	public Long getShowUrl() {
		return showUrl;
	}

	public void setShowUrl(Long showUrl) {
		this.showUrl = showUrl;
	}

	public Long getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}

	public Long getChannelId() {
		return channelId;
	}

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getBuildPath() {
		return buildPath;
	}

	public void setBuildPath(String buildPath) {
		this.buildPath = buildPath;
	}

	public String getBuildName() {
		return buildName;
	}

	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}

	public String getTemplatePath() {
		return templatePath;
	}

	public void setTemplatePath(String templatePath) {
		this.templatePath = templatePath;
	}

	public String getChannelIds() {
		return channelIds;
	}

	public void setChannelIds(String channelIds) {
		this.channelIds = channelIds;
	}

	public String getPubTime() {
		return pubTime;
	}

	public void setPubTime(String pubTime) {
		this.pubTime = pubTime;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getNavigation() {
		return navigation;
	}

	public void setNavigation(String navigation) {
		this.navigation = navigation;
	}

	public HtmlPage getPrePage() {
		return prePage;
	}

	public void setPrePage(HtmlPage prePage) {
		this.prePage = prePage;
	}

	public HtmlPage getNextPage() {
		return nextPage;
	}

	public void setNextPage(HtmlPage nextPage) {
		this.nextPage = nextPage;
	}

	public List<Map<String, Object>> getContextList() {
		contextList = new ArrayList<Map<String,Object>>();
		Map<String,Object> context = new HashMap<String,Object>();
		context.put("key", "source");
		context.put("value",getSource());
		contextList.add(context);
		
		if(getJsonType()!=null && getJsonType()==1){
			context = new HashMap<String,Object>();
		    context.put("key", "page");
	    	context.put("value",Utils.readValue(getContent(),HashMap.class));
	    	contextList.add(context);
	    	context = new HashMap<String,Object>();
		    context.put("key", "content");
	    	context.put("value",((HashMap)Utils.readValue(getContent(),HashMap.class)).get("content"));
	    	contextList.add(context);
		}else{
	    	context = new HashMap<String,Object>();
		    context.put("key", "content");
	    	context.put("value",getContent());
	    	contextList.add(context);
		}

		context = new HashMap<String,Object>();
		context.put("key", "pubTime");
		context.put("value",getPubTime());
		contextList.add(context);
		
		context = new HashMap<String,Object>();
		context.put("key", "prePage");
		context.put("value",getPrePage());
		contextList.add(context);
		
		context = new HashMap<String,Object>();
		context.put("key", "nextPage");
		context.put("value",getNextPage());
		contextList.add(context);
		
		context = new HashMap<String,Object>();
		context.put("key", "id");
		context.put("value",getId());
		contextList.add(context);
		
		context = new HashMap<String,Object>();
		context.put("key", "createTime");
		context.put("value", DateUtils.formatDateTime(getCreateTime()));
		contextList.add(context);
		return contextList;
	}

	
	public String getChannelName(List<Channel> list){
		if(null==this.channelId)return "";
		for(Channel channel:list){
			if(channel.getId().longValue()==this.getChannelId().longValue()){
				return channel.getName();
			}
		}
		return "";
	}
	
	public String getTemplateName(List<Template> list){
		for(Template template:list){
			if(template.getId().longValue()==this.getTemplateId().longValue()){
				return template.getTitle();
			}
		}
		return "";
	}
				
}
