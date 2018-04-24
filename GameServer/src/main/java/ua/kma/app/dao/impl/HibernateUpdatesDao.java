package ua.kma.app.dao.impl;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.kma.app.dao.UpdatesDAO;
import ua.kma.app.entities.Updates;

@Repository
public class HibernateUpdatesDao implements UpdatesDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory s) {
		sessionFactory = s;
	}

	private void setUpdatesNow() {
		Updates u = new Updates();
		currentSession().save(u);
	}

	public Date getLastWeekUpdate() {
		Updates u = (Updates) currentSession().get(Updates.class, 1);
		if (u == null) {
			setUpdatesNow();
			return getLastWeekUpdate();
		} else
			return u.getLastWeekUpdate();
	}

	public void setLastWeekUpdateNow() {
		Updates curr = (Updates) currentSession().get(Updates.class, 1);
		if (curr == null)
			setUpdatesNow();
		else {
			curr.setLastWeekUpdate(new Date(System.currentTimeMillis()));
			currentSession().update(curr);
		}
	}

	public Date getLastMonthUpdate() {
		Updates u = (Updates) currentSession().get(Updates.class, 1);
		if (u == null) {
			setUpdatesNow();
			return getLastMonthUpdate();
		} else
			return u.getLastMonthUpdate();
	}

	public void setLastMonthUpdateNow() {
		Updates curr = (Updates) currentSession().get(Updates.class, 1);
		if (curr == null)
			setUpdatesNow();
		else {
			curr.setLastMonthUpdate(new Date(System.currentTimeMillis()));
			currentSession().update(curr);
		}
	}

}
