package com.bootdo.zxg.service;

import com.bootdo.zxg.domain.ZxgProfitsDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author teacherMa
 * @email teacherMa@163.com
 * @date 2020-08-07 16:46:51
 */
public interface ZxgProfitsService {
	
	ZxgProfitsDO get(String id);
	
	List<ZxgProfitsDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ZxgProfitsDO zxgProfits);
	
	int update(ZxgProfitsDO zxgProfits);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
