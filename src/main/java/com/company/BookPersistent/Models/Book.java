package com.company.BookPersistent.Models;

import javax.validation.constraints.NotBlank;

public class Book {

    @NotBlank(message = "Book must have a Title.")
    private String title;

    private String author;

    private String isbn;

    private BookType type;

    public Book (){

    }

    public Book(String title, String author, String isbn, BookType type) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.type = type;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public BookType getType() {
        return type;
    }

    public void setType(BookType type) {
        this.type = type;
    }
}
