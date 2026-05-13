package org.lessons.java.spring_alexandria_library.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "books")
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "ISBN must not be null, nor empty or blank")
    @Size(min = 13, max = 13, message = "ISBN must be made of 13 characters")
    @Column(name = "isbn_code", length = 13, nullable = false)
    private String isbn;

    @NotBlank(message = "The title must not be null, nor empty or blank")
    private String title;

    @NotBlank(message = "The author must not be null, nor empty or blank")
    private String author;

    @NotBlank(message = "The publisher must not be null, nor empty or blank")
    private String publisher;

    @Lob
    private String synopis;

    @NotNull
    private LocalDate publicationDate;

    @NotNull
    @Min(value = 0, message = "the number of messages cannot be negative")
    private Integer numberOfCopies;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getSynopis() {
        return this.synopis;
    }

    public void setSynopis(String synopis) {
        this.synopis = synopis;
    }

    public LocalDate getPublicationDate() {
        return this.publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Integer getNumberOfCopies() {
        return this.numberOfCopies;
    }

    public void setNumberOfCopies(Integer numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    @Override
    public String toString(){
        return String.format("%s: %s, code: %s, published by: %s", this.author,this.title, this.isbn, this.publisher);
    }

}
