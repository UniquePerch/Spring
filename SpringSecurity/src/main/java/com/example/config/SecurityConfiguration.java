package com.example.config;

import com.example.service.UserAuthService;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.annotation.Resource;
import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Resource
    UserAuthService service;
    @Resource
    PersistentTokenRepository repository;

    @Override
    public void init(WebSecurity web) throws Exception {
        SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);//可以从子线程中获取用户信息
    }

    @Bean
    public PersistentTokenRepository jdbcRepository(@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") @Autowired DataSource dataSource){
        JdbcTokenRepositoryImpl repository = new JdbcTokenRepositoryImpl();  //使用基于JDBC的实现
        repository.setDataSource(dataSource);   //配置数据源
        repository.setCreateTableOnStartup(false);   //启动时自动创建用于存储Token的表（建议第一次启动之后删除该行）
        return repository;
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(service)   //使用自定义的Service实现类进行验证
                .passwordEncoder(new BCryptPasswordEncoder());   //依然使用BCryptPasswordEncoder
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()   //首先需要配置哪些请求会被拦截，哪些请求必须具有什么角色才能访问
                .antMatchers("/static/**").permitAll()    //静态资源，使用permitAll来运行任何人访问（注意一定要放在前面）
                .and()
                .formLogin()
                .loginPage("/login")//设置登录页面
                .loginProcessingUrl("/doLogin")//登录处理
                .defaultSuccessUrl("/index")//登录成功后跳转的页面
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")    //退出登陆的请求地址
                .logoutSuccessUrl("/login")    //退出后重定向的地址;
                .and()
                .csrf()
                .disable()
                .rememberMe()
                .rememberMeParameter("remember")
                .tokenValiditySeconds(60*60*24*7)
                .tokenRepository(repository);
    }
}
