package com.minor.entity;

/**
 * Stucourse entity. @author MyEclipse Persistence Tools
 */

public class Stucourse implements java.io.Serializable {

	// Fields

	private Integer scId;
	private Course course;
	private Userinfo userinfo;

	// Constructors

	/** default constructor */
	public Stucourse() {
	}

	/** full constructor */
	public Stucourse(Course course, Userinfo userinfo) {
		this.course = course;
		this.userinfo = userinfo;
	}

	// Property accessors

	public Integer getScId() {
		return this.scId;
	}

	public void setScId(Integer scId) {
		this.scId = scId;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

}