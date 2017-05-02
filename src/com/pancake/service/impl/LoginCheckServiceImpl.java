package com.pancake.service.impl;

import org.springframework.stereotype.Service;

import com.pancake.dao.impl.UserDaoImpl;
import com.pancake.entity.User;
import com.pancake.service.LoginCheckService;
@Service
public class LoginCheckServiceImpl implements LoginCheckService {

	@Override
	public boolean compareLoginInfo(String userName, String password) {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		User user = userDaoImpl.findByUserName(userName);
		if (user != null) {
			String passwordInDB = user.getPassword();
			if (passwordInDB.equals(password)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

}
