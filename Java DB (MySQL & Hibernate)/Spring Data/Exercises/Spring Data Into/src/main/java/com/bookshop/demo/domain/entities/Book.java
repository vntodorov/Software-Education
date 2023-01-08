package com.bookshop.demo.domain.entities;

import com.bookshop.demo.domain.enums.AgeRestriction;
import com.bookshop.demo.domain.enums.EditionType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book extends BaseEntity{

    @Column(length = 50, nullable = false)
    private String title;

    @ManyToOne
    private Author author;

    @ManyToMany
    @JoinTable(name = "books_categories",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id")
    )
    private Set<Category> categories;

    @Column(length = 1000)
    private String description;

    @Column(name = "edition_type")
    @Enumerated(EnumType.STRING)
    private EditionType editionType;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private int copies;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "age_restriction")
    @Enumerated(EnumType.STRING)
    private AgeRestriction ageRestriction;

}
