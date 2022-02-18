package com.ttl.services;

import com.ttl.dto.BookDTO;
import com.ttl.dto.FullBookDTO;

import java.util.List;

public interface BookService {
    List<FullBookDTO> getAllBooksByTitle(String title);

    List<FullBookDTO> getAllBooksByKeyWords(String keywords);

    List<FullBookDTO> getAllBooksByAuthorName(String authorName);

    FullBookDTO read(Integer id);

    Integer create(BookDTO entity);

    void update(BookDTO entity);

    void delete(Integer id);
}