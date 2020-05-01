package com.bernardo.chat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bernardo.chat.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{
	public User findByUsername(String userName);
}
