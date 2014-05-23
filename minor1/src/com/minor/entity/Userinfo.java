package com.minor.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Userinfo entity. @author MyEclipse Persistence Tools
 */

public class Userinfo implements java.io.Serializable {

	// Fields

	private String userId;
	private Roleinfo roleinfo;
	private String userName;
	private String pass;
	private Integer flag;
	private Set stucourses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Userinfo() {
	}

	/** full constructor */
	public Userinfo(Roleinfo roleinfo, String userName, String pass,
			Integer flag, Set stucourses) {
		this.roleinfo = roleinfo;
		this.userName = userName;
		this.pass = pass;
		this.flag = flag;
		this.stucourses = stucourses;
	}

	// Property accessors

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Roleinfo getRoleinfo() {
		return this.roleinfo;
	}

	public void setRoleinfo(Roleinfo roleinfo) {
		this.roleinfo = roleinfo;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Integer getFlag() {
		return this.flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Set getStucourses() {
		return this.stucourses;
	}

	public void setStucourses(Set stucourses) {
		this.stucourses = stucourses;
	}

}