package util;

import dao.UserDao;
import dao.UserHibernateDao;
import dao.UserJdbcDao;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class UserDaoFactory {
    DaoType type;

    public UserDaoFactory() {
        this.type = getProperty();
    }

    public UserDao getDao() {
        UserDao dao = null;
        switch (type) {
            case JDBC:
                dao = new UserJdbcDao();
                break;
            case HIBERNATE:
                dao = new UserHibernateDao();
                break;
        }
        return dao;

    }

    private DaoType getProperty() {
        DaoType daoType = null;
        Properties properties = new Properties();
        try {
            InputStream is = this.getClass().getClassLoader().getResourceAsStream("daotype.properties");
            properties.load(is);
            daoType = DaoType.valueOf(properties.getProperty("daotype"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return daoType;
    }
}
