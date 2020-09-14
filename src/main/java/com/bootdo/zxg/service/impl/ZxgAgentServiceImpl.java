package com.bootdo.zxg.service.impl;

import com.bootdo.zxg.domain.ZxgOrderDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.bootdo.zxg.dao.ZxgAgentDao;
import com.bootdo.zxg.domain.ZxgAgentDO;
import com.bootdo.zxg.service.ZxgAgentService;



@Service
public class ZxgAgentServiceImpl implements ZxgAgentService {
	@Autowired
	private ZxgAgentDao zxgAgentDao;
	
	@Override
	public ZxgAgentDO get(String id){
		return zxgAgentDao.get(id);
	}
	
	@Override
	public List<ZxgAgentDO> list(Map<String, Object> map){
		return zxgAgentDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return zxgAgentDao.count(map);
	}

	private void profitAgent(ZxgAgentDO zxgAgent){
		zxgAgent.setId(UUID.randomUUID().toString().replaceAll("-",""));
		zxgAgent.setAgentId(UUID.randomUUID().toString().replaceAll("-",""));
		zxgAgent.setStatus(true);
		zxgAgent.setInDate(new Date());
	}
	@Override
	public int save(ZxgAgentDO zxgAgent){
		profitAgent(zxgAgent);
		return zxgAgentDao.save(zxgAgent);
	}
	
	@Override
	public int update(ZxgAgentDO zxgAgent){
		zxgAgent.setReDate(new Date());
		return zxgAgentDao.update(zxgAgent);
	}
	
	@Override
	public int remove(String id){
		return zxgAgentDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return zxgAgentDao.batchRemove(ids);
	}

	@Override
	public List<Map<String, Object>> zxgAgent() {
		return zxgAgentDao.zxgAgent();
	}
}
