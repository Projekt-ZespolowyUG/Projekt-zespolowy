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
	    
	    public void updateOutpost(Outpost outpost) {
			Outpost outpostUpdate = getOutpost(outpost.getIdOutpost());
			outpostUpdate.setName(outpost.getName());
			outpostUpdate.setAdress(outpost.getAdress());
			outpostUpdate.setPostcode(outpost.getPostcode());
			outpostUpdate.setTown(outpost.getTown());
			outpostUpdate.setCountry(outpost.getCountry());
			getCurrentSession().update(outpostUpdate);
			
		}

		public Outpost getOutpost(Long id) {
			Outpost outpost = (Outpost) getCurrentSession().get(Outpost.class, id);
			return outpost;
		}
}