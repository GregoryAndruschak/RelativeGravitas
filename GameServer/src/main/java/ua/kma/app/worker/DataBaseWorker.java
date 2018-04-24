//package ua.kma.app.worker;
//
//import java.util.List;
//
//import org.hibernate.annotations.Cache;
//import org.hibernate.annotations.CacheConcurrencyStrategy;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;
//
//import ua.kma.app.dao.FriendsDAO;
//import ua.kma.app.dao.HighscoresDAO;
//import ua.kma.app.dao.UpdatesDAO;
//import ua.kma.app.dao.UsersDAO;
//import ua.kma.app.entities.Highscores;
//import ua.kma.app.entities.User;
//import ua.kma.app.pojo.UsersData;
//
//@Transactional
//@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
//public class DataBaseWorker {
//
//	@Autowired
//	private UsersDAO usersDAO;
//
//	@Autowired
//	private FriendsDAO friendsDAO;
//
//	@Autowired
//	private HighscoresDAO highscoresDAO;
//
//	@Autowired
//	private UpdatesDAO updatesDao;
//
//	private static final long millisInWeek = 1000L * 60 * 60 * 24 * 7;
//
//	private static final long millisInMonth = 1000L * 60 * 60 * 24 * 30;
//
//	public void test() {
//		System.out.println(highscoresDAO.getIdOfBestUserAllTime());;
//	}
//
//	private void checkToWeekUpdate() {
//		if (millisInWeek <= (System.currentTimeMillis() - updatesDao.getLastWeekUpdate().getTime())) {
//			highscoresDAO.updateAfterWeek();
//			updatesDao.setLastWeekUpdateNow();
//		}
//	}
//
//	private void checkToMonthUpdate() {
//		if (millisInMonth <= (System.currentTimeMillis() - updatesDao.getLastMonthUpdate().getTime())) {
//			highscoresDAO.updateAfterMonth();
//			updatesDao.setLastMonthUpdateNow();
//		}
//	}
//
//	private void update() {
//		checkToMonthUpdate();
//		checkToWeekUpdate();
//	}
//
//	public boolean containsUserWithId(int id) {
//		return usersDAO.containsUserWithId(id);
//	}
//
//	public boolean containsUserWithName(String name) {
//		return usersDAO.containsUserWithName(name);
//	}
//
//	public String getNameById(int id) {
//		User u = usersDAO.getUserByID(id);
//		if (u == null)
//			return null;
//		return u.getUsername();
//	}
//
//	public Highscores getHighscoresById(int id) {
//		update();
//		return highscoresDAO.getHighscoresByID(id);
//	}
//
//	public UsersData getAllUserDataByID(int id) {
//		update();
//		return new UsersData(getNameById(id), getHighscoresById(id));
//
//	}
//
//	public int getIdByName(String name) {
//		if (containsUserWithName(name))
//			return usersDAO.getUserByUsername(name).getID();
//		return -1;
//	}
//
//	public UsersData[] getAllUsersData() {
//		List<Highscores> l = highscoresDAO.getAllUsers();
//		UsersData[] res = new UsersData[l.size()];
//		for (int i = 0; i < res.length; i++) {
//			Highscores h = l.get(i);
//			res[i] = new UsersData(usersDAO.getUsernameById(h.getID()), h);
//		}
//		return res;
//
//	}
//
//	public String[] getArrayOfNames() {
//		List<User> u = usersDAO.getAllUsers();
//		String[] res = new String[u.size()];
//		for (int i = 0; i < res.length; i++)
//			res[i] = u.get(i).getUsername();
//		return res;
//	}
//
//	public UsersData[] getFriendsOfID(int id) {
//		int[] fr = friendsDAO.getFriendsOfId(id);
//		UsersData[] res = new UsersData[fr.length];
//		for (int i = 0; i < res.length; i++)
//			res[i] = getAllUserDataByID(i);
//		return res;
//	}
//
//	public void addFriends(int id1, int id2) {
//		if (containsUserWithId(id1) && containsUserWithId(id2))
//			friendsDAO.addFriends(id1, id2);
//	}
//
//	public void addFriends(String name1, String name2) {
//		int id1 = usersDAO.getIdByName(name1);
//		int id2 = usersDAO.getIdByName(name2);
//		if (id1 != -1 && id2 != -1)
//			friendsDAO.addFriends(id1, id2);
//	}
//
//	public void updateUser(UsersData ud) {
//		if (ud != null)
//			highscoresDAO.updateHighscores(ud.high());
//	}
//}
