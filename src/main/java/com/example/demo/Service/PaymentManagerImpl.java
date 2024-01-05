package com.example.demo.Service;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.JPA.PaymentRepository;
import com.example.demo.pojos.Payment;

@Service
public class PaymentManagerImpl implements PaymentManager
{
	@Autowired
	PaymentRepository repository;

	@Override
	public void addPayment(Payment p) {
		repository.save(p);
		
		
	}

	@Override
	public List<?> getPayments() {
		// TODO Auto-generated method stub
		return repository.findAll();
		
		
	}

	@Override
	public void delete(int paymentId) {
		repository.deleteById(paymentId);
	}

//	@Override
//	public void update(Student student,int studentId) {
//		// TODO Auto-generated method stub
//		System.out.println("inside update method of service layer");
//		repository.update(student.getStudentName(),student.getStudentEmailId(),student.getStudentAddress(),student.getStudentGender(),student.getPhotoUrl(),student.getStudentDob(),student.getStudentAge(),student.getStudentQualification(),student.getStudentMobile(),student.getStudentPassword(),student.getStudentUsername(),student.getEnquiryId(),student.getBatchId(),student.getEnquiryId(),student.getCourseId(),studentId);
//		
//	}

	@Override
	public Payment getPayment(int paymentId) {
		// TODO Auto-generated method stub
		return repository.findById(paymentId);
	}
	
	@Override
	public Payment getPaymentdetails(int studentId) {
		// TODO Auto-generated method stub
		return repository.findByStudentId(studentId);
	}


}
