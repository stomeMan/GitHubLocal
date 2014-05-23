package com.minor.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.minor.entity.Course;
import com.minor.entity.Stucourse;
import com.minor.entity.Userinfo;
import com.minor.form.CourseForm;
import com.minor.service.CourseService;

public class CourseAction extends DispatchAction {
	private CourseService courseService=new CourseService();
	public ActionForward showCourses(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String page=request.getParameter("page");
		int totalCourse=courseService.getCourseCount();
		int pp=0;
		int pagesize=5;
		int pageCount=0;
		if(page==null){
			pp=1;
		}
		else{
			pp=Integer.parseInt(page);
		}
		if(totalCourse%pagesize!=0){
			pageCount=totalCourse/pagesize+1;
		}
		else{
			pageCount=totalCourse/pagesize;
		}
		List<Course> clist=courseService.getCourse(pp,pagesize);
		request.setAttribute("page", pp);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("COURSES", clist);
		return mapping.findForward("list");
	}
	
	public ActionForward toAssign(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int cId=Integer.parseInt(request.getParameter("cid"));
		Course c=courseService.getCourseDetail(cId);
		request.setAttribute("COURSE", c);
		return mapping.findForward("detail");
	}
	public ActionForward toSelect(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String page=request.getParameter("page");
		int totalCourse=courseService.getCourseCount();
		int pp=0;
		int pagesize=5;
		int pageCount=0;
		if(page==null){
			pp=1;
		}
		else{
			pp=Integer.parseInt(page);
		}
		if(totalCourse%pagesize!=0){
			pageCount=totalCourse/pagesize+1;
		}
		else{
			pageCount=totalCourse/pagesize;
		}
		List<Course> clist=courseService.getCourse(pp,pagesize);
		request.setAttribute("page", pp);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("COURSES", clist);
	    Userinfo user=(Userinfo)request.getSession().getAttribute("USER");
		List<Stucourse> sclist=courseService.getStuCourse(user.getUserId());
		request.setAttribute("SC", sclist);
		return mapping.findForward("select");
	}
	public ActionForward selectCourse(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 int cId=Integer.parseInt(request.getParameter("cid"));
		 Userinfo user=(Userinfo)request.getSession().getAttribute("USER");
		boolean flag=courseService.checkStuCourse(user.getUserId(), cId);
		if(flag){
			int totalCourse=courseService.getCourseCount();
			int pp=1;
			int pagesize=5;
			int pageCount=0;
			if(totalCourse%pagesize!=0){
				pageCount=totalCourse/pagesize+1;
			}
			else{
				pageCount=totalCourse/pagesize;
			}
			request.setAttribute("page", pp);
			request.setAttribute("pageCount", pageCount);
			List<Course> clist=courseService.getCourse(pp, pagesize);
			request.setAttribute("COURSES", clist);
		    Userinfo users=(Userinfo)request.getSession().getAttribute("USER");
			List<Stucourse> sclist=courseService.getStuCourse(users.getUserId());
			request.setAttribute("SC", sclist);
			return mapping.findForward("select");
		}
		else{
			Course c=courseService.getCourseDetail(cId);
			request.setAttribute("COURSE", c);
			return mapping.findForward("regCourse");
			
		}
	}
	public ActionForward selCourse(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String uid=request.getParameter("uid");
		int cid=Integer.parseInt(request.getParameter("cid"));
		boolean flag=courseService.doSelect(uid, cid);
		if(flag){
			Course c=courseService.getCourseDetail(cid);
			request.setAttribute("COUR", c);
			return mapping.findForward("show1");
		}
		return mapping.findForward("err");
	}
		public ActionForward delCourse(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)//อหัก
				throws Exception {
			request.setCharacterEncoding("gb2312");
			int cId=Integer.parseInt(request.getParameter("cid"));
			Userinfo user=(Userinfo)request.getSession().getAttribute("USER");
			boolean flag=courseService.deleteCourse(user.getUserId(), cId);
			if(flag){
				int totalCourse=courseService.getCourseCount();
				int pp=1;
				int pagesize=5;
				int pageCount=0;
				if(totalCourse%pagesize!=0){
					pageCount=totalCourse/pagesize+1;
				}
				else{
					pageCount=totalCourse/pagesize;
				}
				request.setAttribute("page", pp);
				request.setAttribute("pageCount", pageCount);
				List<Course> clist=courseService.getCourse(pp, pagesize);
				request.setAttribute("COURSES", clist);
				List<Stucourse> sclist=courseService.getStuCourse(user.getUserId());
				request.setAttribute("SC", sclist);
				return mapping.findForward("select");
			}
			return mapping.findForward("err");
		}
		
