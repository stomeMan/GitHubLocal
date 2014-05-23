package com.minor.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Rightinfo entity. @author MyEclipse Persistence Tools
 */

public class Rightinfo implements java.io.Serializable {

	// Fields

	private String rightCode;
	private String rightParentCode;
	private String rightType;
	private String rightText;
	private String rightUrl;
	private String rightTip;
	private Set rolerights = new HashSet(0);

	// Constructors

	/** default constructor */
	public Rightinfo() {
	}

	/** full constructor */
	public Rightinfo(String rightParentCode, String rightType,
			String rightText, String rightUrl, String rightTip, Set rolerights) {
		this.rightParentCode = rightParentCode;
		this.rightType = rightType;
		this.rightText = rightText;
		this.rightUrl = rightUrl;
		this.rightTip = rightTip;
		this.rolerights = rolerights;
	}

	// Property accessors

	public String getRightCode() {
		return this.rightCode;
	}

	public void setRightCode(String rightCode) {
		this.rightCode = rightCode;
	}

	public String getRightParentCode() {
		return this.rightParentCode;
	}

	public void setRightParentCode(String rightParentCode) {
		this.rightParentCode = rightParentCode;
	}

	public String getRightType() {
		return this.rightType;
	}

	public void setRightType(String rightType) {
		this.rightType = rightType;
	}

	public String getRightText() {
		return this.rightText;
	}

	public void setRightText(String rightText) {
		this.rightText = rightText;
	}

	public String getRightUrl() {
		return this.rightUrl;
	}

	public void setRightUrl(String rightUrl) {
		this.rightUrl = rightUrl;
	}

	public String getRightTip() {
		return this.rightTip;
	}

	public void setRightTip(String rightTip) {
		this.rightTip = rightTip;
	}

	public Set getRolerights() {
		return this.rolerights;
	}

	public void setRolerights(Set rolerights) {
		this.rolerights = rolerights;
	}

}