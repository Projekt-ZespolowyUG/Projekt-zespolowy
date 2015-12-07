package com.pgs.soft.visit.service;

import java.util.List;
import com.pgs.soft.visit.domain.Outpost;
public interface OutpostService {

    
   public void addOutpost(Outpost outpost);
   public List<Outpost> getOutposts();
}