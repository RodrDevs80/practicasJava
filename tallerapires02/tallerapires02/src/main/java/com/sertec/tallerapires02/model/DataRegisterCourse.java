package com.sertec.tallerapires02.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataRegisterCourse(Long id, @NotBlank String title,@NotNull Float price) {
}
