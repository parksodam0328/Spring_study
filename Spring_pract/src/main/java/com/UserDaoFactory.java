package com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserDaoFactory {
    @Bean
    public UserDao getLocalUserDao(){
        ConnectionMaker connectionMaker = new LocalConnectionMaker();
        UserDao userDao = new UserDao();
        userDao.setConnectionMaker(connectionMaker);
        return userDao;
    }
    @Bean
    public UserDao getPrdUserDao(){
        ConnectionMaker connectionMaker = new LocalConnectionMaker();
        UserDao dao = new UserDao();
        dao.setConnectionMaker(connectionMaker);
        return dao;
    }
}
