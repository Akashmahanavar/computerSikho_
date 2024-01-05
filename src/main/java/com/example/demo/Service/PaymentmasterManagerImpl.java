package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.JPA.PaymentmasterRepository;
import com.example.demo.pojos.Paymentmaster;


@Service
public class PaymentmasterManagerImpl implements PaymentmasterManager {

	@Autowired
	PaymentmasterRepository repository;
	
	@Override
	public void addpaymentmaster(Paymentmaster s) {
		// TODO Auto-generated method stub
		repository.save(s);
	}

	@Override
	public List<?> getPaymentmaster() {
		
		return repository.findAll();
	}

	@Override
	public void delete(int id) {
		
		repository.deleteById(id);
	}

	@Override
	public Paymentmaster getPaymentmasterbyId(int Id) {
		
		return repository.findById(Id);
	}
	
	@Override
	public void updatefees(int coursefees, int student) {
		 repository.update(coursefees, student);
		
	}

	@Override
	public Paymentmaster getStudentbyId(int student) {
		// TODO Auto-generated method stub
		return repository.findByStudentId(student);
	}

	
}
