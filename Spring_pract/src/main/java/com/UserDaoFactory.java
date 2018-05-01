package com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import javax.sql.DataSource;
import com.mysql.jdbc.Driver;


@Configuration
public class UserDaoFactory {
    @Bean
    public DataSource getLocalUserDao(){
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
        dataSource.setUrl("jdbc:mysql://localhost:3606/spring_pract_01");
        dataSource.setUsername("root");
        dataSource.setPassword("password");
        //ConnectionMaker connectionMaker = new LocalConnectionMaker();
        UserDao userDao = new UserDao();
        userDao.setDataSource(dataSource);
        return dataSource;
    }
    @Bean
    public DataSource getPrdUserDao(){
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
        dataSource.setUrl("jdbc:mysql://localhost:3606/spring_prod_db");
        dataSource.setUsername("root");
        dataSource.setPassword("password");
        //ConnectionMaker connectionMaker = new LocalConnectionMaker();
        UserDao dao = new UserDao();
        dao.setDataSource(dataSource);
        return dataSource;
    }
    @Bean
    public UserDao localUserDao(){
        DataSource dataSource = getLocalUserDao();

        UserDao userDao =new UserDao();
        userDao.setDataSource(dataSource);

        return userDao;
    }

    public UserDao prdUserDao(){
        DataSource dataSource = getLocalUserDao();

        UserDao dao =new UserDao();
        dao.setDataSource(dataSource);

        return dao;
    }
}
