package all.dao;


import all.dbHelper.DBHelper;

import java.io.*;
import java.util.Scanner;

public class UserDaoFactory {
    private String getProperties() {
        String str = "";
        try (BufferedReader bufferedReader = new BufferedReader
               (new FileReader("D:\\TARAZ\\Java\\Personal\\PersonalOne\\src\\main\\java\\all\\resources\\db.properties.txt"))) {
            str = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public UserDao create() {
        if (getProperties().contains("sql")) {
            return new UserDaoJDBCimpl(DBHelper.getInstance().getConnection());
        } else {
            return new UserDaoHibernateImpl(DBHelper.getInstance().getSessionFactory());
        }
    }

}
