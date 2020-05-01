package com.bernardo.chat.repositories;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bernardo.chat.domain.Type;
import com.bernardo.chat.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest 
{
	@Autowired
	UserRepository repository;
	
	
	//@Test
	public void findAllTest()
	{
		List<User> users = repository.findAll();
		for (User user : users) {
			System.out.println(user.getUsername());
		}
		
	}
	
	//@Test
	public void findById()
	{
		Optional<User> optional = repository.findById(1);
		
		User user = optional.get();
		
		System.out.println(user.getUsername());
		
	}
	
	//@Test
	public void findByUsername()
	{
		User user = repository.findByUsername("gabriel");
		
		//System.out.println(user.getPassword());
	}
	
	
	//@Test
		public void insert(User newuser) {
				
			User user = repository.findByUsername(newuser.getUsername());
			if(user==null) {
			repository.save(newuser);
		}
		}
	
	//@Test
		public void delete(String username) {
			User user = repository.findByUsername(username);
			if(user!=null) {
			repository.deleteById(user.getId());
			}
		}
		
		
	
	@Test
	public void test() {
		User newuser = new User();
		newuser.setUsername("werneck");
		//newuser.setId(2);
		newuser.setEmail("wern@gmail.com");
		newuser.setPassword("abcde");
		Type type = Type.user;
		newuser.setType(type);
		
		delete("jbdjas");
		
	}
	
}
