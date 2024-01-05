package com.example.demo.Controllers;

import java.util.ArrayList;
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

import com.example.demo.JPA.BatchRepository;
import com.example.demo.Service.BatchManager;
import com.example.demo.Service.CourseManager;
import com.example.demo.pojos.Batch;
import com.example.demo.pojos.Course;
import com.google.gson.Gson;

@RestController  
@CrossOrigin("http://localhost:3000")
public class CourseController
{
	@Autowired
	CourseManager manager;
	
	@Autowired
	BatchManager manager1;
//	@Autowired
//	BatchManager manager2;

//	@Autowired
//	BatchRepository repository;
	
	@GetMapping(value = "Courses",headers = "Accept=application/json")  
	 public String showCourses()
	 {
		  return new Gson().toJson(manager.getCourses());
	 }
	@GetMapping(value = "Courses/{pid}", headers = "Accept=application/json")  
	 public Course getPro(@PathVariable int pid)
	 {
		Course p=manager.getCourse(pid);
		return p;
	 }
	@DeleteMapping(value = "Courses/{pid}", headers = "Accept=application/json")  
	 public void removepro(@PathVariable int pid)
	 {
		manager.delete(pid);
	 }
	@PutMapping(value = "Courses/{pid}",headers = "Accept=application/json")  
	 public void updatepro(@RequestBody Course course,@PathVariable int pid)
	 {
		System.out.println("inside updatepro of controller");
		manager.update(course,pid);
	 }
//	@PostMapping(value = "Courses", headers = "Accept=application/json")  
//	 public void addpro(@RequestBody Course course)
//	 {
//		System.out.println("addpro called");
//		manager.addCourse(course);
//	 }
	
	@PostMapping(value = "Courses/addpro", headers = "Accept=application/json")  
	 public void addpro(@RequestBody Course course)
	 {
		System.out.println("addpro called");
		course.setCourseIsActive(true);
		course.setCoverPhoto("abc");
		manager.addCourse(course);
		
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
//		   LocalDate now = LocalDate.now();
//		Date today = new Date();
//		long ltime = today.getTime()+8*24*60*60*1000;
//		Date today8 = new Date(ltime);

		
		Batch b  = new Batch();
		b.setBatchName("Morning") ;
		b.setBatchStartTime(new Date());
		b.setBatchEndTime(new Date());
		b.setCourse(course.getCourseId());
		b.setBatchIsActive(true);
		
		b.setFinalPresentationDate(b.getBatchEndTime());
		manager1.AddBatch(b);
		Batch b1  = new Batch();
		b1.setBatchName("Evening") ;
		b1.setBatchStartTime(new Date());
		b1.setBatchEndTime(new Date());
		b1.setCourse(course.getCourseId());
		b1.setBatchIsActive(true);
		b1.setFinalPresentationDate(b1.getBatchEndTime());
		//manager1.AddBatch(b));
//		List<Batch> batch = new ArrayList<Batch>();
//		batch.add(b);
//		batch.add(b1);
		manager1.AddBatch(b1);
		//repository.saveAll(List.of(b,b1));
	 }
	@GetMapping(value = "ActiveCourses",headers = "Accept=application/json")  
	 public String getActiveCourses()
	 {
		  return new Gson().toJson(manager.getActiveCourses());
	 }
	
}
