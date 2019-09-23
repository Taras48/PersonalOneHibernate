package all.dao;

import all.dbHelper.DBHelperHiber;
import all.model.User;
import org.hibernate.Session;

import java.util.List;


public class UserDaoHider implements UserDao {

    private Session session;

    public UserDaoHider(Session session) {
        this.session = session;
    }

    @Override
    public List<User> getAllUsers() {
        session = DBHelperHiber.getSessionFactory().openSession();
        List<User> list = session.createQuery("FROM User").list();
        session.close();
        return list;
    }

    @Override
    public void addUser(User user) {
        session = DBHelperHiber.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public boolean isUser(Long id) {
        session = DBHelperHiber.getSessionFactory().openSession();
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
        session = DBHelperHiber.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteUser(Long id) {
        session = DBHelperHiber.getSessionFactory().openSession();
        session.beginTransaction();
        User user = session.get(User.class,id);
        session.delete(user);
        session.getTransaction().commit();
        session.close();

    }
}
