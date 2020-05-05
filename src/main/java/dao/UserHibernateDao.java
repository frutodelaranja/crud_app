package dao;

import model.User;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import util.DBHelper;

import java.util.List;

public class UserHibernateDao implements UserDao {

    private SessionFactory sessionFactory;
    private Session session;

    public UserHibernateDao() {
        this.sessionFactory = DBHelper.getSessionFactory();
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
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("login", user.getLogin()));
            User userOld = (User) criteria.uniqueResult();
            return userOld != null ? true : false;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public List<User> getAllUsers() {
        session = sessionFactory.openSession();
        try {
            List<User> users = session.createCriteria(User.class).list();
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
            User user = (User) session.load(User.class,id);
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
            User user = (User) session.load(User.class, id);
            return user;
        } catch (HibernateException e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }
}
