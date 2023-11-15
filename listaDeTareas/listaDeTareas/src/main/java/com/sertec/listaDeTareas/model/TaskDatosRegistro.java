package com.sertec.listaDeTareas.model;

import jakarta.validation.constraints.NotNull;

public record TaskDatosRegistro(
                                Long id,
                                @NotNull
                                String title,
                                @NotNull
                                String descripcion) {
}
