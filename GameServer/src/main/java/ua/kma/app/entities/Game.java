package ua.kma.app.entities;

public class Game {

	// First command
	private int id11;
	private int id12;

	// Second command
	private int id21;
	private int id22;

	private int deaths11;
	private int deaths12;
	private int deaths21;
	private int deaths22;

	public Game(int id11, int id12, int id21, int id22) {
		this.id11 = id11;
		this.id12 = id12;

		this.id21 = id21;
		this.id22 = id22;
	}

	public void killed(int id) {
		if (id == id11)
			deaths11++;
		if (id == id12)
			deaths12++;
		if (id == id21)
			deaths21++;
		if (id == id22)
			deaths22++;
	}

	public int getDeaths11() {
		return deaths11;
	}

	public int getDeaths12() {
		return deaths12;
	}

	public int getDeaths21() {
		return deaths21;
	}

	public int getDeaths22() {
		return deaths22;
	}
	
	
}
