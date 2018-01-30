/**
 * Copyright &copy; 2017 demo.com All rights reserved.
 */
package com.blizzard.cms.modules.sys.dao;

import com.blizzard.cms.commons.annotation.MyBatisDao;
import com.blizzard.cms.commons.dao.FrameworkDao;
import com.blizzard.cms.modules.sys.entity.Log;

/**
 * 日志DAO接口
 * @author demo.com
 * @version 2014-05-16
 */
@MyBatisDao
public interface LogDao extends FrameworkDao<Log> {

}
