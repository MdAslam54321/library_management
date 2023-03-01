package com.acs.library_management.service;

import com.acs.library_management.repository.OverdueRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class OverdueService {

    @Autowired
    OverdueRepository overdueRepository;
}
