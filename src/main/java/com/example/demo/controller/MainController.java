package com.example.demo.controller;

import com.example.demo.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private BookRepo repo;

//    @Autowired
//    private Calcalute calcalute;

    @GetMapping
    public String index(){
//        int res = calcalute.sum(2,3);
//        System.out.println("******************* " + res);
        return "index";
    }


    @GetMapping("/html/books")
    public String getAllBooks(Model model){
//        int res = calcalute.sum(2,33);
//        System.out.println("******************* " + res);
        model.addAttribute("books",repo.findAll());
        return "books";
    }



}
