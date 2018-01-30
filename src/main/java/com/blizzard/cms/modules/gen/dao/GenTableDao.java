/**
 * Copyright &copy; 2017 demo.com All rights reserved.
 */
package com.blizzard.cms.modules.gen.dao;

import com.blizzard.cms.commons.annotation.MyBatisDao;
import com.blizzard.cms.modules.gen.entity.GenTable;
import com.blizzard.cms.commons.dao.FrameworkDao;

/**
 * 业务表DAO接口
 * @author demo.com
 * @version 2013-10-15
 */
@MyBatisDao
public interface GenTableDao extends FrameworkDao<GenTable> {
	
}
