package all.dao;

import all.dao.factorys.DaoFactory;
import all.dao.factorys.DaoHibernateFactory;
import all.dao.factorys.DaoJDBCFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DaoByProprties {
    public static DaoFactory getConnectionByProperties() {
        String db = "";
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream fileReader = classLoader.getResourceAsStream("db.properties");
            Properties properties = new Properties();
            properties.load(fileReader);
            db = properties.getProperty("db");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (db.contains("jdbc")) {
            return new DaoJDBCFactory();
        } else {
            return new DaoHibernateFactory();
        }
    }
}
