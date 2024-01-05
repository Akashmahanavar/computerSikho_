package com.example.demo.JPA;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.pojos.Videos;

@Repository
@Transactional
public interface VideoRepository extends JpaRepository<Videos, Integer> {
	Videos save(Videos p);

	List<Videos> findAll();

	void deleteById(int id);

	Videos findById(int id);
	

	@Modifying
	@Query("update Videos b set b.videoId = :videoId, b.videoDescription = :videoDescription, b.videoUrl=:videoUrl,b.videoIsActive=:videoIsActive,b.startDate=:startDate, b.endDate=:endDate where b.id = :id")
	void update(@Param("videoId") int videoId, @Param("videoDescription") String videoDescription,
			@Param("videoUrl") String videoUrl, @Param("videoIsActive") Boolean videoIsActive,
			@Param("startDate") java.util.Date startDate,@Param("endDate") java.util.Date endDate);

	@Query("from Videos b where b.course = :courseId")
	List<Videos> getCourseVideo(@Param("courseId") int courseId);

}
