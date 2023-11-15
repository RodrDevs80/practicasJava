package org.example;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

public class Utilitarios {
    public static String calcularPromedio(List<Float> jugadores) {
        Double suma;
        Double promedio = 0.0;
        suma = jugadores.stream().mapToDouble(Float::doubleValue).sum();
        int size = jugadores.size();
        // Crear un objeto DecimalFormat con el formato deseado
        DecimalFormat df = new DecimalFormat("#.##");
        String format = df.format(suma / size);
        return format;
    }

    public static Persona menorPersona(List<Persona> personaList) {
        Persona menorPersona = new Persona();
        int edadMenor = 9999;
        String nombreMenor = "";
        for (Persona persona : personaList) {
            if (persona.getEdad() < edadMenor) {
                edadMenor = persona.getEdad();
                nombreMenor = persona.getNombre();
            }

        }
        menorPersona.setNombre(nombreMenor);
        menorPersona.setEdad(edadMenor);
        return menorPersona;
    }

    public static int validarUsuario(int contador, int limite, Scanner entrada, String nombre, String pass){
        while (contador < limite) {
            System.out.println("Ingrese su nombre de usuario: ");
            String nombreUsuario = entrada.next();
            System.out.println("Ingrese su password:  ");
            String password = entrada.next();
            if (nombre.equals(nombreUsuario) && pass.equals(password)) {
                break;
            } else if (nombre.equals(nombreUsuario)) {
                System.out.println("El nombre de usuario es correcto,pero el password no lo es!!!");
            } else if (pass.equals(password)) {
                System.out.println("El password del usuario es correcto,pero el nombre no lo es!!!");
            } else {
                System.out.println("El usuario y password no son correctos");
            }
            contador++;
        }
        return  contador;
    }
}
