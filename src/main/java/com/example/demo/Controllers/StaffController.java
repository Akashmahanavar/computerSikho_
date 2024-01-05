package com.example.demo.Controllers;

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

import com.example.demo.Service.StaffManager;
import com.example.demo.pojos.Staff;
import com.google.gson.Gson;

@RestController  
@CrossOrigin("http://localhost:3000")
public class StaffController
{
	@Autowired
	StaffManager manager;
	@GetMapping(value = "staffs",headers = "Accept=application/json")  
	 public String showStaffs()
	 {
		  return new Gson().toJson(manager.getStaffs());
	 }
	@GetMapping(value = "staffs/{staffId}", headers = "Accept=application/json")  
	 public Staff getPro(@PathVariable int staffId)
	 {
		Staff p=manager.getStaff(staffId);
		return p;
	 }
	@DeleteMapping(value = "staffs/{staffId}", headers = "Accept=application/json")  
	 public void removepro(@PathVariable int staffId)
	 {
		manager.delete(staffId);
	 }
	@PutMapping(value = "staffs/{staffId}",headers = "Accept=application/json")  
	 public void updatepro(@RequestBody Staff staff,@PathVariable int staffId)
	 {
		System.out.println("inside updatepro of controller");
		manager.update(staff,staffId);
	 }
	@PostMapping(value = "staffs", headers = "Accept=application/json")  
	 public void addpro(@RequestBody Staff staff)
	 {
		System.out.println("addpro called");
		manager.addStaff(staff);
	 }
	@PostMapping(value = "staffs/Login", headers = "Accept=application/json")  
	 public boolean GetLogin(@RequestBody Staff staff)
	 {
		Staff p=manager.getLogin(staff);
		if(p!=null)
			return true;
		else
			return false;
	 }
	
}
