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
public class ZxgProfitsDO implements Serializable {
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
	//利润人
	private String profitsName;
	//利润解读
	private String profitsResults;
	//利润总费用
	private Double profitsFee;
	//结算ID
	private String settlementId;
	//结算周期
	private String settlementCycle;
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
	 * 设置：利润人
	 */
	public void setProfitsName(String profitsName) {
		this.profitsName = profitsName;
	}
	/**
	 * 获取：利润人
	 */
	public String getProfitsName() {
		return profitsName;
	}
	/**
	 * 设置：利润解读
	 */
	public void setProfitsResults(String profitsResults) {
		this.profitsResults = profitsResults;
	}
	/**
	 * 获取：利润解读
	 */
	public String getProfitsResults() {
		return profitsResults;
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
	 * 设置：结算周期
	 */
	public void setSettlementCycle(String settlementCycle) {
		this.settlementCycle = settlementCycle;
	}
	/**
	 * 获取：结算周期
	 */
	public String getSettlementCycle() {
		return settlementCycle;
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
