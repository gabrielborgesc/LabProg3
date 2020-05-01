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
	
	@Column(name = "username")
	private String userName;
	
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
