package com.bean.remarsks;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class RemarksBean {

	private int rId;
	private int discipline;
	private int regularity;
	private int grasping;
	private int doubtsolving;
	private int task;
	private int upgradation;
	private int reserch;
	private int exams;
	private int sId;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date rDate;
	private String sName;
	
	
	
	
	
	public int getTask() {
		return task;
	}
	public void setTask(int task) {
		this.task = task;
	}
	

	public Date getrDate() {
		return rDate;
	}
	public void setrDate(Date rDate) {
		this.rDate = rDate;
	}
	public int getrId() {
		return rId;
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	
	public int getDiscipline() {
		return discipline;
	}
	public void setDiscipline(int discipline) {
		this.discipline = discipline;
	}
	public int getRegularity() {
		return regularity;
	}
	public void setRegularity(int regularity) {
		this.regularity = regularity;
	}
	public int getGrasping() {
		return grasping;
	}
	public void setGrasping(int grasping) {
		this.grasping = grasping;
	}
	public int getDoubtsolving() {
		return doubtsolving;
	}
	public void setDoubtsolving(int doubtsolving) {
		this.doubtsolving = doubtsolving;
	}
	public int getUpgradation() {
		return upgradation;
	}
	public void setUpgradation(int upgradation) {
		this.upgradation = upgradation;
	}
	public int getReserch() {
		return reserch;
	}
	public void setReserch(int reserch) {
		this.reserch = reserch;
	}
	public int getExams() {
		return exams;
	}
	public void setExams(int exams) {
		this.exams = exams;
	}
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	
	
	
}
