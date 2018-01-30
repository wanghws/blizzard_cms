/**
 * Copyright &copy; 2017 demo.com All rights reserved.
 */
package com.blizzard.cms.modules.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blizzard.cms.commons.utils.Page;
import com.blizzard.cms.commons.service.FrameworkService;
import com.blizzard.cms.modules.cms.entity.Domain;
import com.blizzard.cms.modules.cms.dao.DomainDao;

/**
 * 域名管理Service
 * @author https://github.com/wanghws
 * @version 2018-01-30
 */
@Service
public class DomainService extends FrameworkService<DomainDao, Domain> {

	public Domain get(Long id) {
		if(null==id)return null;
		return super.get(id);
	}
	
	public List<Domain> findList(Domain domain) {
		return super.findList(domain);
	}
	
	public Page<Domain> findPage(Page<Domain> page, Domain domain) {
		return super.findPage(page, domain);
	}
	
	@Transactional(readOnly = false)
	public void save(Domain domain) {
		super.save(domain);
	}
	
	@Transactional(readOnly = false)
	public void delete(Domain domain) {
		super.delete(domain);
	}
	
}