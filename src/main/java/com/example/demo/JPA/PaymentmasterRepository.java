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
import com.example.demo.pojos.Paymentmaster;



@Repository
@Transactional
public interface PaymentmasterRepository extends JpaRepository<Paymentmaster,Integer> 
{
	Paymentmaster save(Paymentmaster a);
	List<Paymentmaster> findAll();
	void deleteById(int albumId);
	/*
	 * @Modifying
	 * 
	 * @Query("update Album a set a.albumIsActive=:albumIsActive,a.startDate=:startDate,a.endDate=:endDate where a.albumId = :albumId"
	 * ) void update(@Param("albumIsActive") boolean
	 * albumIsActive, @Param("startDate") java.util.Date startDate,
	 * 
	 * @Param("endDate") java.util.Date endDate,@Param("albumId") int albumId);
	 */
	
	Paymentmaster findById(int albumId);
	
	@Modifying
	 @Query("update Paymentmaster set courseFees=courseFees-:courseFees where student=:student") 
	 void update(@Param("courseFees")int courseFees,@Param("student") int student );

	@Query("FROM Paymentmaster WHERE student = :student")
	Paymentmaster findByStudentId(@Param("student")int student);

	
}
