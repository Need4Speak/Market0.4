package com.pancake.dao;

import java.util.List;

import com.pancake.entity.Classification;

public interface ClassificationDao {
	public Classification findById(java.lang.Integer id);
	public List findAll();
}
