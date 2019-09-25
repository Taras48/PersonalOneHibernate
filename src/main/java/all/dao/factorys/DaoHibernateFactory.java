package all.dao.factorys;

import all.dao.UserDao;
import all.dao.UserDaoHibernateImpl;
import all.dbHelper.DBHelper;

public class DaoHibernateFactory implements DaoFactory {
    @Override
    public UserDao createUserDao() {
        return new UserDaoHibernateImpl(DBHelper.getInstance().getSessionFactory());
    }
}
