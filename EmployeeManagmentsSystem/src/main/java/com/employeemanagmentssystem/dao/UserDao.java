package com.employeemanagmentssystem.dao;

import com.employeemanagmentssystem.pojo.User;

public interface UserDao {
	
   boolean register(User user);
   boolean checkEmployeeCredentials(User user);
}
