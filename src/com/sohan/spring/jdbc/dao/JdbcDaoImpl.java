package com.sohan.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.sohan.spring.jdbc.model.Circle;

@Component
public class JdbcDaoImpl {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	// @Autowired
	// private SimpleJdbcTemplate simpleJdbcTemplate;

	public int getCircleCount() {
		return jdbcTemplate.queryForInt("SELECT COUNT(*) FROM CIRCLE");
	}

	public String getCircleName(int id) {
		return jdbcTemplate.queryForObject("SELECT NAME FROM CIRCLE WHERE ID = ?", new Object[] { id }, String.class);
	}

	public Circle getCircle(int id) {
		return jdbcTemplate
				.queryForObject("SELECT * FROM CIRCLE WHERE ID = ?", new Object[] { id }, new CircleMapper());
	}

	public List<Circle> getAllCircles() {
		return jdbcTemplate.query("SELECT * FROM CIRCLE", new CircleMapper());
	}

	public void insertCircle(Circle circle) {
		jdbcTemplate.update("INSERT INTO CIRCLE (ID, NAME) VALUES (?, ?)",
				new Object[] { circle.getId(), circle.getName() });
	}

	public void insertCircle2(Circle circle) {
		String sql = "INSERT INTO CIRCLE (ID, NAME) VALUES (:id, :name)";
		SqlParameterSource source = new MapSqlParameterSource("id", circle.getId()).addValue("name", circle.getName());
		namedParameterJdbcTemplate.update(sql, source);
	}

	public void createTriangleTable() {
		jdbcTemplate.update("CREATE TABLE TRIANGLE (ID INTEGER, NAME CHAR(50))");
	}

	public static final class CircleMapper implements RowMapper<Circle> {

		@Override
		public Circle mapRow(ResultSet resultSet, int rownum) throws SQLException {
			Circle circle = new Circle();
			circle.setId(resultSet.getInt("ID"));
			circle.setName(resultSet.getString("NAME"));
			return circle;
		}

	}

}
