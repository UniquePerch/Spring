package com.test.bean;


import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.Map;

//注意，这里还用不到值注入，只需要包含成员属性即可，不用Getter/Setter。
@ToString
public class Student {
    String name;
    int age;
    Card card;

    public Student(String name){
        this.name = name;
    }

    public Student(String name,int age){
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCard(Card card) {
        this.card = card;
    }
    @Deprecated
    public void test(){
        System.out.println("过时方法");
    }
    public void say(String text){
        System.out.println(text);
    }
}
