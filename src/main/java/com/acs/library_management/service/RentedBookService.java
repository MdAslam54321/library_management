package com.acs.library_management.service;

import com.acs.library_management.repository.RentedBookRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class RentedBookService {

    @Autowired
    RentedBookRepository rentedBookRepository;
}
