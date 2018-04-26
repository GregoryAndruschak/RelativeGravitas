package ua.kma.app.entities;

import java.sql.Blob;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "username", unique = true, length = 20,nullable=false)
	private String username;

	@Column(name = "password",nullable=false)
	private String password;

	@Column(name = "email", length = 100,nullable=false)
	private String email;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "high_score_id", referencedColumnName = "id")
	private Highscores highscores;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name="tbl_friends",
			joinColumns=@JoinColumn(name="person_id"),
			inverseJoinColumns=@JoinColumn(name="friend_id")
	)
	private List<User> friends;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name="tbl_friends",
			joinColumns=@JoinColumn(name="friend_id"),
			inverseJoinColumns=@JoinColumn(name="person_id")
	)
	private List<User> friendOf;

	public String getUsername() {
		return username;
	}

	public void setUsername(String nick) {
		this.username = nick;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Highscores getHighscores() {
		return highscores;
	}

	public List<User> getFriends() {
		return friends;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}

	public void setHighscores(Highscores highscores) {
		this.highscores = highscores;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<User> getFriendOf() {
		return friendOf;
	}

	public void setFriendOf(List<User> friendOf) {
		this.friendOf = friendOf;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", email='" + email + '\'' +
				", highscores=" + highscores +
				'}';
	}
}
