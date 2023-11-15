package com.lombok.app;

import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Slf4j
public class App {
    public static void main( String[] args ) {

        Persona persona=
                new Persona(1L,
                        "Carlos",
                        "Rodriguez",
                        "libertad-cer@gmail.com",
                        43,
                        418268, LocalDate.now());

       /* Persona persona1= Persona
                .builder()
                .id(2L)
                .nombre("Juan")
                .apellido("Ramirez")
                .edad(23)
                .build();*/


    log.info(persona.toString());
       System.out.println(persona);
        //System.out.println(persona1);
    }
}
