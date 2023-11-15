package com.sertecDev.APIRealismMagical.DTO;


import com.sertecDev.APIRealismMagical.persistence.entity.Author;
import com.sertecDev.APIRealismMagical.persistence.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorDTO {
    private String name;
    private String birthdate;
    private String nationality;
    private String description;
    private List<Author> authors;

    public AuthorDTO(Author author) {
       name= author.getName();
       birthdate= author.getBirthdate();
       nationality= author.getNationality();
       description= author.getDescription();
    }
}
