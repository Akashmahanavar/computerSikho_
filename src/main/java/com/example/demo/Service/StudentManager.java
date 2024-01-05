package com.example.demo.Service;


import java.util.List;

import com.example.demo.pojos.Batch;
import com.example.demo.pojos.Student;

public interface StudentManager
{
	Student addStudent(Student s);
	List<?> getStudents();
	void delete(int studentId);
//	void update(Student student,int studentId);
	Student getStudent(int studentId);
	
	Student getLogin(String username,String password);
	
	List<?> getStudentsPage(int offset);
	
	
}