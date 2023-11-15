package com.sertecDev.APIRealismMagical.mapper;

import com.sertecDev.APIRealismMagical.DTO.AuthorDTO;
import com.sertecDev.APIRealismMagical.persistence.entity.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorDTOToAuthor implements IMapper<AuthorDTO,Author>{
    @Override
    public Author map(AuthorDTO authorDTO) {
        Author author=new Author();
        author.setName(authorDTO.getName());
        author.setBirthdate(authorDTO.getBirthdate());
        author.setNationality(authorDTO.getNationality());
        author.setDescription(authorDTO.getDescription());
        return author;
    }
}
