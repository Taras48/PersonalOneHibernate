package all.dao;

import all.dbHelper.DBHelper;

public class DaoHibernateFactory implements DaoFactory {
    @Override
    public UserDao createUserDao() {
        return new UserDaoHibernateImpl(DBHelper.getInstance().getSessionFactory());
    }
}
