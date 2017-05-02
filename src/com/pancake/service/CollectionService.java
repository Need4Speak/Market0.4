package com.pancake.service;

import java.util.List;
import com.pancake.entity.OrderTable;
import com.pancake.entity.User;

public interface CollectionService {
	public OrderTable getOrderById(java.lang.Integer orderId);
	public OrderTable getOrderByGoodAndBuyer(java.lang.Integer goodId, User buyer);
	public OrderTable createCollection(String buyerName, int goodId);
	public List<OrderTable> getOrderByBuyerName(String userName);
	public List<OrderTable> getOrderBySellerName(String userName);
	public OrderTable update(OrderTable order);
}
