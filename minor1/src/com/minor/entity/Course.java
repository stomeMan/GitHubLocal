package com.minor.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Course entity. @author MyEclipse Persistence Tools
 */

public class Course implements java.io.Serializable {

	// Fields

	private Integer courseId;
	private String courseName;
	private Double credit;
	private Integer period;
	private String teacherName;
	private String deptName;
	private String address;
	private Integer stuTotal;
	private Integer haveStu;
	private Set stucourses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Course() {
	}

	/** full constructor */
	public Course(String courseName, Double credit, Integer period,
			String teacherName, String deptName, String address,
			Integer stuTotal, Integer haveStu, Set stucourses) {
		this.courseName = courseName;
		this.credit = credit;
		this.period = period;
		this.teacherName = teacherName;
		this.deptName = deptName;
		this.address = address;
		this.stuTotal = stuTotal;
		this.haveStu = haveStu;
		this.stucourses = stucourses;
	}

	// Property accessors

	public Integer getCourseId() {
		return this.courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Double getCredit() {
		return this.credit;
	}

	public void setCredit(Double credit) {
		this.credit = credit;
	}

	public Integer getPeriod() {
		return this.period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	public String getTeacherName() {
		return this.teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getStuTotal() {
		return this.stuTotal;
	}

	public void setStuTotal(Integer stuTotal) {
		this.stuTotal = stuTotal;
	}

	public Integer getHaveStu() {
		return this.haveStu;
	}

	public void setHaveStu(Integer haveStu) {
		this.haveStu = haveStu;
	}

	public Set getStucourses() {
		return this.stucourses;
	}

	public void setStucourses(Set stucourses) {
		this.stucourses = stucourses;
	}

}