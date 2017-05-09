package com.pancake.service;

import com.pancake.entity.Good;
import com.pancake.entity.OrderTable;
import com.pancake.entity.Page;

public interface PageService {
	public Page<OrderTable> queryForCollectionPage(int currentPage,int pageSize, String userName);
	public Page<Good> queryForGoodPage(int currentPage,int pageSize);
}
