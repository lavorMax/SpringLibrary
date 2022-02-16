package com.ttl.repositories;

import com.ttl.entities.User;
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
public class UserRepositoryImpl implements UserRepository {
    protected JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(DataSource dc) {
        this.jdbcTemplate = new JdbcTemplate(dc);
    }

    @Autowired
    private RowMapper<User> userRowMapper;

    @Override
    public User getUserByLogin(String login) {
        String RawSQLquery = "Select * from Users WHERE Login = ?";

        return jdbcTemplate.queryForObject(RawSQLquery, userRowMapper, login);
    }

    @Override
    public Integer create(User entity) {
        GeneratedKeyHolder holder = new GeneratedKeyHolder();

        jdbcTemplate.update((Connection con) -> {
            PreparedStatement statement = con.prepareStatement(
                    "INSERT INTO Users (Login, Password, Name) VALUES (?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, entity.getLogin());
            statement.setString(2, entity.getPassword());
            statement.setString(3, entity.getName());
            return statement;
        }, holder);

        return holder.getKey().intValue();
    }

    @Override
    public User read(Integer id) {
        String RawSQLquery = "Select * from Users WHERE ID = ?";

        return jdbcTemplate.queryForObject(RawSQLquery, userRowMapper, id);

    }

    @Override
    public void update(User entity) {
        String RawSQLquery = "Update Books SET Login = ?, "
                   + "Password = ?, Name = ? WHERE Id = ?";

        jdbcTemplate.update(RawSQLquery, entity.getLogin(), entity.getPassword(),
                            entity.getName(), entity.getId());
    }

    @Override
    public void deleteById(Integer id) {
        String RawSQLquery = "DELETE FROM Users WHERE Id = ?";

        jdbcTemplate.update(RawSQLquery, id);
    }
}