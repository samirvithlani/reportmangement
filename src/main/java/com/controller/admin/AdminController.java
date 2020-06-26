package com.controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.admin.AdminBean;
import com.dao.admin.AdminDao;
import com.dao.faculty.FacultyDao;
import com.dao.student.StudentDao;

@Controller
public class AdminController {

	@Autowired
	AdminDao adminDao;
	
	@Autowired
	FacultyDao facultyDao;
	
	@Autowired
	StudentDao studentDao;
	
	@RequestMapping(value = "/")
	public String home() {
		
		return "admin/dashboard";
	}
	@RequestMapping(value = "/loginpage")
	public String loginPage() {
		System.out.println("login page...");
		return "admin/login";
	}

	@RequestMapping(value = "/loginadmin",method = RequestMethod.POST)
	public String loginAdmin(@RequestParam("txtAdminEmail") String aEmail,
			@RequestParam("txtAdminPassword") String aPassword, Model m,HttpSession session) {
		System.out.println("login method called...");

		AdminBean adminBean = adminDao.loginAdmin(aEmail, aPassword);
		session.setAttribute("admin", adminBean);
		System.out.println(facultyDao.facultyList().get(0).getfName());
		session.setAttribute("faculty", facultyDao.facultyList());
		System.out.println(studentDao.studentListCount().size());
		session.setAttribute("slen", studentDao.studentListCount().size());
		
		
		return "admin/dashboard";
	}

}
