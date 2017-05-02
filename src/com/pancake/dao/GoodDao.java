package com.pancake.dao;

import java.util.List;

import com.pancake.entity.Classification;
import com.pancake.entity.Good;
import com.pancake.entity.OrderTable;
import com.pancake.entity.User;


public interface GoodDao {
	public void save(Good transientInstance);
	public void delete(Good persistentInstance);
	public Good findById(java.lang.Integer id);
	public List findAll();
	public List findAllByAddTime();
	public List findByUser(User user);
	public List findByClassification(Classification classification);
	public Good merge(Good detachedInstance);
	public List<Good> queryPageList(int offset, int length);
}
