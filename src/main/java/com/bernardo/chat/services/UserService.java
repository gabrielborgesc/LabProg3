package com.bernardo.chat.services;

import com.bernardo.chat.domain.User;
import com.bernardo.chat.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

  private UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public Optional<User> findUserByUsername(String username) {
    return this.userRepository.findByUsername(username);
  }
}
