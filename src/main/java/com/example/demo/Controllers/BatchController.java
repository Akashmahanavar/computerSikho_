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

import com.example.demo.Service.BatchManager;
import com.example.demo.pojos.Batch;
import com.google.gson.Gson;

@RestController  
@CrossOrigin("http://localhost:3000")
public class BatchController
{
	@Autowired
	BatchManager manager;
	@GetMapping(value = "Batches",headers = "Accept=application/json")  
	 public String showBatchs()
	 {
		  return new Gson().toJson(manager.GetBatches());
	 }
	@GetMapping(value = "Batches/{pid}", headers = "Accept=application/json")  
	 public Batch getPro(@PathVariable int pid)
	 {
		Batch p=manager.getBatch(pid);
		return p;
	 }
	@DeleteMapping(value = "Batches/{pid}", headers = "Accept=application/json")  
	 public void removepro(@PathVariable int pid)
	 {
		manager.DeleteBatch(pid);
	 }
	@PutMapping(value = "Batches/{pid}",headers = "Accept=application/json")  
	 public void updatepro(@RequestBody Batch batch,@PathVariable int pid)
	 {
		manager.UpdateBatch(batch,pid);
	 }
	@PostMapping(value = "Batches", headers = "Accept=application/json")  
	 public void addpro(@RequestBody Batch batch)
	 {
		manager.AddBatch(batch);
	 }
	
	@GetMapping(value = "CourseBatch/{pid}", headers = "Accept=application/json")  
	 public String getCourseBatch(@PathVariable int pid)
	 {
		
		return new Gson().toJson(manager.getCourseBatch2(pid));
	 }
	
	

}

