package ua.kma.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ua.kma.app.repository.HighScoresRepository;
import ua.kma.app.repository.UpdatesRepository;
import ua.kma.app.repository.UsersRepository;
import ua.kma.app.service.DataBase;
import ua.kma.app.service.UsersServiceImpl;

import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class AppApplication {


	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
		DataBase db = new DataBase();
		db.test();
		}
}
