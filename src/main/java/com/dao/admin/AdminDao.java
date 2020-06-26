package com.dao.admin;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.admin.AdminBean;

@Repository
public class AdminDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	private final static class AdminMapper implements RowMapper<AdminBean> {

		@Override
		public AdminBean mapRow(ResultSet rs, int rowNum) throws SQLException {

			AdminBean adminBean = new AdminBean();
			adminBean.setaId(rs.getInt("aid"));
			adminBean.setaName(rs.getString("aname"));
			adminBean.setaEmail(rs.getString("aemail"));
			adminBean.setaPassword(rs.getString("apassword"));
			return adminBean;
		}

	}

	public AdminBean loginAdmin(String aEmail, String aPassword) {

		return jdbcTemplate.queryForObject(
				"select * from admin where aemail ='" + aEmail + "' and apassword ='" + aPassword + "'", new AdminMapper());
	}

}
