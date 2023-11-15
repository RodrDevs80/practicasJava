package com.sertec.crudEF.practicasspringRB.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundo {

    @GetMapping("/hola/{usuario}")
    public String saludar(@PathVariable String usuario){
        return "Hola usuario: "+ usuario;
    }
    @GetMapping("/sumar/{a}/{b}")
    public int suma(@PathVariable int a, @PathVariable int b){
     int total=a+b;
     return total;
    }
}
