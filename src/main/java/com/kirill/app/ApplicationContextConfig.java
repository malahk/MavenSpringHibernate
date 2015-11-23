/*
package com.kirill.app;

import com.kirill.app.models.*;
import com.kirill.app.repository.*;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.util.Properties;

*/
/**
 * Created by Kirill Malah
 *
 * @author Kirill Malah
 * @since 21-Nov-15
 *//*

@Configuration
@ComponentScan("com.kirill.app")
@EnableTransactionManagement
public class ApplicationContextConfig {

    // @Bean configurations go here...
    @Bean(name = "viewResolver")
    public InternalResourceViewResolver getViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/users_db");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        return dataSource;
    }

    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {

        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);

        sessionBuilder.addAnnotatedClasses(User.class, Address.class, Role.class, Animals.class, Food.class, Accessories.class);
        sessionBuilder.addProperties(getHibernateProperties());

        return sessionBuilder.buildSessionFactory();
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.hbm2ddl.auto", "validate");
        return properties;
    }
*/
/*
    @Autowired
    @Bean(name = "storageRepositories")
    public StorageRepositories getSorageRepo(SessionFactory sessionFactory) {
        return new StorageRepositories(sessionFactory);
    }*//*


    @Autowired
    @Bean(name = "userRepository")
    public UserRepository getUserRepo(SessionFactory sessionFactory) {
        return new UserRepository(sessionFactory);
    }

    @Autowired
    @Bean(name = "animalRepository")
    public AnimalRepository getAnimalRepo(SessionFactory sessionFactory) {
        return new AnimalRepository(sessionFactory);
    }

    @Autowired
    @Bean(name = "foodRepository")
    public FoodRepository getFoodRepo(SessionFactory sessionFactory) {
        return new FoodRepository(sessionFactory);
    }

    @Autowired
    @Bean(name = "accsRepository")
    public AccessoriesRepository getAccsRepo(SessionFactory sessionFactory) {
        return new AccessoriesRepository(sessionFactory);
    }
}
*/
