package com.ttl.repositories;

import com.ttl.entities.User;

public interface UserRepository extends GenericRepository<User, Integer> {
    User getUserByLogin(String login);
}