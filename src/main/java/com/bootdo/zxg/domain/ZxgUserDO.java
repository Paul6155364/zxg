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
public class ZxgUserDO implements Serializable {
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
	//用户ID
	private String userId;
	//用户名
	private String userName;
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
	 * 设置：用户ID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户ID
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：用户名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：用户名
	 */
	public String getUserName() {
		return userName;
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
