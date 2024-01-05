package com.example.demo.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.JPA.CourseRepository;
import com.example.demo.pojos.Course;




@Service
public class CourseManagerImpl implements CourseManager
{
	@Autowired
	CourseRepository repository;

	@Override
	public void addCourse(Course p) {
		repository.save(p);
		
		
	}

	@Override
	public List<?> getCourses() {
		// TODO Auto-generated method stub
		return repository.findAll();
		
		
	}

	@Override
	public void delete(int id) {
		repository.deleteById(id);
	}

	@Override
	public void update(Course course,int id) {
		// TODO Auto-generated method stub
		repository.update(course.getCourseName(),course.getCourseDescription(),course.getCourseDuration(),course.getCourseIsActive(),id);
		
	}
	@Override
	public Course getCourse(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}
	
	@Override
	public List<?> getActiveCourses() {
		// TODO Auto-generated method stub
		return repository.getActiveCourses();
	}

}
