package all.dao.Factorys;

import all.dao.UserDao;

public interface DaoFactory {
    UserDao createUserDao();
}
