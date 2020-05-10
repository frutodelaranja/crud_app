package dao;

import model.User;

import java.util.List;

public interface UserDao {

    boolean addUser( User user);
    boolean thisUserExists(User user);
    List<User> getAllUsers();
    boolean updateUser(User user);
    boolean deleteUser(Long id);
    User getUser(Long id);
    User getUser(String login, String password);
}
