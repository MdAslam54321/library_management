package com.acs.library_management.repository;

import com.acs.library_management.entity.RentedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentedBookRepository extends JpaRepository<RentedBook, Long> {
}
