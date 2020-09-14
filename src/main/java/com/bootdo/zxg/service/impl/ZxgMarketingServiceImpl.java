package com.bootdo.zxg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.bootdo.zxg.dao.ZxgMarketingDao;
import com.bootdo.zxg.domain.ZxgMarketingDO;
import com.bootdo.zxg.service.ZxgMarketingService;



@Service
public class ZxgMarketingServiceImpl implements ZxgMarketingService {
	@Autowired
	private ZxgMarketingDao zxgMarketingDao;
	
	@Override
	public ZxgMarketingDO get(String id){
		return zxgMarketingDao.get(id);
	}
	
	@Override
	public List<ZxgMarketingDO> list(Map<String, Object> map){
		return zxgMarketingDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return zxgMarketingDao.count(map);
	}
	
	@Override
	public int save(ZxgMarketingDO zxgMarketing){
		zxgMarketing.setId(UUID.randomUUID().toString().replaceAll("-",""));
		return zxgMarketingDao.save(zxgMarketing);
	}
	
	@Override
	public int update(ZxgMarketingDO zxgMarketing){
		zxgMarketing.setReDate(new Date());
		return zxgMarketingDao.update(zxgMarketing);
	}
	
	@Override
	public int remove(String id){
		return zxgMarketingDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return zxgMarketingDao.batchRemove(ids);
	}
	
}
