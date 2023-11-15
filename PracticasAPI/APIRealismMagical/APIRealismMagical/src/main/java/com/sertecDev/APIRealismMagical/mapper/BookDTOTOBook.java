package com.sertecDev.APIRealismMagical.mapper;

import com.sertecDev.APIRealismMagical.DTO.BookDTO;
import com.sertecDev.APIRealismMagical.persistence.entity.Author;
import com.sertecDev.APIRealismMagical.persistence.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookDTOTOBook implements IMapper<BookDTO, Book>{

    @Override
    public Book map(BookDTO bookDTO) {
        Book book=new Book();
        book.setName(bookDTO.getName());
        book.setYear(bookDTO.getYear());
        book.setEditorial(bookDTO.getEditorial());
        book.setNumberOfPages(bookDTO.getNumberOfPages());
        return book;
    }
}
