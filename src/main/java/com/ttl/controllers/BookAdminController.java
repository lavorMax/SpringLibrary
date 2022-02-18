package com.ttl.controllers;

import com.ttl.dto.BookDTO;
import com.ttl.services.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
    private final BookService bookService;

    @Autowired
    public BookAdminController(BookService bookService) {
        this.bookService = bookService;
    }

    @Operation(summary = "Create book", description = "Create new book with entered values")
    @PostMapping("/book")
    public Integer postBook(@RequestBody BookDTO book) {
        return bookService.create(book);
    }

    @Operation(summary = "Update book", description = "Update book with entered values")
    @PutMapping("/book/{id}")
    public void putBook(@RequestBody BookDTO book,
        @Parameter(description = "Book id")
        @PathVariable Integer id){
        book.setId(id);
        bookService.update(book);
    }

    @Operation(summary = "Delete book", description = "Delete book by entered id")
    @DeleteMapping("/book/{id}")
    public void deleteBook(@Parameter(description = "Book id")
        @PathVariable Integer id){
        bookService.delete(id);
    }
}