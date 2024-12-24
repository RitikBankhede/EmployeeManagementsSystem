package com.employeemanagmentssystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.employeemanagmentssystem.daoimpl.UserService;
import com.employeemanagmentssystem.pojo.User;

@Controller
public class UserController {
  	
	@Autowired
	private  UserService service;
	
	@GetMapping("/home")
	public String homePage() {
		return "home";
	}
	
	@GetMapping("/viewUsers")
	public String viewUsers(ModelMap map){
		List<User>users=service.viewUsers();
		map.addAttribute("USERLIST",users);
		return "viewUsers";
	}
	
	 @GetMapping("/addUser")
	    public String addUserPage() {
	        return "addUser";
	  }
	 
	 @GetMapping("/deleteUser")
	    public String deleteUserPage() {
	        return "deleteUser";
	  }
	 
	 @GetMapping("/updateUser")
	    public String updateUserPage() {
	        return "updateUser";
	  }
	 
	 @PostMapping("/saveUser")
	 public String addController( User user,ModelMap map) {
		  if(service.addNewUser(user)) {
			  map.addAttribute("MSG","USER ADDED SUCCESSFULLY");
	          map.addAttribute("MSGCOLOR","GREEN");
	      }else {
			  map.addAttribute("MSG","USERName Exist");
		      map.addAttribute("MSGCOLOR","Red");
		  }
	  return "home";
     }

	 
	 @PostMapping("/updateUser")
	 public String updateController( User user,ModelMap map) {
		  if(service.updateUser(user)) {
			  map.addAttribute("MSG","USER Updated SUCCESSFULLY");
	          map.addAttribute("MSGCOLOR","GREEN");
	      }else {
			  map.addAttribute("MSG","USER Not Exist");
		      map.addAttribute("MSGCOLOR","Red");
		  }
	  return "home";
     }
	 
	 
	 @PostMapping("/deleteUser")
	 public String deleteController(User user,ModelMap map) {
		  if(service.deleteUser(user.getUsername())) {
			  map.addAttribute("MSG","USER Deleted SUCCESSFULLY");
	          map.addAttribute("MSGCOLOR","GREEN");
	      }else {
			  map.addAttribute("MSG","USERName Exist");
		      map.addAttribute("MSGCOLOR","Red");
		  }
	  return "home";
     }

     @GetMapping("/issues")
     public String issuePage() {
    	 return "issues";
     }
     
     @GetMapping("/logout")
     public String logoutPage() {
    	 return "login";
     }
}