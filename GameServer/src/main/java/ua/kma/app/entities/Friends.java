package ua.kma.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "friends")
public class Friends {
	
	public Friends() {};
	
	public Friends(int id1, int id2) {
		this.id1 = id1;
		this.id2 = id2;
	}
	@Id
	@Column(name = "id",nullable=false)
	@GeneratedValue
	private int id;

	@Column(name = "id1",nullable=false)
	private int id1;
	
	@Column(name = "id2",nullable=false)
	private int id2;

	public int getId1() {
		return id1;
	}

	public int getId2() {
		return id2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id1;
		result = prime * result + id2;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Friends other = (Friends) obj;
		if (id1 != other.id1)
			return false;
		if (id2 != other.id2)
			return false;
		return true;
	}
	
	
}
