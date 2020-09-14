package com.bootdo.zxg.dao;

import com.bootdo.zxg.domain.ZxgUserDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author teacherMa
 * @email teacherMa@163.com
 * @date 2020-08-07 16:46:51
 */
@Mapper
public interface ZxgUserDao {

	ZxgUserDO get(String id);
	
	List<ZxgUserDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ZxgUserDO zxgUser);
	
	int update(ZxgUserDO zxgUser);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

	List<Map<String,Object>> zxgUser();
}
