package ua.kma.app.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.kma.app.dao.UsersDAO;
import ua.kma.app.entities.User;

@Repository
public class HibernateUsersDao implements UsersDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory s) {
		sessionFactory = s;
	}

	public User getUserByID(int id) {
		// TODO Auto-generated method stub
		return (User) currentSession().get(User.class, id);
	}

	public User getUserByUsername(String name) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(" from User where username = :name ");
		query.setParameter("name", name);
		@SuppressWarnings("unchecked")
		List<User> list = query.list();
		session.close();
		if (list.isEmpty())
			return null;
		else
			return (User) list.get(0);
	}

	public String getUsernameById(int id) {
		if (containsUserWithId(id))
			return ((User) currentSession().get(User.class, id)).getUsername();
		else
			return null;

	}

	public boolean containsUserWithId(int id) {
		return (getUserByID(id) == null) ? false : true;
	}

	public boolean containsUserWithName(String name) {
		// TODO Auto-generated method stub
		return (getUserByUsername(name) == null) ? false : true;
	}

	public List<User> getAllUsers() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(" from User  ");
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) query.list();
		session.close();
		return list;
	}

	public int getIdByName(String name) {
		User u = getUserByUsername(name);
		if (u == null)
			return -1;
		else
			return u.getID();
	}

}
