package com.acs.library_management.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "author")
    private String author;

    @Column(name = "qty")
    private int qty;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "book_category_id", nullable = false)
    private BookCategory bookCategory;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "book_rental_request",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "rental_request_id"))
    private Set<RentalRequest> rentalRequestSet;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "book_rented_book",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "rented_book_id"))
    private Set<RentedBook> rentedBookSet;

    public Book(String name, String author, BookCategory bookCategory, int qty) {
        this.name = name;
        this.author = author;
        this.bookCategory = bookCategory;
        this.qty = qty;
    }
}
