package com.pgs.soft.visit.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pgs.soft.visit.domain.Outpost;


@Repository
public class OutpostDAOImpl implements OutpostDAO {
	  @Autowired
	    private SessionFactory sessionFactory;
	     
	    private Session getCurrentSession() {
	        return sessionFactory.getCurrentSession();
	    }
	 
	    public void addOutpost(Outpost outpost) {
	        getCurrentSession().save(outpost);
	    }
	 	 
	    @SuppressWarnings("unchecked")
	    public List<Outpost> getOutposts() {
	        return getCurrentSession().createQuery("from Outpost").list();
	    }
}