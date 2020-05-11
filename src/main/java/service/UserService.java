package service;

import dao.UserDao;
import model.User;
import util.UserDaoFactory;

import java.util.List;

public class UserService {
    private static UserService userService;
    private UserDao dao;
    private UserService(){
        dao = new UserDaoFactory().getDao();
    }

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    public boolean addUser(User user) {
        if (!thisUserExists(user)){
            dao.addUser(user);
            return true;
        }
        return false;
    }

    public boolean thisUserExists(User user) {
        if (dao.thisUserExists(user)){
            return true;
        }else
            return false;
    }

    public User getUser(Long id){
        return dao.getUser(id);
    }

    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

    public boolean updateUser(User user) {
        return dao.updateUser(user);
    }

    public boolean deleteUser(Long id) {
        return dao.deleteUser(id);
    }

    public User getUser(String login, String password){
        return dao.getUser(login, password);
    }
}
