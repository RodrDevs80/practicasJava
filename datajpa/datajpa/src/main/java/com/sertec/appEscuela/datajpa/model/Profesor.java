package com.sertec.appEscuela.datajpa.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "profesores")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre_profesor",nullable = false)
    private String nombre;
    @Column(name = "apellido_profesor",nullable = false)
    private String apellido;

    @OneToMany(mappedBy = "profesor",cascade = CascadeType.ALL)
    private Set<Curso> cursos=new HashSet<>();

    @Override
    public String toString() {
        return "Profesor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
