package dao;

import model.User;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import util.DBHelper;

import java.util.List;

public class UserHibernateDao implements UserDao {

    private SessionFactory sessionFactory;
    private Session session;

    public UserHibernateDao() {
        this.sessionFactory = getSessionFactory();
    }

    public SessionFactory getSessionFactory() {
        Configuration configuration = DBHelper.getInstance().getConfiguration();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    @Override
    public boolean addUser(User user) {
        session = sessionFactory.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.save(user);
            boolean yes = session.contains(user);
            transaction.commit();
            return yes;
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean thisUserExists(User user) {
        session = sessionFactory.openSession();
        try {
            List<User> users = session.createQuery("FROM User WHERE login = :login").setParameter("login", user.getLogin()).list();
            return !users.isEmpty();
        } catch (HibernateException e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return false;
    }

    @Override
    public List<User> getAllUsers() {
        session = sessionFactory.openSession();
        try {
            List users = session.createQuery("FROM User").list();
            return users;
        } catch (HibernateException e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean updateUser(User user) {
        session = sessionFactory.openSession();
        try{
            Transaction transaction = session.beginTransaction();
            session.update(user);
            boolean yes = session.contains(user);
            transaction.commit();
            return yes;
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean deleteUser(Long id) {
        session = sessionFactory.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            User user = (User) session.get(User.class,id);
            session.delete(user);
            boolean yes = session.contains(user);
            transaction.commit();
            return !yes;
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();

        }finally {
            session.close();
        }
        return false;
    }

    @Override
    public User getUser(Long id) {
        session = sessionFactory.openSession();
        try {
            User user = (User) session.get(User.class, id);
            return user;
        } catch (HibernateException e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public User getUser(String login, String password) {
        session = sessionFactory.openSession();
        try {
            List<User> users = session.createQuery("FROM User WHERE login = :login and password = :password").setParameter("login", login).setParameter("password", password).list();
            if (!users.isEmpty()){
                return users.get(0);
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
}
