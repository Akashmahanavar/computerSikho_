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
import com.example.demo.pojos.Batch;
import com.example.demo.pojos.Enquiry;
import com.example.demo.pojos.Followup;
import com.google.gson.Gson;


@RestController  
@CrossOrigin("http://localhost:3000")
public class EnquiryController {

	@Autowired
	EnquiryManager manager;
	
	@Autowired
	FollowupManager manager1;
	
	@GetMapping(value = "Enquiries",headers = "Accept=application/json")  
	 public String showEnquiries()
	 {
		  return new Gson().toJson(manager.GetEnquies());
		//return manager.GetEnquies();
	 }
	@GetMapping(value = "Enquiries/{pid}", headers = "Accept=application/json")  
	 public Enquiry getEnquiry(@PathVariable int pid)
	 {
		Enquiry p=manager.getEnquiry(pid);
		return p;
	 }
	@DeleteMapping(value = "Enquiries/{pid}", headers = "Accept=application/json")  
	 public void removeEnq(@PathVariable int pid)
	 {
		manager.DeleteEnquiry(pid);
	 }
	
	@PostMapping(value = "Enquiries", headers = "Accept=application/json")  
	 public void addpro(@RequestBody Enquiry enquiry)
	 {
		Date today = new Date();
		long ltime = today.getTime()+3*24*60*60*1000;
		enquiry.setEnquiryDate(new Date());
		enquiry.setEnquiryProcessedFlag(false);
		enquiry.setEnquiryCounter(0);
		enquiry.setFollowUp(new Date(ltime));
		enquiry.setClosureReasonMaster(1);
		manager.AddEnquiry(enquiry);
	 }
	@PutMapping(value = "Enquiries/{pid}",headers = "Accept=application/json")  
	 public void updatepro(@RequestBody Enquiry enquiry,@PathVariable int pid)
	 {
		manager.UpdateEnquiry(enquiry,pid);
	 }
	
	
	@GetMapping(value = "Enquiries/Counter/{pid}", headers = "Accept=application/json")  
	 public Enquiry Counter(@PathVariable int pid)
	 {
		Enquiry p=manager.getEnquiry(pid);
		int temp = p.getEnquiryCounter();
		
		p.setEnquiryCounter(++temp);
		manager.UpdateEnquiry(p, p.getEnquiryId());
		
		if(temp == 3)
		{
			p.setEnquiryProcessedFlag(true);
			List<Followup> follow = manager1.getfollowbyenq(p.getEnquiryId());
			
			for(int i = 0 ; i < follow.size();i++)
			{
				follow.get(i).setIsActive(false);
				manager1.update(follow.get(i),follow.get(i).getFollowupId());
			}
			
		}
		
		return p;
	 }
	
	
	
}