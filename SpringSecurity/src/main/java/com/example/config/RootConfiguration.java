package com.example.config;

import com.zaxxer.hikari.HikariDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

import javax.sql.DataSource;
@ComponentScans({
                @ComponentScan("com.example.service"),
        }
)
@MapperScan("com.example.mapper")
public class RootConfiguration {

        @Bean
        public DataSource dataSource(){
                HikariDataSource dataSource = new HikariDataSource();
                dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/library");
                dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
                dataSource.setUsername("root");
                dataSource.setPassword("lyh701721");
                return dataSource;
        }

        @Bean
        public SqlSessionFactoryBean sqlSessionFactoryBean(@Autowired DataSource dataSource){
                SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
                bean.setDataSource(dataSource);
                return bean;
        }
}
