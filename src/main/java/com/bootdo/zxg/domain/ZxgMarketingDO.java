package com.bootdo.zxg.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author teacherMa
 * @email teacherMa@163.com
 * @date 2020-08-07 16:46:51
 */
public class ZxgMarketingDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private String id;
	//创建时间
	private Date inDate;

	private String inDateStr;
	//创建者
	private String inRmk;
	//修改日期
	private Date reDate;
	//修改者
	private String reRmk;
	//状态
	private Boolean status;
	//营销ID
	private String marketingId;
	//营销人
	private String marketingName;
	//营销费用
	private Double marketingFee;
	//营销方式
	private String marketingWay;
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

	public String getInDateStr() {
		return inDateStr;
	}

	public void setInDateStr(String inDateStr) {
		this.inDateStr = inDateStr;
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
	 * 设置：营销ID
	 */
	public void setMarketingId(String marketingId) {
		this.marketingId = marketingId;
	}
	/**
	 * 获取：营销ID
	 */
	public String getMarketingId() {
		return marketingId;
	}
	/**
	 * 设置：营销人
	 */
	public void setMarketingName(String marketingName) {
		this.marketingName = marketingName;
	}
	/**
	 * 获取：营销人
	 */
	public String getMarketingName() {
		return marketingName;
	}
	/**
	 * 设置：营销费用
	 */
	public void setMarketingFee(Double marketingFee) {
		this.marketingFee = marketingFee;
	}
	/**
	 * 获取：营销费用
	 */
	public Double getMarketingFee() {
		return marketingFee;
	}
	/**
	 * 设置：营销方式
	 */
	public void setMarketingWay(String marketingWay) {
		this.marketingWay = marketingWay;
	}
	/**
	 * 获取：营销方式
	 */
	public String getMarketingWay() {
		return marketingWay;
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
