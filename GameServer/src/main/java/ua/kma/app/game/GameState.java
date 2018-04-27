package ua.kma.app.game;


import org.springframework.boot.jackson.JsonComponent;

public class GameState {

    public GameState(String username, int x, int y, int deaths,boolean isJumping, boolean isStanding, boolean isFalling, boolean orientation, boolean isShooting, boolean isDead){
        this.username = username;
        this.x = x;
        this.y = y;
        this.deaths = deaths;
        this.isJumping = isJumping;
        this.isStanding = isStanding;
        this.isFalling = isFalling;
        this.orientation = orientation;
        this.isShooting = isShooting;
        this.isDead = isDead;
    }

    private String username;
    private int x;
    private int y;
    private int deaths;
    private boolean isJumping;
    private boolean isStanding;
    private boolean isFalling;
    private boolean orientation;
    private boolean isShooting;
    private boolean isDead;

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public boolean isFalling() {
        return isFalling;
    }

    public void setFalling(boolean falling) {
        isFalling = falling;
    }

    public boolean isOrientation() {
        return orientation;
    }

    public void setOrientation(boolean orientation) {
        this.orientation = orientation;
    }

    public boolean isShooting() {
        return isShooting;
    }

    public void setShooting(boolean shooting) {
        isShooting = shooting;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isJumping() {
        return isJumping;
    }

    public void setJumping(boolean jumping) {
        isJumping = jumping;
    }

    public boolean isStanding() {
        return isStanding;
    }

    public void setStanding(boolean standing) {
        isStanding = standing;
    }
}
