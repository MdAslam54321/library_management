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
@Table(name = "rented_book")
public class RentedBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "issue_date")
    private String issue_date;

    @Column(name = "return_date")
    private String return_date;

    @ManyToMany(mappedBy = "rentedBookSet")
    private Set<Customer> customerSet;

    @ManyToMany(mappedBy = "rentedBookSet")
    private Set<Book> bookSet;

    @ManyToMany
    @JoinTable(
            name = "rented_book_overdue",
            joinColumns = @JoinColumn(name = "rented_book_id"),
            inverseJoinColumns = @JoinColumn(name = "overdue_id"))
    private Set<Overdue> overdueSet;
}
