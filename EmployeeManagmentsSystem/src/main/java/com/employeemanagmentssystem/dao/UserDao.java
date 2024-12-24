package com.employeemanagmentssystem.dao;

import java.util.List;

import com.employeemanagmentssystem.pojo.User;

public interface UserDao {
	
   User viewUser(String username);
   List<User> viewUsers();
   
   boolean addNewUser(User user);
   boolean updateUser(User user);
   boolean deleteUser(String username);
}
