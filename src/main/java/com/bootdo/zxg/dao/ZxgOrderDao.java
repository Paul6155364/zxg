package com.bootdo.zxg.dao;

import com.bootdo.zxg.domain.ZxgOrderDO;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-08-05 10:06:22
 */
@Mapper
public interface ZxgOrderDao {

	ZxgOrderDO get(String id);
	
	List<ZxgOrderDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(ZxgOrderDO zxgOrder);
	
	int update(ZxgOrderDO zxgOrder);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

	List<ZxgOrderDO> getZxgOrder(String settlementDateStart,String settlementDateEnd);

	int updateZxgOrder(String settlementId,String settlementDateStart,String settlementDateEnd);

	List<ZxgOrderDO> getZxgOrderName(String buyName);
}
