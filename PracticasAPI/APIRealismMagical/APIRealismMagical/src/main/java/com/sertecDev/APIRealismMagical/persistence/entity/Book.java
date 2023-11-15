package com.sertecDev.APIRealismMagical.persistence.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String editorial;
    private Integer year;
    @Column(name = "number_of_pages")
    private String numberOfPages;
    @ManyToOne
    @JoinColumn(name = "id_author")
    private Author author;

    public Book(String name, String editorial, Integer year, String numberOfPages, Author author) {
        this.name=name;
        this.editorial=editorial;
        this.year=year;
        this.numberOfPages=numberOfPages;
        this.author=author;
    }
}
