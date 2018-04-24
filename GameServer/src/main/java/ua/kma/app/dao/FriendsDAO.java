package ua.kma.app.dao;


public interface FriendsDAO {
	
	void addFriends (int id1, int id2);
	
	int[] getFriendsOfId(int id);
	
	void deleteFriends(int id1, int id2);
}
