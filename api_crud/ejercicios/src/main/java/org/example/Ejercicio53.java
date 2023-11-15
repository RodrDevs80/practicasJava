package org.example;
/*Escribir un programa que permita ingresar nombre y edad de un grupo de personas (para cada una, nombre y edad).
La carga termina cuando en el nombre de la persona se ingresa un asterisco ('*').
Mostrar al final cómo se llama la persona más joven.*/

import org.example.Utilitarios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio53 {
    public static void main(String[] args) {
        boolean bandera = true;
        int contador = 1;
        List<Persona> personas = new ArrayList<>();
        Scanner entrada = new Scanner(System.in);
        while (bandera) {
            System.out.println("Ingrese el nombre de la N°" + contador + " persona: ");
            String nombre = entrada.next();
            if (!nombre.equals("*")) {
                System.out.println("Ingrese la edad de la N°" + contador + " persona: ");
                String edadS = entrada.next();
                try {
                    int edad = Integer.parseInt(edadS);
                    personas.add(new Persona(nombre, edad));
                    contador++;

                } catch (NumberFormatException e) {
                    System.out.println("Error: no es una edad valida -->" + e);

                }

            } else {
                bandera = false;
                System.out.println("Lista de perosnas cargadas: ");
                for (Persona persona : personas) {
                    System.out.println("Nombre: " + persona.getNombre() + " Edad: " + persona.getEdad());
                }
                Persona menorPersona = Utilitarios.menorPersona(personas);

                System.out.println("La persona de menor edad es: ");
                System.out.println("Nombre: " + menorPersona.getNombre());
                System.out.println("Edad: " + menorPersona.getEdad());
            }

        }

    }

}
