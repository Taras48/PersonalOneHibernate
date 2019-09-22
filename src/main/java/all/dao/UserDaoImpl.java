package all.dao;

import all.dbHelper.DBHelper;
import all.model.User;
import org.hibernate.Session;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDaoImpl implements UserDao {

    private Session session;

    public UserDaoImpl(Session session) {
        this.session = session;
    }

    @Override
    public List<User> getAllUsers() {
        session = DBHelper.getSessionFactory().openSession();
        List<User> list = session.createQuery("FROM User").list();
        session.close();
        return list;
    }

    @Override
    public void addUser(User user) {
        session = DBHelper.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public boolean isUser(Long id) {
        session = DBHelper.getSessionFactory().openSession();
        session.beginTransaction();
        User user = session.get(User.class,id);
        session.getTransaction().commit();
        session.close();
        if (user != null){
            return true;
        }
        return false;
    }

    @Override
    public void updateUser(User user) {
        session = DBHelper.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteUser(Long id) {
        session = DBHelper.getSessionFactory().openSession();
        session.beginTransaction();
        User user = session.get(User.class,id);
        session.delete(user);
        session.getTransaction().commit();
        session.close();

    }
}
//jdbc
  /*  private Connection connection;

    public UserDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean addUser(User user) {
        if (user == null) {
            return false;
        }
        createTable();
        String sql = "insert user(name, mail) values (?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getMail());
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException e) {
            System.out.println("user not add");
        }
        return false;
    }

    @Override
    public List<User> getAllUsers()  {
        createTable();
        String sql = "select * from user";
        List<User> users = new ArrayList<User>();
        Statement st = null;
        try {
            st = connection.createStatement();

        ResultSet resultSet = st.executeQuery(sql);
        while (resultSet.next()) {
            User user = new User(resultSet.getLong("id"), resultSet.getString("name"),
                    resultSet.getString("mail"));
            users.add(user);
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public boolean isUser(Long id) {
        String sql = "select * from user where id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setLong(1, id);
            ResultSet resultSet = st.executeQuery();
            resultSet.next();
            if (resultSet != null) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("not is user - error");
        }
        return false;
    }

    @Override
    public void updateUser(User user) {
        String update = "update user set name = ?,mail = ? where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(update);
            ps.setString(1, user.getName());
            ps.setString(2, user.getMail());
            ps.setLong(3, user.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("user not update1");
        }
    }

    @Override
    public boolean deleteUser(Long id) {
        String sql = "delete from user where id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setLong(1, id);
            return st.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("erorr delet user");
        }
        return false;
    }

    public void createTable() {
        try {
            String sql = "create table if not exists user(id bigint auto_increment, name  varchar (30), mail varchar (80), primary key (id))";
            Statement statement = connection.createStatement();
            statement.execute(sql);
            statement.close();
        } catch (SQLException e) {
            System.out.println("error create table");
        }
    }
}*/
