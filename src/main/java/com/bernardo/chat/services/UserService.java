package com.bernardo.chat.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bernardo.chat.domain.Room;
import com.bernardo.chat.domain.Type;
import com.bernardo.chat.domain.User;
import com.bernardo.chat.dto.CreateUserCommand;
import com.bernardo.chat.dto.GetUserRoomsCommand;
import com.bernardo.chat.dto.RemoveUserCommand;
import com.bernardo.chat.dto.UpdateUserEmailCommand;
import com.bernardo.chat.dto.UpdateUserPasswordCommand;
import com.bernardo.chat.repositories.UserRepository;

@Service
public class UserService {
  private UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public boolean create(CreateUserCommand command) {
	String password = command.getPassword();
	String retype = command.getRetype();
	
	if (!password.equals(retype))
		return false;
	else {
	    User user = this.findByUsername(command.getUsername());
	    if (user == null) {
	      this.save(
	              new User(command.getUsername(),
	                      command.getPassword(),
	                      command.getEmail(),
	                      Type.REGULAR)
	      );
	      return true;
	    }
	    return false;
	}

  }

  public boolean delete(RemoveUserCommand command) {
    User user = this.findByUsername(command.getUsername());
    if (user == null)
      return false;

    this.deleteById(user.getId());
    return true;
  }

  public boolean updateEmail(UpdateUserEmailCommand command) {
    User user = this.findByUsername(command.getUsername());
    if (user == null)
      return false;

    user.setEmail(command.getEmail());
    this.save(user);
    return true;
  }

  public boolean updatePassword(UpdateUserPasswordCommand command) {
    User user = this.findByUsername(command.getUsername());
    if (user == null)
      return false;

    user.setPassword(command.getPassword());
    this.save(user);
    return true;
  }

  public Set<Room> getRooms(GetUserRoomsCommand command) {
    User user = this.findByUsername(command.getUsername());
    if(user == null)
      return new HashSet<>();

    return user.getRooms();
  }

  public User findByUsername(String username) {
    return this.userRepository.findByUsername(username);
  }

  public User save(User user) {
    return this.userRepository.save(user);
  }

  public void deleteById(Integer id) {
    this.userRepository.deleteById(id);
  }

  public Iterable<User> findAll() {
    return this.userRepository.findAll();
  }
}
