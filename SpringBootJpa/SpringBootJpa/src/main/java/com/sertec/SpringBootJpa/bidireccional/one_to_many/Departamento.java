package com.sertec.SpringBootJpa.bidireccional.one_to_many;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "bi_departamentos")
@Table(name = "bi_departamentos")
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @OneToMany(mappedBy = "departamento",cascade = CascadeType.ALL
    ,fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Empleado1> empleado1s;
}
