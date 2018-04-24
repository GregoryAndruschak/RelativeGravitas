package ua.kma.app.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.kma.app.dao.HighscoresDAO;
import ua.kma.app.entities.Highscores;
import ua.kma.app.entities.User;

@Repository

public class HibernateHighscoresDao implements HighscoresDAO {
	

	@Autowired
	private SessionFactory sessionFactory;

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory s) {
		sessionFactory = s;
	}
	
	
	public Highscores getHighscoresByID(int id) {
		// TODO Auto-generated method stub
		return (Highscores) currentSession().get(Highscores.class, id);
	}

	public int getIdOfBestUserAllTime() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Highscores order by raiting desc limit 1 ");
		List list = query.list();
		session.close();
		if(list.isEmpty()) return -1;
		else return ((Highscores)list.get(0)).getID();
	}

	public int getIdOfBestUserLastMonth() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Highscores order by raitingmonth desc limit 1 ");
		List list = query.list();
		session.close();
		if(list.isEmpty()) return -1;
		else return ((User)list.get(0)).getID();
	}

	public int getIdOfBestUserLastWeek() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(" from Highscores order by raitingweek desc limit 1 ");
		List list = query.list();
		session.close();
		if(list.isEmpty()) return -1;
		else return ((User)list.get(0)).getID();
	}

	public List<Highscores> getAllUsers() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		List l = session.createQuery("from Highscores order by raiting").list();
		session.close();
		return l;
	}

	public void updateHighscores(Highscores h) {
		currentSession().saveOrUpdate(h);

	}

	public void updateAfterWeek() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("update Highscores set raitingweek = 0, gameslastweek = 0, winslastweek = 0, deathlastweek = 0");
		int result = query.executeUpdate();
		session.close();	

	}

	public void updateAfterMonth() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("update Highscores set raitingmonth = 0, gameslastmonth = 0, winslastmonth = 0, deathlastmonth = 0");
		int result = query.executeUpdate();
		session.close();

	}
}
