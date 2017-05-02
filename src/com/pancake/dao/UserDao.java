package com.pancake.dao;

import java.util.List;

import com.pancake.entity.User;

public interface UserDao {
	public void save(User transientInstanc);
	public void delete(User persistentInstance);
	public User findById(java.lang.Integer id);
	public List findAll();
	public User findByUserName(Object userName);
	public User merge(User detachedInstance);
}
