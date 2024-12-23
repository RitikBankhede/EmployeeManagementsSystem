package com.employeemanagmentssystem.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {
   
	@Autowired
	private MyUserDetailsService service;

	public SecurityConfig(MyUserDetailsService service) {
		super();
		this.service = service;
	}
	
	@Bean
	BCryptPasswordEncoder getPasswordEncoder() {
		BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
		return passwordEncoder;
	}
	
	@Bean
	DaoAuthenticationProvider getAuthProvider() {
		DaoAuthenticationProvider authProvider=new DaoAuthenticationProvider();
		authProvider.setPasswordEncoder(getPasswordEncoder());
		authProvider.setUserDetailsService(service);
		return authProvider;
	}
	
	AuthenticationManager getAuthenticationManager(AuthenticationConfiguration authConfig) throws Exception{
		return authConfig.getAuthenticationManager();
	}
	
	SecurityFilterChain getSecurityFilterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(request->request
			    .requestMatchers("/").permitAll()
		        .requestMatchers("/login").permitAll()
		        .requestMatchers("/viewEmployees").hasAnyAuthority("admin")
			    .requestMatchers("/viewEmployee").hasAnyAuthority("admin","manager","employee")
			    .requestMatchers("/addEmployee").hasAnyAuthority("admin","manager")
			    .requestMatchers("/updateEmployee").hasAnyAuthority("admin","manager")
				.requestMatchers("/deleteEmployee").hasAnyAuthority("admin")
				.anyRequest().authenticated())
			.formLogin(login->login
		        .defaultSuccessUrl("/home",true)
		        .failureUrl("/403"))
		    .csrf(csrf->csrf
		    	.disable())
		    .exceptionHandling(exc->exc
		        .accessDeniedPage("/403"));
         
	SecurityFilterChain sf=http.build();
	return sf;
		    
	}
}
