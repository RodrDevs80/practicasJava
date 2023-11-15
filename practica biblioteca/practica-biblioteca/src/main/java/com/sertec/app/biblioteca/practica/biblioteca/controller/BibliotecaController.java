package com.sertec.app.biblioteca.practica.biblioteca.controller;

import com.sertec.app.biblioteca.practica.biblioteca.entity.Biblioteca;
import com.sertec.app.biblioteca.practica.biblioteca.repository.BibliotecaRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/biblioteca")
public class BibliotecaController {
  private BibliotecaRepository bibliotecaRepository;

    public BibliotecaController(BibliotecaRepository bibliotecaRepository) {
        this.bibliotecaRepository = bibliotecaRepository;
    }
    @GetMapping
    public ResponseEntity<Page<Biblioteca>> listarBibliotecas(Pageable pageable){
        return ResponseEntity.ok(bibliotecaRepository.findAll(pageable));
    }
    @PostMapping
    public ResponseEntity<Biblioteca> guardarBiblioteca(@Valid @RequestBody Biblioteca biblioteca){
        Biblioteca bibliotecaGuardada = bibliotecaRepository.save(biblioteca);
        URI url= ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(bibliotecaGuardada.getId()).toUri();

        return ResponseEntity.created(url).body(bibliotecaGuardada);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteBiblioteca(@Valid @PathVariable Integer id){
        Biblioteca bibliotecaABorrar = bibliotecaRepository.getReferenceById(id);
        bibliotecaRepository.delete(bibliotecaABorrar);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Biblioteca> actualizarBiblioteca
            (@Valid @PathVariable Integer id,@Valid @RequestBody Biblioteca biblioteca){
        //Biblioteca bibliotecaActualizar = bibliotecaRepository.getReferenceById(id);
        Optional<Biblioteca> bibliotecaOptional=bibliotecaRepository.findById(id);
        if (!bibliotecaOptional.isPresent()){
          return ResponseEntity.unprocessableEntity().build();
        }

        biblioteca.setId(bibliotecaOptional.get().getId());
        bibliotecaRepository.save(biblioteca);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Biblioteca> obtenerBibliotecaPorId(@Valid @PathVariable Integer id){
        Optional<Biblioteca> bibliotecaOptional=bibliotecaRepository.findById(id);
        if (!bibliotecaOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        Biblioteca biblioteca = bibliotecaRepository.getReferenceById(id);

        return ResponseEntity.ok(biblioteca);
    }

}
