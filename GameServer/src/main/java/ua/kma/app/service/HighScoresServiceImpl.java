package ua.kma.app.service;

import org.hibernate.criterion.Order;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ua.kma.app.entities.Highscores;
import ua.kma.app.entities.User;
import ua.kma.app.repository.HighScoresRepository;

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
}
