package com.example.demo.Service;

import java.util.List;

import com.example.demo.pojos.Enquiry;





public interface EnquiryManager
{
	void AddEnquiry(Enquiry p);
	
	List<?> GetEnquies();
	
	void DeleteEnquiry(int id);
	
	Enquiry getEnquiry(int id);
	
    void UpdateEnquiry(Enquiry enqiry,int id);
    
    List<Enquiry> findALLFollow();
    
}
