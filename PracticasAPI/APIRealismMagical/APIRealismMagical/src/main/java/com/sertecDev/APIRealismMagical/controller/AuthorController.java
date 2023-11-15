package com.sertecDev.APIRealismMagical.controller;


import com.sertecDev.APIRealismMagical.DTO.AuthorDTO;
import com.sertecDev.APIRealismMagical.DTO.AuthorRespuestaDTO;
import com.sertecDev.APIRealismMagical.DTO.BookDTO;
import com.sertecDev.APIRealismMagical.persistence.entity.Author;
import com.sertecDev.APIRealismMagical.persistence.entity.Book;
import com.sertecDev.APIRealismMagical.service.AuthorService;
import com.sertecDev.APIRealismMagical.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api_library")
public class AuthorController {
    private AuthorService authorService;
    private BookService bookService;
    public AuthorController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @PostMapping("/create_author")
    public ResponseEntity<?> createAuthor(@RequestBody AuthorDTO authorDTO){
        Author author = authorService.createAuthor(authorDTO);

        URI url= ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(author.getId()).toUri();

        return ResponseEntity.created(url).body("Author created successfully");
    }

    @GetMapping("/Authors")
    public ResponseEntity<Page<?>> findAll(){
        List<AuthorRespuestaDTO> respuestaDTOS = authorService.findAll();
        Page pageAuthors=new PageImpl(respuestaDTOS);
        return ResponseEntity.ok(pageAuthors);
    }

    @DeleteMapping("/deleteByIdAuthor/{id}")
    public ResponseEntity<?> deleteByIdAuthor(@PathVariable Long id){
        boolean deleted = authorService.deleteByIdAuthor(id);

        if (deleted==true){
            return ResponseEntity.ok("Author successfully removed");
        }
        return ResponseEntity.badRequest().body("The ID does not exist!!!");
    }

    @GetMapping("/findByIdAuthor/{id}")
    public ResponseEntity<?> findByIdAuthor(@PathVariable Long id){
        Author byIdAuthor = authorService.findByIdAuthor(id);
        if (byIdAuthor==null){
            return ResponseEntity.badRequest().body("The ID does not exist!!!");
        }
        return ResponseEntity.ok(byIdAuthor);
    }

    @PutMapping("/updateAuthor/{id}")
    public ResponseEntity<?> updateAuthor(@PathVariable Long id,@RequestBody AuthorDTO authorDTO){
        Author author = authorService.updateAuthor(id, authorDTO);
        if (author==null){
            return ResponseEntity.badRequest().body("The ID does not exist!!!");
        }
        return ResponseEntity.ok("Author updated successfully");
    }
    @GetMapping("/findByName/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name){
        Author author = authorService.findByName(name);
        if (author==null){
            return ResponseEntity.badRequest().body("The name of the author does not exist!");
        }
        return ResponseEntity.ok(author);
    }

}
