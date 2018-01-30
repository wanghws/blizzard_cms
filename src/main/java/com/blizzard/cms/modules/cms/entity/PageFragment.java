package com.blizzard.cms.modules.cms.entity;

import com.blizzard.cms.commons.entity.FrameworkEntity;

public class PageFragment extends FrameworkEntity<PageFragment>{

	private Long pageId;

	private Long fragmentId;

	private Long parentId;


	public Long getPageId() {
		return pageId;
	}

	public void setPageId(Long pageId) {
		this.pageId = pageId;
	}

	public Long getFragmentId() {
		return fragmentId;
	}

	public void setFragmentId(Long fragmentId) {
		this.fragmentId = fragmentId;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
}
