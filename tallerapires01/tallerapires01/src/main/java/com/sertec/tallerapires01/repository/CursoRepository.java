package com.sertec.tallerapires01.repository;

import com.sertec.tallerapires01.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path = "cursos",collectionResourceRel = "cursos")
public interface CursoRepository extends JpaRepository<Curso,Long> {
}
