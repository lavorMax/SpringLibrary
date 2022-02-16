package com.ttl.services;

import com.ttl.dto.BookDTO;
import com.ttl.entities.Book;
import com.ttl.mappers.Mapper;
import com.ttl.repositories.BookRepository;
import java.util.List;
import static java.util.stream.Collectors.toList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private Mapper<Book, BookDTO> bookMapper;

    @Override
    public List<BookDTO> getAllBooksByTitle(String title) {
        return bookRepository.getAllBooksByTitle(title)
                             .stream()
                             .map(i -> bookMapper.EntityToDTO(i))
                             .collect(toList());
    }

    @Override
    public List<BookDTO> getAllBooksByKeyWords(String keywords) {
        String[] keywordsArray =  keywords.split(" ");

        return bookRepository.getAllBooksByKeyWords(keywordsArray)
                             .stream()
                             .map(i -> bookMapper.EntityToDTO(i))
                             .collect(toList());
    }

    @Override
    public List<BookDTO> getAllBooksByAuthorName(String authorName) {
        return bookRepository.getAllBooksByAuthorName(authorName)
                             .stream()
                             .map(i -> bookMapper.EntityToDTO(i))
                             .collect(toList());
    }

    @Override
    public BookDTO read(Integer id) {
        return bookMapper.EntityToDTO(bookRepository.read(id));
    }

    @Transactional
    @Override
    public Integer create(BookDTO entity) {
        return bookRepository.create(bookMapper.DTOToEntity(entity));
    }

    @Override
    public void update(BookDTO entity) {
        bookRepository.update(bookMapper.DTOToEntity(entity));
    }

    @Override
    public void delete(Integer id) {
        bookRepository.deleteById(id);
    }
}