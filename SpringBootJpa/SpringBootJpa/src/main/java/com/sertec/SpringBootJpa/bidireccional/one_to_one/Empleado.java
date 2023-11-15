package com.sertec.SpringBootJpa.bidireccional.one_to_one;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "bi_empleado_one_to_one")
@Table(name = "bi_empleado_one_to_one")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @OneToOne
    @JoinColumn(name = "id_estacionamiento")
    private LugarDeEstacionamiento estacionamiento;

}
