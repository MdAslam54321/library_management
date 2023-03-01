package com.acs.library_management.service;

import com.acs.library_management.repository.RentalRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class RentalRequestService {

    @Autowired
    RentalRequestRepository rentalRequestRepository;
}
