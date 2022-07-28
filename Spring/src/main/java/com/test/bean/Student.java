package com.test.bean;

import lombok.Data;
import lombok.ToString;
import netscape.security.UserTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@ToString
@Data
public class Student {
    int sid;
    String name;
    int age;
//    @Autowired
//    public void setCard(Card card) {
//        System.out.println("注入方法");
//        this.card = card;
//    }
//
//    public Student(){
//        System.out.println("构造方法");
//    }
//    @PostConstruct
//    public void init(){
//        System.out.println("属性card为"+card);
//    }

    public String say(String text){
        System.out.println(text);
        return text;
    }
}
