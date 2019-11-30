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
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookRepo repo;


    @Test
    void getAllBooks() throws Exception {
        when(repo.findAll()).thenReturn(
                Arrays.asList(
                        new Book(1L, "akka in action", "williams"),
                        new Book(2L, "scala profession programming", "odersky"),
                        new Book(3L, "selfish gen", "dawkins")
                ));

        mockMvc.perform(get("/api"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(3)))
                .andExpect(jsonPath("$[*].id",containsInAnyOrder(1,2,3)))
                .andExpect(jsonPath("$[*].author",containsInAnyOrder("williams","odersky","dawkins")));
    }

    @Test
    void getBookById() throws Exception {
        when(repo.findById(anyLong())).thenReturn(Optional.of(
                new Book(1L, "akka in action", "williams"))
        );


        mockMvc.perform(get("/api/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id",equalTo(1)))
                .andExpect(jsonPath("$.author",equalTo("williams")));
    }
}