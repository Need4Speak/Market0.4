package com.pancake.service;

import com.pancake.entity.Good;
import com.pancake.entity.OrderTable;
import com.pancake.entity.Page;

public interface PageService {
	public Page<OrderTable> queryForOrderPage(int currentPage,int pageSize);
	public Page<Good> queryForGoodPage(int currentPage,int pageSize);
}
