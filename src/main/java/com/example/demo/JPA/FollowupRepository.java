package com.example.demo.JPA;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.pojos.Followup;




@Repository
@Transactional
public interface FollowupRepository extends JpaRepository<Followup,Integer> 
{
	Followup save(Followup p);
	
	
	@Query("from Followup f where f.isActive=true")
	List<Followup> findAll();
	void deleteById(int followupId);
	@Modifying
	@Query("update Followup p set p.followupMsg = :followupMsg, p.isActive = :isActive where p.followupId = :followupId")
	void update(@Param("followupMsg") String followupMsg,@Param("isActive") boolean isActive,@Param("followupId") int followupId);
	Followup findById(int followupId);
	
	@Query("from Followup f where f.enquiry=:enquiry ")
	List<Followup> getfollowbyenq(@Param("enquiry")int enquiry);
}
