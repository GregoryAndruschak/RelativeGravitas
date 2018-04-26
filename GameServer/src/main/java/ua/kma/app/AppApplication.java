package ua.kma.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ua.kma.app.repository.HighScoresRepository;
import ua.kma.app.repository.UpdatesRepository;
import ua.kma.app.repository.UsersRepository;
import ua.kma.app.service.DataBase;
import ua.kma.app.service.UsersServiceImpl;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class AppApplication {

	private static final String becomeOnline = "https://relative-gravitas.herokuapp.com/become_online";
	private static final String becomeOffline = "https://relative-gravitas.herokuapp.com/become_offline";


	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
//		DataBase db = new DataBase();
//		db.test();
		sendPostToHelperServer(becomeOnline);
	}

	protected void finalize () {
		sendPostToHelperServer(becomeOffline);
	}

	private static void sendPostToHelperServer(String url) {
		try {
			HttpURLConnection httpConnection = (HttpURLConnection) new URL(url).openConnection();
			httpConnection.setRequestMethod("POST");
			int status = httpConnection.getResponseCode();
			System.out.println("Response from helper server " + status);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
