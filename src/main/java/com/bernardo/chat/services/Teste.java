package com.bernardo.chat.services;


import com.bernardo.chat.beans.SessionBean;
import com.bernardo.chat.domain.Type;
import com.bernardo.chat.domain.User;
import com.bernardo.chat.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Teste {

	private UserRepository userRepository;
	private SessionBean sessionBean;

	@Autowired
	public Teste(UserRepository userRepository, SessionBean sessionBean) {
		this.userRepository = userRepository;
		this.sessionBean = sessionBean;
	}


	public static void main(String[] args) {

		User user1 = new User("gabriel", "1234", "email", Type.ADMIN);
		User user2 = new User("adriano", "1234", "email", Type.REGULAR);
		User user3 = new User("borges", "1234", "email", Type.ADMIN);

//		List<User> list = new List<User>();

//		list.sort(Comparator.comparing(User::getUsername()));

	}
	
}
