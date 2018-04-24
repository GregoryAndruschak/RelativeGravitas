package ua.kma.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.kma.app.entities.Highscores;

import java.util.List;

@Repository
public interface HighScoresRepository extends JpaRepository<Highscores, Long> {
//    List<Highscores> getAllOrderByRaiting();
//    List<Highscores> getAllOrderByRaitingMonth();
//    List<Highscores> getAllOrderByRaitingWeek();
}
