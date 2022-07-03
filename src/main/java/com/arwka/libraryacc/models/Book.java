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
    private int releaseYear;
    private int takenById;

    ///////////////////
    public Book() {}
    public Book(String title, String author, int releaseYear) {
        this.title = title;
        this.author = author;
        this.releaseYear = releaseYear;
    }
    //
    public int getId() {
        return id;
    }
    //
    public void setId(int id) {
        this.id = id;
    }
    //
    public String getTitle() {
        return title;
    }
    //
    public void setTitle(String title) {
        this.title = title;
    }
    //
    public String getAuthor() {
        return author;
    }
    //
    public void setAuthor(String author) {
        this.author = author;
    }
    //
    public int getReleaseYear() {
        return releaseYear;
    }
    //
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
    //
    public int getTakenById() { return takenById; }
    //
    public void setTakenById(int takenById) { this.takenById = takenById; }
    //
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", releaseYear=" + releaseYear +
                '}';
    }
}
