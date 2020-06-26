package com.dao.student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.student.StudentBean;

@Repository
public class StudentDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	static int count=0;
	public int addStudent(StudentBean studentBean) {

		String email = studentBean.getsEmail();
		String hashed = BCrypt.hashpw(email, BCrypt.gensalt());
		
		return jdbcTemplate.update("insert into student(sname,semail,smobile,syear,sbatch,fid)values(?,?,?,?,?,?)",
				studentBean.getsName(),studentBean.getsEmail(),studentBean.getsMobile(), studentBean.getsYear(),
				studentBean.getsBatch(),studentBean.getfId());
	}

	private final static class StudentMapper implements RowMapper<StudentBean> {

		
		@Override
		public StudentBean mapRow(ResultSet rs, int rowNum) throws SQLException {

			StudentBean studentBean = new StudentBean();
			studentBean.setsId(rs.getInt("sid"));
			studentBean.setsName(rs.getString("sname"));
			studentBean.setsEmail(rs.getString("semail"));
			studentBean.setsMobile(rs.getString("smobile"));
			studentBean.setsYear(rs.getString("syear"));
			studentBean.setsBatch(rs.getString("sbatch"));
			studentBean.setfName(rs.getString("fname"));
			return studentBean;
		}
	}

	public List<StudentBean> studentList() {

		return jdbcTemplate.query("select sid,sname,semail,smobile,syear,sbatch,fname from student join faculty using(fid)", new StudentMapper());
	}
	
	

	public List<StudentBean> studentListCount(){
		
		List<StudentBean> al = new ArrayList<StudentBean>();
		return jdbcTemplate.query("select sid,sname,semail,smobile,syear,sbatch,fname from student join faculty using(fid)", new ResultSetExtractor<List<StudentBean>>() {

			@Override
			public List<StudentBean> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while(rs.next()) {
				StudentBean studentBean = new StudentBean();
				studentBean.setsId(rs.getInt("sid"));
				studentBean.setsName(rs.getString("sname"));
				studentBean.setsEmail(rs.getString("semail"));
				studentBean.setsMobile(rs.getString("smobile"));
				studentBean.setsYear(rs.getString("syear"));
				studentBean.setsBatch(rs.getString("sbatch"));
				studentBean.setfName(rs.getString("fname"));
				al.add(studentBean);
				
				}
				
				return al;
			}
			
		});
	}
}
