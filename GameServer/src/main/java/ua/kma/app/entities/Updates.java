package ua.kma.app.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "updates")
public class Updates {

	@Id
	private int ID;

	@Column(name = "week", nullable = false)
	private Date lastWeekUpdate;
	
	
	@Column(name = "month", nullable = false)
	private Date lastMonthUpdate;

	public Date getLastWeekUpdate() {
		return lastWeekUpdate;
	}

	public void setLastWeekUpdate(Date lastWeekUpdate) {
		this.lastWeekUpdate = lastWeekUpdate;
	}

	public Date getLastMonthUpdate() {
		return lastMonthUpdate;
	}

	public void setLastMonthUpdate(Date lastMonthUpdate) {
		this.lastMonthUpdate = lastMonthUpdate;
	}

	public Updates() {
		ID = 1;
		this.lastWeekUpdate = new Date(System.currentTimeMillis());
		this.lastMonthUpdate = new Date(System.currentTimeMillis());
	}

}
