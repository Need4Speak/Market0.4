package com.pancake.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pancake.dao.impl.GoodDaoImpl;
import com.pancake.dao.impl.CollectionDaoImpl;
import com.pancake.dao.impl.UserDaoImpl;
import com.pancake.entity.Good;
import com.pancake.entity.OrderTable;
import com.pancake.entity.User;
import com.pancake.service.CollectionService;

@Service
public class CollectionServiceImpl implements CollectionService {

	private CollectionDaoImpl otdi = new CollectionDaoImpl();
	private GoodDaoImpl gdi = new GoodDaoImpl();
	private UserDaoImpl udi = new UserDaoImpl();
	
	@Override
	public OrderTable getOrderById(java.lang.Integer orderId) {
		OrderTable order = otdi.findById(orderId);
		return order;
	}
	
	@Override
	public OrderTable createCollection(String buyerName, int goodId) {
		String address = "Use param address temporary.";
		String description = "For collection use.";
		Good aGood = gdi.findById(goodId);
		User aBuyer = udi.findByUserName(buyerName);
		User aSeller = aGood.getUser();
//		int buyerId = aBuyer.getUserId();
//		int sellerId = aGood.getUser().getUserId();
		Timestamp creationTime = new Timestamp(System.currentTimeMillis());
		Timestamp cancelTime = null;
		int status = 1; // 1 means waiting for purchase.
		String deliveryAddress = address;
		double freight = aGood.getFreight();
		OrderTable aOrder = new OrderTable(aBuyer, aSeller, aGood, creationTime, cancelTime, status, deliveryAddress,
				freight, description);
		otdi.save(aOrder);
		return aOrder;
	}

	@Override
	public List<OrderTable> getOrderByBuyerName(String userName) {
		User user = udi.findByUserName(userName);
		return otdi.findByBuyer(user);
	}

	@Override
	public List<OrderTable> getOrderBySellerName(String userName) {
		User user = udi.findByUserName(userName);
		return otdi.findBySeller(user);
	}

	@Override
	public OrderTable update(OrderTable order) {
		otdi.merge(order);
		return order;
	}

	@Override
	public OrderTable getOrderByGoodAndBuyer(Integer goodId, User buyer) {
		OrderTable aCollection = null;
		List<OrderTable> collections = otdi.findByBuyer(buyer);
		for (OrderTable collection : collections) {
			if(goodId == collection.getGood().getGoodId()) {
				aCollection = collection;
				break;
			}
		}
//		System.out.println("goodId: " + aCollection.getGood().getGoodId());
		
		return aCollection;
	}

}
