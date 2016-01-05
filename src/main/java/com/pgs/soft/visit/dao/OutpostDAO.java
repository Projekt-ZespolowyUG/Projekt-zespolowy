package com.pgs.soft.visit.dao;

import java.util.List;

import com.pgs.soft.visit.domain.Outpost;

public interface OutpostDAO 
{
	public void addOutpost(Outpost Outpost);
	public List<Outpost> getOutposts();
	public void updateOutpost(Outpost Outpost);
	public Outpost getOutpost(Long id);
	
}
