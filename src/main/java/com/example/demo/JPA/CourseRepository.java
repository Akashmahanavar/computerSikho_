package com.example.demo.JPA;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.pojos.Course;

@Repository
@Transactional
public interface CourseRepository extends JpaRepository<Course,Integer> 
{
	Course save(Course p);
	
	List<Course> findAll();
	
	void deleteById(int id);
	
	@Modifying
	@Query("update Course p set p.courseName = :courseName, p.courseDescription = :courseDescription, p.courseDuration=:courseDuration, p.courseIsActive= :courseIsActive where p.courseId = :courseId")
	void update(@Param("courseName") String name,@Param("courseDescription") String courseDescription,@Param("courseDuration") int courseDuration,@Param("courseIsActive") boolean courseIsActive,@Param("courseId")int courseId);
	Course findById(int id);
	
	@Query("from Course c where c.courseIsActive= True")
	List<Course> getActiveCourses();
	
	
}
