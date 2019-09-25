package all.dao.Factorys;

import all.dao.UserDao;
import all.dao.UserDaoJDBCimpl;
import all.dbHelper.DBHelper;

public class DaoJDBCFactory implements DaoFactory {
    @Override
    public UserDao createUserDao() {
        return new UserDaoJDBCimpl(DBHelper.getInstance().getConnection());
    }
}
