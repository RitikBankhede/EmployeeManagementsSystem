package com.employeemanagmentssystem.daoimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeemanagmentssystem.dao.UserDao;
import com.employeemanagmentssystem.pojo.User;
import com.employeemanagmentssystem.repository.UserRepository;

@Service
public class UserService implements UserDao {

	@Autowired
	private UserRepository repo;
	
	@Override
	public User viewUser(String username) {
	 try{
		 Optional<User>opt=repo.findById(username);
		 if(opt.isPresent())
			 return opt.get();
		 else
			 return null;
	 }catch(Exception exc) {
		 exc.printStackTrace();
		 return null;
	 }
	}

	@Override
	public List<User> viewUsers() {
		List<User>lst=new ArrayList<User>();
	    try {
		repo.findAll().forEach(lst::add);
	    return lst;
	    }catch(Exception exc) {
	    	exc.printStackTrace();
	          return null;
	    }
	    }

	@Override
	public boolean addNewUser(User user) {
       try{
    	   Optional<User>opt=repo.findById(user.getUsername());
    	   if(opt.isPresent()) {
    		   return false;
    	   }else {
                 repo.save(user);
                 return true;
    	   }
       }catch(Exception exc) {
    	   exc.printStackTrace();
    	   return false;
       }
	}

	@Override
	public boolean updateUser(User user) {
	    try{
	    	   Optional<User>opt=repo.findById(user.getUsername());
	    	   if(opt.isPresent()) {
	    		  repo.save(user);
	    		  return true;
	    	   }else {
	    		   return false;
	    	   }
	       }catch(Exception exc) {
	    	   exc.printStackTrace();
	    	   return false;
	       }
		}


	@Override
	public boolean deleteUser(String username) {
	    try{
	    	   Optional<User>opt=repo.findById(username);
	    	   if(opt.isPresent()) {
	    		  repo.delete(opt.get());
	    		  return true;
	    	   }else {
                     return false;
	    	   }
	       }catch(Exception exc) {
	    	   exc.printStackTrace();
	    	   return false;
	       }
		}
	}


