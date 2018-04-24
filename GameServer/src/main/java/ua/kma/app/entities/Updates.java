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
	private Long id;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Updates() {
		id = 1L;
		this.lastWeekUpdate = new Date(System.currentTimeMillis());
		this.lastMonthUpdate = new Date(System.currentTimeMillis());
	}

}
