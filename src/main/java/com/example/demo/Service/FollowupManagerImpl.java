package com.example.demo.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.JPA.FollowupRepository;
import com.example.demo.pojos.Followup;





@Service
public class FollowupManagerImpl implements FollowupManager
{
	@Autowired
	FollowupRepository repository;

	@Override
	public void addFollowup(Followup p) {
		repository.save(p);
		
		
	}

	@Override
	public List<?> getFollowups() {
		// TODO Auto-generated method stub
		return repository.findAll();
		
		
	}

	@Override
	public void delete(int followupId) {
		repository.deleteById(followupId);
	}

	@Override
	public void update(Followup followup,int followupId) {
		// TODO Auto-generated method stub
		System.out.println("inside update method of service layer");
		repository.update(followup.getFollowupMsg(),followup.isIsActive(),followupId);
		
	}
	

	@Override
	public Followup getFollowup(int followupId) {
		// TODO Auto-generated method stub
		return repository.findById(followupId);
	}

	@Override
	public List<Followup> getfollowbyenq(int followupId) {
		// TODO Auto-generated method stub
		return repository.getfollowbyenq(followupId);
	}
	
	

}
