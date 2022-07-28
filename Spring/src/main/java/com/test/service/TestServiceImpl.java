package com.test.service;

import com.test.bean.Student;
import com.test.mapper.TestMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Component
public class TestServiceImpl implements TestService{
    @Resource
    TestMapper mapper;

    @Override
    public Student getStudent(){
        return mapper.getStudent();
    }

    @Transactional
    @Override
    public void test() {
        test2();
    }

    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public void test2() {
        mapper.insertStudent();
        throw new RuntimeException("异常");
    }
}
