package com.sertec.SpringBootJpa.bidireccional.many_to_one;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "bi_escuela_many_to_one")
@Table(name = "bi_escuela_many_to_one")
public class Escuela {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @OneToMany(mappedBy = "escuela",cascade = CascadeType.ALL
    ,fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Estudiante> estudiantes;

}
