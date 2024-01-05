package com.example.demo.Service;

import java.util.List;

import com.example.demo.pojos.Album;
import com.example.demo.pojos.Paymentmaster;

public interface PaymentmasterManager {

	void addpaymentmaster(Paymentmaster s);
	List<?> getPaymentmaster();
	void delete(int id);
	Paymentmaster getPaymentmasterbyId(int Id);
	void updatefees(int coursefees,int student);
	
	Paymentmaster getStudentbyId(int student);


}
