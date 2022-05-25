package com.company.BookPersistent.dataRepositories;

import com.company.BookPersistent.Models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

}
