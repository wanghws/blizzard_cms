/**
 * Copyright &copy; 2017 demo.com All rights reserved.
 */
package com.blizzard.cms.commons.supcan.freeform;

import com.blizzard.cms.commons.supcan.common.Common;
import com.blizzard.cms.commons.supcan.common.properties.Properties;
import com.blizzard.cms.commons.supcan.common.Common;
import com.blizzard.cms.commons.supcan.common.properties.Properties;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 硕正FreeForm
 * @author WangZhen
 * @version 2013-11-04
 */
@XStreamAlias("FreeForm")
public class FreeForm extends Common {

	public FreeForm() {
		super();
	}
	
	public FreeForm(Properties properties) {
		this();
		this.properties = properties;
	}
	
}
