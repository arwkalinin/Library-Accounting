package com.arwka.libraryacc.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Book {

    private int id;
    @NotEmpty(message = "Title should not be empty.")
    @Size(min = 1, max = 64, message = "Title should be between 1 and 64 characters.")
    private String title;
    @NotEmpty(message = "Author should not be empty.")
    @Size(min = 1, max = 64, message = "Author should be between 1 and 64 characters.")
    private String author;
    private int release;
    private int taker;

    public Book() {}
    public Book(String title, String author, int release) {
        this.title = title;
        this.author = author;
        this.release = release;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public int getRelease() {
        return release;
    }
    public void setRelease(int release) {
        this.release = release;
    }
    public int getTaker() { return taker; }
    public void setTaker(int taker) { this.taker = taker; }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", release=" + release +
                '}';
    }
}
