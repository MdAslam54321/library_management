package com.acs.library_management.repository;

import com.acs.library_management.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // Searching books based on title
    List<Book> findByName(String title);

    // Searching books based on author
    List findByAuthor(String author);

    @Transactional
    @Modifying
    @Query("FROM Book WHERE bookCategory.name = :bookCategory")
    public List<Book> findByBookCategory(String bookCategory);
}
