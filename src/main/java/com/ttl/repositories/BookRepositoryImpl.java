package com.ttl.repositories;

import com.ttl.entities.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepositoryImpl implements BookRepository {

    protected JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(DataSource dc) {
        this.jdbcTemplate = new JdbcTemplate(dc);
    }
    
    @Autowired
    private RowMapper<Book> bookRowMapper;
       

    @Override
    public List<Book> getAllBooksByTitle(String title) {
        String RawSQLquery = 
                     "Select b.ID, Title, Description, AuthorId, Name, Surname "
                   + "from Books b join Authors a on b.AuthorId = a.ID "
                   + "WHERE b.Title like '%"
                   + title + "%'";
        
        return jdbcTemplate.query(RawSQLquery, bookRowMapper);
    }
    
    @Override
    public List<Book> getAllBooksByKeyWords(String[] keywords) {
        StringBuilder  RawSQLquery = new StringBuilder (
                "Select b.ID, Title, Description, AuthorId, Name, Surname "
              + "from Books b join Authors a on b.AuthorId = a.ID WHERE ");
        
        for (int i = 0; i < keywords.length; i++) {
            RawSQLquery.append("Description like '%");
            RawSQLquery.append(keywords[i]);
            RawSQLquery.append("%'");
            if(i == keywords.length - 1) break;
            RawSQLquery.append(" or ");
        }
        
        return jdbcTemplate.query(RawSQLquery.toString(), bookRowMapper);
    }
    
    /*
    @Override
    public Page<Book> getAllBooksByAuthorName(String authorName, Pageable page) {

        Order order = Order.by("ID");
        
        List<Book> books = jdbcTemplate.query("Select b.ID, Title, Description, AuthorId, Name, Surname " 
                   + "from Books b join Authors a on b.AuthorId = a.ID " 
                   + "WHERE concat(Name, ' ', Surname) like '%"
                   + authorName + "%' " 
                   + "or concat(Surname, ' ', Name) like '%"
                   + authorName + "%' LIMIT " + page.getPageSize() + " OFFSET " + page.getOffset(),
        bookRowMapper);
        
    return new PageImpl<Book>(books, page, count());
    }
    
    
    private int count() {
        return jdbcTemplate.queryForObject("SELECT count(*) FROM Books", Integer.class);
    }

    */
    
    @Override
    public List<Book> getAllBooksByAuthorName(String authorName) {
        String RawSQLquery = 
                     "Select b.ID, Title, Description, AuthorId, Name, Surname " 
                   + "from Books b join Authors a on b.AuthorId = a.ID " 
                   + "WHERE concat(Name, ' ', Surname) like '%"
                   + authorName + "%' " 
                   + "or concat(Surname, ' ', Name) like '%"
                   + authorName + "%'";
        
        return jdbcTemplate.query(RawSQLquery, bookRowMapper);
    }

    @Override
    public Integer create(Book entity) {
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        
        jdbcTemplate.update((Connection con) -> {
            PreparedStatement statement = con.prepareStatement("INSERT INTO Books"
                    + " (Title, Description, AuthorId) VALUES (?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            
            statement.setString(1, entity.getTitle());
            statement.setString(2, entity.getDescription());
            statement.setInt(3, entity.getAuthor().getId());
            return statement;
        }, holder);

        return holder.getKey().intValue();
    }
    
    @Override
    public Book read(Integer id) {
        String RawSQLquery = 
                     "Select b.ID, Title, Description, AuthorId, Name, Surname "
                   + "from Books b join Authors a on b.AuthorId = a.ID"
                   + " WHERE b.ID = ?";
        
        return jdbcTemplate.queryForObject(RawSQLquery, bookRowMapper, id);
    }

    @Override
    public void update(Book entity) {
        String RawSQLquery = 
                   "Update Books SET Title = ?, Description = ?, AuthorId = ? "
                 + "WHERE Id = ?";

        jdbcTemplate.update(RawSQLquery, entity.getTitle(), 
                                         entity.getDescription(), 
                                         entity.getAuthor().getId(), 
                                         entity.getId());
    }

    @Override
    public void deleteById(Integer id) {
        String RawSQLquery = "DELETE FROM Books WHERE Id = ?";
        
        jdbcTemplate.update(RawSQLquery, id);
    }
}
