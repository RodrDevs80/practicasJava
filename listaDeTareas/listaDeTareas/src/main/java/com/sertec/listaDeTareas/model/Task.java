package com.sertec.listaDeTareas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title",nullable = false)
    private String title;
    @Column(name = "descripcion",nullable = false,columnDefinition = "VARCHAR(700)")
    private String descripcion;
    private boolean active;

    public Task(TaskDatosRegistro taskDatosRegistro) {
        this.active=true;
        this.title= taskDatosRegistro.title();
        this.descripcion= taskDatosRegistro.descripcion();
    }

    public void desactivarTask(Long id) {
        this.active=false;
    }

    public void updateTask(TaskDatosActualizar taskDatosActualizar) {
        if (this.title!= taskDatosActualizar.title()){
            this.title= taskDatosActualizar.title();
        }
        if (this.descripcion!= taskDatosActualizar.descripcion()){
            this.descripcion= taskDatosActualizar.descripcion();
        }

    }
}
