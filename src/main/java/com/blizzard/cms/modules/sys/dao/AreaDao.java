/**
 * Copyright &copy; 2017 demo.com All rights reserved.
 */
package com.blizzard.cms.modules.sys.dao;

import com.blizzard.cms.commons.annotation.MyBatisDao;
import com.blizzard.cms.commons.dao.TreeDao;
import com.blizzard.cms.modules.sys.entity.Area;

/**
 * 区域DAO接口
 * @author demo.com
 * @version 2014-05-16
 */
@MyBatisDao
public interface AreaDao extends TreeDao<Area> {
	
}
