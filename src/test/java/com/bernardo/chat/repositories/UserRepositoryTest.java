package com.bernardo.chat.repositories;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bernardo.chat.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest 
{
	@Autowired
	UserRepository repository;
	
	@Test
	public void findAllTest()
	{
		List<User> users = repository.findAll();
		for (User user : users) {
			System.out.println(user.getUsername());
		}
		
	}
	
	@Test
	public void findById()
	{
		Optional<User> optional = repository.findById(1);
		
		User user = optional.get();
		
		System.out.println(user.getUsername());
		
	}
	
	@Test
	public void findByUsername()
	{
		User gabilau = repository.findByUsername("gabilau");
		
		System.out.println(gabilau.getPassword());
	}
	
}
