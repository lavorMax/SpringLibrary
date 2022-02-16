package com.ttl.mappers;

import com.ttl.dto.AuthorDTO;
import com.ttl.dto.BookDTO;
import com.ttl.entities.Author;
import com.ttl.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookMapper implements Mapper<Book, BookDTO> {
    @Override
    public Book DTOToEntity(BookDTO DTO) {
       if(DTO == null) return null;

       return Book.builder()
               .Description(DTO.getDescription())
               .Id(DTO.getId())
               .Title(DTO.getTitle())
               .AuthorId(DTO.getAuthorId())
               .build();
    }

    @Override
    public BookDTO EntityToDTO(Book entity) {
       if(entity == null) return null;

       return BookDTO.builder()
               .Description(entity.getDescription())
               .Id(entity.getId())
               .Title(entity.getTitle())
               .AuthorId(entity.getAuthorId())
               .build();
    }
}