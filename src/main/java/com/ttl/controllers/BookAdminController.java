package com.ttl.controllers;

import com.ttl.dto.BookDTO;
import com.ttl.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/bookAdmin")
public class BookAdminController {
    
    @Autowired
    private BookService bookService;
    
    @PostMapping("/postbook")
    public Integer postBook(@RequestBody BookDTO book){
        return bookService.create(book);
    }
    
    @PutMapping("/putbook")
    public void putBook(@RequestBody BookDTO book){
        bookService.update(book);
    }
    
    @DeleteMapping("/deletebook/{id}")
    public void deleteBook(@PathVariable Integer id){
        bookService.delete(id);
    }
}
