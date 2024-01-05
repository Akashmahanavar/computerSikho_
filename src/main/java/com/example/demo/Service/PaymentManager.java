package com.example.demo.Service;



import java.util.List;

import com.example.demo.pojos.Payment;

public interface PaymentManager
{
	void addPayment(Payment p);
	List<?> getPayments();
	void delete(int paymentId);
//	void update(Student student,int studentId);
	Payment getPayment(int paymentId);
	Payment getPaymentdetails(int studentId);

}
