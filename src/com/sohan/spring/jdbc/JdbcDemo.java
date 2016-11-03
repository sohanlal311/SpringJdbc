package com.sohan.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.sohan.spring.jdbc.dao.HibernateDaoImpl;

public class JdbcDemo {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		// JdbcDaoImpl dao = ctx.getBean("simpleJdbcDaoImpl",
		// JdbcDaoImpl.class);
		// SimpleJdbcDaoImpl dao = ctx.getBean("simpleJdbcDaoImpl",
		// SimpleJdbcDaoImpl.class);
		HibernateDaoImpl dao = ctx.getBean("hibernateDaoImpl", HibernateDaoImpl.class);
		System.out.println(dao.getCircleCount());
		// System.out.println(dao.getCircleName(1));
		// System.out.println(dao.getCircle(1).getName());
		// dao.insertCircle2(new Circle(4, "Fourth Circle"));
		// System.out.println(dao.getAllCircles().size());
		// dao.createTriangleTable();
	}

}
