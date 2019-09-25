package all.dao;

import all.dbHelper.DBHelper;

public class DaoJDBCFactory implements DaoFactory {
    @Override
    public UserDao createUserDao() {
        return new UserDaoJDBCimpl(DBHelper.getInstance().getConnection());
    }
}
