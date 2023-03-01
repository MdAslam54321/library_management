package com.acs.library_management.controller;

import com.acs.library_management.entity.Book;
import com.acs.library_management.entity.BookCategory;
import com.acs.library_management.exception.ResourceNotFoundException;
import com.acs.library_management.repository.BookCategoryRepository;
import com.acs.library_management.repository.BookRepository;
import com.acs.library_management.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/library_management/book/")
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    BookCategoryRepository bookCategoryRepository;

    @Autowired
    BookRepository bookRepository;

    //    Method to get all book
    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    //    Method to get all book based on title
    @GetMapping("/searchByTitle/{title}")
    public List<Book> searchByTitle(@PathVariable("title") String title) {
        return bookService.searchByTitle(title);
    }

    //    Method to get all book based on author
    @GetMapping("/searchByAuthor/{author}")
    public List<Book> searchByAuthor(@PathVariable("author") String author) {
        return bookService.searchByAuthor(author);
    }

    //    Method to get all book based on book category
    @GetMapping("/searchByCategory/{category}")
    public List<Book> searchByBookCategory(@PathVariable("category") String bookCategory) {
        return bookService.searchByBookCategory(bookCategory);
    }

    //    Method to create book category
    @PostMapping("/{bookCategoryId}/book")
    public ResponseEntity<Book> createBook(@PathVariable(value = "bookCategoryId") Long bookCategoryId, @RequestBody Book bookRequest) {
        Book book = bookService.createBook(bookCategoryId, bookRequest);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    //    Method to delete book
    @DeleteMapping("/book/delete/{bookid}")
    public ResponseEntity<String> deleteBook(@PathVariable("bookid") long bookid){
        bookService.deleteBook(bookid);
        return ResponseEntity.ok("Book deleted");
    }
}
