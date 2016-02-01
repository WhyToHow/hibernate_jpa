package com.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "t_user")
public class User {
	private Integer userId;
	private String userName;
	private Date myDate;
	@Transient
	private String test;//这个属性不是数据库表的字段，需要标识为transient
	
	@Id //主键标识需要放在getter方法上
	@Column(name="user_id")//只要标识为主键后 column注解须和id标识放在一起  否则报错
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	@Basic//(optional = false)//为true指定不能为空
	@Column(name = "user_name",columnDefinition="varchar2(30)",length=20,unique=false)//多个属性用逗号连接
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Basic //basic 与 column 为了保险起见 要放在一起 且在getter方法之上  防止出现数据库类型不完全的错误
	@Column(name="user_date",columnDefinition="timestamp",nullable=false)
	//@Temporal(value = TemporalType.TIMESTAMP)  显式注明数据库时间的类型
	public Date getMyDate() {
		return myDate;
	}
	public void setMyDate(Date myDate) {
		this.myDate = myDate;
	}

}
