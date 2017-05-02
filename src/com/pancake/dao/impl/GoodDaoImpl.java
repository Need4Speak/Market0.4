package com.pancake.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pancake.dao.GoodDao;
import com.pancake.entity.Classification;
import com.pancake.entity.Good;
import com.pancake.entity.OrderTable;
import com.pancake.entity.User;
import com.pancake.util.HibernateSessionFactory;

public class GoodDaoImpl implements GoodDao{
	
	/**
	 * @param transientInstance
	 */
	public void save(Good transientInstance) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();			
			session.save(transientInstance);			
			transaction.commit();
			HibernateSessionFactory.closeSession();
			
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	/**
	 * @param persistentInstance
	 */
	public void delete(Good persistentInstance) {
//		log.debug("deleting Good instance");
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
	 * @param persistentInstance
	 */
	public void update(Good persistentInstance) {
//		log.debug("deleting Good instance");
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();
			session.update(persistentInstance);
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
	public Good findById(java.lang.Integer id) {
		//log.debug("getting Good instance with id: " + id);
		try {
			Session session = HibernateSessionFactory.getSession();
//			Transaction transaction = session.beginTransaction();
			
			Good instance = (Good) session.get("com.pancake.entity.Good", id);
			
//			transaction.commit();
//			HibernateSessionFactory.closeSession();
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
		//log.debug("finding all Good instances");
		try {
			Session session = HibernateSessionFactory.getSession();
//			Transaction transaction = session.beginTransaction();
			
			String queryString = "from Good";
			Query queryObject = session.createQuery(queryString);
			
//			transaction.commit();
//			HibernateSessionFactory.closeSession();
			return queryObject.list();
		} catch (RuntimeException re) {
			//log.error("find all failed", re);
			throw re;
		}
	}
	
	@Override
	public List findAllByAddTime() {
		//log.debug("finding all Good instances");
		try {
			Session session = HibernateSessionFactory.getSession();
//			Transaction transaction = session.beginTransaction();
			
			String queryString = "from Good order by add_time desc";
			Query queryObject = session.createQuery(queryString);
			
//			transaction.commit();
//			HibernateSessionFactory.closeSession();
			return queryObject.list();
		} catch (RuntimeException re) {
			//log.error("find all failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
//		log.debug("finding Good instance with property: " + propertyName
//				+ ", value: " + value);
		try {
			String queryString = "from Good as model where model."
					+ propertyName + "= ?  order by add_time desc";
			Session session = HibernateSessionFactory.getSession();
			
			Query queryObject = session.createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
//			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findByUser(User user) {
		return findByProperty("user", user);
	}
	
	@Override
	public List findByClassification(Classification classification) {
		// TODO Auto-generated method stub
		return findByProperty("classification", classification);
	}

	public Good merge(Good detachedInstance) {
//		log.debug("merging Good instance");
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();
			
			Good result = (Good) session.merge(detachedInstance);
			
			transaction.commit();
			HibernateSessionFactory.closeSession();
//			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
//			log.error("merge failed", re);
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Good> queryPageList(int offset, int length) {
        List<Good> entitylist=null;
        try{
        	Session session = HibernateSessionFactory.getSession();
            Query query = session.createQuery("from Good where status != 0 order by add_time desc");
            query.setFirstResult(offset);
            query.setMaxResults(length);
            entitylist = query.list();
            
        }catch(RuntimeException re){
            throw re;
        }
        
        return entitylist;
	}
}
