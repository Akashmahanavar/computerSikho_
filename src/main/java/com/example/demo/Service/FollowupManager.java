package com.example.demo.Service;


import java.util.List;

import com.example.demo.pojos.Followup;





public interface FollowupManager
{
	void addFollowup(Followup followup);
	List<?> getFollowups();
	void delete(int followupId);
	void update(Followup followup,int followupId);
	Followup getFollowup(int followupId);
	List<Followup> getfollowbyenq(int followupId );
}
