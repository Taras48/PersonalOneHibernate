package all.service;

import all.dao.UserDaoHiber;
import all.dao.UserDaoJdbc;
import all.dbHelper.DBHelperHiber;
import all.dbHelper.DBHelperJdbc;
import all.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private static UserServiceImpl userService;

    private UserServiceImpl() {
    }

    public static UserServiceImpl getInstance() {
        if (userService == null) {
            userService = new UserServiceImpl();
        }
        return userService;
    }

    private UserDaoJdbc getUserDaoJdbc() {
        return new UserDaoJdbc(DBHelperJdbc.getConnection());
    }

    private UserDaoHiber getUserDaoHiber() {
        return new UserDaoHiber(DBHelperHiber.getSessionFactory().openSession());
    }

    @Override
    public void addUser(User user) {
        getUserDaoHiber().addUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return getUserDaoHiber().getAllUsers();
    }

    @Override
    public void updateUser(User user) {
        getUserDaoHiber().updateUser(user);
    }

    @Override
    public boolean isUser(Long id) {
        return getUserDaoHiber().isUser(id);
    }

    @Override
    public void deleteUser(Long id) {
        getUserDaoHiber().deleteUser(id);
    }
}


