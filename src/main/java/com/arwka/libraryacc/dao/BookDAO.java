package com.arwka.libraryacc.dao;

import com.arwka.libraryacc.models.Book;
import com.arwka.libraryacc.models.Person;
import com.arwka.libraryacc.rowmappers.BookRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    public List<Book> index() {
        return jdbcTemplate.query("SELECT * FROM Book", new BookRowMapper());
    }
    //
    public void saveNewBook(Book book) {
        jdbcTemplate.update("INSERT INTO Book(title, author, release) VALUES(?,?,?)", book.getTitle(), book.getAuthor(), book.getRelease());
    }
    //
    public Book getBookById(int id) {
        return jdbcTemplate.query(
                "SELECT * FROM Book WHERE id=?", new Object[]{id}, new BookRowMapper())
                .stream().findAny().orElse(null);
    }
    //
    public void update(int id, Book updatedBook) {
        jdbcTemplate.update(
                "UPDATE Book SET title=?, author=?, release=?, taker=? WHERE id=?",
                updatedBook.getTitle(), updatedBook.getAuthor(), updatedBook.getRelease(), updatedBook.getTaker(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Book WHERE id=?", id);
    }
}
