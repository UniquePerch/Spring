package com.test.mapper;

import com.test.bean.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TestMapper {
    @Select("select * from student where sid='1001'")
    Student getStudent();

    @Insert("insert into student(name,age) values('测试','12')")
    void insertStudent();
}
