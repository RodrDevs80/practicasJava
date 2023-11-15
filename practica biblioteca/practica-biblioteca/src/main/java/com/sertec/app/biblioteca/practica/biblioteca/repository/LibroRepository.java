package com.sertec.app.biblioteca.practica.biblioteca.repository;

import com.sertec.app.biblioteca.practica.biblioteca.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {

}
