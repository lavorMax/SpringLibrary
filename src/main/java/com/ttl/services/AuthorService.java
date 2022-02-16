package com.ttl.services;

import com.ttl.dto.AuthorDTO;

public interface AuthorService {
    AuthorDTO read(Integer id);
}