/**
 * Copyright &copy; 2017 demo.com All rights reserved.
 */
package com.blizzard.cms.modules.sys.service;

import com.blizzard.cms.modules.sys.dao.DictDao;
import com.blizzard.cms.modules.sys.entity.Dict;
import com.blizzard.cms.modules.sys.utils.DictUtils;
import com.blizzard.cms.commons.service.FrameworkService;
import com.blizzard.cms.commons.utils.CacheUtils;
import com.blizzard.cms.modules.sys.entity.Dict;
import com.blizzard.cms.modules.sys.dao.DictDao;
import com.blizzard.cms.modules.sys.utils.DictUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 字典Service
 * @author demo.com
 * @version 2014-05-16
 */
@Service
public class DictService extends FrameworkService<DictDao, Dict> {
	
	/**
	 * 查询字段类型列表
	 * @return
	 */
	public List<String> findTypeList(){
		return dao.findTypeList(new Dict());
	}

	@Transactional(readOnly = false)
	public void save(Dict dict) {
		super.save(dict);
		CacheUtils.remove(DictUtils.CACHE_DICT_MAP);
	}

	@Transactional(readOnly = false)
	public void delete(Dict dict) {
		super.delete(dict);
		CacheUtils.remove(DictUtils.CACHE_DICT_MAP);
	}

}
