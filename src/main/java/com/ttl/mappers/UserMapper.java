package com.ttl.mappers;

import com.ttl.dto.UserDTO;
import com.ttl.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements Mapper<User, UserDTO>{
    
    @Override
    public User DTOToEntity(UserDTO DTO) {
       if(DTO == null) return null;
       
       return User.builder()
               .Id(DTO.getId())
               .Login(DTO.getLogin())
               .Name(DTO.getName())
               .build();
    }
    
    @Override
    public UserDTO EntityToDTO(User entity) {
       if(entity == null) return null;
       
       return UserDTO.builder()
               .Id(entity.getId())
               .Login(entity.getLogin())
               .Name(entity.getName())
               .build();
    }
    
}
