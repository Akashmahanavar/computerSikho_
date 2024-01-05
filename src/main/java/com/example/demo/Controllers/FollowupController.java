package com.example.demo.Controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.EnquiryManager;
import com.example.demo.Service.FollowupManager;
import com.example.demo.Service.StaffManager;
import com.example.demo.pojos.Enquiry;
import com.example.demo.pojos.Followup;
import com.example.demo.pojos.Staff;
import com.google.gson.Gson;

@RestController  
@CrossOrigin("http://localhost:3000")
public class FollowupController
{
	@Autowired
	FollowupManager manager;
	
	@Autowired
	EnquiryManager manager2;
	
	@Autowired
	StaffManager manager3;
	
	
	@GetMapping(value = "followups",headers = "Accept=application/json")  
	 public String showFollowups()
	 {
		  return new Gson().toJson(manager.getFollowups());
	 }
	@GetMapping(value = "followups/{followupId}", headers = "Accept=application/json")  
	 public Followup getPro(@PathVariable int followupId)
	 {
		Followup p=manager.getFollowup(followupId);
		return p;
	 }
	@DeleteMapping(value = "followups/{followupId}", headers = "Accept=application/json")  
	 public void removepro(@PathVariable int followupId)
	 {
		manager.delete(followupId);
	 }
	@PutMapping(value = "followups/{followupId}",headers = "Accept=application/json")  
	 public void updatepro(@RequestBody Followup followup,@PathVariable int followupId)
	 {
		System.out.println("inside updatepro of controller");
		
		if(followup.isIsActive()==false)
		{
			Enquiry e = manager2.getEnquiry(followup.getEnquiry());
			e.setEnquiryProcessedFlag(true);
			manager2.UpdateEnquiry(e, e.getEnquiryId());
			List<Followup> follow = manager.getfollowbyenq(followup.getEnquiry());
			
			for(int i = 0 ; i< follow.size();i++)
			{
				follow.get(i).setIsActive(false);
				manager.update(follow.get(i),follow.get(i).getFollowupId());
			}
			
			
			
		}
		
		
		
		manager.update(followup,followupId);
	 }
	
	@PostMapping(value = "followups", headers = "Accept=application/json")  
	 public void addpro(@RequestBody Followup followup)
	 {
		System.out.println("addpro called");
	//	manager.addFollowup(followup);
		Date today = new Date();
		long ltime = today.getTime()+3*24*60*60*1000;
		List<Enquiry> list = manager2.findALLFollow();
		
		for(int i = 0 ; i < list.size() ;i++ )
		{
			list.get(i).setFollowUp(new Date(ltime));
			
			manager2.UpdateEnquiry(list.get(i), list.get(i).getEnquiryId());
			
		}
//		List<Staff> list1 = manager3.getStaffs();
//		 int count = list1.size();
		
		for(int i = 0 ; i< list.size();i++)
		{
			 Followup f = new Followup();
			 f.setEnquiry(list.get(i).getEnquiryId());
			 f.setIsActive(true);
			 f.setStaff(1);
			 manager.addFollowup(f);
          System.out.println(f.getEnquiry());
		}
		
		
		
	 }
}
