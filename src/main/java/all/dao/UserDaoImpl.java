package all.dao;

import all.dbHelper.DBHelper;
import all.model.User;
import org.hibernate.Session;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDaoImpl implements UserDao {

    private Session session;

    public UserDaoImpl(Session session) {
        this.session = session;
    }

    @Override
    public List<User> getAllUsers() {
        session = DBHelper.getSessionFactory().openSession();
        List<User> list = session.createQuery("FROM User").list();
        session.close();
        return list;
    }

    @Override
    public void addUser(User user) {
        session = DBHelper.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public boolean isUser(Long id) {
        session = DBHelper.getSessionFactory().openSession();
        session.beginTransaction();
        User user = session.get(User.class,id);
        session.getTransaction().commit();
        session.close();
        if (user != null){
            return true;
        }
        return false;
    }

    @Override
    public void updateUser(User user) {
        session = DBHelper.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteUser(Long id) {
        session = DBHelper.getSessionFactory().openSession();
        session.beginTransaction();
        User user = session.get(User.class,id);
        session.delete(user);
        session.getTransaction().commit();
        session.close();

    }
}