		public ActionForward showCourseByCname(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			String cname=new String(request.getParameter("cn").getBytes("ISO-8859-1"),"UTF-8");
			List<Course> clist=courseService.getCouserByCname(cname);
			request.setAttribute("page", 1);
			request.setAttribute("pageCount", 1);
			request.setAttribute("COURSES", clist);
			return mapping.findForward("list");
		}
		public ActionForward showCourseByDname(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			String dname=new String(request.getParameter("dn").getBytes("ISO-8859-1"),"UTF-8");
			String page=request.getParameter("page");
			int totalCourse=courseService.getCourseCountByDname(dname);
			int pp=0;
			int pagesize=5;
			int pageCount=0;
			if(page==null){
				pp=1;
			}
			else{
				pp=Integer.parseInt(page);
			}
			if(totalCourse%pagesize!=0){
				pageCount=totalCourse/pagesize+1;
			}
			else{
				pageCount=totalCourse/pagesize;
			}
			List<Course> clist=courseService.getCouserByDname(dname,pp,pagesize);
			request.setAttribute("page", pp);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("COURSES", clist);
			return mapping.findForward("list");
		}
		public ActionForward showCourseByCDname(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			String cname=new String(request.getParameter("cn").getBytes("ISO-8859-1"),"UTF-8");
			String dname=new String(request.getParameter("dn").getBytes("ISO-8859-1"),"UTF-8");
			List<Course> clist=courseService.getCouserByCDname(cname,dname);
			request.setAttribute("page", 1);
			request.setAttribute("pageCount", 1);
			request.setAttribute("COURSES", clist);
			return mapping.findForward("list");
		}
		public ActionForward manageCourse(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			String page=request.getParameter("page");
			int totalCourse=courseService.getCourseCount();
			int pp=0;
			int pagesize=5;
			int pageCount=0;
			if(page==null){
				pp=1;
			}
			else{
				pp=Integer.parseInt(page);
			}
			if(totalCourse%pagesize!=0){
				pageCount=totalCourse/pagesize+1;
			}
			else{
				pageCount=totalCourse/pagesize;
			}
			List<Course> clist=courseService.getCourse(pp,pagesize);
			request.setAttribute("page", pp);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("COURSES", clist);
			return mapping.findForward("dolist");
		}
		public ActionForward deleteCourse(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			request.setCharacterEncoding("gb2312");
			int cId=Integer.parseInt(request.getParameter("cid"));
			boolean flag=courseService.deleteCourseById(cId);
			if(flag){
				int totalCourse=courseService.getCourseCount();
				int pp=1;
				int pagesize=5;
				int pageCount=0;
				if(totalCourse%pagesize!=0){
					pageCount=totalCourse/pagesize+1;
				}
				else{
					pageCount=totalCourse/pagesize;
				}
				request.setAttribute("page", pp);
				request.setAttribute("pageCount", pageCount);
				List<Course> clist=courseService.getCourse(pp, pagesize);
				request.setAttribute("COURSES", clist);
				return mapping.findForward("dolist");
			}
			return mapping.findForward("err");
		}
		public ActionForward editCourse(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			request.setCharacterEncoding("gb2312");
			int cId=Integer.parseInt(request.getParameter("cid"));
			Course co=courseService.getCourseDetail(cId);
			request.setAttribute("CO", co);
			return mapping.findForward("edit");
		}
		public ActionForward doedit(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			CourseForm cf=(CourseForm)form;	
			boolean flag=courseService.doEdit(cf.getCourse());
			if(flag){
				int totalCourse=courseService.getCourseCount();
				int pp=1;
				int pagesize=5;
				int pageCount=0;
				if(totalCourse%pagesize!=0){
					pageCount=totalCourse/pagesize+1;
				}
				else{
					pageCount=totalCourse/pagesize;
				}
				request.setAttribute("page", pp);
				request.setAttribute("pageCount", pageCount);
				List<Course> clist=courseService.getCourse(pp, pagesize);
				request.setAttribute("COURSES", clist);
				return mapping.findForward("dolist");
			}
			return mapping.findForward("edit");
		}
		public ActionForward doAddCourse(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			CourseForm cf=(CourseForm)form;	
			boolean flag=courseService.doAdd(cf.getCourse());
			if(flag){
				int totalCourse=courseService.getCourseCount();
				int pp=1;
				int pagesize=5;
				int pageCount=0;
				if(totalCourse%pagesize!=0){
					pageCount=totalCourse/pagesize+1;
				}
				else{
					pageCount=totalCourse/pagesize;
				}
				request.setAttribute("page", pp);
				request.setAttribute("pageCount", pageCount);
				List<Course> clist=courseService.getCourse(pp, pagesize);
				request.setAttribute("COURSES", clist);
				return mapping.findForward("dolist");
			}
			return mapping.findForward("edit");
		}
		public ActionForward showMessage(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			
			List<Course> clist=courseService.getCourses();
			request.setAttribute("COURSES", clist);
			return mapping.findForward("clist");
		}
		public ActionForward showUsersByCname(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			String cname=new String(request.getParameter("cn").getBytes("ISO-8859-1"),"UTF-8");
			List<Stucourse> cstudents=courseService.getStudents(cname);
			request.setAttribute("CSTU", cstudents);
			return mapping.findForward("stulist");
		}
}
