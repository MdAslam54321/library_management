package com.acs.library_management.repository;

import com.acs.library_management.entity.Overdue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OverdueRepository extends JpaRepository<Overdue, Long> {

}
