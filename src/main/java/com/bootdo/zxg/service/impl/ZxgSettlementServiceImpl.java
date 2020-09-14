package com.bootdo.zxg.service.impl;

import com.bootdo.zxg.dao.ZxgMarketingDao;
import com.bootdo.zxg.dao.ZxgOrderDao;
import com.bootdo.zxg.dao.ZxgProfitsDao;
import com.bootdo.zxg.domain.ZxgMarketingDO;
import com.bootdo.zxg.domain.ZxgOrderDO;
import com.bootdo.zxg.domain.ZxgProfitsDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.bootdo.zxg.dao.ZxgSettlementDao;
import com.bootdo.zxg.domain.ZxgSettlementDO;
import com.bootdo.zxg.service.ZxgSettlementService;



@Service
public class ZxgSettlementServiceImpl implements ZxgSettlementService {
	@Autowired
	private ZxgSettlementDao zxgSettlementDao;
	@Autowired
	private ZxgOrderDao zxgOrderDao;
	@Autowired
	private ZxgMarketingDao zxgMarketingDao;
	@Autowired
	private ZxgProfitsDao zxgProfitsDao;
	
	@Override
	public ZxgSettlementDO get(String id){
		return zxgSettlementDao.get(id);
	}
	
	@Override
	public List<ZxgSettlementDO> list(Map<String, Object> map){
		return zxgSettlementDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return zxgSettlementDao.count(map);
	}
	
