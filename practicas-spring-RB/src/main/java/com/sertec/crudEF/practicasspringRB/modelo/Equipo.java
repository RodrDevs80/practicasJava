package com.sertec.crudEF.practicasspringRB.modelo;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "equipos")
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombre_pais",nullable = false)
    private String nombrePais;
    @Column(name = "confederacion",nullable = false)
    private String confederacion;
    @Column(name = "rankig_fifa",nullable = false)
    private int rankingFifa;

    @Override
    public String toString() {
        return "Equipo{" +
                "nombrePais='" + nombrePais + '\'' +
                ", confederacion='" + confederacion + '\'' +
                ", rankingFifa=" + rankingFifa +
                '}';
    }
}
