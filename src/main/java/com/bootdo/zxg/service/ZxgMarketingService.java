package com.bootdo.zxg.service;

import com.bootdo.zxg.domain.ZxgMarketingDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author teacherMa
 * @email teacherMa@163.com
 * @date 2020-08-07 16:46:51
 */
public interface ZxgMarketingService {
	
	ZxgMarketingDO get(String id);
	
	List<ZxgMarketingDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ZxgMarketingDO zxgMarketing);
	
	int update(ZxgMarketingDO zxgMarketing);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
