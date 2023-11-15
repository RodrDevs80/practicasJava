package edu.tienda.core.domain;

import com.googlecode.jmapper.annotations.JMap;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @JMap
    private Integer id;
    @JMap
    private String nombre;
    private Double precio;
    private Integer stock;
}


