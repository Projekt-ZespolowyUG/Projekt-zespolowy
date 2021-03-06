package com.pgs.soft.visit.service;

import java.util.List;

import com.pgs.soft.visit.domain.Outpost;

public interface OutpostService {
   public void addOutpost(Outpost outpost);
   public List<Outpost> getOutposts();
   public List<Outpost> filterOutposts(String name, String adress, String postcode, String town, String country);
   public void updateOutpost(Outpost Outpost);
   public Outpost getOutpost(Long id);
   public void deleteOutpost(Long id);

}