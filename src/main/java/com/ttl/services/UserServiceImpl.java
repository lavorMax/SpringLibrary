package com.ttl.services;

import com.ttl.dto.UserDTO;
import com.ttl.entities.User;
import com.ttl.mappers.Mapper;
import com.ttl.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private Mapper<User, UserDTO> userMapper;
    
    @Override
    public UserDTO getUserByLogin(String login) {
        return userMapper.EntityToDTO(userRepository.getUserByLogin(login));
    }

    @Override
    public boolean checkPasswordByUserID(Integer Id, String password) {
        User user = userRepository.read(Id);
        return user.getPassword().equals(password);
    }
    
}
