package com.sertec.listaDeTareas.model;

import jakarta.validation.constraints.NotNull;

public record TaskDatosLista( @NotNull
                             Long id,
                             @NotNull
                             String title,
                             @NotNull
                             String descripcion) {

    public TaskDatosLista(Task task) {
        this(task.getId(), task.getTitle(), task.getDescripcion());
    }


}
