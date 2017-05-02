package com.pancake.entity;

import java.sql.Timestamp;

/**
 * AbstractOrderTable entity provides the base persistence definition of the
 * OrderTable entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractOrderTable implements java.io.Serializable {

	// Fields

	private Integer orderId;
	private Good good;
	private User userBySellerId;
	private User userByBuyerId;
	private Timestamp creationTime;
	private Timestamp cancelTime;
	private Integer status;
	private String deliveryAddress;
	private Double freight;
	private String description;

	// Constructors

	/** default constructor */
	public AbstractOrderTable() {
	}

	/** minimal constructor */
	public AbstractOrderTable(Good good, User userBySellerId, User userByBuyerId) {
		this.good = good;
		this.userBySellerId = userBySellerId;
		this.userByBuyerId = userByBuyerId;
	}

	/** full constructor */
	public AbstractOrderTable(Good good, User userBySellerId, User userByBuyerId, Timestamp creationTime,
			Timestamp cancelTime, Integer status, String deliveryAddress, Double freight, String description) {
		this.good = good;
		this.userBySellerId = userBySellerId;
		this.userByBuyerId = userByBuyerId;
		this.creationTime = creationTime;
		this.cancelTime = cancelTime;
		this.status = status;
		this.deliveryAddress = deliveryAddress;
		this.freight = freight;
		this.description = description;
	}

	// Property accessors

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Good getGood() {
		return this.good;
	}

	public void setGood(Good good) {
		this.good = good;
	}

	public User getUserBySellerId() {
		return this.userBySellerId;
	}

	public void setUserBySellerId(User userBySellerId) {
		this.userBySellerId = userBySellerId;
	}

	public User getUserByBuyerId() {
		return this.userByBuyerId;
	}

	public void setUserByBuyerId(User userByBuyerId) {
		this.userByBuyerId = userByBuyerId;
	}

	public Timestamp getCreationTime() {
		return this.creationTime;
	}

	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}

	public Timestamp getCancelTime() {
		return this.cancelTime;
	}

	public void setCancelTime(Timestamp cancelTime) {
		this.cancelTime = cancelTime;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDeliveryAddress() {
		return this.deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public Double getFreight() {
		return this.freight;
	}

	public void setFreight(Double freight) {
		this.freight = freight;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}