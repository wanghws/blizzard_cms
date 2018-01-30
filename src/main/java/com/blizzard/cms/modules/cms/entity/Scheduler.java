package com.blizzard.cms.modules.cms.entity;

import com.blizzard.cms.commons.entity.FrameworkEntity;


public class Scheduler extends FrameworkEntity<Scheduler> {

	private String title;
	private String name;
	private String expression;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}
}
