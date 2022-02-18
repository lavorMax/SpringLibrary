package com.ttl.mappers;

import com.ttl.dto.AuthorDTO;
import com.ttl.dto.FullBookDTO;
import com.ttl.entities.Author;
import com.ttl.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FullBookMapper implements Mapper<Book, FullBookDTO>{

    @Autowired
    private Mapper<Author, AuthorDTO> authorMapper;

    @Override
    public Book DTOToEntity(FullBookDTO DTO) {
        if(DTO == null) return null;

        return Book.builder()
                .Description(DTO.getDescription())
                .Id(DTO.getId())
                .Title(DTO.getTitle())
                .Author(authorMapper.DTOToEntity(DTO.getAuthor()))
                .AuthorId(DTO.getAuthor().getId())
                .build();
    }

    @Override
    public FullBookDTO EntityToDTO(Book entity) {
        if(entity == null) return null;

        return FullBookDTO.builder()
                .Description(entity.getDescription())
                .Id(entity.getId())
                .Title(entity.getTitle())
                .Author(authorMapper.EntityToDTO(entity.getAuthor()))
                .build();
    }
}