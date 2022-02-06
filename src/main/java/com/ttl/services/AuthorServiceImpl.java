package com.ttl.services;

import com.ttl.dto.AuthorDTO;
import com.ttl.entities.Author;
import com.ttl.mappers.Mapper;
import com.ttl.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthorServiceImpl implements AuthorService{
    
    @Autowired
    private AuthorRepository authorRepository;
    
    @Autowired
    private Mapper<Author, AuthorDTO> authorMapper;

    @Override
    public AuthorDTO read(Integer id) {
        return authorMapper.EntityToDTO(authorRepository.read(id));
    }
}
