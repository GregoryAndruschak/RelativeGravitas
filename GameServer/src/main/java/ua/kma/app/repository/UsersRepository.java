package ua.kma.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.kma.app.entities.User;

@Repository
public interface UsersRepository extends JpaRepository<User,Long> {
    User getUserByUsernameEquals(String userName);
    User getUserByUsernameEqualsAndPasswordEquals(String username, String password);
    User getUserByEmailEqualsAndPasswordEquals(String email, String password);
    User getUserByEmailEquals(String email);
}
