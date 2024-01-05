package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.example.demo.JPA.EnquiryRepository;
import com.example.demo.pojos.Enquiry;







@Service
public class EnquiryManagerImpl implements EnquiryManager
{
	@Autowired
	EnquiryRepository repository;

	@Override
	public void AddEnquiry(Enquiry e) {
		
		repository.save(e);
	}

	@Override
	public List<?> GetEnquies() {
		
		return repository.findAll();
	}

	@Override
	public void DeleteEnquiry(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}
	
	

	
	
	@Override
	public Enquiry getEnquiry(int id) {
		
		return repository.findById(id);
	}

	@Override
	public void UpdateEnquiry(Enquiry enquiry, int id) {
		
		repository.update(enquiry.getClosureReason(),enquiry.getEnquiryProcessedFlag(),enquiry.getEnquiryCounter(),enquiry.getFollowUp(),id);
	}

	@Override
	public List<Enquiry> findALLFollow() {
		// TODO Auto-generated method stub
		return repository.findALLFollow();
	}
	
	

}
