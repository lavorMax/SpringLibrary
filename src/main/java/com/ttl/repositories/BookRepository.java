package com.ttl.repositories;

import com.ttl.entities.Book;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends GenericRepository<Book, Integer> {
    List<Book> getAllBooksByTitle(String title);

    List<Book> getAllBooksByKeyWords(String[] keywords);

    List<Book> getAllBooksByAuthorName(String authorName);
}