	@Override
	public int save(ZxgSettlementDO zxgSettlement){
		zxgSettlement.setId(UUID.randomUUID().toString().replaceAll("-",""));
		zxgSettlement.setSettlementId(UUID.randomUUID().toString().replaceAll("-",""));
		generateSettlement(zxgSettlement);
		zxgProfits(zxgSettlement,"毛灵丹");
		zxgProfits(zxgSettlement,"姚欣宏");
		zxgProfits(zxgSettlement,"李萌");
		return zxgSettlementDao.save(zxgSettlement);
	}
	private void zxgProfits(ZxgSettlementDO zxgSettlement,String name){
		ZxgProfitsDO zxgProfits = new ZxgProfitsDO();
		zxgProfits.setId(UUID.randomUUID().toString().replaceAll("-",""));
		zxgProfits.setInDate(new Date());
		List<ZxgMarketingDO> zxgMarketingDOS = zxgMarketingDao.getZxgMarketingName(name);
		Double marketingFee = 0D;
		if(zxgMarketingDOS!=null&&zxgMarketingDOS.size()!=0){
			for(ZxgMarketingDO zxgMarketingDO : zxgMarketingDOS){
				marketingFee = marketingFee + zxgMarketingDO.getMarketingFee();
			}
		}
		Double brushFee = 0D;
		List<ZxgOrderDO> zxgOrderDOList = zxgOrderDao.getZxgOrderName(name);
		if(zxgOrderDOList!=null&&zxgOrderDOList.size()!=0){
			for(ZxgOrderDO ZxgOrderDO : zxgOrderDOList){
				brushFee = brushFee + ZxgOrderDO.getSalesAmount();
			}
		}
		//利润人
		zxgProfits.setProfitsName(name);
		Double phoneFee = 0D;
		Double profits = 0D;
		String profitsResults = "";
		Double paymentFee = 0D;
		Double profitsFee = 0D;
		if("李萌".equals(name)){
			phoneFee = 200d;
			profits = zxgSettlement.getProfitsFee()*2/10;
			profitsResults = "此周期内，利润总额度："+zxgSettlement.getProfitsFee()+"因分"+name+"利润:"+profits+"另补偿通信费："+phoneFee+"元，营销费："+marketingFee+"元，货款费："+paymentFee+"元，刷单费："+brushFee;
			profitsFee = profits+phoneFee+marketingFee+paymentFee+brushFee;
		}else if("毛灵丹".equals(name)){
			profits = zxgSettlement.getProfitsFee()*4/10;
			paymentFee = zxgSettlement.getPaymentFee();
			profitsResults = "此周期内，利润总额度："+zxgSettlement.getProfitsFee()+"因分"+name+"利润:"+profits+"另补偿通信费："+phoneFee+"元，营销费："+marketingFee+"元，货款费："+paymentFee+"元，刷单费："+brushFee;
			profitsFee = profits+phoneFee+marketingFee+paymentFee+brushFee;
		}else if("姚欣宏".equals(name)){
			profits = zxgSettlement.getProfitsFee()*4/10;
			profitsResults = "此周期内，利润总额度："+zxgSettlement.getProfitsFee()+"因分"+name+"利润:"+profits+"另补偿通信费："+phoneFee+"元，营销费："+marketingFee+"元，货款费："+paymentFee+"元，刷单费："+brushFee;
			profitsFee = profits+phoneFee+marketingFee+paymentFee+brushFee;
		}
		//利润解读
		zxgProfits.setProfitsFee(profitsFee);
		zxgProfits.setProfitsResults(profitsResults);
		//结算ID
		String settlementId = zxgSettlement.getSettlementId();
		zxgProfits.setSettlementId(settlementId);
		//结算周期
		Date settlementDateStart = zxgSettlement.getSettlementDateStart();
		Date settlementDateEnd = zxgSettlement.getSettlementDateEnd();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String settlementCycle = "结算周期："+simpleDateFormat.format(settlementDateStart)+"到"+simpleDateFormat.format(settlementDateEnd)+"。";
		zxgProfits.setSettlementCycle(settlementCycle);
		zxgProfitsDao.save(zxgProfits);
	}
	private void generateSettlement(ZxgSettlementDO zxgSettlement){
		String settlementId = zxgSettlement.getSettlementId();
		Date settlementDateStart = zxgSettlement.getSettlementDateStart();
		Date settlementDateEnd = zxgSettlement.getSettlementDateEnd();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		List<ZxgMarketingDO> zxgMarketingDOList = zxgMarketingDao.getZxgMarketing(simpleDateFormat.format(settlementDateStart),simpleDateFormat.format(settlementDateEnd));
		List<ZxgOrderDO> zxgOrderDOList = zxgOrderDao.getZxgOrder(simpleDateFormat.format(settlementDateStart),simpleDateFormat.format(settlementDateEnd));
		//获取周期订单
		//销售总费用
		Double settlementFee = 0.0D;
		//货款总费用
		Double paymentFee = 0.0D;
		//发货快递费总费用
		Double deliveryCourierFee = 0.0D;
		//退货快递费总费用
		Double returnCourierFee = 0.0D;
		//技术服务总费用
		Double messageFee = 0.0D;
		//运费险总费用
		Double freightFee = 0.0D;
		//小额打款总费用
		Double remitSmallFee = 0.0D;
		//小额收款总费用
		Double paySmallFee = 0.0D;
		//罚款总费用
		Double fineFee = 0.0D;
		//多多进宝总费用
		Double manyFee = 0.0D;
		//其他支出总费用（200通信费）
		Double otherFee = 200.0D;
		//刷单总费用
		Double brushFee = 0.0D;
		//营销活动总费用
		Double marketingFee = 0.0D;
		//利润总费用
		Double profitsFee = 0.0D;
		//结算结果
		String settlementResults = "";
		if(zxgOrderDOList!=null&&zxgOrderDOList.size()!=0){
			for(ZxgOrderDO zxgOrderDO : zxgOrderDOList){
				settlementFee = settlementFee + zxgOrderDO.getSalesAmount();
				messageFee = messageFee + zxgOrderDO.getMessageFee();
				freightFee = freightFee + zxgOrderDO.getFreightInsurance();
				manyFee = manyFee +zxgOrderDO.getManyFee();
				if(zxgOrderDO.getOrderStatus().equals("0")){
					paymentFee = paymentFee + 0.0D;
					deliveryCourierFee = deliveryCourierFee + 0.0D;
					returnCourierFee = returnCourierFee + 0.0D;
					remitSmallFee = remitSmallFee + 0.0D;
					paySmallFee = paySmallFee + 0.0D;
					fineFee = fineFee + 0.0D;
					otherFee = otherFee + 0.0D;
					brushFee = brushFee + zxgOrderDO.getSalesAmount();
				}else{
					paymentFee = paymentFee + zxgOrderDO.getAgentAmount();
					deliveryCourierFee = deliveryCourierFee + zxgOrderDO.getDeliveryCourierFee();
					returnCourierFee = returnCourierFee + zxgOrderDO.getReturnCourierFee();
					remitSmallFee = remitSmallFee + zxgOrderDO.getRemitSmallMoney();
					paySmallFee = paySmallFee + zxgOrderDO.getPaySmallMoney();
					fineFee = fineFee + zxgOrderDO.getFine();
					otherFee = otherFee +zxgOrderDO.getOtherSupport();
				}
			}
		}
		if(zxgMarketingDOList!=null&&zxgMarketingDOList.size()!=0){
			for(ZxgMarketingDO zxgMarketingDO : zxgMarketingDOList){
				marketingFee = marketingFee + zxgMarketingDO.getMarketingFee();
			}
		}
		profitsFee = settlementFee-paymentFee-deliveryCourierFee-returnCourierFee-messageFee-freightFee-remitSmallFee+paySmallFee-fineFee-manyFee-otherFee-brushFee-marketingFee;
		settlementResults = "结算周期："+simpleDateFormat.format(settlementDateStart)+"到"+simpleDateFormat.format(settlementDateEnd)+"。结算订单"+zxgOrderDOList.size()+"笔,"+
		"销售总费用:"+settlementFee+"元,货款总费用:"+paymentFee+"元,发货快递费总费用:"+deliveryCourierFee+"元,退货快递费总费用:"+returnCourierFee+"元,技术服务总费用:"+messageFee+"元,运费险总费用:"+freightFee+"元,小额打款总费用:"+remitSmallFee+
		"元,小额收款总费用:"+paySmallFee+"元,罚款总费用:"+fineFee+"元,多多进宝总费用:"+manyFee+"元,其他支出总费用:"+otherFee+"元,刷单总费用:"+brushFee+"元，营销活动总费用:"+marketingFee+"元，利润总费用:"+profitsFee;
		zxgSettlement.setSettlementFee(settlementFee);
		zxgSettlement.setPaymentFee(paymentFee);
		zxgSettlement.setDeliveryCourierFee(deliveryCourierFee);
		zxgSettlement.setReturnCourierFee(returnCourierFee);
		zxgSettlement.setMessageFee(messageFee);
		zxgSettlement.setFreightFee(freightFee);
		zxgSettlement.setRemitSmallFee(remitSmallFee);
		zxgSettlement.setPaySmallFee(paySmallFee);
		zxgSettlement.setFineFee(fineFee);
		zxgSettlement.setManyFee(manyFee);
		zxgSettlement.setOtherFee(otherFee);
		zxgSettlement.setBrushFee(brushFee);
		zxgSettlement.setMarketingFee(marketingFee);
		zxgSettlement.setProfitsFee(profitsFee);
		zxgSettlement.setSettlementResults(settlementResults);
		zxgOrderDao.updateZxgOrder(settlementId,simpleDateFormat.format(settlementDateStart),simpleDateFormat.format(settlementDateEnd));
		zxgMarketingDao.updateZxgMarketing(settlementId,simpleDateFormat.format(settlementDateStart),simpleDateFormat.format(settlementDateEnd));
	}
	@Override
	public int update(ZxgSettlementDO zxgSettlement){
		return zxgSettlementDao.update(zxgSettlement);
	}
	
	@Override
	public int remove(String id){
		return zxgSettlementDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return zxgSettlementDao.batchRemove(ids);
	}
	
}
