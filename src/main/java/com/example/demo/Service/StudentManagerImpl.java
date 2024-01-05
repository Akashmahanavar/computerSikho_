package com.example.demo.Service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.JPA.StudentRepository;
import com.example.demo.pojos.Batch;
import com.example.demo.pojos.Student;

@Service
public class StudentManagerImpl implements StudentManager
{
	@Autowired
	StudentRepository repository;

	@Override
	public Student addStudent(Student s) {
		
		return repository.save(s);
		
		
	}

	@Override
	public List<?> getStudents() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void delete(int studentId) {
		repository.deleteById(studentId);
	}

//	@Override
//	public void update(Student student,int studentId) {
//		// TODO Auto-generated method stub
//		System.out.println("inside update method of service layer");
//		repository.update(student.getStudentName(),student.getStudentEmailId(),student.getStudentAddress(),student.getStudentGender(),student.getPhotoUrl(),student.getStudentDob(),student.getStudentAge(),student.getStudentQualification(),student.getStudentMobile(),student.getStudentPassword(),student.getStudentUsername(),student.getEnquiryId(),student.getBatchId(),student.getEnquiryId(),student.getCourseId(),studentId);
//		
//	}

	@Override
	public Student getStudent(int studentId) {
		// TODO Auto-generated method stub
		return repository.findById(studentId);
	}

	@Override
	public Student getLogin(String username, String password) {
		
		return repository.getLogin(username,password);
	}
	
	@Override
	public List<?> getStudentsPage(int offset) {
		// TODO Auto-generated method stub
		return repository.findPage(offset);
		
		
	}

	

}