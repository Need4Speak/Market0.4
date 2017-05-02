package com.pancake.service.impl;

import org.springframework.stereotype.Service;

import com.pancake.dao.impl.UserDaoImpl;
import com.pancake.entity.User;
import com.pancake.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserDaoImpl udi = new UserDaoImpl();

	@Override
	public User getByName(String userName) {
		return udi.findByUserName(userName);
	}

	@Override
	public User getById(int userId) {
		// TODO Auto-generated method stub
		return udi.findById(userId);
	}

	@Override
	public User update(User user) {
		udi.merge(user);
		return null;
	}
	
}
