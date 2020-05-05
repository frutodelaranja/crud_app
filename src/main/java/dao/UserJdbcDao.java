package dao;

import model.User;
import util.DBHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserJdbcDao implements UserDao{
    Connection connection;

    {
        try {
            connection = new DBHelper().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean addUser( User user){

        try {
            connection.setAutoCommit(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try(PreparedStatement statement = connection.prepareStatement("INSERT INTO users(name, login, password) VALUES (?,?,?)");){
            statement.setString(1, user.getName());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getPassword());
            boolean yes = statement.executeUpdate() > 0;
            connection.commit();
            return yes;
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return false;
        }
    }

    public boolean thisUserExists(User user) {
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE login=?");) {
            statement.setString(1, user.getLogin());
            statement.executeQuery();
            ResultSet result = statement.getResultSet();
            return result.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Statement statement = connection.createStatement();) {
            statement.executeQuery("select * from users");
            ResultSet result = statement.getResultSet();
            while (result.next()) {
                users.add(new User(result.getLong(1), result.getString(2), result.getString(3), result.getString(4)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public boolean updateUser(User user) {

        try {
            connection.setAutoCommit(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try (PreparedStatement statement = connection.prepareStatement("UPDATE users SET name=?, login=?, password=? WHERE id=?");) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getPassword());
            statement.setLong(4, user.getId());
            boolean yes = statement.executeUpdate() > 0;
            connection.commit();
            return yes;
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return false;
        }
    }

    public boolean deleteUser(Long id) {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try (PreparedStatement statement = connection.prepareStatement("DELETE from users WHERE id=?")) {
            statement.setLong(1, id);
            boolean yes = statement.executeUpdate() > 0;
            connection.commit();
            return yes;
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return false;
        }
    }
    public User getUser(Long id) {
        User isUser = new User();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE id=?");) {
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                isUser.setId(result.getLong(1));
                isUser.setName(result.getString(2));
                isUser.setLogin(result.getString(3));
                isUser.setPassword(result.getString(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUser;
    }
}
