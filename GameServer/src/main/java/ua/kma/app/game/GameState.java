package ua.kma.app.game;

public class GameState {

    public GameState(String username, float x, float y, boolean isJumping, boolean isStanding){
        this.username = username;
        this.x = x;
        this.y = y;
        this.isJumping = isJumping;
        this.isStanding = isStanding;
    }

    private String username;
    private float x;
    private float y;
    private boolean isJumping;
    private boolean isStanding;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
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
