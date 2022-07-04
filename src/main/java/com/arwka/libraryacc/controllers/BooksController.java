package com.arwka.libraryacc.controllers;

import com.arwka.libraryacc.dao.BookDAO;
import com.arwka.libraryacc.dao.PersonDAO;
import com.arwka.libraryacc.models.Book;
import com.arwka.libraryacc.util.BookValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/books")
public class BooksController {

    private final BookDAO bookDAO;
    private final PersonDAO personDAO;
    private final BookValidator bookValidator;

    @Autowired
    public BooksController(BookDAO bookDAO, PersonDAO personDAO, BookValidator bookValidator) {
        this.bookDAO = bookDAO;
        this.personDAO = personDAO;
        this.bookValidator = bookValidator;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("books", bookDAO.index());
        return "books/index";
    }

    @GetMapping("/{id}")
    public String bookPage(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookDAO.getBookById(id));
        model.addAttribute("people", personDAO.index());
        return "books/book-page";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookDAO.getBookById(id));
        return "books/edit";
    }

    @GetMapping("/new")
    public String newBook(@ModelAttribute("book") Book book) { return "books/new"; }

    @PostMapping
    public String saveNewBook(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "books/new";
        } else {
            bookDAO.saveNewBook(book);
            return "redirect:/books";
        }
    }

    @PatchMapping("/{id}/return-book")
    public String returnBook(@PathVariable("id") int id) {
        Book book = bookDAO.getBookById(id);
        int recentTakerId = book.getTaker();
        book.setTaker(0);
        bookDAO.update(id, book);
        return "redirect:/people/" + recentTakerId;
    }

    @PatchMapping("/{id}")
    public String updateBook(@ModelAttribute("book") @Valid Book book,
                               BindingResult bindingResult,
                               @PathVariable("id") int id) {
        bookValidator.validate(book, bindingResult);
        if (bindingResult.hasErrors())
            return "books/edit";

        bookDAO.update(id, book);
        return "redirect:/books";
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        bookDAO.delete(id);
        return "redirect:/books";
    }
}
