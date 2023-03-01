package com.acs.library_management.service;

import com.acs.library_management.entity.Book;
import com.acs.library_management.entity.BookCategory;
import com.acs.library_management.repository.BookCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCategoryService {

    @Autowired
    BookCategoryRepository bookCategoryRepository;

    public List<BookCategory> getAllBookCategory() {
        return bookCategoryRepository.findAll();
    }

    public BookCategory createBookCategory(BookCategory bookCategory) {
        BookCategory bookCategory1 = bookCategoryRepository.save(new BookCategory(bookCategory.getName(), bookCategory.getMin_age(), bookCategory.getMax_age()));
        return bookCategory1;
    }

}
