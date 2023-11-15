package com.lombok.app;

import lombok.*;
import lombok.experimental.FieldDefaults;


import java.time.LocalDate;

/*@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder*/
@Value
@RequiredArgsConstructor
@ToString(includeFieldNames = false)
public class Persona {

    Long id;
    @NonNull
    String nombre;
    @NonNull
    String apellido;
    String email;
    Integer edad;
    Integer telefono;
    LocalDate fechaDeNacimiento;

}
