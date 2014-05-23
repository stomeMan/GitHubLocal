package com.minor.entity;

/**
 * Roleright entity. @author MyEclipse Persistence Tools
 */

public class Roleright implements java.io.Serializable {

	// Fields

	private Integer rrId;
	private Rightinfo rightinfo;
	private Roleinfo roleinfo;

	// Constructors

	/** default constructor */
	public Roleright() {
	}

	/** full constructor */
	public Roleright(Rightinfo rightinfo, Roleinfo roleinfo) {
		this.rightinfo = rightinfo;
		this.roleinfo = roleinfo;
	}

	// Property accessors

	public Integer getRrId() {
		return this.rrId;
	}

	public void setRrId(Integer rrId) {
		this.rrId = rrId;
	}

	public Rightinfo getRightinfo() {
		return this.rightinfo;
	}

	public void setRightinfo(Rightinfo rightinfo) {
		this.rightinfo = rightinfo;
	}

	public Roleinfo getRoleinfo() {
		return this.roleinfo;
	}

	public void setRoleinfo(Roleinfo roleinfo) {
		this.roleinfo = roleinfo;
	}

}