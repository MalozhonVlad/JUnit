package com.example.demo;

import com.example.demo.domain.Book;
import com.example.demo.repo.BookRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class JUnitApplication {

    public static void main(String[] args) {
        SpringApplication.run(JUnitApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner preload(BookRepo bookRepo){
//        return args -> {
//            bookRepo.save(new Book("akka in action","williams"));
//            bookRepo.save(new Book("scala profession programming","odersky"));
//            bookRepo.save(new Book("selfish gen","dawkins"));
//
//        };
//    }

}
