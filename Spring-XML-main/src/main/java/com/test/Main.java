package com.test;

import com.test.bean.Student;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test.xml");
        Student student = context.getBean(Student.class);
        student.say("123");
    }
}
