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
@Table(name = "estudiantes")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre_estudiante",nullable = false)
    private String nombre;
    @Column(name = "apellido_estudiante",nullable = false)
    private String apellido;
    @Column(name = "fecha_de_nacimiento",nullable = false)
    private LocalDate fechaDeNacimiento;

    @OneToOne(mappedBy = "estudiante",cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private InformacionDeContacto informacionDeContacto;

    @ManyToMany
    @JoinTable(name = "estudiantes_curso",joinColumns =
    @JoinColumn(name = "estudiante_id"),inverseJoinColumns =@JoinColumn(name = "curso_id") )
    private Set<Curso> cursos=new HashSet<>();

    @Override
    public String toString() {
        return "Estudiante{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaDeNacimiento=" + fechaDeNacimiento +
                '}';
    }
}
