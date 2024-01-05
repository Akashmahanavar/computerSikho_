package com.example.demo.Controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.PaymentManager;
import com.example.demo.Service.PaymentmasterManager;
import com.example.demo.Service.StudentManager;
import com.example.demo.pojos.Payment;
import com.example.demo.pojos.Student;
import com.google.gson.Gson;



@RestController  
@CrossOrigin("http://localhost:3000")
public class PaymentController
{
	@Autowired
	PaymentManager manager;
	
	@Autowired
	StudentManager studentmanager;

	@Autowired
	PaymentmasterManager paymentmasterManager;

	
	@GetMapping(value = "payments",headers = "Accept=application/json")  
	 public String showPayments()
	 {
		  return new Gson().toJson(manager.getPayments());
	 }
	@GetMapping(value = "payments/{pid}", headers = "Accept=application/json")  
	 public Payment getPay(@PathVariable int pid)
	 {
		Payment p=manager.getPayment(pid);
		return p;
	 }
	@DeleteMapping(value = "payments/{pid}", headers = "Accept=application/json")  
	 public void removepay(@PathVariable int pid)
	 {
		manager.delete(pid);
	 }
//	@PutMapping(value = "crud/update/{pid}",headers = "Accept=application/json")  
//	 public void updatepro(@RequestBody Student student,@PathVariable int pid)
//	 {
//		System.out.println("inpide updatepro of controller");
//		manager.update(student,pid);
//	 }
//	@PostMapping(value = "payments", headers = "Accept=application/json")  
//	 public void addpay(@RequestBody Payment payment)
//	 {
//		System.out.println("addpay called");
//		manager.addPayment(payment);
//	 }
	
	@GetMapping(value = "studentspay/{stu}", headers = "Accept=application/json")  
	 public Payment getStu(@PathVariable int stu)
	 {
		Payment p=manager.getPaymentdetails(stu);
		return p;
	 }
	@PostMapping(value = "payments", headers = "Accept=application/json")  
	 public void addpay(@RequestBody Payment payment)
	 {
		System.out.println("addpay called");
		Student s=studentmanager.getStudent(payment.getStudent());
		payment.setCourse(s.getCourse());
		payment.setPaymentDate(new Date());
		payment.setPaymentDone(true);
		payment.setPaymentReceiptSend(true);
		manager.addPayment(payment);
		paymentmasterManager.updatefees(payment.getAmount(), payment.getStudent());
	 }

}
