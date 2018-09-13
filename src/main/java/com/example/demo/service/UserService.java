package com.example.demo.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.entity.Usermanger;

public interface UserService {
	
	public Usermanger findBylogin(String login  ,String password);
	public Usermanger findByusername(String login  );

	public Usermanger save(Usermanger user);
     public Usermanger updateUser(Usermanger user);
	public List<Usermanger> findAll();
	
	public Boolean deleteUser(long code_user);

	
	
	
	

}
