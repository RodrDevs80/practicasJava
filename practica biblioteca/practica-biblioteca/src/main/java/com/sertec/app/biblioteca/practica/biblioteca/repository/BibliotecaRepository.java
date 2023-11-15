package com.sertec.app.biblioteca.practica.biblioteca.repository;

import com.sertec.app.biblioteca.practica.biblioteca.entity.Biblioteca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BibliotecaRepository extends JpaRepository<Biblioteca,Integer> {

}
