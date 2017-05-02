package com.pancake.entity;

import java.util.Set;

/**
 * Classification entity. @author MyEclipse Persistence Tools
 */
public class Classification extends AbstractClassification implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Classification() {
	}

	/** minimal constructor */
	public Classification(String classificationName) {
		super(classificationName);
	}

	/** full constructor */
	public Classification(String classificationName, Set goods) {
		super(classificationName, goods);
	}

}
