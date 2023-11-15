package com.sertecDev.APIRealismMagical.controller;

import com.sertecDev.APIRealismMagical.DTO.BookDTO;
import com.sertecDev.APIRealismMagical.persistence.entity.Book;
import com.sertecDev.APIRealismMagical.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
@RestController
@RequestMapping("/api_library")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/create_book")
    public ResponseEntity<?> createAuthor(@RequestBody BookDTO bookDTO){
        Book book=bookService.createBook(bookDTO);

        URI url= ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(book.getId()).toUri();

        return ResponseEntity.created(url).body("book created successfully");
    }
    @GetMapping("/books")
    public ResponseEntity<Page<?>> findAllBook(){
        Page page=new PageImpl( bookService.findAllBook());
        return ResponseEntity.ok(page);
    }

    @GetMapping("/findByIdBook/{id}")
    public ResponseEntity<?> findByIdBook(@PathVariable Long id){
        Book serviceById = bookService.findById(id);
        if (serviceById==null){
            return ResponseEntity.badRequest().body("The id does not exist");
        }
        return ResponseEntity.ok(serviceById);
    }

    @DeleteMapping("/deleteByIdBook/{id}")
    public ResponseEntity<?>  deleteByIdBook(@PathVariable Long id){
        boolean flag= bookService.deleteByIdBook(id);
        if (flag==false){
            return ResponseEntity.badRequest().body("The id does not exist");
        }
        return ResponseEntity.ok("Book Deleted Successfully");
    }

    @PutMapping("/updateBook/{id}")
    public ResponseEntity<?> updateBookById(@PathVariable Long id,@RequestBody BookDTO bookDTO){
        Book book = bookService.updateBookById(id, bookDTO);
        if (book==null){
            return ResponseEntity.badRequest()
                    .body("The book with the ID you are trying to modify does not exist");
        }
        return ResponseEntity.ok("The book was successfully updated");
    }
}
