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
@Table(name = "overdue")
public class Overdue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "overdue_date")
    private String overdue_date;

    @Column(name = "overdue_amt")
    private int overdue_amt;

    @Column(name = "payment_status")
    private boolean payment_status;

    @ManyToMany(mappedBy = "overdueSet")
    private Set<Customer> customerSet;

    @ManyToMany(mappedBy = "overdueSet")
    private Set<RentedBook> rentedBookSet;
}
