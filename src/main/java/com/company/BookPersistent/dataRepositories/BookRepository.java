package com.company.BookPersistent.dataRepositories;

import com.company.BookPersistent.Models.Book;

import java.util.ArrayList;

public class BookRepository {

    // this is the container holding all of the books
    public static ArrayList<Book> books = new ArrayList<>();

    // a helper method that adds a new book to our static books property
    public static void addBook(Book book) {
        books.add(book);
    }

    public static ArrayList<Book> searchBook(String type, String keyword){
        ArrayList<Book> matchingBooks = new ArrayList<>();
        if (type.equals("author")){
            for(Book book : BookRepository.books) {
                if (book.getAuthor().equalsIgnoreCase(keyword)) {
                    matchingBooks.add(book);
                }
            }
        } else if (type.equals("title")){
            for(Book book : BookRepository.books) {
                if(book.getTitle().equalsIgnoreCase(keyword)) {
                    matchingBooks.add(book);
                }
            }
        }
        return matchingBooks;
    }

}
