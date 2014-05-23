package com.minor.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.minor.common.HibernateSessionFactory;
import com.minor.entity.Course;
import com.minor.entity.Stucourse;
import com.minor.entity.Userinfo;

public class CourseService {
	public int getCourseCount(){
		Session sess=HibernateSessionFactory.getSession();
    	Transaction tran=sess.beginTransaction();
    	Query query=sess.createQuery("select count(*) from Course");
    	List<Long> clist=query.list();
    	int count=clist.get(0).intValue();
    	HibernateSessionFactory.closeSession();
		return count;
	}
	public List<Course> getCourse(int pp,int pageSize){//将所有的辅修课程列出来
		Session sess=HibernateSessionFactory.getSession();
    	Transaction tran=sess.beginTransaction();
    	Query query=sess.createQuery("from Course");
    	int p=(pp-1)*pageSize;
    	query.setFirstResult(p);
    	query.setMaxResults(pageSize);
    	List<Course> clist=query.list();
    	HibernateSessionFactory.closeSession();
		return clist;
	}
	public List<Course> getCourses(){//将所有的辅修课程列出来
		Session sess=HibernateSessionFactory.getSession();
    	Transaction tran=sess.beginTransaction();
    	Query query=sess.createQuery("from Course");
    	List<Course> clist=query.list();
    	HibernateSessionFactory.closeSession();
		return clist;
	}
	public Course getCourseDetail(int cid){//根据课程号列出详细的课程信息
		Session sess=HibernateSessionFactory.getSession();
    	Transaction tran=sess.beginTransaction();
    	Course course=(Course)sess.get(Course.class, cid);
    	HibernateSessionFactory.closeSession();
		return course;
	}
	public List<Stucourse> getStuCourse(String uid){
		Session sess=HibernateSessionFactory.getSession();
    	Transaction tran=sess.beginTransaction();
    	Query query=sess.createQuery("from Stucourse s left outer join fetch s.course where s.userinfo.userId=?");
    	query.setString(0, uid);
    	List<Stucourse> sclist=query.list();
    	HibernateSessionFactory.closeSession();
		return sclist;
	}
	public boolean checkStuCourse(String uid ,int courseId){
		boolean flag=false;
		Session sess=HibernateSessionFactory.getSession();
    	Transaction tran=sess.beginTransaction();
    	Query query=sess.createQuery("from Stucourse s  where s.userinfo.userId=? and s.course.courseId=?");
    	query.setString(0, uid);
    	query.setInteger(1, courseId);
    	List<Stucourse> list=query.list();
    	if(list!=null && list.size()>0){
    		flag=true;
    		return flag;
    	}
    	return flag;
	}
	public boolean doSelect(String uid,int cid){
		boolean flag=false;
		Session sess=HibernateSessionFactory.getSession();
    	Transaction tran=sess.beginTransaction();
    	try{
    		Userinfo user=(Userinfo)sess.get(Userinfo.class, uid);
    		Course course=(Course)sess.get(Course.class, cid);
    		int count=course.getHaveStu()+1;
    		course.setHaveStu(count);
    		Stucourse sc=new Stucourse(course, user);
    		sess.save(sc);
    		tran.commit();
    		flag=true;
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    	HibernateSessionFactory.closeSession();
		return flag;
	}
	public boolean deleteCourse(String uid,int cid){//退选课程
		boolean flag=false;
		Session sess=HibernateSessionFactory.getSession();
    	Transaction tran=sess.beginTransaction();
    	try{
    		Query query=sess.createQuery("from Stucourse s left outer join fetch s.course where s.userinfo.userId=? and s.course.courseId=?");
    		query.setString(0, uid);
    		query.setInteger(1, cid);
    		List<Stucourse> sclist=query.list();
    		Stucourse sc=sclist.get(0);
    		Course c=sc.getCourse();
    		int count=c.getHaveStu()-1;
    		c.setHaveStu(count);
    		sess.update(c);
    		sess.delete(sc);
    		flag=true;
    		tran.commit();
    		HibernateSessionFactory.closeSession();
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    	return flag;
	}
	public List<Course> getCouserByCname(String cname){//通过课程名查找
		Session sess=HibernateSessionFactory.getSession();
    	Transaction tran=sess.beginTransaction();
    	Query query=sess.createQuery("from Course where courseName=?");
    	query.setString(0, cname);
    	List<Course> clist=query.list();
		return clist;
	}
	public int getCourseCountByDname(String dname){
		Session sess=HibernateSessionFactory.getSession();
    	Transaction tran=sess.beginTransaction();
    	Query query=sess.createQuery("select count(*) from Course where deptName=?");
    	query.setString(0, dname);
    	List<Long> clist=query.list();
    	int count=clist.get(0).intValue();
    	HibernateSessionFactory.closeSession();
		return count;
	}
	public List<Course> getCouserByDname(String dname,int pp,int pageSize){//通过系名查找
		Session sess=HibernateSessionFactory.getSession();
    	Transaction tran=sess.beginTransaction();
    	Query query=sess.createQuery("from Course where deptName=?");
    	int off=(pp-1)*pageSize;
    	query.setFirstResult(off);
    	query.setMaxResults(pageSize);
    	query.setString(0, dname);
    	List<Course> dlist=query.list();
		return dlist;
	}
	public List<Course> getCouserByCDname(String cname,String dname){//通过课程名、系名查找
		Session sess=HibernateSessionFactory.getSession();
    	Transaction tran=sess.beginTransaction();
    	Query query=sess.createQuery("from Course where courseName=? and deptname=?");
    	query.setString(0, cname);
    	query.setString(1, dname);
    	List<Course> cdlist=query.list();
		return cdlist;
	}
	public boolean deleteCourseById(int cid){//退选课程
		boolean flag=false;
		Session sess=HibernateSessionFactory.getSession();
    	Transaction tran=sess.beginTransaction();
    	try{
    		Query query=sess.createQuery("from Stucourse s where s.course.courseId=?");
    		query.setInteger(0, cid);
    		List<Stucourse> sclist=query.list();
    		for(int i=0;i<sclist.size();i++){
    			Stucourse s=sclist.get(i);
    			sess.delete(s);
    		}
    		query=sess.createQuery("from Course c where c.courseId=?");
    		query.setInteger(0, cid);
    		List<Course> clist=query.list();
    		Course sc=clist.get(0);
    		sess.delete(sc);
    		flag=true;
    		tran.commit();
    		HibernateSessionFactory.closeSession();
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    	return flag;
	}
	public boolean doEdit(Course c){
		boolean flag=false;
		Session sess=HibernateSessionFactory.getSession();
    	Transaction tran=sess.beginTransaction();
    	try{
    		Course c1=(Course)sess.get(Course.class, c.getCourseId());
    		c1.setCredit(c.getCredit());
    		c1.setPeriod(c.getPeriod());
    		c1.setTeacherName(c.getTeacherName());
    		c1.setAddress(c.getAddress());
    		c1.setDeptName(c.getDeptName());
    		c1.setStuTotal(c.getStuTotal());
    		sess.update(c1);
    		tran.commit();
    		flag=true;
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    	HibernateSessionFactory.closeSession();
		return flag;
	}
	public boolean doAdd(Course c){
		boolean flag=false;
		Session sess=HibernateSessionFactory.getSession();
    	Transaction tran=sess.beginTransaction();
    	try{
    		sess.save(c);
    		tran.commit();
    		flag=true;
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    	HibernateSessionFactory.closeSession();
		return flag;
	}
	public List<Stucourse> getStudents(String cname){
		Session sess=HibernateSessionFactory.getSession();
    	Transaction tran=sess.beginTransaction();
    	Query query=sess.createQuery("from Stucourse s left outer join fetch s.userinfo where s.course.courseName=?");
    	query.setString(0, cname);
    	List<Stucourse> sclist=query.list();
    	HibernateSessionFactory.closeSession();
		return sclist;
	}
	
}
