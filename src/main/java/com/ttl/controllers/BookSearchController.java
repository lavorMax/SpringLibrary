package com.ttl.controllers;

import com.ttl.dto.BookDTO;
import com.ttl.dto.FullBookDTO;
import com.ttl.services.BookService;
import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookSearch")
public class BookSearchController {
    private final BookService bookService;

    @Autowired
    public BookSearchController(BookService bookService) {
        this.bookService = bookService;
    }

    @Operation(summary = "Get books by author name", description = "Get books which author name contains entered author name")
    @GetMapping("/getByAuthorName/{authorName}")
    public List<FullBookDTO> searchByAuthorName(@Parameter(description = "Author name by which books will be searched")
        @PathVariable String authorName){
        List<FullBookDTO> books = bookService.getAllBooksByAuthorName(authorName);

        return books;
    }
    @Operation(summary = "Get books by title", description = "Get books which title contains entered title")
    @GetMapping("/getByTitle/{title}")
    public List<FullBookDTO> searchByTitle(@Parameter(description = "Book title by which books will be searched")
        @PathVariable String title){
        List<FullBookDTO> books = bookService.getAllBooksByTitle(title);

        return books;
    }

    @Operation(summary = "Get books by keywords", description = "Get books which description contains entered keywords")
    @GetMapping("/getByKeyWords/{keywords}")
    public List<FullBookDTO> searchByKeyWords(@Parameter(description = "Keywords by which books will be searched")
        @PathVariable String keywords){
        List<FullBookDTO> books = bookService.getAllBooksByKeyWords(keywords);

        return books;
    }
}