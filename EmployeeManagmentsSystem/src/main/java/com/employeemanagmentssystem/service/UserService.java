package com.employeemanagmentssystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeemanagmentssystem.dao.UserDao;
import com.employeemanagmentssystem.pojo.User;
import com.employeemanagmentssystem.repository.UserRepository;

@Service
public class UserService implements UserDao{

	@Autowired
	private UserRepository repo;
	
	@Override
	public boolean register(User user) {
		try {
			   Optional<User>opt=repo.findById(user.getUsername());	
			   if(opt.isPresent())
				   return false;
			   else {
				      repo.save(user);
				      return true;
			   }
			}catch(Exception exc){
				exc.printStackTrace();
			    return true;
			}	
	}

	@Override
	public boolean checkEmployeeCredentials(User user) {
		try {
			   Optional<User>opt=repo.findById(user.getUsername());	
			   if(opt.isPresent()){
				if(opt.get().getPassword().equals(user.getPassword())) 
					return true;
				else
					return false;
			   }
			   else
			      return false;
		   }catch(Exception exc){
				exc.printStackTrace();
			    return true;
			}	
	}

}
