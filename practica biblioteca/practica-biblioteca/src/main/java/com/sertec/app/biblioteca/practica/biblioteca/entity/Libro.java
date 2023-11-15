package com.sertec.app.biblioteca.practica.biblioteca.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @NotNull
    String nombre;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    //@ManyToOne
    @JoinColumn(name = "id_biblioteca")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    Biblioteca biblioteca;
}
