package com.employeemanagmentssystem.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.employeemanagmentssystem.pojo.User;
import com.employeemanagmentssystem.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository repo; 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	  Optional<User>user=repo.findById(username);
	 if(user.isPresent()) {
		 MyUserDetails userDetails=new MyUserDetails(user.get());
		 return userDetails;
	 }else
		 throw new UsernameNotFoundException(username);
	}

}
