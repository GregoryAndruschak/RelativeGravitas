package ua.kma.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ua.kma.app.repository.HighScoresRepository;
import ua.kma.app.repository.UpdatesRepository;
import ua.kma.app.repository.UsersRepository;
import ua.kma.app.service.DataBase;
import ua.kma.app.service.UsersServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        sendGetToHelperServer(becomeOnline);
	}

	protected void finalize () {
        sendGetToHelperServer(becomeOffline);
	}

    private static void sendGetToHelperServer(String url) {
        try {
            HttpURLConnection httpConnection = (HttpURLConnection) new URL(url).openConnection();
            httpConnection.setRequestMethod("GET");
            httpConnection.setRequestProperty("ip",getIpAddress());
            int status = httpConnection.getResponseCode();
            System.out.println("Response from helper server " + status);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getIpAddress()
    {
        URL myIP;
        try {
            myIP = new URL("http://api.externalip.net/ip/");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(myIP.openStream())
            );
            return in.readLine();
        } catch (Exception e)
        {
            try
            {
                myIP = new URL("http://myip.dnsomatic.com/");

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(myIP.openStream())
                );
                return in.readLine();
            } catch (Exception e1)
            {
                try {
                    myIP = new URL("http://icanhazip.com/");

                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(myIP.openStream())
                    );
                    return in.readLine();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        return null;
    }
}
