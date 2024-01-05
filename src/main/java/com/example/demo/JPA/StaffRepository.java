package com.example.demo.JPA;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.pojos.Staff;


@Repository
@Transactional
public interface StaffRepository extends JpaRepository<Staff,Integer> 
{
	Staff save(Staff p);
	List<Staff> findAll();
	void deleteById(int staffId);
	@Modifying
	@Query("update Staff p set p.staffName = :staffName, p.photoUrl = :photoUrl, p.staffMobile = :staffMobile, p.staffEmail = :staffEmail,p.staffUsername = :staffUsername,p.staffPassword = :staffPassword where p.staffId = :staffId")
	void update(@Param("staffName") String staffName,@Param("photoUrl") String photoUrl,@Param("staffMobile") String staffMobile,@Param("staffEmail")String staffEmail,@Param("staffUsername") String staffUsername,@Param("staffPassword") String staffPassword,@Param("staffId") int staffId);
	Staff findById(int staffId);
	
	@Query("from Staff s where s.staffUsername=:staffUsername and s.staffPassword=:staffPassword")
	Staff GetLogin(@Param("staffUsername") String staffUsername,@Param("staffPassword") String staffPassword);
	
}
