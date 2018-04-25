package ua.kma.app.service;

import org.hibernate.criterion.Order;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ua.kma.app.entities.Highscores;
import ua.kma.app.entities.User;
import ua.kma.app.repository.HighScoresRepository;
import ua.kma.app.pojo.Game;

import java.util.List;
import java.util.Optional;

@Service
public class HighScoresServiceImpl {
    private final HighScoresRepository highScoresRepository;

    public HighScoresServiceImpl(HighScoresRepository highScoresRepository) {
        this.highScoresRepository = highScoresRepository;
    }

    public Highscores getHighscoresByID(Long id) {
        return highScoresRepository.getOne(id);
    }

    public Long getIdOfBestUserAllTime() {
        List<Highscores> highScores= highScoresRepository.getAllOrderByRaiting();
        if(highScores.isEmpty()) return -1L;
        else return (highScores.get(0)).getId();
    }

    public Long getIdOfBestUserLastMonth() {
        List list = highScoresRepository.getAllOrderByRaitingMonth();
        if(list.isEmpty()) return -1L;
        else return ((User)list.get(0)).getId();
    }

    public Long getIdOfBestUserLastWeek() {
        List list = highScoresRepository.getAllOrderByRaitingWeek();
        if(list.isEmpty()) return -1L;
        else return ((User)list.get(0)).getId();
    }

    public List<Highscores> getAllHighScores() {
        return highScoresRepository.findAll();
    }

    public int getRaitingById(Long id){
        return getHighscoresByID(id).getRaiting();
    }

    public List<Highscores> getAllUsers() {
        return highScoresRepository.findAll();
    }

    public void updateHighscores(Highscores h) {
        highScoresRepository.saveAndFlush(h);
    }

    public void updateAfterWeek() {
        List<Highscores> highscores = highScoresRepository.findAll();
        highscores.forEach(highscore -> {
            highscore.setRaitingWeek(0);
            highscore.setGamesLastWeek(0);
            highscore.setWinsLastWeek(0);
            highscore.setDeathLastWeek(0);
        });
        highScoresRepository.saveAll(highscores);
    }

    public void updateAfterMonth() {
        List<Highscores> highscores = highScoresRepository.findAll();
        highscores.forEach(highscore -> {
            highscore.setRaitingMonth(0);
            highscore.setGamesLastMonth(0);
            highscore.setWinsLastMonth(0);
            highscore.setDeathLastMonth(0);
        });
        highScoresRepository.saveAll(highscores);
    }

    public void saveResultOfGame(Game g){
        addGameToId(g.getId11());
        addGameToId(g.getId12());
        addGameToId(g.getId21());
        addGameToId(g.getId22());

        addDeathsToId(g.getId11(),g.getDeaths11());
        addDeathsToId(g.getId12(),g.getDeaths12());
        addDeathsToId(g.getId21(),g.getDeaths21());
        addDeathsToId(g.getId22(),g.getDeaths22());

        int com1 = g.getDeaths11()+g.getDeaths12();
        int com2 = g.getDeaths21()+g.getDeaths22();
        int rait1 = getRaitingById(g.getId11()) + getRaitingById(g.getId12());
        int rait2 = getRaitingById(g.getId21()) + getRaitingById(g.getId22());
        //first command wins
        if(com2>com1){
            addWinsToId(g.getId11());
            addWinsToId(g.getId12());
            double per;
            if (rait1 > rait2)
                per = (double) rait2 / rait1;
            else
                per = (double) rait1/rait2;

            int k = (int)Math.floor(per* (com1+com2));

            addRaitingToId(g.getId11(),k);
            addRaitingToId(g.getId12(),k);
            addRaitingToId(g.getId21(),-k);
            addRaitingToId(g.getId22(),-k);
        }
        //second command wins
        if(com1 > com2){
            addWinsToId(g.getId21());
            addWinsToId(g.getId22());
            double per;
            if (rait2 > rait1)
                per = (double) rait1 / rait2;
            else
                per = (double) rait2 / rait1;

            int k = (int)Math.floor(per* (com1+com2));

            addRaitingToId(g.getId11(),-k);
            addRaitingToId(g.getId12(),-k);
            addRaitingToId(g.getId21(),k);
            addRaitingToId(g.getId22(),k);
        }
    }

    private void addDeathsToId(Long id, int d){
        Highscores h = getHighscoresByID(id);
        h.setDeathAllTime(h.getDeathAllTime()+d);
        h.setDeathLastWeek(h.getDeathLastWeek()+d);
        h.setDeathLastMonth(h.getDeathLastMonth()+d);
        updateHighscores(h);
    }

    private void addGameToId(Long id){
        Highscores h = getHighscoresByID(id);
        h.setGamesAllTime(h.getGamesAllTime()+1);
        h.setGamesLastWeek(h.getGamesLastWeek()+1);
        h.setGamesLastMonth(h.getGamesLastMonth()+1);
        updateHighscores(h);
    }

    private void addWinsToId(Long id){
        Highscores h = getHighscoresByID(id);
        h.setWinsAllTime(h.getWinsAllTime()+1);
        h.setWinsLastWeek(h.getWinsLastWeek()+1);
        h.setWinsLastMonth(h.getWinsLastMonth()+1);
        updateHighscores(h);
    }

    private void addRaitingToId(Long id, int d){
        Highscores h = getHighscoresByID(id);
        h.setRaiting(h.getRaiting()+d);
        h.setRaitingWeek(h.getRaitingWeek()+d);
        h.setRaitingMonth(h.getRaitingMonth()+d);
        updateHighscores(h);
    }
}
