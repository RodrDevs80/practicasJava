package com.sertec.appEscuela.datajpa.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "informacion_de_contacto")
public class InformacionDeContacto {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estudiante_id")
    private Long id;
    @Column(name = "email",nullable = false)
    private String email;
    @Column(name = "telefono",nullable = false)
    private String telefono;
    @Column(name = "direccion",nullable = false)
    private String direccion;
    @Column(name = "ciudad",nullable = false)
    private String ciudad;
    @Column(name = "provincia",nullable = false)
    private String provincia;
    @Column(name = "codigo_postal",nullable = false)
    private String codigoPostal;

    @OneToOne(cascade = CascadeType.ALL,optional = false)
    @MapsId
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;
    @Override
    public String toString() {
        return "InformacionDeContacto{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", provincia='" + provincia + '\'' +
                ", codigoPostal='" + codigoPostal + '\'' +
                '}';
    }
}
