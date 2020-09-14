package com.bootdo.zxg.service;

import com.bootdo.zxg.domain.ZxgAgentDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-08-06 09:30:12
 */
public interface ZxgAgentService {
	
	ZxgAgentDO get(String id);
	
	List<ZxgAgentDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ZxgAgentDO zxgAgent);
	
	int update(ZxgAgentDO zxgAgent);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

	List<Map<String,Object>> zxgAgent();
}
