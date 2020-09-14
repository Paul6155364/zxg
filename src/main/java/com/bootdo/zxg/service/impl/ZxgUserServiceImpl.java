package com.bootdo.zxg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.bootdo.zxg.dao.ZxgUserDao;
import com.bootdo.zxg.domain.ZxgUserDO;
import com.bootdo.zxg.service.ZxgUserService;



@Service
public class ZxgUserServiceImpl implements ZxgUserService {
	@Autowired
	private ZxgUserDao zxgUserDao;
	
	@Override
	public ZxgUserDO get(String id){
		return zxgUserDao.get(id);
	}
	
	@Override
	public List<ZxgUserDO> list(Map<String, Object> map){
		return zxgUserDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return zxgUserDao.count(map);
	}
	
	@Override
	public int save(ZxgUserDO zxgUser){
		zxgUser.setId(UUID.randomUUID().toString().replaceAll("-",""));
		zxgUser.setInDate(new Date());
		zxgUser.setStatus(true);
		return zxgUserDao.save(zxgUser);
	}
	
	@Override
	public int update(ZxgUserDO zxgUser){
		zxgUser.setReDate(new Date());
		return zxgUserDao.update(zxgUser);
	}
	
	@Override
	public int remove(String id){
		return zxgUserDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return zxgUserDao.batchRemove(ids);
	}

	@Override
	public List<Map<String, Object>> zxgUser() {
		return zxgUserDao.zxgUser();
	}
	
}
