package com.ttl.services;

import com.ttl.dto.BookDTO;
import java.util.List;

public interface BookService {
    
    List<BookDTO> getAllBooksByTitle(String title);
    
    List<BookDTO> getAllBooksByKeyWords(String keywords);
    
    List<BookDTO> getAllBooksByAuthorName(String authorName);
    
    public BookDTO read(Integer id);
    
    public Integer create(BookDTO entity);
    
    public void update(BookDTO entity);
    
    public void delete(Integer id);
}
