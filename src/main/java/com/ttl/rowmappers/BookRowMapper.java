package com.ttl.rowmappers;

import com.ttl.entities.Book;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class BookRowMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Book.builder()
               .Description(rs.getString("Description"))
               .Id(rs.getInt("ID"))
               .Title(rs.getString("Title"))
               .AuthorId(rs.getInt("AuthorId"))
               .build();
    }
}