package com.solveva.spdjpa_intro.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BookNatural {

    @Id
    private String title;

    private String isbn;
    private String publisher;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }
}
