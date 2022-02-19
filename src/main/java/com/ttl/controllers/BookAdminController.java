package com.ttl.controllers;

import com.ttl.dto.BookDTO;
import com.ttl.entities.Book;
import com.ttl.services.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bookAdmin")
public class BookAdminController {
    private final BookService bookService;

    @Autowired
    public BookAdminController(BookService bookService) {
        this.bookService = bookService;
    }

    @Operation(summary = "Create book", description = "Create new book with entered values")
    @PostMapping("/book")
    public String postBook(@ModelAttribute(value="book") BookDTO book) {
        bookService.create(book);
        return "index";
    }

    @Operation(summary = "Update book", description = "Update book with entered values")
    @PostMapping("/book/{id}")
    public String putBook(@ModelAttribute BookDTO book,
        @Parameter(description = "Book id")
        @PathVariable Integer id){
        book.setId(id);
        bookService.update(book);
        return "index";
    }

    @Operation(summary = "Delete book", description = "Delete book by entered id")
    @PostMapping("/deleteBook/{id}")
    public String deleteBook(@Parameter(description = "Book id")
        @PathVariable Integer id){
        bookService.delete(id);
        return "index";
    }

    @GetMapping("/addBook")
    public ModelAndView addBook() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("book", new BookDTO());
        modelAndView.setViewName("addBook");
        return modelAndView;
    }

    @GetMapping("/updateBook")
    public ModelAndView updateBook() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("book", new BookDTO());
        modelAndView.setViewName("updateBook");
        return modelAndView;
    }

    @GetMapping("/deleteBook")
    public ModelAndView deleteBook() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("book", new BookDTO());
        modelAndView.setViewName("deleteBook");
        return modelAndView;
    }
}