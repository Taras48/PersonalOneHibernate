package all.dao;


import all.dbHelper.DBHelper;

import java.io.*;
import java.util.Scanner;

public  class UserDaoFactory {

    private static String getProperties() {
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
        return str;
    }

    public UserDao getUserDao() {
        if (getProperties().contains("sql")) {
            return new UserDaoJDBCimpl(DBHelper.getInstance().getConnection());
        } else {
            return new UserDaoHibernateImpl(DBHelper.getInstance().getSessionFactory());
        }
    }

}
