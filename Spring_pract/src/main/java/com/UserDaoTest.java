package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws SQLException {

        UserDaoFactory userDaoFactory = new UserDaoFactory();

        //applicationContext 선언하기
        ApplicationContext context;

        //AnnotationConfigApplicationContext로 생성
        context = new AnnotationConfigApplicationContext(UserDaoFactory.class);
        UserDao dao = userDaoFactory.getLocalUserDao(); // 어떤 메소드를 연결하냐의 따라 연결되는 디비가 달라짐
        //ConnectionMaker connectionMaker = new LocalConnectionMaker();
        //ConnectionMaker connectionMaker = new PrdConnectionMaker();

        String environment ="prd";
        if(environment.equals("prd")){
            dao = userDaoFactory.getPrdUserDao();
        }
        //UserDao dao = new UserDao(connectionMaker); //DI 적용

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
