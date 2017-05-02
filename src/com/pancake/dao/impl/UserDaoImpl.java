package com.pancake.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pancake.dao.UserDao;
import com.pancake.entity.User;
import com.pancake.util.HibernateSessionFactory;


public class UserDaoImpl implements UserDao{
	//private static final Logger log = LoggerFactory.getLogger(UserDaoImpl.class);

	/**
	 * @param transientInstance
	 */
	public void save(User transientInstance) {
		//log.debug("saving User instance");
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();
			session.save(transientInstance);
			transaction.commit();
			HibernateSessionFactory.closeSession();

			System.out.println("save success");
			//log.debug("save successful");
		} catch (RuntimeException re) {
			//log.error("save failed", re);
			throw re;
		}
	}

	/**
	 * @param persistentInstance
	 */
	public void delete(User persistentInstance) {
		//log.debug("deleting User instance");
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();
			session.delete(persistentInstance);
			transaction.commit();
			HibernateSessionFactory.closeSession();

			//log.debug("delete successful");
		} catch (RuntimeException re) {
			//log.error("delete failed", re);
			throw re;
		}
	}
	
	/**
	 * @param id
	 * @return
	 */
	public User findById(java.lang.Integer id) {
		//log.debug("getting User instance with id: " + id);
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();
			User instance = (User) session.get("com.pancake.entity.User", id);
			transaction.commit();
			HibernateSessionFactory.closeSession();
			return instance;
		} catch (RuntimeException re) {
			//log.error("get failed", re);
			throw re;
		}
	}
	
	/**
	 * @return
	 */
	public List findAll() {
		//log.debug("finding all User instances");
		try {
			String queryString = "from User";
			Session session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();
			Query queryObject = session.createQuery(queryString);
			transaction.commit();
			HibernateSessionFactory.closeSession();
			return queryObject.list();
		} catch (RuntimeException re) {
			//log.error("find all failed", re);
			throw re;
		}
	}
	
	public List findByProperty(String propertyName, Object value) {
//		log.debug("finding User instance with property: " + propertyName
//				+ ", value: " + value);
		try {
			String queryString = "from User as model where model."
					+ propertyName + "= ?";
			Session session = HibernateSessionFactory.getSession();
			
			Query queryObject = session.createQuery(queryString);
			queryObject.setParameter(0, value);
			
			return queryObject.list();
		} catch (RuntimeException re) {
//			log.error("find by property name failed", re);
			throw re;
		}
	}

	public User findByUserName(Object userName) {
		User user = null;
		if(0 != findByProperty("userName", userName).size())
		{
			user = (User) findByProperty("userName", userName).get(0);
		}
		HibernateSessionFactory.closeSession();
		return user;
	}

	@Override
	public User merge(User detachedInstance) {
//		log.debug("merging User instance");
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();
			
			User result = (User) session.merge(detachedInstance);
			
			transaction.commit();
			HibernateSessionFactory.closeSession();
//			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
//			log.error("merge failed", re);
			throw re;
		}
	}
	
	
}
