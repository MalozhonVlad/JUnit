package com.example.demo.repo;

import com.example.demo.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class BookRepoTest {

    @Autowired
    private BookRepo bookRepo;

    @Test
    public void findByNameAndAuthor(){
        assertTrue(!bookRepo.findAll().iterator().hasNext());
        Book book = bookRepo.save(new Book("akka in action","williams"));
        System.out.println(book.getId() + "---------------------");
        assertTrue(bookRepo.findByNameAndAuthor("akka in action","williams").get().getId() == book.getId());

    }

    @Test
    public void findAll(){
        assertTrue(!bookRepo.findAll().iterator().hasNext());
        bookRepo.save(new Book("akka in action","williams"));
        bookRepo.save(new Book("scala profession programming","odersky"));
        bookRepo.save(new Book("selfish gen","dawkins"));

        assertTrue(StreamSupport.stream(bookRepo.findAll().spliterator(),false).count() == 3);
    }

    @Test
    public void saveNewBook(){
        assertTrue(!bookRepo.findAll().iterator().hasNext());
        Book book = bookRepo.save(new Book("akka in action", "williams"));
        Book book1 = bookRepo.save(new Book("scala profession programming", "odersky"));

        assertTrue(bookRepo.save(book).getAuthor().equals("williams"));
        assertFalse(bookRepo.save(book).getName().equals("williams"));
    }

}