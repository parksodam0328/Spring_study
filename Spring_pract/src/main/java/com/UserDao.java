package com;

import javax.jws.soap.SOAPBinding;
import java.sql.*;

public abstract class UserDao {

    //getConnection 구현
   /* private Connection getConnection() throws SQLException {
        Connection con = null;
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring_pract_01", "root","password");
        return con;
        }
   */

   abstract Connection getConnection() throws SQLException;
    //add 구현
    public void add(User user) throws SQLException {
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("insert into users(id,password, name) values(?,?,?)");

        ps.setString(1, user.getId());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getName());

        ps.executeUpdate();

        ps.close();
        con.close();
    }
    //get 구현
    public User get(String id) throws SQLException {
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("select * from users where id=?");

        ps.setString(1,id);
        ResultSet rs = ps.executeQuery();
        rs.next();

        User user = new User();
        user.setId(rs.getString("id"));
        user.setPassword(rs.getString("password"));
        user.setName(rs.getString("name"));

        rs.close();
        ps.close();
        con.close();

        return user;
    }
    public static void main(String[] args) throws SQLException {
        UserDao dao = new ProUserDao();

        User user = new User();
        user.setId(("Sean"));
        user.setPassword("2014");
        user.setName("hot");
        dao.add(user);

        User selectedUser = dao.get("lady");
        System.out.println("id : "+selectedUser.getId());
        System.out.println("password : "+selectedUser.getPassword());
        System.out.println("name : "+selectedUser.getName());

        dao.get(user.getId());
    }
}
