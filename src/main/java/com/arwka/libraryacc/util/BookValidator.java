package com.arwka.libraryacc.util;

import com.arwka.libraryacc.controllers.BooksController;
import com.arwka.libraryacc.dao.BookDAO;
import com.arwka.libraryacc.dao.PersonDAO;
import com.arwka.libraryacc.models.Book;
import com.arwka.libraryacc.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

@Component
public class BookValidator implements Validator {

    private final PersonDAO personDAO;
    private final BookDAO bookDAO;

    @Autowired
    public BookValidator(PersonDAO personDAO, BookDAO bookDAO) {
        this.personDAO = personDAO;
        this.bookDAO = bookDAO;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Book.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Book book = (Book) o;
        if (!isTakerPresent(book.getTaker()) && book.getTaker() != 0)
            errors.rejectValue("taker", "", "This taker doesnt exist.");
//        if (!isTitleUnique(book.getTitle()))
//            errors.rejectValue("title", "", "This title is occupied.");
    }

    private boolean isTakerPresent(int id) {
        List<Person> people = personDAO.index();
        Person person = people.stream().filter(e -> e.getId() == id).findAny().orElse(null);
        return person != null;
    }
    private boolean isTitleUnique(String title) {
        List<Book> books = bookDAO.index();
        Book book = books.stream().filter(e -> e.getTitle().equals(title)).findAny().orElse(null);
        return book != null;
    }
}
