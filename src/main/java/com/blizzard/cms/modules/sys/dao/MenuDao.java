/**
 * Copyright &copy; 2017 demo.com All rights reserved.
 */
package com.blizzard.cms.modules.sys.dao;

import com.blizzard.cms.commons.annotation.MyBatisDao;
import com.blizzard.cms.modules.sys.entity.Menu;
import com.blizzard.cms.commons.dao.FrameworkDao;

import java.util.List;

/**
 * 菜单DAO接口
 * @author demo.com
 * @version 2014-05-16
 */
@MyBatisDao
public interface MenuDao extends FrameworkDao<Menu> {

	public List<Menu> findByParentIdsLike(Menu menu);

	public List<Menu> findByUserId(Menu menu);
	
	public int updateParentIds(Menu menu);
	
	public int updateSort(Menu menu);
	
}
