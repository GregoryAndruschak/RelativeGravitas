package ua.kma.app.worker;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ua.kma.app.entities.Highscores;
import ua.kma.app.entities.User;
import ua.kma.app.service.HighScoresServiceImpl;
import ua.kma.app.service.UpdatesServiceImpl;
import ua.kma.app.service.UsersServiceImpl;

@Component
public class DataBaseWorker {

	private final UsersServiceImpl usersService;
	private final HighScoresServiceImpl highScoresService;
	private final UpdatesServiceImpl updatesService;

    public DataBaseWorker(UsersServiceImpl usersService, HighScoresServiceImpl highScoresService, UpdatesServiceImpl updatesService) {
        this.usersService = usersService;
        this.highScoresService = highScoresService;
        this.updatesService = updatesService;
    }

    private static final long millisInWeek = 1000L * 60 * 60 * 24 * 7;

	private static final long millisInMonth = 1000L * 60 * 60 * 24 * 30;

	public void test() {
		System.out.println(highScoresService.getIdOfBestUserAllTime());;
	}

	private void checkToWeekUpdate() {
		if (millisInWeek <= (System.currentTimeMillis() - updatesService.getLastWeekUpdate().getTime())) {
			highScoresService.updateAfterWeek();
			updatesService.setLastWeekUpdateNow();
		}
	}

	private void checkToMonthUpdate() {
		if (millisInMonth <= (System.currentTimeMillis() - updatesService.getLastMonthUpdate().getTime())) {
			highScoresService.updateAfterMonth();
			updatesService.setLastMonthUpdateNow();
		}
	}

	private void update() {
		checkToMonthUpdate();
		checkToWeekUpdate();
	}

	public boolean containsUserWithId(Long id) {
		return usersService.containsUserWithId(id);
	}

	public boolean containsUserWithName(String name) {
		return usersService.containsUserWithName(name);
	}

	public String getNameById(Long id) {
		User u = usersService.getUserByID(id);
		if (u == null)
			return null;
		return u.getUsername();
	}

	public Highscores getHighscoresById(Long id) {
		update();
		return highScoresService.getHighscoresByID(id);
	}

	public User getAllUserDataByID(Long id) {
		update();
		return usersService.getUserByID(id);

	}

	public Long getIdByName(String name) {
		if (containsUserWithName(name))
			return usersService.getUserByUsername(name).getId();
		return -1L;
	}

	public List<User> getAllUsersData() {
		return usersService.getAllUsers();
	}

	public String[] getArrayOfNames() {
		List<User> u = usersService.getAllUsers();
		String[] res = new String[u.size()];
		for (int i = 0; i < res.length; i++)
			res[i] = u.get(i).getUsername();
		return res;
	}

	public List<User> getFriendsOfID(Long id) {
	    User user = usersService.getUserByID(id);
	    return user.getFriends();
	}

	public void addFriends(Long id1, Long id2) {
	    User user1 = usersService.getUserByID(id1);
	    User user2 = usersService.getUserByID(id2);
	    user1.getFriends().add(user2);
	    user1.getFriendOf().add(user2);
	}

	public void addFriends(String name1, String name2) {
        User user1 = usersService.getUserByUsername(name1);
        User user2 = usersService.getUserByUsername(name2);
        user1.getFriends().add(user2);
        user1.getFriendOf().add(user2);
	}

	public void updateUser(User user) {
	    usersService.saveUser(user);
	}
}
