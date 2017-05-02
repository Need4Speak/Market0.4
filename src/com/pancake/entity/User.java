package com.pancake.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String userName;
	private String password;
	private Integer phoneNumber;
	private String gender;
	private String userPhoto;
	private Set orderTablesForBuyerId = new HashSet(0);
	private Set orderTablesForSellerId = new HashSet(0);
	private Set goods = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	/** full constructor */
	public User(String userName, String password, Integer phoneNumber,
			String gender, String userPhoto, Set orderTablesForBuyerId,
			Set orderTablesForSellerId, Set goods) {
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.userPhoto = userPhoto;
		this.orderTablesForBuyerId = orderTablesForBuyerId;
		this.orderTablesForSellerId = orderTablesForSellerId;
		this.goods = goods;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUserPhoto() {
		return this.userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

	public Set getOrderTablesForBuyerId() {
		return this.orderTablesForBuyerId;
	}

	public void setOrderTablesForBuyerId(Set orderTablesForBuyerId) {
		this.orderTablesForBuyerId = orderTablesForBuyerId;
	}

	public Set getOrderTablesForSellerId() {
		return this.orderTablesForSellerId;
	}

	public void setOrderTablesForSellerId(Set orderTablesForSellerId) {
		this.orderTablesForSellerId = orderTablesForSellerId;
	}

	public Set getGoods() {
		return this.goods;
	}

	public void setGoods(Set goods) {
		this.goods = goods;
	}

}