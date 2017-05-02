package com.pancake.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.pancake.dao.ClassificationDao;
import com.pancake.entity.Classification;
import com.pancake.entity.Classification;
import com.pancake.util.HibernateSessionFactory;

public class ClassificationDaoImpl implements ClassificationDao {

	@Override
	public Classification findById(Integer id) {
		try {
			Session session = HibernateSessionFactory.getSession();
//			Transaction transaction = session.beginTransaction();
			
			Classification instance = (Classification) session.get("com.pancake.entity.Classification", id);
			
//			transaction.commit();
//			HibernateSessionFactory.closeSession();
			return instance;
		} catch (RuntimeException re) {
			//log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List findAll() {
		try {
			Session session = HibernateSessionFactory.getSession();
//			Transaction transaction = session.beginTransaction();
			
			String queryString = "from Classification";
			Query queryObject = session.createQuery(queryString);
			
//			transaction.commit();
//			HibernateSessionFactory.closeSession();
			return queryObject.list();
		} catch (RuntimeException re) {
			//log.error("find all failed", re);
			throw re;
		}
	}

}
