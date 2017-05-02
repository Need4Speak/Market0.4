package com.pancake.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pancake.dao.impl.GoodDaoImpl;
import com.pancake.entity.Good;
import com.pancake.entity.User;
import com.pancake.service.GoodService;
@Service
public class GoodServiceImpl implements GoodService {

	private GoodDaoImpl gdi = new GoodDaoImpl();

	@SuppressWarnings("unchecked")
	@Override
	public List<Good> getAllGoodsByUser(User user) {
		List<Good> goods = gdi.findByUser(user);
		return goods;
	}

	@Override
	public Good save(Good good) {
		gdi.save(good);
		return good;
	}

	@Override
	public Good update(Good good) {
//		// Set status here, otherwise the value of status is null.
//		good.setStatus(1);
		gdi.merge(good);
		return good;
	}

	@Override
	public Good get(int id) {
		Good good = gdi.findById(id);
		return good;
	}

}
