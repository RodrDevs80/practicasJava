package com.sertec.SpringBootJpa.bidireccional.one_to_many;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "bi_empleado_one_to_mamy")
@Table(name = "bi_empleado_one_to_mamy")
public class Empleado1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "id_departamento")
    private Departamento departamento;
}
