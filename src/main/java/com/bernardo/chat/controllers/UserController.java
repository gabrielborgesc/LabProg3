package com.bernardo.chat.controllers;

import com.bernardo.chat.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
  private UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @RequestMapping("/users")
  public String getUsers(Model model) {
    model.addAttribute("users", this.userService.findAll());
    return "users/list";
  }
}
