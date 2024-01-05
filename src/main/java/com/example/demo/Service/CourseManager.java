package com.example.demo.Service;

import java.util.List;

import com.example.demo.pojos.Course;





public interface CourseManager
{
	void addCourse(Course p);
	List<?> getCourses();
	void delete(int id);
	void update(Course course,int id);
	Course getCourse(int id);
	List<?>getActiveCourses();
	
}
