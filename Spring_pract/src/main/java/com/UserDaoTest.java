package com;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws SQLException {
        ConnectionMaker connectionMaker = new LocalConnectionMaker();
        //ConnectionMaker connectionMaker = new PrdConnectionMaker();
        UserDao dao = new UserDao(connectionMaker); //DI 적용

        /*User user = new User();
        user.setId(("yeah"));
        user.setPassword("1121");
        user.setName("swing");
        dao.add(user);*/

        User selectedUser = dao.get("adam");
        System.out.println("id : "+selectedUser.getId());
        System.out.println("password : "+selectedUser.getPassword());
        System.out.println("name : "+selectedUser.getName());

        //dao.get(user.getId());
    }
}
