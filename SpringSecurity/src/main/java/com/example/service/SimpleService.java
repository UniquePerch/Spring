package com.example.service;

import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleService {

    public void test(List<String> list){
        System.out.println(list);
    }
}
