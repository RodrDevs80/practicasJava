package com.sertecDev.APIRealismMagical.DTO;

import com.sertecDev.APIRealismMagical.persistence.entity.Author;
import com.sertecDev.APIRealismMagical.persistence.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDTO {
    private String name;
    private String editorial;
    private Integer year;
    private String numberOfPages;
    private Author author;

    public BookDTO(Book book) {
        name= book.getName();
        editorial= book.getEditorial();
        year=book.getYear();
        numberOfPages= book.getNumberOfPages();
        author=book.getAuthor();
    }
}
