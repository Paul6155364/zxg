package com.bootdo.zxg.dao;

import com.bootdo.zxg.domain.ZxgMarketingDO;

import java.util.List;
import java.util.Map;

import com.bootdo.zxg.domain.ZxgOrderDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author teacherMa
 * @email teacherMa@163.com
 * @date 2020-08-07 16:46:51
 */
@Mapper
public interface ZxgMarketingDao {

	ZxgMarketingDO get(String id);
	
	List<ZxgMarketingDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ZxgMarketingDO zxgMarketing);
	
	int update(ZxgMarketingDO zxgMarketing);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

	List<ZxgMarketingDO> getZxgMarketing(String settlementDateStart, String settlementDateEnd);

	int updateZxgMarketing(String settlementId,String settlementDateStart,String settlementDateEnd);

	List<ZxgMarketingDO> getZxgMarketingName(String marketingName);
}
