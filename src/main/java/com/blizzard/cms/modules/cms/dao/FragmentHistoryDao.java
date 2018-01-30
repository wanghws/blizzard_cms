/**
 * Copyright &copy; 2017 demo.com All rights reserved.
 */
package com.blizzard.cms.modules.cms.dao;

import com.blizzard.cms.commons.dao.FrameworkDao;
import com.blizzard.cms.commons.annotation.MyBatisDao;
import com.blizzard.cms.modules.cms.entity.FragmentHistory;

/**
 * 碎片历史管理DAO接口
 * @author https://github.com/wanghws
 * @version 2018-01-30
 */
@MyBatisDao
public interface FragmentHistoryDao extends FrameworkDao<FragmentHistory> {
	
}