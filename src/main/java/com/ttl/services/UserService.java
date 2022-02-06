package com.ttl.services;

import com.ttl.dto.UserDTO;

public interface UserService {
    
    UserDTO getUserByLogin(String login);
    
    boolean checkPasswordByUserID(Integer Id, String password);
}
