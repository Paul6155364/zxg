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
public class ZxgSettlementDO implements Serializable {
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
	//结算开始日期
	private Date settlementDateStart;
	//结算结束日期
	private Date settlementDateEnd;
	//结算ID
	private String settlementId;
	//结算人
	private String settlementName;
	//销售总费用
	private Double settlementFee;
	//货款总费用
	private Double paymentFee;
	//发货快递费总费用
	private Double deliveryCourierFee;
	//退货快递费总费用
	private Double returnCourierFee;
	//技术服务总费用
	private Double messageFee;
	//运费险总费用
	private Double freightFee;
	//小额打款总费用
	private Double remitSmallFee;
	//小额收款总费用
	private Double paySmallFee;
	//罚款总费用
	private Double fineFee;
	//多多进宝总费用
	private Double manyFee;
	//其他支出总费用
	private Double otherFee;
	//刷单总费用
	private Double brushFee;
	//营销活动总费用
	private Double marketingFee;
	//利润总费用
	private Double profitsFee;
	//结算结果
	private String settlementResults;
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
	 * 设置：结算开始日期
	 */
	public void setSettlementDateStart(Date settlementDateStart) {
		this.settlementDateStart = settlementDateStart;
	}
	/**
	 * 获取：结算开始日期
	 */
	public Date getSettlementDateStart() {
		return settlementDateStart;
	}
	/**
	 * 设置：结算结束日期
	 */
	public void setSettlementDateEnd(Date settlementDateEnd) {
		this.settlementDateEnd = settlementDateEnd;
	}
	/**
	 * 获取：结算结束日期
	 */
	public Date getSettlementDateEnd() {
		return settlementDateEnd;
	}
	/**
	 * 设置：结算ID
	 */
	public void setSettlementId(String settlementId) {
		this.settlementId = settlementId;
	}
	/**
	 * 获取：结算ID
	 */
	public String getSettlementId() {
		return settlementId;
	}
	/**
	 * 设置：结算人
	 */
	public void setSettlementName(String settlementName) {
		this.settlementName = settlementName;
	}
	/**
	 * 获取：结算人
	 */
	public String getSettlementName() {
		return settlementName;
	}
	/**
	 * 设置：销售总费用
	 */
	public void setSettlementFee(Double settlementFee) {
		this.settlementFee = settlementFee;
	}
	/**
	 * 获取：销售总费用
	 */
	public Double getSettlementFee() {
		return settlementFee;
	}
	/**
	 * 设置：货款总费用
	 */
	public void setPaymentFee(Double paymentFee) {
		this.paymentFee = paymentFee;
	}
	/**
	 * 获取：货款总费用
	 */
	public Double getPaymentFee() {
		return paymentFee;
	}
	/**
	 * 设置：发货快递费总费用
	 */
	public void setDeliveryCourierFee(Double deliveryCourierFee) {
		this.deliveryCourierFee = deliveryCourierFee;
	}
	/**
	 * 获取：发货快递费总费用
	 */
	public Double getDeliveryCourierFee() {
		return deliveryCourierFee;
	}
	/**
	 * 设置：退货快递费总费用
	 */
	public void setReturnCourierFee(Double returnCourierFee) {
		this.returnCourierFee = returnCourierFee;
	}
	/**
	 * 获取：退货快递费总费用
	 */
	public Double getReturnCourierFee() {
		return returnCourierFee;
	}
	/**
	 * 设置：技术服务总费用
	 */
	public void setMessageFee(Double messageFee) {
		this.messageFee = messageFee;
	}
	/**
	 * 获取：技术服务总费用
	 */
	public Double getMessageFee() {
		return messageFee;
	}
	/**
	 * 设置：运费险总费用
	 */
	public void setFreightFee(Double freightFee) {
		this.freightFee = freightFee;
	}
	/**
	 * 获取：运费险总费用
	 */
	public Double getFreightFee() {
		return freightFee;
	}
	/**
	 * 设置：小额打款总费用
	 */
	public void setRemitSmallFee(Double remitSmallFee) {
		this.remitSmallFee = remitSmallFee;
	}
	/**
	 * 获取：小额打款总费用
	 */
	public Double getRemitSmallFee() {
		return remitSmallFee;
	}
	/**
	 * 设置：小额收款总费用
	 */
	public void setPaySmallFee(Double paySmallFee) {
		this.paySmallFee = paySmallFee;
	}
	/**
	 * 获取：小额收款总费用
	 */
	public Double getPaySmallFee() {
		return paySmallFee;
	}
	/**
	 * 设置：罚款总费用
	 */
	public void setFineFee(Double fineFee) {
		this.fineFee = fineFee;
	}
	/**
	 * 获取：罚款总费用
	 */
	public Double getFineFee() {
		return fineFee;
	}
	/**
	 * 设置：多多进宝总费用
	 */
	public void setManyFee(Double manyFee) {
		this.manyFee = manyFee;
	}
	/**
	 * 获取：多多进宝总费用
	 */
	public Double getManyFee() {
		return manyFee;
	}
	/**
	 * 设置：其他支出总费用
	 */
	public void setOtherFee(Double otherFee) {
		this.otherFee = otherFee;
	}
	/**
	 * 获取：其他支出总费用
	 */
	public Double getOtherFee() {
		return otherFee;
	}
	/**
	 * 设置：刷单总费用
	 */
	public void setBrushFee(Double brushFee) {
		this.brushFee = brushFee;
	}
	/**
	 * 获取：刷单总费用
	 */
	public Double getBrushFee() {
		return brushFee;
	}

	public Double getMarketingFee() {
		return marketingFee;
	}

	public void setMarketingFee(Double marketingFee) {
		this.marketingFee = marketingFee;
	}

	/**
	 * 设置：利润总费用
	 */
	public void setProfitsFee(Double profitsFee) {
		this.profitsFee = profitsFee;
	}
	/**
	 * 获取：利润总费用
	 */
	public Double getProfitsFee() {
		return profitsFee;
	}
	/**
	 * 设置：结算结果
	 */
	public void setSettlementResults(String settlementResults) {
		this.settlementResults = settlementResults;
	}
	/**
	 * 获取：结算结果
	 */
	public String getSettlementResults() {
		return settlementResults;
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
