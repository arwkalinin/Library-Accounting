package com.arwka.libraryacc.rowmappers;

import com.arwka.libraryacc.models.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {
        Book book = new Book();

        book.setId(resultSet.getInt("id"));
        book.setTitle(resultSet.getString("title"));
        book.setAuthor(resultSet.getString("author"));
        book.setRelease(resultSet.getInt("release"));
        book.setTaker(resultSet.getInt("taker"));
        return book;
    }
}
