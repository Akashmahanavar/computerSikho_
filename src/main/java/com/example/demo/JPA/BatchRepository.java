package com.example.demo.JPA;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.pojos.Batch;

@Repository
@Transactional
public interface BatchRepository extends JpaRepository<Batch, Integer> {
//	List<Batch >saveAll(Batch p,Batch p2);
	Batch save(Batch p);
	List<Batch> findAll();

	void deleteById(int id);

	Batch findById(int id);

	@Modifying
	@Query("update Batch b set b.batchName = :batchName, b.batchStartTime = :batchStartTime, b.batchEndTime=:batchEndTime,b.batchIsActive=:batchIsActive,b.finalPresentationDate=:finalPresentationDate where b.id = :id")
	void update(@Param("batchName") String batchName, @Param("batchStartTime") java.util.Date batchStartTime, 
			@Param("batchEndTime") java.util.Date batchEndTime,
			@Param("batchIsActive") Boolean batchIsActive, @Param("finalPresentationDate") java.util.Date finalPresentationDate,
			@Param("id") int id);
	
	@Query("from Batch b where b.course = :courseId")
	List<Batch> getCourseBatch(@Param("courseId") int courseId);

	@Query("from Batch b where b.course=:course")
	List<Batch> getSbatch(@Param("course") int course);
}
