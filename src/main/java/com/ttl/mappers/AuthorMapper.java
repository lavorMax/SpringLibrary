package com.ttl.mappers;

import com.ttl.dto.AuthorDTO;
import com.ttl.entities.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper implements Mapper<Author, AuthorDTO>{
    
    @Override
    public Author DTOToEntity(AuthorDTO DTO) {
       if(DTO == null) return null;
       
       return Author.builder()
               .Id(DTO.getId())
               .Name(DTO.getName())
               .Surname(DTO.getSurname())
               .build();
    }
    
    @Override
    public AuthorDTO EntityToDTO(Author entity) {
       if(entity == null) return null;
       
       return AuthorDTO.builder()
               .Id(entity.getId())
               .Name(entity.getName())
               .Surname(entity.getSurname())
               .build();
    }
    
}
