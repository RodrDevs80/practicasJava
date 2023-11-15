package com.sertecDev.APIRealismMagical.mapper;

import com.sertecDev.APIRealismMagical.DTO.AuthorRespuestaDTO;
import com.sertecDev.APIRealismMagical.persistence.entity.Author;

public class AuthorRespuestaDTOToAuthor implements IMapper<AuthorRespuestaDTO,Author>{
    @Override
    public Author map(AuthorRespuestaDTO respuestaDTO) {
        Author author=new Author();
        author.setName(respuestaDTO.getName());
        author.setBirthdate(respuestaDTO.getBirthdate());
        author.setNationality(respuestaDTO.getNationality());
        author.setDescription(respuestaDTO.getDescription());
        author.setBooks(respuestaDTO.getBooks());
        return author;
    }
}
