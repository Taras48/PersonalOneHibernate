package all.dao.factorys;

import all.dao.UserDao;

public interface DaoFactory {
    UserDao createUserDao();
}
