package com.ttl.repositories;

import com.ttl.entities.Author;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository {
    protected JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(DataSource dc) {
        this.jdbcTemplate = new JdbcTemplate(dc);
    }

    @Autowired
    private RowMapper<Author> authorRowMapper;

    @Override
    public Integer create(Author entity) {
        GeneratedKeyHolder holder = new GeneratedKeyHolder();

        jdbcTemplate.update((Connection con) -> {
            PreparedStatement statement = con.prepareStatement(
                    "INSERT INTO Author (Name, Surname) VALUES (?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, entity.getName());
            statement.setString(2, entity.getSurname());
            return statement;
        }, holder);

        return holder.getKey().intValue();
    }

    @Override
    public Author read(Integer id) {
        String RawSQLquery = "Select * from Authors WHERE ID = ?";

        return jdbcTemplate.queryForObject(RawSQLquery, authorRowMapper, id);
    }

    @Override
    public void update(Author entity) {
        String RawSQLquery = "Update Books SET Name = ?, Surname = ? WHERE Id = ?";

        jdbcTemplate.update(RawSQLquery, entity.getName(),
                            entity.getSurname(), entity.getId());
    }

    @Override
    public void deleteById(Integer id) {
        String RawSQLquery = "DELETE FROM Authors WHERE Id = ?";

        jdbcTemplate.update(RawSQLquery, id);
    }
}