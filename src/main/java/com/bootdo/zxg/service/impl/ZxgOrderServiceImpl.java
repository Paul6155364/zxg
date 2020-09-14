package com.bootdo.zxg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.bootdo.zxg.dao.ZxgOrderDao;
import com.bootdo.zxg.domain.ZxgOrderDO;
import com.bootdo.zxg.service.ZxgOrderService;



@Service
public class ZxgOrderServiceImpl implements ZxgOrderService {
	@Autowired
	private ZxgOrderDao zxgOrderDao;
	
	@Override
	public ZxgOrderDO get(String id){
		return zxgOrderDao.get(id);
	}
	
	@Override
	public List<ZxgOrderDO> list(Map<String, Object> map){
		return zxgOrderDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return zxgOrderDao.count(map);
	}
	
	@Override
	public int save(ZxgOrderDO zxgOrder){
		profitCalculation(zxgOrder);
		zxgOrder.setId(UUID.randomUUID().toString().replaceAll("-",""));
		zxgOrder.setStatus(true);
		return zxgOrderDao.save(zxgOrder);
	}
	/**
	 * 利润计算
	 * @param zxgOrder
	 */
	private void profitCalculation(ZxgOrderDO zxgOrder){
		//获取：销售价格
		Double salesAmount = zxgOrder.getSalesAmount();
		//获取：代理价
		Double agentAmount = zxgOrder.getAgentAmount();
		//获取：发货快递费
		Double deliveryCourierFee = zxgOrder.getDeliveryCourierFee();
		//获取：退货快递费
		Double returnCourierFee = zxgOrder.getReturnCourierFee();
		//获取：技术服务费销售价的千分之六
		Double messageFee = salesAmount*6/1000;
		//获取：运费险
		Double freightInsurance = 0.12D;
		//获取：小额打款
		Double remitSmallMoney = zxgOrder.getRemitSmallMoney();
		//获取：小额收款
		Double paySmallMoney = zxgOrder.getPaySmallMoney();
		//获取：多多进宝 销售价格*多多进宝比例
		Double manyFee = salesAmount*zxgOrder.getManyFeeRatio();
		//获取：其他支出费
		Double otherSupport = zxgOrder.getOtherSupport();
		//获取：罚款
		Double fine = zxgOrder.getFine();
		zxgOrder.setMessageFee(messageFee);
		zxgOrder.setFreightInsurance(freightInsurance);
		zxgOrder.setManyFee(manyFee);
		Double profits = salesAmount-agentAmount-deliveryCourierFee-returnCourierFee-messageFee-freightInsurance-remitSmallMoney+paySmallMoney-manyFee-otherSupport-fine;
		zxgOrder.setProfits(profits);
	}
	@Override
	public int update(ZxgOrderDO zxgOrder){
		profitCalculation(zxgOrder);
		zxgOrder.setReDate(new Date());
		return zxgOrderDao.update(zxgOrder);
	}
	
	@Override
	public int remove(String id){
		return zxgOrderDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return zxgOrderDao.batchRemove(ids);
	}
	
}
