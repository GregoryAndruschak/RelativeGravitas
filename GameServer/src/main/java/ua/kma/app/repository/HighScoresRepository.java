package ua.kma.app.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.kma.app.entities.Highscores;

import java.util.List;

@Repository
public interface HighScoresRepository extends JpaRepository<Highscores, Long> {

    @Query("select h from Highscores h order by raiting desc")
    List<Highscores> getAllOrderByRaiting();
    @Query("select h from Highscores h order by raitingmonth desc")
    List<Highscores> getAllOrderByRaitingMonth();
    @Query("select h from Highscores h order by raitingweek desc")
    List<Highscores> getAllOrderByRaitingWeek();
}
