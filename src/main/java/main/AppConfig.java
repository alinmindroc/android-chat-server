package main;

import dao.GroupDao;
import dao.GroupMessageDao;
import dao.MessageDao;
import dao.NotificationDao;
import model.Group;
import model.GroupMessage;
import model.Message;
import model.Notification;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
@Configuration
@EnableTransactionManagement
public class AppConfig {
    @Bean
    public NotificationDao notificationDao() {
        return new NotificationDao();
    }
    @Bean
    public GroupMessageDao groupMessageDao() {
        return new GroupMessageDao();
    }
    @Bean
    public GroupDao groupDao() {
        return new GroupDao();
    }
    @Bean
    public MessageDao messageDao() {
        return new MessageDao();
    }
    @Bean
    public HibernateTemplate hibernateTemplate() {
        return new HibernateTemplate(sessionFactory());
    }
    @Bean
    public SessionFactory sessionFactory() {
        return new LocalSessionFactoryBuilder(getDataSource())
                .addAnnotatedClasses(Message.class)
                .addAnnotatedClasses(Group.class)
                .addAnnotatedClasses(GroupMessage.class)
                .addAnnotatedClasses(Notification.class)
                .buildSessionFactory();
    }
    @Bean
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/lechat");
        dataSource.setUsername("root");
        dataSource.setPassword("");

        return dataSource;
    }
    @Bean
    public HibernateTransactionManager hibTransMan(){
        return new HibernateTransactionManager(sessionFactory());
    }
}
