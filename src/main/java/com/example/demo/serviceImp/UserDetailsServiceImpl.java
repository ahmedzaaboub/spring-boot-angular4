package com.example.demo.serviceImp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Usermanger;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		 Usermanger usermanger=userService.findByusername(username);
		if (usermanger == null) throw new UsernameNotFoundException(username);
		//List <Role> authorities= new ArrayList <Role>();
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		for(int i=0;i<usermanger.getRole().size();i++ )
		{
			authorities.add(new SimpleGrantedAuthority(usermanger.getRole().get(i).getRole_name()));
		}
				
		return (UserDetails) new User( usermanger.getLogin(),usermanger.getPassword(),authorities);
		
	
	}

}
