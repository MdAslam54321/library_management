package com.acs.library_management.service;

import com.acs.library_management.entity.Book;
import com.acs.library_management.exception.ResourceNotFoundException;
import com.acs.library_management.repository.BookCategoryRepository;
import com.acs.library_management.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookCategoryRepository bookCategoryRepository;

    //    Method to get all books.
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    //    Method to get all books
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    //    Method to add book
    public Book createBook(@PathVariable(value = "bookCategoryId") Long bookCategoryId, Book bookRequest) {
        Book book = bookCategoryRepository.findById(bookCategoryId).map(bookCategory -> {
            bookRequest.setBookCategory(bookCategory);
            return bookRepository.save(bookRequest);
        }).orElseThrow(() -> new ResourceNotFoundException("Not found book category with id = " + bookCategoryId));

        return book;
    }

    //    Method to get all book based on title
    public List<Book> searchByTitle(String title) {
        return bookRepository.findByName(title);
    }

    //    Method to get all book based on author
    public List searchByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    //    Method to get all book based on book category
    public List<Book> searchByBookCategory(String bookCategory) {
        return bookRepository.findByBookCategory(bookCategory);

    }

    //    Method to delete book
    public void deleteBook(long bookid) {
        Book book = bookRepository.findById(bookid)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found for this id :: " + bookid));
        bookRepository.delete(book);
    }
}

