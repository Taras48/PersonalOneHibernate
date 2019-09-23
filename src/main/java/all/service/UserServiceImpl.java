package all.service;

import all.dao.UserDaoHider;
import all.dbHelper.DBHelperHiber;
import all.model.User;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserServiceImpl implements UserService {

    private SessionFactory sessionFactory;

    private static UserServiceImpl userService;

    private UserServiceImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public static UserServiceImpl getInstance() {
        if (userService == null) {
            userService = new UserServiceImpl(DBHelperHiber.getSessionFactory());
        }
        return userService;
    }

    @Override
    public void addUser(User user) {
        new UserDaoHider(sessionFactory.openSession()).addUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return new UserDaoHider(sessionFactory.openSession()).getAllUsers();
    }

    @Override
    public void updateUser(User user) {
        new UserDaoHider(sessionFactory.openSession()).updateUser(user);
    }

    @Override
    public boolean isUser(Long id) {
        return  new UserDaoHider(sessionFactory.openSession()).isUser(id);
    }

    @Override
    public void deleteUser(Long id) {
          new UserDaoHider(sessionFactory.openSession()).deleteUser(id);
    }
}


