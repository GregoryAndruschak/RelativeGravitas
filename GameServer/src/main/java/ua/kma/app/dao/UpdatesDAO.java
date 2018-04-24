package ua.kma.app.dao;

import java.sql.Date;

public interface UpdatesDAO {

	Date getLastWeekUpdate();
	
	void setLastWeekUpdateNow();
	
	Date getLastMonthUpdate();
	
	void setLastMonthUpdateNow();
}
