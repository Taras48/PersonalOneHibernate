package factorys;

import all.dao.UserDao;

public interface DaoFactory {
    UserDao createUserDao();
}
