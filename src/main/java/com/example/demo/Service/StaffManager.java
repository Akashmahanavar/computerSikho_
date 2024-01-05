package com.example.demo.Service;


import java.util.List;

import com.example.demo.pojos.Staff;





public interface StaffManager
{
	void addStaff(Staff staff);
	List<Staff> getStaffs();
	void delete(int staffId);
	void update(Staff staff,int staffId);
	Staff getStaff(int staffId);
	Staff getLogin(Staff s);
}
