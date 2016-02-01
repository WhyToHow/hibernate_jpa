package com.mapping.associatemapping.one2one;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * 基于外键的 1-1 关联关系：在双向的一对一关联中，
 * 需要在关系被维护端(inverse side)中的 @OneToOne 注释中指定 mappedBy，以指定是这一关联中的被维护端。
 * 同时需要在关系维护端(owner side)建立外键列指向关系被维护端的主键列。

 * 
 * */
@Entity
@Table(name="t_card")
public class IdCard {
	private String cardNum;
	private String place;
	//身份证与用户 一对一的关系
	private User2 user;
	@Id
	@Column(name="card_num")
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	@Basic
	@Column(name="palce")
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	//此为维护方  需要指定外键
	@OneToOne(targetEntity=User2.class)
	@JoinColumn(name="user_id")
	public User2 getUser() {
		return user;
	}
	public void setUser(User2 user) {
		this.user = user;
	}

}
