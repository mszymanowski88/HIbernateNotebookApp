package com.example.hibernatenotebookapp.newsrepo;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "inputs")
public class News {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    Long id;

    @Column(name = "Inputs", length = 100000)
    @Lob
    String input;

    @Column(name = "Date")
    private LocalDate localDate = LocalDate.now();

    public News() {
    }

    public News(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}
