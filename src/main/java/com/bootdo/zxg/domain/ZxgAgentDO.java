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
public class ZxgAgentDO implements Serializable {
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
	//代理ID
	private String agentId;
	//代理人
	private String agentName;
	//代理费
	private Integer agentFee;
	//代理星级
	private Integer agentStar;
	//代理对接人
	private String agentDocking;
	//代理来源
	private String agentSource;
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
	 * 设置：代理ID
	 */
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}
	/**
	 * 获取：代理ID
	 */
	public String getAgentId() {
		return agentId;
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
	 * 设置：代理费
	 */
	public void setAgentFee(Integer agentFee) {
		this.agentFee = agentFee;
	}
	/**
	 * 获取：代理费
	 */
	public Integer getAgentFee() {
		return agentFee;
	}
	/**
	 * 设置：代理星级
	 */
	public void setAgentStar(Integer agentStar) {
		this.agentStar = agentStar;
	}
	/**
	 * 获取：代理星级
	 */
	public Integer getAgentStar() {
		return agentStar;
	}
	/**
	 * 设置：代理对接人
	 */
	public void setAgentDocking(String agentDocking) {
		this.agentDocking = agentDocking;
	}
	/**
	 * 获取：代理对接人
	 */
	public String getAgentDocking() {
		return agentDocking;
	}
	/**
	 * 设置：代理来源
	 */
	public void setAgentSource(String agentSource) {
		this.agentSource = agentSource;
	}
	/**
	 * 获取：代理来源
	 */
	public String getAgentSource() {
		return agentSource;
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
