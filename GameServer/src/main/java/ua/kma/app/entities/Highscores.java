package ua.kma.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "highscores")
public class Highscores {

	@Id
	@Column(unique=true)
	protected int ID;
	
	@Column(name = "gamesalltime",nullable=false)
	protected int gamesAllTime;
	
	@Column(name = "gameslastmonth",nullable=false)
	protected int gamesLastMonth;
	
	@Column(name = "gameslastweek",nullable=false)
	protected int gamesLastWeek;
	
	@Column(name = "deathalltime",nullable=false)
	protected int deathAllTime;
	
	

	@Column(name = "deathlastmonth",nullable=false)
	protected int deathLastMonth;
	
	@Column(name = "deathlastweek",nullable=false)
	protected int deathLastWeek;
	
	@Column(name = "winsalltime",nullable=false)
	protected int winsAllTime;
	
	@Column(name = "winslastmonth",nullable=false)
	protected int winsLastMonth;
	

	@Column(name = "winslastweek",nullable=false)
	protected int winsLastWeek;
	
	@Column(name = "raiting",nullable=false)
	protected int raiting;
	
	@Column(name = "raitingmonth",nullable=false)
	protected int raitingMonth;
	
	@Column(name = "raitingweek",nullable=false)
	protected int raitingWeek;
	
	
	
	public Highscores(Highscores s) {
		ID = s.ID;
		this.gamesAllTime = s.gamesAllTime;
		this.gamesLastMonth = s.gamesLastMonth;
		this.gamesLastWeek = s.gamesLastWeek;
		this.deathAllTime = s.deathAllTime;
		this.deathLastMonth = s.deathLastMonth;
		this.deathLastWeek = s.deathLastWeek;
		this.winsAllTime = s.winsAllTime;
		this.winsLastMonth = s.winsLastMonth;
		this.winsLastWeek = s.winsLastWeek;
		this.raiting = s.raiting;
		this.raitingMonth = s.raitingMonth;
		this.raitingWeek = s.raitingWeek;
	}

	public Highscores() {
		super();
	}

	
		

	public int getGamesAllTime() {
		return gamesAllTime;
	}

	public void setGamesAllTime(int gamesAllTime) {
		this.gamesAllTime = gamesAllTime;
	}

	public int getGamesLastMonth() {
		return gamesLastMonth;
	}

	public void setGamesLastMonth(int gamesLastMonth) {
		this.gamesLastMonth = gamesLastMonth;
	}

	public int getGamesLastWeek() {
		return gamesLastWeek;
	}

	public void setGamesLastWeek(int gamesLastWeek) {
		this.gamesLastWeek = gamesLastWeek;
	}

	public int getDeathAllTime() {
		return deathAllTime;
	}

	public void setDeathAllTime(int deathAllTime) {
		this.deathAllTime = deathAllTime;
	}

	public int getDeathLastMonth() {
		return deathLastMonth;
	}

	public void setDeathLastMonth(int deathLastMonth) {
		this.deathLastMonth = deathLastMonth;
	}

	public int getDeathLastWeek() {
		return deathLastWeek;
	}

	public void setDeathLastWeek(int deathLastWeek) {
		this.deathLastWeek = deathLastWeek;
	}

	public int getWinsAllTime() {
		return winsAllTime;
	}

	public void setWinsAllTime(int winsAllTime) {
		this.winsAllTime = winsAllTime;
	}

	public int getWinsLastMonth() {
		return winsLastMonth;
	}
	

	public void setWinsLastMonth(int winsLastMonth) {
		this.winsLastMonth = winsLastMonth;
	}

	public int getWinsLastWeek() {
		return winsLastWeek;
	}

	public void setWinsLastWeek(int winsLastWeek) {
		this.winsLastWeek = winsLastWeek;
	}

	public int getRaiting() {
		return raiting;
	}

	public void setRaiting(int raiting) {
		this.raiting = raiting;
	}

	public int getRaitingMonth() {
		return raitingMonth;
	}

	public void setRaitingMonth(int raitingMonth) {
		this.raitingMonth = raitingMonth;
	}

	public int getRaitingWeek() {
		return raitingWeek;
	}

	public void setRaitingWeek(int raitingWeek) {
		this.raitingWeek = raitingWeek;
	}

	public int getID() {
		return ID;
	}
	
	@Override
	public String toString() {
		return "Highscores [ID=" + ID + ", gamesAllTime=" + gamesAllTime + ", gamesLastMonth=" + gamesLastMonth
				+ ", gamesLastWeek=" + gamesLastWeek + ", deathAllTime=" + deathAllTime + ", deathLastMonth="
				+ deathLastMonth + ", deathLastWeek=" + deathLastWeek + ", winsAllTime=" + winsAllTime
				+ ", winsLastMonth=" + winsLastMonth + ", winsLastWeek=" + winsLastWeek + ", raiting=" + raiting
				+ ", raitingMonth=" + raitingMonth + ", raitingWeek=" + raitingWeek + "]";
	}


	
}
