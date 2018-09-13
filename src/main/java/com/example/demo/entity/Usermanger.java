package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.context.annotation.Scope;



@Entity
@Scope("session")
public class Usermanger implements Serializable{
	
	@Id
	private long code_user;
	private String login;
	private String password;
	private String name_user;
	
	
	
	
	@OneToMany(mappedBy = "id_role",fetch=FetchType.EAGER)
	private List <Role> role;
	
	public Usermanger() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Usermanger(long code_user, String login, String password, String name_user,
			List<Role> role) {
		super();
		this.code_user = code_user;
		this.login = login;
		this.password = password;
		this.name_user = name_user;
		this.role = role;
	}
    
	


	public Usermanger(String login, String password, List<Role> role) {
		super();
		this.login = login;
		this.password = password;
		this.role = role;
	}


	public long getCode_user() {
		return code_user;
	}
	public void setCode_user(long code_user) {
		this.code_user = code_user;
	}
	public String getName_user() {
		return name_user;
	}
	public void setName_user(String name_user) {
		this.name_user = name_user;
	}

	

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	
	public List<Role> getRole() {
		return role;
	}


	public void setRole(List<Role> role) {
		this.role = role;
	}


	
	
	

}
