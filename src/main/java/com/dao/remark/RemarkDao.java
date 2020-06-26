package com.dao.remark;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.bean.remarsks.RemarksBean;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;



@Service
public class RemarkDao {

	
	@Autowired
	JdbcTemplate jdbcTemplate; 
	
	@Autowired
	RemarkDao remarkDao;
	
	
	public int addRemarsk(RemarksBean remarksBean) {
		
		
		return jdbcTemplate.update("insert into remarks(discipline,regularity,grasping,doubtsolving,upgradation,reserch,task,exams,rdate,sid)values(?,?,?,?,?,?,?,?,?,?)",
				remarksBean.getDiscipline(),remarksBean.getRegularity(),remarksBean.getGrasping(),remarksBean.getDoubtsolving(),remarksBean.getUpgradation(),remarksBean.getReserch(),remarksBean.getTask(),remarksBean.getExams(),remarksBean.getrDate(),remarksBean.getsId()
				);
	}
	
	private final static class RemarkMapper implements RowMapper<RemarksBean>{

		@Override
		public RemarksBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			RemarksBean remarksBean = new RemarksBean();
			remarksBean.setDiscipline(rs.getInt("discipline"));
			remarksBean.setRegularity(rs.getInt("regularity"));
			remarksBean.setGrasping(rs.getInt("grasping"));
			remarksBean.setDoubtsolving(rs.getInt("doubtsolving"));
			remarksBean.setUpgradation(rs.getInt("upgradation"));
			remarksBean.setReserch(rs.getInt("reserch"));
			remarksBean.setTask(rs.getInt("task"));
			remarksBean.setExams(rs.getInt("exams"));
			remarksBean.setrDate(rs.getDate("rdate"));
			remarksBean.setsId(rs.getInt("sid"));
			remarksBean.setsName(rs.getString("sname"));
			
			
			return remarksBean;
		}
		
		
	}
	public List<RemarksBean> allstudentRemarskList(){
		
		
		return jdbcTemplate.query("select rid discipline,regularity,grasping,doubtsolving,upgradation,reserch,task,exams,rdate,sid,sname from remarks join student using (sid)", new RemarkMapper());
	}
	

	public String generateReport() {
		
		System.out.println("report method called...");

		String reportPath = "D:\\report";
		//
		try {
			// compile report file....
			JasperReport jasperReport = JasperCompileManager
					.compileReport("D:\\sts workspace2\\ReportaManagement\\reportxmls\\remarksreport.jrxml");
			// get your data source
			
			
			JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(remarkDao.allstudentRemarskList());

			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("createdBy", "sam");

			// fill the report

			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,
					jrBeanCollectionDataSource);
			//
			// export reort to pdf File
			JasperExportManager.exportReportToPdfFile(jasperPrint, reportPath + "\\remark.pdf");
			System.out.println("done");

		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "report sucessfully genereate @path " + reportPath;

	}
	

	
	
	public String generateRemarkReport(int sId) {
		
		System.out.println("report method called...");

		String reportPath = "D:\\report";
		//
		try {
			// compile report file....
			JasperReport jasperReport = JasperCompileManager
					.compileReport("D:\\sts workspace2\\ReportaManagement\\reportxmls\\studentremarks.jrxml");
			// get your data source
			
			
			JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(remarkDao.getStudentRemarks(sId));

			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("createdBy", "sam");

			// fill the report

			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,
					jrBeanCollectionDataSource);
			//
			// export reort to pdf File
			JasperExportManager.exportReportToPdfFile(jasperPrint, reportPath + "\\remark.pdf");
			System.out.println("done");

		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "report sucessfully genereate @path " + reportPath;

	}
	
	
	
	
	
	
	public List<RemarksBean> getStudentRemarks(int sId){
		
		
		return jdbcTemplate.query("select rid discipline,regularity,grasping,doubtsolving,upgradation,reserch,task,exams,rdate,sid,sname from remarks join student using (sid) where sid= "+sId+"", new RemarkMapper());
	}
	
}
