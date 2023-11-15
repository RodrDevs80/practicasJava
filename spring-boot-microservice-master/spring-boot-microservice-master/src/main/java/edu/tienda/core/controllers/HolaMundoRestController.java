package edu.tienda.core.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class HolaMundoRestController {

    @GetMapping("/hola")
    public String saludo(HttpServletResponse response){
        System.out.println("Ejecutando el metodo saludo");
        response.addHeader("Content-Security-Policy", "frame-ancestors http://localhost:8081");
        return "<h1>Ejemplo</h1>";
    }

}
