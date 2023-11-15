package com.sertecDev.APIRealismMagical.service;

import com.sertecDev.APIRealismMagical.DTO.BookDTO;
import com.sertecDev.APIRealismMagical.mapper.BookDTOTOBook;
import com.sertecDev.APIRealismMagical.persistence.entity.Author;
import com.sertecDev.APIRealismMagical.persistence.entity.Book;
import com.sertecDev.APIRealismMagical.persistence.repository.AuthorRepository;
import com.sertecDev.APIRealismMagical.persistence.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {
    private BookRepository bookRepository;
    private BookDTOTOBook bookDTOTOBook;
    private AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, BookDTOTOBook bookDTOTOBook, AuthorRepository authorRepository, AuthorRepository authorRepository1) {
        this.bookRepository = bookRepository;
        this.bookDTOTOBook = bookDTOTOBook;
        this.authorRepository = authorRepository1;
    }

    public Book createBook(BookDTO bookDTO){
        Optional<Author> authorOptional = authorRepository.findById(bookDTO.getAuthor().getId());

        if (authorOptional.isPresent()){
            Author authorExistente = authorOptional.get();
            Book book=new Book(bookDTO.getName(),bookDTO.getEditorial()
                    ,bookDTO.getYear(),bookDTO.getNumberOfPages()
                    ,authorExistente);
            return bookRepository.save(book);
        }
        Author save = authorRepository.save(new Author(bookDTO.getAuthor().getName(),
                bookDTO.getAuthor().getBirthdate(), bookDTO.getAuthor().getNationality()
                , bookDTO.getAuthor().getDescription()));

        Book book=new Book(bookDTO.getName(),bookDTO.getEditorial()
                ,bookDTO.getYear(),bookDTO.getNumberOfPages()
                ,save);
        return bookRepository.save(book);

    }

    public List<BookDTO> findAllBook(){
        List<Book> books = bookRepository.findAll();
      return books.stream().map(BookDTO::new).collect(Collectors.toList());
    }

    public Book findById(Long id){
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()){
            return optionalBook.get();
        }
        return null;
    }

    public boolean deleteByIdBook(Long id){
        boolean flag=false;
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()){
            Book book = optionalBook.get();
            bookRepository.delete(book);
            flag=true;
            return flag;
        }
        return flag;
    }

    public Book updateBookById(Long id,BookDTO bookDTO){
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()){
            Book bookUpdate = optionalBook.get();
            bookUpdate.setName(bookDTO.getName());
            bookUpdate.setYear(bookDTO.getYear());
            bookUpdate.setEditorial(bookDTO.getEditorial());
            bookUpdate.setNumberOfPages(bookDTO.getNumberOfPages());
            Optional<Author> authorOptional = authorRepository
                    .findById(optionalBook.get().getAuthor().getId());
            if (authorOptional.isPresent()){
                Author author = authorOptional.get();
                bookUpdate.setAuthor(author);
                bookRepository.save(bookUpdate);
                return bookUpdate;
            }
            Author newAuthor = new Author(bookDTO.getAuthor().getName()
                    ,bookDTO.getAuthor().getBirthdate(),bookDTO.getAuthor().getNationality()
                    ,bookDTO.getAuthor().getDescription());
            authorRepository.save(newAuthor);
            bookUpdate.setAuthor(newAuthor);
            bookRepository.save(bookUpdate);
            return bookUpdate;
        }
        return null;
    }
}
