package com.pancake.dao;

import java.util.List;
import com.pancake.entity.OrderTable;

public interface CollectionDao {
	public void save(OrderTable transientInstance);
	public void delete(OrderTable persistentInstance);
	public OrderTable findById(java.lang.Integer id);
	public OrderTable findByGoodIdAndBuyeId(java.lang.Integer goodId, java.lang.Integer buyerId);
	public List findByExample(OrderTable instance);
	public List findByProperty(String propertyName, Object value);
	public List findByGood(Object good);
	public List findByBuyer(Object buyer);
	public List findBySeller(Object seller);
	public List findByStatus(Object status);
	public List findByDeliveryAddress(Object deliveryAddress);
	public List findByFreight(Object freight);
	public List findByDescription(Object description);
	public List findAll();
	public List<OrderTable> queryPageList(int offset, int length, Object value);
	public OrderTable merge(OrderTable detachedInstance);
}
