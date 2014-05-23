package com.minor.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Roleinfo entity. @author MyEclipse Persistence Tools
 */

public class Roleinfo implements java.io.Serializable {

	// Fields

	private Integer roleId;
	private String roleName;
	private String roleDesc;
	private Integer flag;
	private Set userinfos = new HashSet(0);
	private Set rolerights = new HashSet(0);

	// Constructors

	/** default constructor */
	public Roleinfo() {
	}

	/** full constructor */
	public Roleinfo(String roleName, String roleDesc, Integer flag,
			Set userinfos, Set rolerights) {
		this.roleName = roleName;
		this.roleDesc = roleDesc;
		this.flag = flag;
		this.userinfos = userinfos;
		this.rolerights = rolerights;
	}

	// Property accessors

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return this.roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public Integer getFlag() {
		return this.flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Set getUserinfos() {
		return this.userinfos;
	}

	public void setUserinfos(Set userinfos) {
		this.userinfos = userinfos;
	}

	public Set getRolerights() {
		return this.rolerights;
	}

	public void setRolerights(Set rolerights) {
		this.rolerights = rolerights;
	}

}