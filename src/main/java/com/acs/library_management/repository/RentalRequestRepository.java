package com.acs.library_management.repository;

import com.acs.library_management.entity.RentalRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRequestRepository extends JpaRepository<RentalRequest, Long> {
}
