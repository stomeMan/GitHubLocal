package com.minor.service;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.minor.common.HibernateSessionFactory;
import com.minor.entity.Roleright;
import com.minor.entity.Userinfo;

public class UserService {
    public List<Userinfo> checkUser(Userinfo user){
    	Session sess=HibernateSessionFactory.getSession();
    	Transaction tran=sess.beginTransaction();
    	Query query=sess.createQuery("from Userinfo u left outer join fetch u.roleinfo where u.userId=? and u.pass=?");
    	query.setString(0, user.getUserId());
    	query.setString(1, user.getPass());
    	List<Userinfo> ulist= query.list();
    	HibernateSessionFactory.closeSession();
    	return ulist;
    }
    public List<Roleright> getRights(int roleid){
    	Session sess=HibernateSessionFactory.getSession();
    	Transaction tran=sess.beginTransaction();
    	Query query=sess.createQuery("from Roleright r left outer join fetch r.rightinfo where r.roleinfo.roleId=?");
    	query.setInteger(0, roleid);
    	List<Roleright> rrlist=query.list();
    	HibernateSessionFactory.closeSession();
    	return rrlist;
    }
}
