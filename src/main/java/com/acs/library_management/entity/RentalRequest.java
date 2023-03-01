package com.acs.library_management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rental_request")
public class RentalRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "request_status")
    private String request_status;

    @Column(name = "request_date")
    private String request_date;

    @Column(name = "action_date")
    private String action_date;

    @ManyToMany(mappedBy = "rentalRequestSet")
    private Set<Customer> customerSet;

    @ManyToMany(mappedBy = "rentalRequestSet")
    private Set<Book> bookSet;
}
