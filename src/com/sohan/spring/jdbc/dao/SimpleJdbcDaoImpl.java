package com.sohan.spring.jdbc.dao;

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.stereotype.Component;

@Component
public class SimpleJdbcDaoImpl extends SimpleJdbcDaoSupport {

	public int getCircleCount() {
		return getJdbcTemplate().queryForInt("SELECT COUNT(*) FROM CIRCLE");
	}

}
