package com.example.demo.JPA;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.pojos.Enquiry;




@Repository
@Transactional
public interface EnquiryRepository extends JpaRepository<Enquiry,Integer> 
{
	Enquiry save(Enquiry p);
	
	
	@Query("from Enquiry e where e.enquiryProcessedFlag=false")
	List<Enquiry> findAll();
	
	Date today = new Date();
	
	@Query(value = "select * from enquiry where follow_up <= curdate() and enquiry_processed_flag=false",nativeQuery = true) 
	List<Enquiry> findALLFollow();
	
	void deleteById(int id);
	
	Enquiry findById(int id);
	
	
//	@Query("select enquirerName,enquiryDate,courseName,courseFees from Enquiry e JOIN Course c where e.courseId=c.courseId") 
//	List<?> Short();
	
	  @Modifying
	  
	  @Query("update Enquiry e set e.closureReason = :closureReason, e.enquiryProcessedFlag = :enquiryProcessedFlag, e.enquiryCounter=:enquiryCounter,e.followUp=:followUp where e.id = :id"
	  ) void update(@Param("closureReason") String closureReason,@Param("enquiryProcessedFlag") boolean
			  enquiryProcessedFlag,@Param("enquiryCounter") int enquiryCounter,@Param("followUp") Date followUp,@Param("id")int id);
	 
	  
	  
	  
}
