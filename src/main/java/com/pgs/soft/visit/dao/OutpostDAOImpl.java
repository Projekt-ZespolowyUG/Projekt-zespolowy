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

	public void updateOutpost(Outpost outpost) {
		Outpost outpostToUpdate = getOutpost(outpost.getId());
		outpostToUpdate.setName(outpost.getName());

		outpostToUpdate.setAdress(outpost.getAdress());
		outpostToUpdate.setPostcode(outpost.getPostcode());
		outpostToUpdate.setTown(outpost.getTown());
		outpostToUpdate.setCountry(outpost.getCountry());
		outpostToUpdate.setEmployees(outpost.getEmployees());
		getCurrentSession().update(outpostToUpdate);

	}

	public void deleteOutpost(Long id) {

		Outpost outpost = getOutpost(id);
		if (outpost != null) {
			getCurrentSession().delete(outpost);
		}
	}


	@SuppressWarnings("unchecked")
	public List<Outpost> getOutposts() {
		return getCurrentSession().createQuery("from Outpost").list();
	}

	public Outpost getOutpost(Long id) {
		Outpost outpost = (Outpost) getCurrentSession().get(Outpost.class, id);
		return outpost;
	}
	@SuppressWarnings("unchecked")
	public List<Outpost> filterOutposts(String name, String adress, String postcode, String town, String country) {
		String query = "from Outpost where name='"+name+"' or adress='"+adress+"' or postcode='"+postcode+"' or town='"+town+"' or country='"+country+"'";
		return getCurrentSession().createQuery(query).list();
	}
}
