package com.ttl.rowmappers;

import com.ttl.entities.Author;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class AuthorRowMapper implements RowMapper<Author> {
    @Override
    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {

        return Author.builder()
               .Id(rs.getInt("ID"))
               .Name(rs.getString("Name"))
               .Surname(rs.getString("Surname"))
               .build();
    }
}