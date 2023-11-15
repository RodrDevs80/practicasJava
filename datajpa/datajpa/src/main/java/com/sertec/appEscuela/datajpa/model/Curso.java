package com.sertec.appEscuela.datajpa.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre_curso",nullable = false)
    private String nombre;
    @ManyToOne(fetch = FetchType.EAGER)
    private Profesor profesor;

    @ManyToMany(mappedBy = "cursos")
    private Set<Estudiante> estudiantes=new HashSet<>();

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
