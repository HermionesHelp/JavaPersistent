package com.company.BookPersistent.Controllers;

import com.company.BookPersistent.Models.Book;
import com.company.BookPersistent.Models.BookType;
import com.company.BookPersistent.dataRepositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    // GET /book -> returns a JSON List of all the books
    @GetMapping
    public String getBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "bookList";
    }


    // GET /book/new -> returns an HTML form
    @GetMapping(value = "/new")
    public String addBookForm(Model model) {
        model.addAttribute(new Book());
        model.addAttribute("types", BookType.values());
        return "newBookForm";
    }

    // POST /book/new
    @PostMapping(value = "/new")
    public String addBook(@ModelAttribute @Valid Book newBook, Errors errors, Model model) {

        if (errors.hasErrors()){
            return "newBooKForm";
        }

        bookRepository.save(newBook);
        model.addAttribute("bookName", newBook.getTitle());
        return "bookAdded";
    }

    @GetMapping(value = "/search")
    public String searchBooksForm(){
        return "filterBooksForm";
    }

    @PostMapping(value = "/search")
    public String searchBooks(Model model, @RequestParam String type, @RequestParam String keyword){
        ArrayList<Book> matchingBooks = new ArrayList<>();

        if (type.equals("author")) {
            for (Book book : bookRepository.findAll()) {
                if (book.getAuthor().toString().toLowerCase().contains(keyword.toLowerCase())) {
                    matchingBooks.add(book);
                }
            }
        }else if (type.equals("title")) {
            for (Book book : bookRepository.findAll()) {
                if(book.getTitle().toString().toLowerCase().contains(keyword.toLowerCase()));
                matchingBooks.add(book);
            }
        }
        model.addAttribute("books", matchingBooks);
        return "filterBooks";
    }
}
