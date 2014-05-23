package com.minor.form;

import org.apache.struts.action.ActionForm;

import com.minor.entity.Userinfo;

public class UserForm extends ActionForm {
	private Userinfo user=new Userinfo();

	public Userinfo getUser() {
		return user;
	}

	public void setUser(Userinfo user) {
		this.user = user;
	}
	
}
