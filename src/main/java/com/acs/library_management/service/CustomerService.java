package com.acs.library_management.service;

import com.acs.library_management.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
}
