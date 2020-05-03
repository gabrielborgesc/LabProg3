package com.bernardo.chat.services;

import com.bernardo.chat.beans.SessionBean;
import com.bernardo.chat.domain.User;
import com.bernardo.chat.dto.LoginCommand;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class LoginService {

  private SessionBean sessionBean;
  private UserService userService;

  @Autowired
  public LoginService(SessionBean sessionBean, UserService userService) {
    this.sessionBean = sessionBean;
    this.userService = userService;
  }

  public void login(@RequestBody LoginCommand command) {
    String username = command.getUsername();
    String password = command.getPassword();
    User user =
        this.userService.findByUsername(username);

    if (validateUser(user, password)) sessionBean.login(user);
  }

  private boolean validateUser(User user, String password) {
    return user.getPassword().equals(password);
  }

  public String isLogged() {
    return String.valueOf(sessionBean.isLogged());
  }
}
