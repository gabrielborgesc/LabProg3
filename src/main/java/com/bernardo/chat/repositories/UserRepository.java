package com.bernardo.chat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bernardo.chat.domain.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{
	public Optional<User> findByUsername(String username);
}
