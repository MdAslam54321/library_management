package com.acs.library_management.controller;

import com.acs.library_management.service.OverdueService;
import org.springframework.beans.factory.annotation.Autowired;

public class OverdueController {

    @Autowired
    OverdueService overdueService;
}
