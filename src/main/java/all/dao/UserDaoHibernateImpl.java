package all.dao;

import all.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;


public class UserDaoHibernateImpl implements UserDao {

    private SessionFactory factory;

    public UserDaoHibernateImpl(SessionFactory factory ) {
        this.factory = factory ;
    }

    @Override
    public List<User> getAllUsers() {
        Session session = factory.openSession();
        List<User> list = session.createQuery("FROM User").list();
        session.close();
        return list;
    }

    @Override
    public void addUser(User user) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public boolean isUser(Long id) {
        Session session = factory.openSession();
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
        Session session = factory.openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteUser(Long id) {
        Session session = factory.openSession();
        session.beginTransaction();
        User user = session.get(User.class,id);
        session.delete(user);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public User getUser(Long id) {
        Session session = factory.openSession();
        session.beginTransaction();
        User user = session.get(User.class,id);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    @Override
    public User getUser(String name, Long password) {
        Session session = factory.openSession();
        Query query = session.createQuery("from User where name = :name and password = :password");
        query.setParameter("name", name);
        query.setParameter("password", password);
        User user = (User) query.uniqueResult();
        session.close();
        return user;
    }
}
