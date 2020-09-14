package com.bootdo.zxg.service;

import com.bootdo.zxg.domain.ZxgUserDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author teacherMa
 * @email teacherMa@163.com
 * @date 2020-08-07 16:46:51
 */
public interface ZxgUserService {
	
	ZxgUserDO get(String id);
	
	List<ZxgUserDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ZxgUserDO zxgUser);
	
	int update(ZxgUserDO zxgUser);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

	List<Map<String,Object>> zxgUser();
}
