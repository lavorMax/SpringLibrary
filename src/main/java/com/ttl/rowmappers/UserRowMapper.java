package com.ttl.rowmappers;

import com.ttl.entities.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class UserRowMapper implements RowMapper<User>{
    
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {

        return User.builder()
               .Id(rs.getInt("ID"))
               .Login(rs.getString("Login"))
               .Name(rs.getString("Name"))
               .Password(rs.getString("Password"))
               .build();
    }
}
