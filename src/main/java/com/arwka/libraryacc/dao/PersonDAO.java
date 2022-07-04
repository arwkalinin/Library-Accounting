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
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person getPersonById(int id) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }

    public List<Book> booksOnBalance(Person person) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE taker=?", new Object[]{person.getId()}, new BookRowMapper());
    }

    public void saveNewPerson(Person person) {
        jdbcTemplate.update("INSERT INTO Person(name, birth) VALUES (?,?)", person.getName(), person.getBirth());
    }

    public void update(int id, Person updatedPerson) {
        jdbcTemplate.update("UPDATE Person SET name=?, birth=? WHERE id=?", updatedPerson.getName(), updatedPerson.getBirth(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);
    }
}
