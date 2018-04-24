package ua.kma.app.dao;

import java.util.List;

import ua.kma.app.entities.User;

public interface UsersDAO {
	User getUserByID(int id);

	User getUserByUsername(String name);

	String getUsernameById(int id);

	int getIdByName(String name);

	boolean containsUserWithId(int id);

	boolean containsUserWithName(String name);

	List<User> getAllUsers();
}
