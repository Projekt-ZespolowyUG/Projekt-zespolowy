package com.pgs.soft.visit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pgs.soft.visit.domain.Outpost;
import com.pgs.soft.visit.dao.*;

@Service
@Transactional
public class OutpostServiceImpl implements OutpostService {

	@Autowired
	private OutpostDAO outpostDAO;

	public void addOutpost(Outpost outpost) {
		outpostDAO.addOutpost(outpost);

	}

	public List<Outpost> getOutposts() {
		return outpostDAO.getOutposts();
	}

	public void updateOutpost(Outpost outpost) {
		outpostDAO.updateOutpost(outpost);
	}

	public Outpost getOutpost(Long id) {
		return outpostDAO.getOutpost(id);
	}

	public void deleteOutpost(Long id) {
		outpostDAO.deleteOutpost(id);
	}

}