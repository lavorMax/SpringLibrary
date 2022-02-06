package com.ttl.controllers;

import com.ttl.dto.BookDTO;
import com.ttl.services.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/bookSearch")
public class BookSearchController {
    
    @Autowired
    private BookService bookService;
    
    @GetMapping("/getByAuthorName/{authorName}")
    public List<BookDTO> serchByAuthorName(@PathVariable String authorName){
        List<BookDTO> books = bookService.getAllBooksByAuthorName(authorName);
         
        return books;
    }
    
    
    @GetMapping("/getByTitle/{title}")
    public List<BookDTO> searchByTitle(@PathVariable String title){
        List<BookDTO> books = bookService.getAllBooksByTitle(title);
         
        return books;
    }
    
    @GetMapping("/getByKeyWords/{keywords}")
    public List<BookDTO> searchByKeyWords(@PathVariable String keywords){
        List<BookDTO> books = bookService.getAllBooksByKeyWords(keywords);
        
        return books;
    }
}

