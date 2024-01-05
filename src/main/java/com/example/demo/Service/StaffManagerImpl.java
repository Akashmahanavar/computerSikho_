package com.example.demo.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.JPA.StaffRepository;
import com.example.demo.pojos.Staff;





@Service
public class StaffManagerImpl implements StaffManager
{
	@Autowired
	StaffRepository repository;

	@Override
	public void addStaff(Staff p) {
		repository.save(p);
		
		
	}

	@Override
	public List<Staff> getStaffs() {
		// TODO Auto-generated method stub
		return repository.findAll();
		
		
	}

	@Override
	public void delete(int staffId) {
		repository.deleteById(staffId);
	}

	@Override
	public void update(Staff staff,int staffId) {
		// TODO Auto-generated method stub
		System.out.println("inside update method of service layer");
		repository.update(staff.getStaffName(),staff.getPhotoUrl(),staff.getStaffMobile(),staff.getStaffEmail(),staff.getStaffUsername(),staff.getStaffPassword(),staffId);
		
	}

	@Override
	public Staff getStaff(int staffId) {
		// TODO Auto-generated method stub
		return repository.findById(staffId);
	}
	@Override
	public Staff getLogin(Staff s) {
		
		return repository.GetLogin(s.getStaffUsername(),s.getStaffPassword());
	}
	
}
