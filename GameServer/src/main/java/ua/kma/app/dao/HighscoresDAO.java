package ua.kma.app.dao;

import java.util.List;

import ua.kma.app.entities.Highscores;

public interface HighscoresDAO {

	Highscores getHighscoresByID (int id);
		
	int getIdOfBestUserAllTime ();
	
	int getIdOfBestUserLastMonth ();
	
	int getIdOfBestUserLastWeek ();
	
	List<Highscores> getAllUsers();
	
	void updateHighscores(Highscores h);
	
	public void updateAfterWeek();
	
	public void updateAfterMonth();
	
}
