package main;

import javax.sql.DataSource;

import dao.ConversationDao;
import dao.PersonDao;
import model.Conversation;
import model.Person;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@Configuration
@EnableTransactionManagement
public class AppConfig {
    @Bean
    public ConversationDao conversationDao() {
        return new ConversationDao();
    }
    @Bean
    public PersonDao personDao() {
        return new PersonDao();
    }
    @Bean
    public HibernateTemplate hibernateTemplate() {
        return new HibernateTemplate(sessionFactory());
    }
    @Bean
    public SessionFactory sessionFactory() {
        return new LocalSessionFactoryBuilder(getDataSource())
                .addAnnotatedClasses(Person.class)
                .addAnnotatedClasses(Conversation.class)
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
