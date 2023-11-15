package com.sertecDev.APIRealismMagical.service;

import com.sertecDev.APIRealismMagical.DTO.AuthorDTO;
import com.sertecDev.APIRealismMagical.DTO.AuthorRespuestaDTO;
import com.sertecDev.APIRealismMagical.mapper.AuthorDTOToAuthor;
import com.sertecDev.APIRealismMagical.mapper.AuthorRespuestaDTOToAuthor;
import com.sertecDev.APIRealismMagical.mapper.BookDTOTOBook;
import com.sertecDev.APIRealismMagical.persistence.entity.Author;
import com.sertecDev.APIRealismMagical.persistence.repository.AuthorRepository;
import com.sertecDev.APIRealismMagical.persistence.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorService {
  private AuthorRepository authorRepository;
  private AuthorDTOToAuthor dtoToAuthor;
  private AuthorRespuestaDTOToAuthor authorRespuestaDTOToAuthor;

    public AuthorService(AuthorRepository authorRepository, AuthorDTOToAuthor dtoToAuthor, BookRepository bookRepository, BookDTOTOBook bookDTOTOBook, BookService bookService) {
        this.authorRepository = authorRepository;
        this.dtoToAuthor = dtoToAuthor;
    }

    public List<AuthorRespuestaDTO> findAll(){
        List<Author> authors = authorRepository.findAll();
        List<AuthorRespuestaDTO> authorRespuestaDTOS = authors.stream().map(AuthorRespuestaDTO::new).collect(Collectors.toList());
        return authorRespuestaDTOS;
    }
    public Author createAuthor(AuthorDTO authorDTO){
        Author author=dtoToAuthor.map(authorDTO);
        return authorRepository.save(author);
    }
    public boolean deleteByIdAuthor(Long id){
        Optional<Author> authorOptional = authorRepository.findById(id);
        if (authorOptional.isPresent()) {
            authorRepository.deleteById(id);
            return true;
        }
         return false;
    }

    public Author findByIdAuthor(Long id){
        Optional<Author> authorOptional = authorRepository.findById(id);
        if (authorOptional.isPresent()){
            Author author = authorOptional.get();
            return author;
        }
        return null;
    }

   public Author updateAuthor(Long id,AuthorDTO authorDTO){
       Optional<Author> authorOptional = authorRepository.findById(id);
       if (authorOptional.isPresent()){
           Author author = authorOptional.get();
           author.setName(authorDTO.getName());
           author.setDescription(authorDTO.getDescription());
           author.setBirthdate(authorDTO.getBirthdate());
           author.setNationality(authorDTO.getNationality());
           authorRepository.save(author);
           return author;
       }
       return null;

   }

   @Transactional
   public Author findByName(String name){
       Optional<Author> authorOptional = authorRepository.findByName(name);
       if (authorOptional.isPresent()){
           return authorOptional.get();
       }
       return null;
   }
}
