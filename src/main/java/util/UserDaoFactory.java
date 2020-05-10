package util;

import dao.UserDao;
import dao.UserHibernateDao;
import dao.UserJdbcDao;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
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
        File file = new File("/home/evgeny/dev/crud_app/src/main/resources/daotype.properties");
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(file));
            daoType = DaoType.valueOf(properties.getProperty("daotype"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return daoType;
    }
}
