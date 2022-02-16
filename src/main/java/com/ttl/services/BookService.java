package com.ttl.services;

import com.ttl.dto.BookDTO;
import java.util.List;

public interface BookService {
    List<BookDTO> getAllBooksByTitle(String title);

    List<BookDTO> getAllBooksByKeyWords(String keywords);

    List<BookDTO> getAllBooksByAuthorName(String authorName);

    BookDTO read(Integer id);

    Integer create(BookDTO entity);

    void update(BookDTO entity);

    void delete(Integer id);
}