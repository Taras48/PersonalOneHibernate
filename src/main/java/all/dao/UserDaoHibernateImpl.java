package all.dao;

import all.dbHelper.DBHelperHiber;
import all.model.User;
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
}
