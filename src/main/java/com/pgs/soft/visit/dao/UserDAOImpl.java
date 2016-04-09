package com.pgs.soft.visit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


import com.pgs.soft.visit.domain.User;

public class UserDAOImpl implements UserDAO{

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	
	public void addUser(User user) {
		getCurrentSession().save(user);
	}
}
