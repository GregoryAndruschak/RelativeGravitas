package ua.kma.app.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.kma.app.dao.FriendsDAO;
import ua.kma.app.entities.Friends;
import ua.kma.app.entities.User;

@Repository
public class HibernateFriendsDao implements FriendsDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory s) {
		sessionFactory = s;
	}

	public void addFriends(int id1, int id2) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Friends where id1 = :id1 " + " and id2 = :id2");
		query.setParameter("id1", id1);
		query.setParameter("id2", id2);
		List l = query.list();
		if (l.isEmpty()) {
			Friends f1 = new Friends(id1, id2);
			currentSession().save(f1);
			Friends f2 = new Friends(id2, id1);
			currentSession().save(f2);
		}
		session.close();
	}

	public int[] getFriendsOfId(int id) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Friends where id1 = :id1 ");
		query.setParameter("id1", id);
		List<Friends> d = query.list();
		session.close();
		int[] res = new int[d.size()];
		for (int i = 0; i < res.length; i++)
			res[i] = d.get(i).getId2();
		return res;
	}

	public void deleteFriends(int id1, int id2) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("delete Friends where id1 = :id1" + " and id2 = :id2");
		query.setParameter("id1", id1);
		query.setParameter("id2", id2);
		int result = query.executeUpdate();

		query = session.createQuery("delete Friends where id1 = :id2" + " and id2 = :id1");
		query.setParameter("id1", id1);
		query.setParameter("id2", id2);
		result = query.executeUpdate();
		session.close();

	}

}
