package com.pancake.dao.impl;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pancake.dao.CollectionDao;
import com.pancake.entity.OrderTable;
import com.pancake.util.HibernateSessionFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * OrderTable entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.pancake.entity.OrderTable
 * @author MyEclipse Persistence Tools
 */
public class CollectionDaoImpl implements CollectionDao {
	// private static final Logger log = LoggerFactory
	// .getLogger(OrderTableDaoImpl.class);
	// property constants
	public static final String GOOD_ID = "goodId";
	public static final String BUYER_ID = "buyerId";
	public static final String SELLER_ID = "sellerId";
	public static final String STATUS = "status";
	public static final String DELIVERY_ADDRESS = "deliveryAddress";
	public static final String FREIGHT = "freight";
	public static final String DESCRIPTION = "description";

	@Override
	public void save(OrderTable transientInstance) {
		// log.debug("saving OrderTable instance");
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();

			session.save(transientInstance);

			transaction.commit();
			HibernateSessionFactory.closeSession();
			// log.debug("save successful");
		} catch (RuntimeException re) {
			// log.error("save failed", re);
			throw re;
		}
	}

	@Override
	public void delete(OrderTable persistentInstance) {
		// log.debug("deleting OrderTable instance");
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();

			session.delete(persistentInstance);

			transaction.commit();
			HibernateSessionFactory.closeSession();
			// log.debug("delete successful");
		} catch (RuntimeException re) {
			// log.error("delete failed", re);
			throw re;
		}
	}

	@Override
	public OrderTable findById(java.lang.Integer id) {
		// log.debug("getting OrderTable instance with id: " + id);
		try {
			Session session = HibernateSessionFactory.getSession();

			OrderTable instance = (OrderTable) session.get("com.pancake.entity.OrderTable", id);
			return instance;
		} catch (RuntimeException re) {
			// log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List findByExample(OrderTable instance) {
		// log.debug("finding OrderTable instance by example");
		try {
			Session session = HibernateSessionFactory.getSession();

			List results = session.createCriteria("com.pancake.entity.OrderTable").add(Example.create(instance)).list();
			// log.debug("find by example successful, result size: "
			// + results.size());
			return results;
		} catch (RuntimeException re) {
			// log.error("find by example failed", re);
			throw re;
		}
	}

	@Override
	public List findByProperty(String propertyName, Object value) {
		// log.debug("finding OrderTable instance with property: " +
		// propertyName
		// + ", value: " + value);
		try {
			String queryString = "from OrderTable as model where model." + propertyName
					+ "= ?   order by creationTime desc";
			Session session = HibernateSessionFactory.getSession();

			Query queryObject = session.createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			// log.error("find by property name failed", re);
			throw re;
		}
	}

	@Override
	public List findByGood(Object good) {
		return findByProperty("good", good);
	}

	@Override
	public List findByBuyer(Object buyer) {
		return findByProperty("userByBuyerId", buyer);
	}

	@Override
	public List findBySeller(Object seller) {
		return findByProperty("userBySellerId", seller);
	}

	@Override
	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	@Override
	public List findByDeliveryAddress(Object deliveryAddress) {
		return findByProperty(DELIVERY_ADDRESS, deliveryAddress);
	}

	@Override
	public List findByFreight(Object freight) {
		return findByProperty(FREIGHT, freight);
	}

	@Override
	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	@Override
	public List findAll() {
		// log.debug("finding all OrderTable instances");
		try {
			String queryString = "from OrderTable order by creationTime desc";
			Session session = HibernateSessionFactory.getSession();

			Query queryObject = session.createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			// log.error("find all failed", re);
			throw re;
		}
	}

	/**
	 * 分页查询
	 * 
	 * @param hql
	 *            查询的条件
	 * @param offset
	 *            开始记录
	 * @param length
	 *            一次查询几条记录
	 * @return 返回查询记录集合
	 */
	@Override
	public List<OrderTable> queryPageList(int offset, int length, Object value) {
		// TODO Auto-generated method stub
		List<OrderTable> entitylist = null;
		try {
			Session session = HibernateSessionFactory.getSession();
			Query query = session
					.createQuery("from OrderTable where status = 1 and userByBuyerId = ? order by creationTime desc");
			query.setParameter(0, value);
			query.setFirstResult(offset);
			query.setMaxResults(length);
			entitylist = query.list();

		} catch (RuntimeException re) {
			throw re;
		}

		return entitylist;
	}

	@Override
	public OrderTable merge(OrderTable detachedInstance) {
		// log.debug("merging OrderTable instance");
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();

			OrderTable result = (OrderTable) session.merge(detachedInstance);

			transaction.commit();
			HibernateSessionFactory.closeSession();
			// log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			// log.error("merge failed", re);
			throw re;
		}
	}

	@Override
	public OrderTable findByGoodIdAndBuyeId(Integer goodId, Integer buyerId) {
		// TODO Auto-generated method stub
		return null;
	}

}