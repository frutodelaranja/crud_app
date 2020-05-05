package util;

import dao.UserDao;
import dao.UserHibernateDao;
import dao.UserJdbcDao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class UserDaoFactory {
    DaoType type;

    public UserDaoFactory() {
        this.type = getProperty();
    }

    public UserDao getDao(){
        UserDao dao = null;
        switch (type){
            case JDBC:
                dao = new UserJdbcDao();
                break;
            case HIBERNATE:
                dao = new UserHibernateDao();
                break;
        }
        return dao;

    }

    private DaoType getProperty(){
        String result = "";

        try {
            List<String> lines = null;
            lines = Files.readAllLines(Paths.get("daotype.properties"));
            result = lines.get(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (result.contains("jdbc")){
            return DaoType.JDBC;
        }else if (result.contains("hibernate")){
            return DaoType.HIBERNATE;
        }
        return null;
    }
}
