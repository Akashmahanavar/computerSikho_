package com.example.demo.JPA;

import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.pojos.Payment;
@Repository
@Transactional
public interface PaymentRepository extends JpaRepository<Payment,Integer> 
{
	Payment save(Payment s);
	List<Payment> findAll();
	void deleteById(int paymentId);
//	@Modifying
//	@Query("update Student s set  s.studentName = :studentName, s.studentEmailId=:studentEmailId,s.studentAddress=:studentAddress,s.studentGender=:studentGender,s.photoUrl=:photoUrl,s.studentDob=:studentDob,s.studentAge=:studentAge,s.studentQualification=:studentQualification,s.studentMobile=:studentMobile,s.studentPassword=:studentPassword,s.studentUsername=:studentUsername,s.enquiryId=:enquiryId,s.batchId=:batchId,s.courseId=:courseId, where s.studentId = :studentId")
//	void update(@Param("studentName") String studentName,@Param("studentEmailId") String studentEmailId,@Param("studentAddress") String studentAddress,@Param("studentGender") String studentGender,@Param("photoUrl") String photoUrl,@Param("studentDob") Date studentDob,@Param("studentAge") int studentAge,@Param("studentQualification") String studentQualification,@Param("studentMobile") String studentMobile,@Param("studentPassword") String studentPassword,@Param("studentUsername") String studentUsername,@Param("enquiryId")Integer enquiryId,@Param("batchId")int batchId,@Param("courseId")int courseId,@Param("studentId")int studentId);
	Payment findById(int paymentId);
	
	@Query(value="select * from payment where student_id = ?1 order by payment_date desc limit 1" , nativeQuery=true)
	Payment findByStudentId(int studentId);
}
