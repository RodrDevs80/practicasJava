package com.sertec.app.biblioteca.practica.biblioteca.controller;

import com.sertec.app.biblioteca.practica.biblioteca.entity.Biblioteca;
import com.sertec.app.biblioteca.practica.biblioteca.entity.Libro;
import com.sertec.app.biblioteca.practica.biblioteca.repository.BibliotecaRepository;
import com.sertec.app.biblioteca.practica.biblioteca.repository.LibroRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/libros")
public class LibroController {
    private BibliotecaRepository bibliotecaRepository;
    private LibroRepository libroRepository;
    public LibroController(BibliotecaRepository bibliotecaRepository, LibroRepository libroRepository) {
        this.bibliotecaRepository = bibliotecaRepository;
        this.libroRepository = libroRepository;
    }

    @PostMapping
    public ResponseEntity<Libro> guardarLibro(@Valid @RequestBody Libro libro){
        Optional<Biblioteca> bibliotecaOptional=bibliotecaRepository
                .findById(libro.getBiblioteca().getId());
        System.out.println(bibliotecaOptional.get());

        if(!bibliotecaOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        libro.setBiblioteca(bibliotecaOptional.get());

        Libro libroGuardado=libroRepository.save(libro);
        URI url=ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(libroGuardado.getId()).toUri();
        return ResponseEntity.created(url).body(libroGuardado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> editarLibro(@PathVariable Integer id,@Valid @RequestBody Libro libro){
        Optional<Biblioteca> bibliotecaOptional=bibliotecaRepository
                .findById(libro.getBiblioteca().getId());

        if(!bibliotecaOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        Optional<Libro> libroOptional=libroRepository.findById(id);
        if(!libroOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        libro.setBiblioteca(bibliotecaOptional.get());
        libro.setId(libroOptional.get().getId());
        libroRepository.save(libro);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Libro> eliminarLibro(@PathVariable Integer id){
        Optional<Libro> libroOptional=libroRepository.findById(id);

        if(!libroOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        libroRepository.delete(libroOptional.get());
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<Libro>> listarLibros(Pageable pageable){
        return ResponseEntity.ok(libroRepository.findAll(pageable));

    }
    @GetMapping("/{id}")
    public ResponseEntity<Libro> obtenerLibroPorId(@PathVariable Integer id){
        Optional<Libro> libroOptional=libroRepository.findById(id);

        if(!libroOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(libroOptional.get());

    }
    @GetMapping("/librosPorBiblioteca/{idBiblioteca}")
    public ResponseEntity<Page<Libro>> librosPorBiblioteca
            (@Valid @PathVariable Integer idBiblioteca,Pageable pageable){
        List<Libro> listaRespuesta=new ArrayList<>();

        Optional<Biblioteca> bibliotecaOptional=bibliotecaRepository
                .findById(idBiblioteca);
        if (!bibliotecaOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        Page<Libro> libroList = libroRepository.findAll(pageable);

       for (Libro libro:libroList){
           if(bibliotecaOptional.get().getId()==libro.getBiblioteca().getId()){
               listaRespuesta.add(libro);
           }

       }
       System.out.println(listaRespuesta.toString());
        Page<Libro> libroPage=new PageImpl<>(listaRespuesta);
        return ResponseEntity.ok(libroPage);

    }

    @GetMapping("/librosPorNombreBiblioteca/{nombreBiblioteca}")
    public ResponseEntity<Page<Libro>> librosPorNombreDEBiblioteca
            (@Valid @PathVariable String nombreBiblioteca,Pageable pageable){
        Integer idB=null;
        List<Libro> listaRespuesta=new ArrayList<>();
        System.out.println(nombreBiblioteca);
        List<Biblioteca> bibliotecaList=bibliotecaRepository.findAll();
        System.out.println(bibliotecaList.toString());
        for (Biblioteca biblioteca:bibliotecaList){
            if (nombreBiblioteca.equals(biblioteca.getNombre())){
                idB=biblioteca.getId();
            }
        }
        System.out.println(idB);
       if (idB==null){
            return ResponseEntity.unprocessableEntity().build();
        }

        Page<Libro> libroList = libroRepository.findAll(pageable);

        for (Libro libro:libroList){
            if(idB==libro.getBiblioteca().getId()){
                listaRespuesta.add(libro);
            }

        }
        System.out.println(listaRespuesta.toString());
        Page<Libro> libroPage=new PageImpl<>(listaRespuesta);
        return ResponseEntity.ok(libroPage);

    }
}
