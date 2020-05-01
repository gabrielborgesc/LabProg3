package com.bernardo.chat.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usr", schema = "public")
public class User 
{
	@Id
	@Column(name = "user_id")
	private Integer id;
	
	private String username;
	
	private String password;
	
//	private String email;
//	
//	private Type type;
	
	//
	// Métodos de acesso
	//
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
//	
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	
//	public Type getType() {
//		return type;
//	}
//
//	public void setType(Type type) {
//		this.type = type;
//	}
	
	
}
