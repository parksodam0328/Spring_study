package com;

import javax.jws.soap.SOAPBinding;
import java.sql.*;

public class UserDao {

    //getConnection 구현
   /* private Connection getConnection() throws SQLException {
        Connection con = null;
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring_pract_01", "root","password");
        return con;
        }
   */
   ConnectionMaker connectionMaker;
   //PrdConnectionMaker prdConnectionMaker;
   public UserDao(ConnectionMaker connectionMaker){ //DI 적용
       this.connectionMaker = connectionMaker;
   }
    //add 구현
    public void add(User user) throws SQLException {
        Connection con = connectionMaker.getConnection();
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
        Connection con = connectionMaker.getConnection();
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

}
