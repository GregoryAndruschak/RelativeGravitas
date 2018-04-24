package ua.kma.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.kma.app.entities.Updates;

@Repository
public interface UpdatesRepository extends JpaRepository<Updates, Long> {
}
