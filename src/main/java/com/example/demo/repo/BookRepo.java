package com.example.demo.repo;

import com.example.demo.domain.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BookRepo extends CrudRepository<Book, Long> {
    Optional<Book> findByNameAndAuthor(String name,String author);
}
