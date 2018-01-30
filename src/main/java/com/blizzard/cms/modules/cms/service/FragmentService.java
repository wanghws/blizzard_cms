/**
 * Copyright &copy; 2017 demo.com All rights reserved.
 */
package com.blizzard.cms.modules.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blizzard.cms.commons.utils.Page;
import com.blizzard.cms.commons.service.FrameworkService;
import com.blizzard.cms.modules.cms.entity.Fragment;
import com.blizzard.cms.modules.cms.dao.FragmentDao;

/**
 * 碎片管理Service
 * @author https://github.com/wanghws
 * @version 2018-01-30
 */
@Service
public class FragmentService extends FrameworkService<FragmentDao, Fragment> {

	public Fragment get(Long id) {
		if(null==id)return null;
		return super.get(id);
	}
	
	public List<Fragment> findList(Fragment fragment) {
		return super.findList(fragment);
	}
	
	public Page<Fragment> findPage(Page<Fragment> page, Fragment fragment) {
		return super.findPage(page, fragment);
	}
	
	@Transactional(readOnly = false)
	public void save(Fragment fragment) {
		super.save(fragment);
	}
	
	@Transactional(readOnly = false)
	public void delete(Fragment fragment) {
		super.delete(fragment);
	}
	
}