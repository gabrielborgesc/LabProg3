package com.bernardo.chat.controllers;

import com.bernardo.chat.dto.LoginCommand;
import com.bernardo.chat.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
  private LoginService loginService;

  @Autowired
  public LoginController(LoginService loginService) {
    this.loginService = loginService;
  }

  @PostMapping("/login")
  public void login(@RequestBody LoginCommand command) {
    this.loginService.login(command);
  }

  @RequestMapping(value = "/login", method = RequestMethod.GET, produces = "text/plain")
  @ResponseBody
  public String logged() {
    return this.loginService.isLogged();
  }
}
