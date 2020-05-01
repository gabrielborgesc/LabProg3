package com.bernardo.chat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bernardo.chat.beans.SessionBean;
import com.bernardo.chat.domain.User;
import com.bernardo.chat.repositories.UserRepository;
import com.fasterxml.jackson.annotation.JsonProperty;

@RestController
public class LoginService 
{
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	SessionBean sessionBean;
	
	@PostMapping("/login")
	public void doLogin(@RequestBody LoginRequest request)
	{
		User user = userRepository.findByUsername(request.getUsername());
		
		if(validateUser(request, user))
			sessionBean.login(user);
	}

	private boolean validateUser(LoginRequest request, User user) {
		return request.getPassword()!= null 
				&& user != null 
				&& request.getPassword().equals(user.getPassword());
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET, produces="text/plain")
	@ResponseBody
	public String logged()
	{
		return sessionBean.isLogged() ? "true" : "false";
	}
}

class LoginRequest
{
	private String username;
	private String password;
	
	LoginRequest(@JsonProperty("username") String username,
			@JsonProperty("password") String password)
	{
		this.username = username;
		this.password = password;
	}
	
	LoginRequest() { }
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
}
