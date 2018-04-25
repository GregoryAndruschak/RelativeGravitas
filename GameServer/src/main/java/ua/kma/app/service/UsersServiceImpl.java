package ua.kma.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kma.app.AppApplication;
import ua.kma.app.entities.User;
import ua.kma.app.repository.UsersRepository;

import java.util.List;

@Service
public class UsersServiceImpl {
    private final UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public User getUserByID(Long id) {
        return usersRepository.getOne(id);
    }

    public User getUserByUsername(String userName) {
        return usersRepository.getUserByUsernameEquals(userName);
    }

    public String getUsernameById(Long id) {
        return usersRepository.getOne(id).getUsername();
    }

    public boolean containsUserWithId(Long id) {
        return getUserByID(id) != null;
    }

    public boolean containsUserWithName(String name) {
        return getUserByUsername(name) != null;
    }

    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }

    public Long getIdByName(String userName) {
        return usersRepository.getUserByUsernameEquals(userName).getId();
    }

    public void saveUser(User user) {
        usersRepository.save(user);
    }

}
