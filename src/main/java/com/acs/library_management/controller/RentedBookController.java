package com.acs.library_management.controller;

import com.acs.library_management.service.RentedBookService;
import org.springframework.beans.factory.annotation.Autowired;

public class RentedBookController {

    @Autowired
    RentedBookService rentedBookService;
}
