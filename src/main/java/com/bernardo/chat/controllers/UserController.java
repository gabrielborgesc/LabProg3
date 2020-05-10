package com.bernardo.chat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bernardo.chat.domain.User;
import com.bernardo.chat.services.UserService;

@Controller
public class UserController {
  private UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/users")
  public String getUsers(Model model) {
    model.addAttribute("users", this.userService.findAll());
    return "user/list";
  }
  
  @RequestMapping(value = "/userRemove", method = RequestMethod.POST, produces = "text/plain")
  @ResponseBody
  public String removeUser(@RequestBody User userCommand) {
	  String usernameToDelete = userCommand.getUsername();
	  return String.valueOf(userService.delete(usernameToDelete));
  }
}
