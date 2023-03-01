package com.acs.library_management.controller;

import com.acs.library_management.repository.CustomerRepository;
import com.acs.library_management.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerController{

    @Autowired
    CustomerService customerService;
}
