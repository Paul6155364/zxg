package com.bootdo.zxg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.zxg.dao.ZxgProfitsDao;
import com.bootdo.zxg.domain.ZxgProfitsDO;
import com.bootdo.zxg.service.ZxgProfitsService;



@Service
public class ZxgProfitsServiceImpl implements ZxgProfitsService {
	@Autowired
	private ZxgProfitsDao zxgProfitsDao;
	
	@Override
	public ZxgProfitsDO get(String id){
		return zxgProfitsDao.get(id);
	}
	
	@Override
	public List<ZxgProfitsDO> list(Map<String, Object> map){
		return zxgProfitsDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return zxgProfitsDao.count(map);
	}
	
	@Override
	public int save(ZxgProfitsDO zxgProfits){
		return zxgProfitsDao.save(zxgProfits);
	}
	
	@Override
	public int update(ZxgProfitsDO zxgProfits){
		return zxgProfitsDao.update(zxgProfits);
	}
	
	@Override
	public int remove(String id){
		return zxgProfitsDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return zxgProfitsDao.batchRemove(ids);
	}
	
}
