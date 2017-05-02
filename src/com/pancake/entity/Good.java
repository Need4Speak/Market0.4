package com.pancake.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

public class Good extends AbstractGood implements Serializable {

	public Good() {
		// TODO Auto-generated constructor stub
	}

	public Good(Classification classification, String name, Double price, String pictures, Double freight) {
		super(classification, name, price, pictures, freight);
		// TODO Auto-generated constructor stub
	}

	public Good(Classification classification, User user, String name, Double price, String pictures, Double freight,
			String description, Integer status, Timestamp addTime, Timestamp delTime, Set orderTables) {
		super(classification, user, name, price, pictures, freight, description, status, addTime, delTime, orderTables);
		// TODO Auto-generated constructor stub
	}

}
