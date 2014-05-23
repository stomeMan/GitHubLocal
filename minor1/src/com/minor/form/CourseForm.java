package com.minor.form;

import org.apache.struts.action.ActionForm;

import com.minor.entity.Course;

public class CourseForm extends ActionForm {
	private Course course=new Course();

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
}
