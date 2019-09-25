package all.dao;

import all.dao.Factorys.DaoFactory;
import all.dao.Factorys.DaoHibernateFactory;
import all.dao.Factorys.DaoJDBCFactory;

import java.io.IOException;
import java.io.InputStream;

public class DaoByProprties {
    public static DaoFactory getConnectionByProperties(){
        //чтение из файла
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

        if (str.contains("jdbc")) {
            return new DaoJDBCFactory();
        } else {
            return new DaoHibernateFactory();
        }

    }
}
