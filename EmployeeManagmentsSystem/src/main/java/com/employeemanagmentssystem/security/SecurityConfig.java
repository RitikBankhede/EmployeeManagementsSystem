package com.employeemanagmentssystem.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
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
	
	@Bean
	AuthenticationManager getAuthenticationManager(AuthenticationConfiguration authConfig) throws Exception{
		return authConfig.getAuthenticationManager();
	}
	
	@Bean
	SecurityFilterChain getSecurityFilterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(request->request
			    .requestMatchers("/").permitAll()
			    .requestMatchers("/viewUsers").hasAnyAuthority("admin")
			    .requestMatchers("/addUser").hasAnyAuthority("admin","manager")
			    .requestMatchers("/updateUser").hasAnyAuthority("admin","manager")
				.requestMatchers("/deleteUser").hasAnyAuthority("admin")
				.anyRequest().authenticated())
			.formLogin(login->login
			    .defaultSuccessUrl("/home",true)
		        .failureUrl("/403")
		        .permitAll())
			 .csrf(csrf->csrf
		    	.disable())
		    .exceptionHandling(exc->exc
		        .accessDeniedPage("/issues"));
         
	SecurityFilterChain sf=http.build();
	return sf;
		    
	}
}
