package edu.tienda.core.persistance.entities;

import com.googlecode.jmapper.annotations.JMap;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="productos")
@Data
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JMap
    private Integer id;
    @JMap
    private String nombre;
    private Double precio;
    private Integer stock;


}
