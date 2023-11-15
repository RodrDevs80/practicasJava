package com.sertec.SpringBootJpa.bidireccional.one_to_one;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "bi_estacionamiento")
@Table(name = "bi_estacionamiento")
public class LugarDeEstacionamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "estacionamiento")
    private Empleado empleado;
}
