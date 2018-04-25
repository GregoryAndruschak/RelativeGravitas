package ua.kma.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;
import ua.kma.app.entities.Highscores;
import ua.kma.app.entities.User;
import ua.kma.app.repository.UsersRepository;

import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class AppApplication {
	private static UsersRepository usersRepository;
//
//	@Autowired
//	public void setUsersRepository(UsersRepository usersRepository) {
//		AppApplication.usersRepository = usersRepository;
//	}

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
//		User user = new User();
//		user.setEmail("email");
//		user.setUsername("user");
//		user.setPassword("password");
//
//		User user1 = new User();
//		user1.setEmail("email1");
//		user1.setUsername("user1");
//		user1.setPassword("password1");
//
//		user.setFriends(Collections.singletonList(user1));
//		usersRepository.save(user);
//		usersRepository.save(user1);
//		List<User> userList = usersRepository.findAll();
//		userList.get(0).setFriendOf(Collections.singletonList(userList.get(1)));
//		userList.get(0).setFriends(Collections.singletonList(userList.get(1)));
//		usersRepository.save(userList.get(0));
//		System.out.println(123);
	}
}
