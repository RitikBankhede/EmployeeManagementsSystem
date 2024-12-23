package com.employeemanagmentssystem.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.employeemanagmentssystem.pojo.Role;
import com.employeemanagmentssystem.pojo.User;

public class MyUserDetails implements UserDetails {

	private User user;
	
	public MyUserDetails(User user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority>lst=new ArrayList<>();
	  Set<Role>roles=user.getRoles();
	  for(Role r:roles) {
		  SimpleGrantedAuthority sga=new SimpleGrantedAuthority(r.getRole_name());
		  lst.add(sga);
	  }
	  return lst;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
	    return user.getPassword();	
	}

}
