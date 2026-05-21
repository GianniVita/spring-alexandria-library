package org.lessons.java.spring_alexandria_library.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

@Entity
@Table(name = "borrowings")
public class Borrowing {
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    // libro da cui dipendo
    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;


    @NotNull(message = "The borrowing date cannot be null")
    @PastOrPresent(message = "The borrowing date cannot be set in the future")
    private LocalDate borrowingDate;

    @PastOrPresent(message = "The return date cannot be set in the future")
    private LocalDate returnDate;

    @Lob
    private String notes;
}
