package com.example.demo.controller;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Usermanger;
import com.example.demo.service.UserService;


@RestController
@CrossOrigin
@RequestMapping(path="/gestion")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/adduser", method = RequestMethod.POST) 
	@PreAuthorize("hasAuthority('ADMIN_USER')")
	public  @ResponseBody Usermanger addNewUser( @RequestBody Usermanger user  )
	{
		userService.save(user);
		
		return(user);
	}
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/getuser", method = RequestMethod.GET)
	public List<Usermanger> getalluser()
	{
		return userService.findAll();
	}
	
	
	@RequestMapping(value = "/upuser", method = RequestMethod.PUT)
	public Usermanger updateUser(@RequestBody Usermanger user) {
		return userService.updateUser(user);
	}
	
	
	
	@RequestMapping(value = "/getuserbylogin/{id}", method = RequestMethod.GET) 
	public  Usermanger getuserbylogin( @PathVariable("id")String login )
	{
		
	  return  userService.findByusername(login);
	
		
	}
	
	@RequestMapping(value = "/userD/{code_user}", method = RequestMethod.DELETE)
	public Boolean deleteUser(@PathVariable long code_user) {
		return userService.deleteUser(code_user);
		
	}
}
