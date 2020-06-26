package com.dao.faculty;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.faculty.FacultyBean;



@Repository
public class FacultyDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	private final static class FacultyMapper implements RowMapper<FacultyBean> {

		@Override
		public FacultyBean mapRow(ResultSet rs, int rowNum) throws SQLException {

			FacultyBean facultyBean = new FacultyBean();
			facultyBean.setfName(rs.getString("fname"));
			facultyBean.setfEmail(rs.getString("femail"));
			facultyBean.setfId(rs.getInt("fid"));
			facultyBean.setfPassword(rs.getString("fpassword"));
			facultyBean.setfAge(rs.getInt("fage"));
			facultyBean.setfMobile(rs.getString("fmobile"));

			return facultyBean;
		}

	}

	public List<FacultyBean> facultyList() {

		return jdbcTemplate.query("select * from faculty", new FacultyMapper());
	}
}
