package com.sertecDev.APIRealismMagical.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String birthdate;
    private String nationality;
    private String description;
    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL,
    fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Book> books;

    public Author(Long id, String name, String birthdate, String nationality, String description) {
        this.id=id;
        this.name=name;
        this.birthdate=birthdate;
        this.nationality=nationality;
        this.description=description;
    }

    public Author(String name, String birthdate, String nationality, String description) {
        this.name=name;
        this.birthdate=birthdate;
        this.nationality=nationality;
        this.description=description;
    }
}
