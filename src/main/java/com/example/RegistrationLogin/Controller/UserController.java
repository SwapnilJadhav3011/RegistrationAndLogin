package com.example.RegistrationLogin.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.RegistrationLogin.Entity.User;
import com.example.RegistrationLogin.Service.UserService;

@RestController
public class UserController {

	
	@Autowired 
	private UserService userService;
	
	@PostMapping("/register")
	public User saveUser(@RequestBody User user) throws Exception
	{
		String tempEmailId= user.getEmail();
		
		if(tempEmailId != null && !"".endsWith(tempEmailId))
		{
			User userObj = userService.getUserByEmailId(tempEmailId);
			if(userObj != null)
			{
				throw new Exception("User With "+ tempEmailId+ " Is Already Exist");
			}
		}
		User userObj=null;
		userObj= userService.saveUser(user);
		return userObj;
	}
	
	@PostMapping("/login")
	public User loginUser(@RequestBody User  user) throws Exception
	{
		String tempEmailId = user.getEmail();
		String tempPass= user.getPassword();
		
		User userObj= null;
		if(tempEmailId != null && tempPass != null)
		{
			userObj= userService.getUserByEmailAndPassword(tempEmailId, tempPass);
		}
		
		if(userObj == null)
		{
			throw new Exception("Bad Credintials");
		}
		return userObj;
	}
}
