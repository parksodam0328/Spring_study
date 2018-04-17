package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws SQLException {

        UserDaoFactory userDaoFactory = new UserDaoFactory();

        //applicationContext 선언하기
        ApplicationContext context;

        //AnnotationConfigApplicationContext로 생성
        //context = new AnnotationConfigApplicationContext(UserDaoFactory.class);
        //context = new GenericXmlApplicationContext("applicationContext.xml");
        context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //UserDao dao = userDaoFactory.getLocalUserDao(); // 어떤 메소드를 연결하냐의 따라 연결되는 디비가 달라짐
        UserDao dao = context.getBean("localUserDao",UserDao.class);

        //ConnectionMaker connectionMaker = new LocalConnectionMaker();
        //ConnectionMaker connectionMaker = new PrdConnectionMaker();

        String environment ="prd";
        if(environment.equals("prd")){
            dao = userDaoFactory.getPrdUserDao();
            dao = context.getBean("prdUserDao",UserDao.class);
        }
        //UserDao dao = new UserDao(connectionMaker); //DI 적용

       /* User user = new User();
        user.setId(("ewods"));
        user.setPassword("123");
        user.setName("swinewfg");
        dao.add(user);*/

        User selectedUser = dao.get("ewods");
        System.out.println("id : "+selectedUser.getId());
        System.out.println("password : "+selectedUser.getPassword());
        System.out.println("name : "+selectedUser.getName());

        //dao.get(user.getId());
    }
}
