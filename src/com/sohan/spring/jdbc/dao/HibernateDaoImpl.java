package com.sohan.spring.jdbc.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateDaoImpl {

	@Autowired
	private SessionFactory sessionFactory;

	public long getCircleCount() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		String hql = "select count(*) from Circle";
		Query query = session.createQuery(hql);
		long count = (long) query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return count;
	}

}
