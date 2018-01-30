package com.blizzard.cms.modules.cms.entity;

import com.blizzard.cms.commons.entity.FrameworkEntity;

import java.util.List;



public class Fragment extends FrameworkEntity<Fragment>{

	private String title;

	private String name;

	private Long type;

	private String content;

	private Long categoryId;

	private String fileName;

	private String modifyUserName;

	private String beginTime;

	private String endTime;

	private Long parentId;

	private String includeUrl;

	private Integer fileType;

	private Integer sumPages;

	private Long domainId;


	private List<Object> jsonList;
	private Integer pageStatus;
	private HtmlPage cmsPage;
	private Long schedulerId;
	private String domain;


	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getModifyUserName() {
		return modifyUserName;
	}

	public void setModifyUserName(String modifyUserName) {
		this.modifyUserName = modifyUserName;
	}

	public Integer getFileType() {
		return fileType;
	}

	public void setFileType(Integer fileType) {
		this.fileType = fileType;
	}

	public Integer getPageStatus() {
		return pageStatus;
	}

	public void setPageStatus(Integer pageStatus) {
		this.pageStatus = pageStatus;
	}

	public HtmlPage getCmsPage() {
		return cmsPage;
	}

	public void setCmsPage(HtmlPage cmsPage) {
		this.cmsPage = cmsPage;
	}

	public Long getSchedulerId() {
		return schedulerId;
	}
	public void setSchedulerId(Long schedulerId) {
		this.schedulerId = schedulerId;
	}

	public List<Object> getJsonList() {
		return jsonList;
	}
	public void setJsonList(List<Object> jsonList) {
		this.jsonList = jsonList;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public Long getDomainId() {
		return domainId;
	}
	public void setDomainId(Long domainId) {
		this.domainId = domainId;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public Integer getSumPages() {
		return null==this.sumPages?0:this.sumPages;
	}
	public void setSumPages(Integer sumPages) {
		this.sumPages = (null==sumPages?0:sumPages);
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

	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public void setId(Long id){
		this.id = id;
	}
	public Long getId(){
		return this.id;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public String getTitle(){
		return this.title;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setType(Long type){
		this.type = type;
	}
	public Long getType(){
		return this.type;
	}
	public void setContent(String content){
		this.content = content;
	}
	public String getContent(){
		return this.content;
	}

	public void setIncludeUrl(String includeUrl){
		this.includeUrl = includeUrl;
	}
	public String getIncludeUrl(){
		return this.includeUrl;
	}

	public String getPreviewContent(){
		if(null==this.getContent())return "";
		return "<tt id=\"fragment"+this.getId()+"\" url=\"/cmsFragment/display?id="+this.getId()+"&source=div&keepThis=true&TB_iframe=true&height=400&width=680\" class=\"thickbox\">"+this.getContent()+"</tt>";
	}
	public String getDynamicContent(){
		if(null==this.getContent())return "";
		String include = "<!--#include file=\"/inc/"+this.getFileName()+".inc\"--> ";
		return include;
	}
	
	public String getDynamicContent(int i){
		if(null==this.getContent())return "";
		if(i<=1){
			return getDynamicContent();
		}
		String include = "<!--#include file=\"/inc/"+this.getFileName()+"_"+i+".inc\"--> ";
		return include;
	}
	public String getRequestParameter(String key){
		if(null==getIncludeUrl()||"".equals(getIncludeUrl()))return "";
		if(this.getIncludeUrl().lastIndexOf("?")>=0){
			String parameters = getIncludeUrl().substring(getIncludeUrl().lastIndexOf("?")+1,getIncludeUrl().length());
			String[] parametArray =  parameters.split("&");
			String[] item;
			for(String keys:parametArray){
				item = keys.split("=");
				if(key.equals(item[0])){
					return item[1];
				}
			}
		}
		return "";
	}
	
}
