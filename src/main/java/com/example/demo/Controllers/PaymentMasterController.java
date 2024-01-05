package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.PaymentmasterManager;
import com.example.demo.pojos.Paymentmaster;
import com.google.gson.Gson;



@RestController  
@CrossOrigin("http://localhost:3000")
public class PaymentMasterController
{
	@Autowired
	PaymentmasterManager manager;
	
	@GetMapping(value = "paymentmaster",headers = "Accept=application/json")  
	 public String showAlbum()
	 {
		  return new Gson().toJson(manager.getPaymentmaster());
	 }
	@GetMapping(value = "paymentmaster/{aid}", headers = "Accept=application/json")  
	 public Paymentmaster getAlb(@PathVariable int aid)
	 {
		Paymentmaster a=manager.getPaymentmasterbyId(aid);
		return a;
	 }
	@DeleteMapping(value = "paymentmaster/{aid}", headers = "Accept=application/json")  
	 public void removealb(@PathVariable int aid)
	 {
		manager.delete(aid);
	 }

		/*
		 * @PutMapping(value = "albums/{aid}",headers = "Accept=application/json")
		 * public void updatepro(@RequestBody Album album,@PathVariable int aid) {
		 * System.out.println("inaide updatepro of controller");
		 * manager.update(album,aid); }
		 */
	@PostMapping(value = "paymentmaster", headers = "Accept=application/json")  
	 public void addAlb(@RequestBody Paymentmaster paymentmaster)
	 {
		System.out.println("addAlb called");
		manager.addpaymentmaster(paymentmaster);
	 }
	
	@GetMapping(value = "studentdetails/{student}", headers = "Accept=application/json")  
	 public Paymentmaster getStudent(@PathVariable int student)
	 {
		Paymentmaster a=manager.getStudentbyId(student);
		return a;
	 }

	
}
