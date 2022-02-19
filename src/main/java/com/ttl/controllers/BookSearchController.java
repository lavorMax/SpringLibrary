package com.ttl.controllers;

import com.ttl.dto.BookDTO;
import com.ttl.dto.FullBookDTO;
import com.ttl.services.BookService;
import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/bookSearch")
public class BookSearchController {
    private final BookService bookService;

    @Autowired
    public BookSearchController(BookService bookService) {
        this.bookService = bookService;
    }

    @Operation(summary = "Get books by author name", description = "Get books which author name contains entered author name")
    @GetMapping("/getByAuthorName/{authorName}")
    public RedirectView searchByAuthorName(@Parameter(description = "Author name by which books will be searched")
        @PathVariable String authorName,
        RedirectAttributes redir){
        List<FullBookDTO> books = bookService.getAllBooksByAuthorName(authorName);

        var redirectView= new RedirectView("/",true);
        redir.addFlashAttribute("books", books);

        return redirectView;
    }
    @Operation(summary = "Get books by title", description = "Get books which title contains entered title")
    @GetMapping("/getByTitle/{title}")
    public RedirectView searchByTitle(@Parameter(description = "Book title by which books will be searched")
        @PathVariable String title,
        RedirectAttributes redir){
        List<FullBookDTO> books = bookService.getAllBooksByTitle(title);

        var redirectView= new RedirectView("/",true);
        redir.addFlashAttribute("books", books);

        return redirectView;
    }

    @Operation(summary = "Get books by keywords", description = "Get books which description contains entered keywords")
    @GetMapping("/getByKeyWords/{keywords}")
    public RedirectView searchByKeyWords(@Parameter(description = "Keywords by which books will be searched")
        @PathVariable String keywords,
        RedirectAttributes redir){
        List<FullBookDTO> books = bookService.getAllBooksByKeyWords(keywords);

        var redirectView= new RedirectView("/",true);
        redir.addFlashAttribute("books", books);

        return redirectView;
    }
}