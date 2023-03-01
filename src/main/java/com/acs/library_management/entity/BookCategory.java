package com.acs.library_management.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.domain.Page;

import java.util.Set;

@Data
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book_category")
public class BookCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "min_age")
    private int min_age;

    @Column(name = "max_age")
    private int max_age;

    @JsonIgnore
    @OneToMany(mappedBy = "bookCategory", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Book> bookSet;

    public BookCategory(String name, int min_age, int max_age) {
        this.name = name;
        this.min_age = min_age;
        this.max_age = max_age;
    }
}
