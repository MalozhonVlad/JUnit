package com.example.demo.component;

import org.springframework.stereotype.Component;

@Component
public class Language {


    public String hello() {
        System.out.println("bla-bla");
        return "Hello";
    }


}
