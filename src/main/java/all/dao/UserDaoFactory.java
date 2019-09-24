package all.dao;


import all.dbHelper.DBHelper;

import java.io.*;
import java.util.Scanner;

public  class UserDaoFactory {
    private static String getProperties() {
        String str = "";
        try (BufferedReader bufferedReader = new BufferedReader
                (new FileReader("db.properties"))) {
            str = bufferedReader.readLine();

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
