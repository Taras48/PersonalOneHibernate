package all.dao;


import all.dbHelper.DBHelper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserDaoFactory {
    private String getProperties() {
        String str = "";
       /* try (Scanner scanner = new Scanner(new File("db.properties.txt"))) {
            while (scanner.hasNext()) {
                str += scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/
        return str;
    }

    public UserDao create() {
        if (getProperties().contains("sql")) {
            return new UserDaoJDBCimpl(DBHelper.getInstance().getConnection());
        } else  {
            return new UserDaoHibernateImpl(DBHelper.getInstance().getSessionFactory());
        }
    }

}
