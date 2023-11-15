package com.sertecDev.APIRealismMagical.DTO;

import com.sertecDev.APIRealismMagical.persistence.entity.Author;
import com.sertecDev.APIRealismMagical.persistence.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorRespuestaDTO {
    private String name;
    private String birthdate;
    private String nationality;
    private String description;
    private List<Book> books;

    public AuthorRespuestaDTO(Author author) {
        name= author.getName();
        birthdate= author.getBirthdate();
        nationality= author.getNationality();
        description= author.getDescription();
        books=author.getBooks();
    }
}
