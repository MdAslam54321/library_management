package com.acs.library_management.controller;

import com.acs.library_management.entity.Book;
import com.acs.library_management.entity.BookCategory;
import com.acs.library_management.repository.BookCategoryRepository;
import com.acs.library_management.service.BookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/library_management/book_category/")
public class BookCategoryController {

    @Autowired
    BookCategoryService bookCategoryService;

    //    Method to get all books
    @GetMapping("/getAllBookCategory")
    public List<BookCategory> getAllBookCategory() {
        return bookCategoryService.getAllBookCategory();
    }

    //    Method to create book category
    @PostMapping("/create_book_category")
    public ResponseEntity<BookCategory> createBookCategory(@RequestBody BookCategory bookCategory) {
        BookCategory bookCategory1 = bookCategoryService.createBookCategory(bookCategory);
        return new ResponseEntity<>(bookCategory1, HttpStatus.CREATED);
    }
}
