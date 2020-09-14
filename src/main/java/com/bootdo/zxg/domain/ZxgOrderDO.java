package com.bootdo.zxg.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author teacherMa
 * @email teacherMa@163.com
 * @date 2020-08-08 10:31:01
 */
public class ZxgOrderDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private String id;
	//创建时间
	private Date inDate;
	//创建者
	private String inRmk;
	//修改日期
	private Date reDate;
	//修改者
	private String reRmk;
	//状态
	private Boolean status;
	//订单ID
	private String orderId;
	//订单大类
	private String orderCategories;
	//订单小类
	private String orderStatus;
	//订单类型
	private String orderType;
	//订单品牌
	private String orderBrand;
	//产品名称
	private String productName;
	//商品规格
	private String productSpecifications;
	//购买人
	private String buyName;
	//购买人电话
	private String buyPhone;
	//购买人地址
	private String buyAddress;
	//销售价格
	private Double salesAmount;
	//发货快递费
	private Double deliveryCourierFee;
	//退货快递费
	private Double returnCourierFee;
	//技术服务费
	private Double messageFee;
	//运费险
	private Double freightInsurance;
	//小额打款
	private Double remitSmallMoney;
	//小额打款人
	private String remitSmallName;
	//小额打款原因
	private String remitSmallReason;
	//小额收款
	private Double paySmallMoney;
	//小额收款人
	private String paySmallName;
	//小额收款原因
	private String paySmallReason;
	//多多进宝
	private Double manyFee;
	//多多进宝比例
	private Double manyFeeRatio;
	//其他支出费
	private Double otherSupport;
	//其他支出原因
	private String otherSupportReason;
	//罚款
	private Double fine;
	//代理价
	private Double agentAmount;
	//代理人
	private String agentName;
	//货款人
	private String paymentName;
	//订单利润
	private Double profits;
	//是否结算
	private String settlementId;
	//备注
	private String comment;

	/**
	 * 设置：主键ID
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：主键ID
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：创建时间
	 */
	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getInDate() {
		return inDate;
	}
	/**
	 * 设置：创建者
	 */
	public void setInRmk(String inRmk) {
		this.inRmk = inRmk;
	}
	/**
	 * 获取：创建者
	 */
	public String getInRmk() {
		return inRmk;
	}
	/**
	 * 设置：修改日期
	 */
	public void setReDate(Date reDate) {
		this.reDate = reDate;
	}
	/**
	 * 获取：修改日期
	 */
	public Date getReDate() {
		return reDate;
	}
	/**
	 * 设置：修改者
	 */
	public void setReRmk(String reRmk) {
		this.reRmk = reRmk;
	}
	/**
	 * 获取：修改者
	 */
	public String getReRmk() {
		return reRmk;
	}
	/**
	 * 设置：状态
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}
	/**
	 * 获取：状态
	 */
	public Boolean getStatus() {
		return status;
	}
	/**
	 * 设置：订单ID
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	/**
	 * 获取：订单ID
	 */
	public String getOrderId() {
		return orderId;
	}
	/**
	 * 设置：订单大类
	 */
	public void setOrderCategories(String orderCategories) {
		this.orderCategories = orderCategories;
	}
	/**
	 * 获取：订单大类
	 */
	public String getOrderCategories() {
		return orderCategories;
	}
	/**
	 * 设置：订单小类
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	/**
	 * 获取：订单小类
	 */
	public String getOrderStatus() {
		return orderStatus;
	}
	/**
	 * 设置：订单类型
	 */
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	/**
	 * 获取：订单类型
	 */
	public String getOrderType() {
		return orderType;
	}
	/**
	 * 设置：订单品牌
	 */
	public void setOrderBrand(String orderBrand) {
		this.orderBrand = orderBrand;
	}
	/**
	 * 获取：订单品牌
	 */
	public String getOrderBrand() {
		return orderBrand;
	}
	/**
	 * 设置：产品名称
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * 获取：产品名称
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * 设置：商品规格
	 */
	public void setProductSpecifications(String productSpecifications) {
		this.productSpecifications = productSpecifications;
	}
	/**
	 * 获取：商品规格
	 */
	public String getProductSpecifications() {
		return productSpecifications;
	}
	/**
	 * 设置：购买人
	 */
	public void setBuyName(String buyName) {
		this.buyName = buyName;
	}
	/**
	 * 获取：购买人
	 */
	public String getBuyName() {
		return buyName;
	}
	/**
	 * 设置：购买人电话
	 */
	public void setBuyPhone(String buyPhone) {
		this.buyPhone = buyPhone;
	}
	/**
	 * 获取：购买人电话
	 */
	public String getBuyPhone() {
		return buyPhone;
	}
	/**
	 * 设置：购买人地址
	 */
	public void setBuyAddress(String buyAddress) {
		this.buyAddress = buyAddress;
	}
	/**
	 * 获取：购买人地址
	 */
	public String getBuyAddress() {
		return buyAddress;
	}
	/**
	 * 设置：销售价格
	 */
	public void setSalesAmount(Double salesAmount) {
		this.salesAmount = salesAmount;
	}
	/**
	 * 获取：销售价格
	 */
	public Double getSalesAmount() {
		return salesAmount;
	}
	/**
	 * 设置：发货快递费
	 */
	public void setDeliveryCourierFee(Double deliveryCourierFee) {
		this.deliveryCourierFee = deliveryCourierFee;
	}
	/**
	 * 获取：发货快递费
	 */
	public Double getDeliveryCourierFee() {
		return deliveryCourierFee;
	}
	/**
	 * 设置：退货快递费
	 */
	public void setReturnCourierFee(Double returnCourierFee) {
		this.returnCourierFee = returnCourierFee;
	}
	/**
	 * 获取：退货快递费
	 */
	public Double getReturnCourierFee() {
		return returnCourierFee;
	}
	/**
	 * 设置：技术服务费
	 */
	public void setMessageFee(Double messageFee) {
		this.messageFee = messageFee;
	}
	/**
	 * 获取：技术服务费
	 */
	public Double getMessageFee() {
		return messageFee;
	}
	/**
	 * 设置：运费险
	 */
	public void setFreightInsurance(Double freightInsurance) {
		this.freightInsurance = freightInsurance;
	}
	/**
	 * 获取：运费险
	 */
	public Double getFreightInsurance() {
		return freightInsurance;
	}
	/**
	 * 设置：小额打款
	 */
	public void setRemitSmallMoney(Double remitSmallMoney) {
		this.remitSmallMoney = remitSmallMoney;
	}
	/**
	 * 获取：小额打款
	 */
	public Double getRemitSmallMoney() {
		return remitSmallMoney;
	}
	/**
	 * 设置：小额打款人
	 */
	public void setRemitSmallName(String remitSmallName) {
		this.remitSmallName = remitSmallName;
	}
	/**
	 * 获取：小额打款人
	 */
	public String getRemitSmallName() {
		return remitSmallName;
	}
	/**
	 * 设置：小额打款原因
	 */
	public void setRemitSmallReason(String remitSmallReason) {
		this.remitSmallReason = remitSmallReason;
	}
	/**
	 * 获取：小额打款原因
	 */
	public String getRemitSmallReason() {
		return remitSmallReason;
	}
	/**
	 * 设置：小额收款
	 */
	public void setPaySmallMoney(Double paySmallMoney) {
		this.paySmallMoney = paySmallMoney;
	}
	/**
	 * 获取：小额收款
	 */
	public Double getPaySmallMoney() {
		return paySmallMoney;
	}
	/**
	 * 设置：小额收款人
	 */
	public void setPaySmallName(String paySmallName) {
		this.paySmallName = paySmallName;
	}
	/**
	 * 获取：小额收款人
	 */
	public String getPaySmallName() {
		return paySmallName;
	}
	/**
	 * 设置：小额收款原因
	 */
	public void setPaySmallReason(String paySmallReason) {
		this.paySmallReason = paySmallReason;
	}
	/**
	 * 获取：小额收款原因
	 */
	public String getPaySmallReason() {
		return paySmallReason;
	}
	/**
	 * 设置：多多进宝
	 */
	public void setManyFee(Double manyFee) {
		this.manyFee = manyFee;
	}
	/**
	 * 获取：多多进宝
	 */
	public Double getManyFee() {
		return manyFee;
	}
	/**
	 * 设置：多多进宝比例
	 */
	public void setManyFeeRatio(Double manyFeeRatio) {
		this.manyFeeRatio = manyFeeRatio;
	}
	/**
	 * 获取：多多进宝比例
	 */
	public Double getManyFeeRatio() {
		return manyFeeRatio;
	}
	/**
	 * 设置：其他支出费
	 */
	public void setOtherSupport(Double otherSupport) {
		this.otherSupport = otherSupport;
	}
	/**
	 * 获取：其他支出费
	 */
	public Double getOtherSupport() {
		return otherSupport;
	}
	/**
	 * 设置：其他支出原因
	 */
	public void setOtherSupportReason(String otherSupportReason) {
		this.otherSupportReason = otherSupportReason;
	}
	/**
	 * 获取：其他支出原因
	 */
	public String getOtherSupportReason() {
		return otherSupportReason;
	}
	/**
	 * 设置：罚款
	 */
	public void setFine(Double fine) {
		this.fine = fine;
	}
	/**
	 * 获取：罚款
	 */
	public Double getFine() {
		return fine;
	}
	/**
	 * 设置：代理价
	 */
	public void setAgentAmount(Double agentAmount) {
		this.agentAmount = agentAmount;
	}
	/**
	 * 获取：代理价
	 */
	public Double getAgentAmount() {
		return agentAmount;
	}
	/**
	 * 设置：代理人
	 */
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	/**
	 * 获取：代理人
	 */
	public String getAgentName() {
		return agentName;
	}
	/**
	 * 设置：货款人
	 */
	public void setPaymentName(String paymentName) {
		this.paymentName = paymentName;
	}
	/**
	 * 获取：货款人
	 */
	public String getPaymentName() {
		return paymentName;
	}
	/**
	 * 设置：订单利润
	 */
	public void setProfits(Double profits) {
		this.profits = profits;
	}
	/**
	 * 获取：订单利润
	 */
	public Double getProfits() {
		return profits;
	}
	/**
	 * 设置：是否结算
	 */
	public void setSettlementId(String settlementId) {
		this.settlementId = settlementId;
	}
	/**
	 * 获取：是否结算
	 */
	public String getSettlementId() {
		return settlementId;
	}
	/**
	 * 设置：备注
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
	 * 获取：备注
	 */
	public String getComment() {
		return comment;
	}
}
