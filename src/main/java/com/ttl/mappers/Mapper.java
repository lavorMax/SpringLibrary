package com.ttl.mappers;

public interface Mapper<T, K> {
    
    T DTOToEntity(K DTO);
    
    K EntityToDTO(T entity);
}
