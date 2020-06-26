package com.controller.faculty;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.faculty.FacultyDao;

public class FacultyController {

	@Autowired
	FacultyDao facultyDao;

	@RequestMapping(value = "/facultylist")
	public String facultyList(HttpSession session) {

		System.out.println("faculty list");
		session.setAttribute("faculty", facultyDao.facultyList());

		return "admin/dashboard";
		
	}
}
