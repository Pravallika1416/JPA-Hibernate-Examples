package org.example.Java_SpringBoot.db;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@Configuration
public class GetConnection {

    @Bean
    public Connection connection(){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/testdb", "root", "root");
        return connection;
        }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }

    }
    @Bean
    public DataSource dataSource(){
       DataSource source= DataSourceBuilder.create().url("jdbc:mysql://127.0.0.1:3306/testdb").username("root").password("root").build();

        return source;
    }

}
