package com.bootdo.zxg.service;

import com.bootdo.zxg.domain.ZxgOrderDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-08-05 10:06:22
 */
public interface ZxgOrderService {
	
	ZxgOrderDO get(String id);
	
	List<ZxgOrderDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ZxgOrderDO zxgOrder);
	
	int update(ZxgOrderDO zxgOrder);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
