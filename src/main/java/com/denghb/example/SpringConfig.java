package com.denghb.example;

import com.denghb.dbhelper.DbHelper;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


/**
 * Created by ppd on 16/11/23.
 */
@Configuration
@ComponentScan(basePackages={"com.denghb.*.service"})
public class SpringConfig {
    @Value("${db.driver}")
    private String driver;

    @Value("${db.url}")
    private String url;

    @Value("${db.username}")
    private String username;

    @Value("${db.password}")
    private String password;

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setValidationQuery("select 1;");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public DbHelper dbHelper(){
        DbHelper db = new DbHelper();
        db.setJdbcTemplate(jdbcTemplate());
        return db;
    }

    /**
     * 必须加上static
     */
    @Bean
    public static PropertyPlaceholderConfigurer loadProperties() {
        PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
        ClassPathResource resource = new ClassPathResource("db.properties");
        configurer.setLocations(resource);
        return configurer;
    }
}
