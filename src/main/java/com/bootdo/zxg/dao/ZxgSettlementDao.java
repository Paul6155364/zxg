package com.bootdo.zxg.dao;

import com.bootdo.zxg.domain.ZxgSettlementDO;

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
public interface ZxgSettlementDao {

	ZxgSettlementDO get(String id);
	
	List<ZxgSettlementDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ZxgSettlementDO zxgSettlement);
	
	int update(ZxgSettlementDO zxgSettlement);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
