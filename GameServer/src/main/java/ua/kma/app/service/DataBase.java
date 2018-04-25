package ua.kma.app.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kma.app.entities.Highscores;
import ua.kma.app.entities.User;
import ua.kma.app.pojo.Game;
import ua.kma.app.repository.HighScoresRepository;
import ua.kma.app.repository.UpdatesRepository;
import ua.kma.app.repository.UsersRepository;

import java.util.List;

public class DataBase {

    private static UsersRepository usersRepository;
    private static HighScoresRepository highScoresRepository;
    private static UpdatesRepository updatesRepository;

    private static UsersServiceImpl usersService;
    private static HighScoresServiceImpl highScoresService;
    private static UpdatesServiceImpl updatesService;

    @Autowired
    public void setUsersRepository(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
        usersService = new UsersServiceImpl(usersRepository);
    }

    @Autowired
    public void setHighScoresRepository(HighScoresRepository highScoresRepository) {
        this.highScoresRepository = highScoresRepository;
        highScoresService = new HighScoresServiceImpl(highScoresRepository);
    }

    @Autowired
    public void setUpdatesRepository(UpdatesRepository updatesRepository){
        this.updatesRepository=updatesRepository;
        updatesService = new UpdatesServiceImpl(updatesRepository);
    }

    private static final Long millisInWeek = 1000L * 60 * 60 * 24 *7;

    private static final Long millisInMonth = 1000L * 60 * 60 * 24 *30;

    private void update (){
        if(System.currentTimeMillis() - updatesService.getLastWeekUpdate().getTime() >= millisInWeek){
            updatesService.setLastWeekUpdateNow();
            highScoresService.updateAfterWeek();
        }
        if(System.currentTimeMillis() - updatesService.getLastMonthUpdate().getTime() >= millisInMonth){
            updatesService.setLastMonthUpdateNow();
            highScoresService.updateAfterMonth();;
        }
    }

    public User getUserById(Long id){
       return usersService.getUserByID(id);
    }

    public User getUserByUsername(String name){
        return usersService.getUserByUsername(name);
    }

    public Highscores getHighscoresById(Long id){
        return highScoresService.getHighscoresByID(id);
    }

    public String getUsernameById(Long id){
        return usersService.getUsernameById(id);
    }

    public void saveResultOfGame(Game g){
        highScoresService.saveResultOfGame(g);
        update();
    }

    public int getRaitingById(Long id){
        return highScoresService.getRaitingById(id);
    }

    public List<User> getAllUsers(){
        return usersService.getAllUsers();
    }

    public User getBestUserAllTime(){
        return usersService.getUserByID(highScoresService.getIdOfBestUserAllTime());
    }

    public User getUserByNameAndPass(String name, String pass){
        return usersRepository.getUserByUsernameEqualsAndPasswordEquals(name,pass);
    }

    public User getUserByEmaiAndPass(String email, String pass){
        return usersRepository.getUserByEmailEqualsAndPasswordEquals(email,pass);
    }

    public boolean containUserWithId(Long id){
        return usersService.containsUserWithId(id);
    }

    public boolean containUserWithNickname(String name){
        return  usersService.containsUserWithName(name);
    }

    public boolean containUserWithEmail(String email){
        return  usersService.containsUserWithEmail(email);
    }

    public void test(){
        System.out.print(updatesService!=null&&highScoresService!=null&&usersService!=null);

    }


}
