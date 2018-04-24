package ua.kma.app.entities;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue
	private int ID;

	@Column(name = "username", unique = true, length = 20,nullable=false)
	private String username;

	@Column(name = "password",nullable=false)
	private Blob password;

	@Column(name = "email", length = 100,nullable=false)
	private String email;

	public String getUsername() {
		return username;
	}

	public void setUsername(String nick) {
		this.username = nick;
	}

	public Blob getPassword() {
		return password;
	}

	public void setPassword(Blob pass) {
		this.password = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getID() {
		// TODO Auto-generated method stub
		return ID;
	}

}
