package com.pancake.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * AbstractGood entity provides the base persistence definition of the Good
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractGood implements java.io.Serializable {

	// Fields

	private Integer goodId;
	private Classification classification;
	private User user;
	private String name;
	private Double price;
	private String pictures;
	private Double freight;
	private String description;
	private Integer status;
	private Timestamp addTime;
	private Timestamp delTime;
	private Set orderTables = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractGood() {
	}

	/** minimal constructor */
	public AbstractGood(Classification classification, String name, Double price, String pictures, Double freight) {
		this.classification = classification;
		this.name = name;
		this.price = price;
		this.pictures = pictures;
		this.freight = freight;
	}

	/** full constructor */
	public AbstractGood(Classification classification, User user, String name, Double price, String pictures,
			Double freight, String description, Integer status, Timestamp addTime, Timestamp delTime, Set orderTables) {
		this.classification = classification;
		this.user = user;
		this.name = name;
		this.price = price;
		this.pictures = pictures;
		this.freight = freight;
		this.description = description;
		this.status = status;
		this.addTime = addTime;
		this.delTime = delTime;
		this.orderTables = orderTables;
	}

	// Property accessors

	public Integer getGoodId() {
		return this.goodId;
	}

	public void setGoodId(Integer goodId) {
		this.goodId = goodId;
	}

	public Classification getClassification() {
		return this.classification;
	}

	public void setClassification(Classification classification) {
		this.classification = classification;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPictures() {
		return this.pictures;
	}

	public void setPictures(String pictures) {
		this.pictures = pictures;
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

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Timestamp getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	public Timestamp getDelTime() {
		return this.delTime;
	}

	public void setDelTime(Timestamp delTime) {
		this.delTime = delTime;
	}

	public Set getOrderTables() {
		return this.orderTables;
	}

	public void setOrderTables(Set orderTables) {
		this.orderTables = orderTables;
	}

}