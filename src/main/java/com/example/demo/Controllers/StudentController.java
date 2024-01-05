package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.BatchManager;
import com.example.demo.Service.CourseManager;
import com.example.demo.Service.EnquiryManager;
import com.example.demo.Service.PaymentmasterManager;
import com.example.demo.Service.StudentManager;
import com.example.demo.pojos.Batch;
import com.example.demo.pojos.Course;
import com.example.demo.pojos.Enquiry;
import com.example.demo.pojos.Paymentmaster;
import com.example.demo.pojos.Staff;
import com.example.demo.pojos.Student;
import com.google.gson.Gson;

@RestController  
@CrossOrigin("http://localhost:3000")
public class StudentController
{
	@Autowired
	StudentManager manager;
	@Autowired
	BatchManager manager1;
	@Autowired
	EnquiryManager manager2;
	
	@Autowired
	PaymentmasterManager master1;
	@Autowired
	CourseManager master2;
	
	
	@GetMapping(value = "students",headers = "Accept=application/json")  
	 public String showStudents()
	 {
		  return new Gson().toJson(manager.getStudents());
	 }
	@GetMapping(value = "students/{sid}", headers = "Accept=application/json")  
	 public Student getPro(@PathVariable int sid)
	 {
		Student s=manager.getStudent(sid);
		return s;
	 }
	@DeleteMapping(value = "students/{sid}", headers = "Accept=application/json")  
	 public void removepro(@PathVariable int sid)
	 {
		manager.delete(sid);
	 }
//	@PutMapping(value = "crud/update/{sid}",headers = "Accept=application/json")  
//	 public void updatepro(@RequestBody Student student,@PathVariable int sid)
//	 {
//		System.out.println("inside updatepro of controller");
//		manager.update(student,sid);
//	 }
	@PostMapping(value = "students", headers = "Accept=application/json")  
	 public boolean addpro(@RequestBody Student student)
	 {
		System.out.println(student.getEnquiry());
		List<Batch> list=manager1.getSbatch(student.getCourse());
		if(student.getBatch()==1)
		{
			student.setBatch(list.get(0).getBatchId());
		}
		else
		{
			student.setBatch(list.get(1).getBatchId());
		}
		Enquiry e=manager2.getEnquiry(student.getEnquiry());
		e.setEnquiryProcessedFlag(true);
		manager2.UpdateEnquiry(e,e.getEnquiryId());
		
		if(student!=null)
		{
		Student s=	manager.addStudent(student);
			
			Paymentmaster pm = new Paymentmaster();
			System.out.println(s.getStudentId());
			pm.setStudent( s.getStudentId());
			
			Course c = master2.getCourse(student.getCourse());
			
			pm.setCourse(c.getCourseId());
			
			pm.setCourseFees(c.getCourseFees());
			
			master1.addpaymentmaster(pm);
			
			
			return true;
		}
		else
			return false;
		
	
		
	 }
	
	@GetMapping(value = "students/Login/{user}/{pass}", headers = "Accept=application/json")  
	 public int GetLogin(@PathVariable String user,@PathVariable String pass)
	 {
		Student p=manager.getLogin(user,pass);
		if(p!=null)
			return p.getStudentId();
		else
			return 0;
	 }
	
	@GetMapping(value = "students/page/{offset}",headers = "Accept=application/json")  
	 public String showStudentsPage(@PathVariable int offset)
	 {
		  return new Gson().toJson(manager.getStudentsPage(offset));
	 }
}