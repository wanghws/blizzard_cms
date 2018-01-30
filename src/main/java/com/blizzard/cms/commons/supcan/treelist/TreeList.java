/**
 * Copyright &copy; 2017 demo.com All rights reserved.
 */
package com.blizzard.cms.commons.supcan.treelist;

import com.blizzard.cms.commons.supcan.common.Common;
import com.blizzard.cms.commons.supcan.common.fonts.Font;
import com.blizzard.cms.commons.supcan.common.properties.Properties;
import com.blizzard.cms.commons.supcan.common.Common;
import com.blizzard.cms.commons.supcan.common.fonts.Font;
import com.blizzard.cms.commons.supcan.common.properties.Properties;
import com.blizzard.cms.commons.supcan.annotation.common.fonts.SupFont;
import com.blizzard.cms.commons.supcan.annotation.treelist.SupTreeList;
import com.google.common.collect.Lists;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.List;

/**
 * 硕正TreeList
 * @author WangZhen
 * @version 2013-11-04
 */
@XStreamAlias("TreeList")
public class TreeList extends Common {

	/**
	 * 列集合
	 */
	@XStreamAlias("Cols")
	private List<Object> cols;

	public TreeList() {
		super();
	}
	
	public TreeList(Properties properties) {
		this();
		this.properties = properties;
	}
	
	public TreeList(SupTreeList supTreeList) {
		this();
		if (supTreeList != null){
			if (supTreeList.properties() != null){
				this.properties = new Properties(supTreeList.properties());
			}
			if (supTreeList.fonts() != null){
				for (SupFont supFont : supTreeList.fonts()){
					if (this.fonts == null){
						this.fonts = Lists.newArrayList();
					}
					this.fonts.add(new Font(supFont));
				}
			}
		}
	}
	
	public List<Object> getCols() {
		if (cols == null){
			cols = Lists.newArrayList();
		}
		return cols;
	}

	public void setCols(List<Object> cols) {
		this.cols = cols;
	}

}
