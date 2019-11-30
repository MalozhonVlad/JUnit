package com.example.demo.controller;

import com.example.demo.domain.Book;
import com.example.demo.repo.BookRepo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import java.util.Arrays;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest
class MainControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookRepo repo;

    @Test
    void index() throws Exception{
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(content().string(containsString("Index Page")));

    }

    @Test
    void getAllBooks() throws Exception {
        when(repo.findAll()).thenReturn(
                Arrays.asList(
                        new Book(1L, "akka in action", "williams"),
                        new Book(2L, "scala profession programming", "odersky"),
                        new Book(3L, "selfish gen", "dawkins")
                ));

        mockMvc.perform(get("/html/books"))
                .andExpect(status().isOk())
                .andExpect(view().name("books"))
                .andExpect(content().string(containsString("williams")));
    }
}