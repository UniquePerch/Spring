package com.test.config;

import com.test.bean.Teacher;
import org.springframework.context.annotation.Bean;

public class TestConfiguration {
    @Bean
    public Teacher teacher(){
        return new Teacher();
    }//@Bean方式注册成为Bean
}
