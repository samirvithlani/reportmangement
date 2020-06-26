package com.controller.reamrk;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.remarsks.RemarksBean;
import com.dao.remark.RemarkDao;

@Controller
public class RemarkController {

	@Autowired
	RemarkDao remarksDao;

	@RequestMapping(value = "/addremarks/{sId}")
	public String addRemark(Model m, @PathVariable int sId) {

		System.out.println(sId);
		m.addAttribute("remarkBean", new RemarksBean());
		m.addAttribute("sid", sId);

		return "remarks/addremark";
	}

	@RequestMapping(value = "/allstudentreport")
	public String generateReport() {

		return remarksDao.generateReport();

	}

	@RequestMapping(value = "/insertremark", method = RequestMethod.POST)
	public String insertRemark(RemarksBean remarksBean) {

		System.out.println("date.." + remarksBean.getrDate());

		int status = remarksDao.addRemarsk(remarksBean);
		System.out.println(status + "remark added..");

		return "remarks/remarksList";
	}

	@RequestMapping(value = "/remarkslist")
	public String remarksList(Model model) {

		List<RemarksBean> remarklist = remarksDao.allstudentRemarskList();
		System.out.println(remarksDao.allstudentRemarskList().get(0).getDiscipline());
		model.addAttribute("remarklist", remarklist);

		return "remarks/remarksList";
	}

	@RequestMapping(value = "/studentremark/{sId}")
	public String getStudentDetail(@PathVariable int sId, Model m) {

		List<RemarksBean> studentRemark = remarksDao.getStudentRemarks(sId);
		m.addAttribute("studentRemark", studentRemark);
		return "remarks/studentRemark";
	}

	@RequestMapping(value = "/generatestudentremarkreport/{sId}")
	public String generatestudentremarkreport(@PathVariable int sId) {

		remarksDao.generateRemarkReport(sId);

		return "";
	}
}
