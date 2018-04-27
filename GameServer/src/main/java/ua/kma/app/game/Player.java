package ua.kma.app.game;

import org.springframework.boot.jackson.JsonComponent;

public class Player {

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
