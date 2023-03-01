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
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "sex")
    private boolean sex;

    @Column(name = "dob")
    private String dob;

    @Column(name = "email_id")
    private String email_id;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "hometown")
    private String hometown;

    @ManyToMany
    @JoinTable(
            name = "customer_rental_request",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "rental_request_id"))
    private Set<RentalRequest> rentalRequestSet;

    @ManyToMany
    @JoinTable(
            name = "customer_rented_book",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "rented_book_id"))
    private Set<RentedBook> rentedBookSet;

    @ManyToMany
    @JoinTable(
            name = "customer_overdue",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "overdue_id"))
    private Set<Overdue> overdueSet;
}
