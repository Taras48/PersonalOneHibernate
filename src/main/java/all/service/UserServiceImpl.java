package all.service;

import all.dao.*;
import all.dbHelper.DBHelper;
import all.model.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserServiceImpl implements UserService {

    private static UserServiceImpl userService;
    private UserDao connect;
    DaoFactory daoFactory = getConnectionByPropiterces();

    private static DaoFactory getConnectionByPropiterces(){
        //чтение из файла
        String str = "";
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream fileReader = classLoader.getResourceAsStream("db.properties");
        int i = -1;
        try {
            while ((i = fileReader.read()) != -1) {
                str += (char) i;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (str.contains("jdbc")) {
            return new DaoJDBCFactory();
        } else {
            return new DaoHibernateFactory();
        }

    }

    private UserServiceImpl() {
        connect =  daoFactory.createUserDao();
    }

    public static UserServiceImpl getInstance() {
        if (userService == null) {
            userService = new UserServiceImpl();
        }
        return userService;
    }
    @Override
    public void addUser(User user) {
        connect.addUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return connect.getAllUsers();
    }

    @Override
    public void updateUser(User user) {
        connect.updateUser(user);
    }

    @Override
    public boolean isUser(Long id) {
        return connect.isUser(id);
    }

    @Override
    public void deleteUser(Long id) {
        connect.deleteUser(id);
    }
}


