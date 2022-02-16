package com.ttl.repositories;

public interface GenericRepository<T, K> {
    public T read(K id);

    public Integer create(T entity);

    public void update(T entity);

    public void deleteById(K id);
}