package com.pancake.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

public class GoodWithImage implements Serializable {

	// Fields

	private Integer goodId;
	private Classification classification;
	private User user;
	private String name;
	private Double price;
	private List<MultipartFile> pictures;
	private Double freight;
	private String description;
	private Integer status;
	private Set orderTables = new HashSet(0);

	// Constructors

	/** default constructor */
	public GoodWithImage() {
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


	public List<MultipartFile> getPictures() {
		return pictures;
	}


	public void setPictures(List<MultipartFile> pictures) {
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

	public Set getOrderTables() {
		return this.orderTables;
	}

	public void setOrderTables(Set orderTables) {
		this.orderTables = orderTables;
	}

}
