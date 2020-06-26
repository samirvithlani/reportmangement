package com.controller.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.student.StudentBean;
import com.dao.faculty.FacultyDao;
import com.dao.student.StudentDao;

@Controller
public class StudentController {

	@Autowired
	StudentDao studentDao;
	
	@Autowired
	FacultyDao facultyDao;

	@RequestMapping(value = "/addstudent")
	public String addStudent(Model m) {
		
		m.addAttribute("studentBean", new StudentBean());
		
		return "student/addstudent";
	}

	@RequestMapping(value = "/insertstudent",method = RequestMethod.POST)
	public String insertStudent(StudentBean studentBean,Model model) {

		int res = studentDao.addStudent(studentBean);
		System.out.println("student addeed.." + res);
		model.addAttribute("faculty", facultyDao.facultyList());
		

		return "redirect:/studentlist";
	}
	
	@RequestMapping(value = "/studentlist",method = RequestMethod.GET)
	public String studentList(Model m){
		System.out.println("studentlist called...");
		List<StudentBean> studentList = studentDao.studentList();
		m.addAttribute("studentlist", studentList);
		return "student/studentList";
	}
	
	
}
