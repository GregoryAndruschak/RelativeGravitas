package ua.kma.app.entities;

public class UsersData {

	private String name;

	private Highscores h;

	public UsersData(String name, Highscores h) {

		this.h = h;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Highscores high() {
		// TODO Auto-generated method stub
		return h;
	}

	public int getGamesAllTime() {
		return h.gamesAllTime;
	}

	public void setGamesAllTime(int gamesAllTime) {
		h.setGamesAllTime(gamesAllTime);
	}

	public int getGamesLastMonth() {
		return h.gamesLastMonth;
	}

	public void setGamesLastMonth(int gamesLastMonth) {
		h.setGamesLastMonth(gamesLastMonth);
	}

	public int getGamesLastWeek() {
		return h.gamesLastWeek;
	}

	public void setGamesLastWeek(int gamesLastWeek) {
		h.setGamesLastWeek( gamesLastWeek);
	}

	public int getDeathAllTime() {
		return h.deathAllTime;
	}

	public void setDeathAllTime(int deathAllTime) {
		h.setDeathAllTime(deathAllTime);
	}

	public int getDeathLastMonth() {
		return h.deathLastMonth;
	}

	public void setDeathLastMonth(int deathLastMonth) {
		h.setDeathLastMonth(deathLastMonth);
	}

	public int getDeathLastWeek() {
		return h.deathLastWeek;
	}

	public void setDeathLastWeek(int deathLastWeek) {
		h.setDeathLastWeek(deathLastWeek);
	}

	public int getWinsAllTime() {
		return h.winsAllTime;
	}

	public void setWinsAllTime(int winsAllTime) {
		h.setWinsAllTime( winsAllTime);
	}

	public int getWinsLastMonth() {
		return h.winsLastMonth;
	}

	public void setWinsLastMonth(int winsLastMonth) {
		h.setWinsLastMonth(winsLastMonth);
	}

	public int getWinsLastWeek() {
		return h.winsLastWeek;
	}

	public void setWinsLastWeek(int winsLastWeek) {
		h.setWinsLastWeek(winsLastWeek);
	}

	public int getRaiting() {
		return h.raiting;
	}

	public void setRaiting(int raiting) {
		h.setRaiting(raiting);
	}

	public int getRaitingMonth() {
		return h.raitingMonth;
	}

	public void setRaitingMonth(int raitingMonth) {
		h.setRaitingMonth(raitingMonth);
	}

	public int getRaitingWeek() {
		return h.raitingWeek;
	}

	public void setRaitingWeek(int raitingWeek) {
		h.setRaitingWeek(raitingWeek);	}

	public int getID() {
		return h.getID();
	}

	@Override
	public String toString() {
		return "UsersData [name=" + name + ", getGamesAllTime()=" + getGamesAllTime() + ", getGamesLastMonth()="
				+ getGamesLastMonth() + ", getGamesLastWeek()=" + getGamesLastWeek() + ", getDeathAllTime()="
				+ getDeathAllTime() + ", getDeathLastMonth()=" + getDeathLastMonth() + ", getDeathLastWeek()="
				+ getDeathLastWeek() + ", getWinsAllTime()=" + getWinsAllTime() + ", getWinsLastMonth()="
				+ getWinsLastMonth() + ", getWinsLastWeek()=" + getWinsLastWeek() + ", getRaiting()=" + getRaiting()
				+ ", getRaitingMonth()=" + getRaitingMonth() + ", getRaitingWeek()=" + getRaitingWeek() + ", getID()="
				+ getID() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + "]";
	}

}
