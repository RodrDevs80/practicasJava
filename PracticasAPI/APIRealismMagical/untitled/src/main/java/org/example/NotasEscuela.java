package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* array Double promedio (suma) max min cantidad;*/
public class NotasEscuela {

    public static void main(String[] args) {
        List<Double> notas = new ArrayList<>();
        boolean bandera = true;
        int contador = 1;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el nombre del estudiante: ");
        String nombre = entrada.next();
        System.out.println("Ingrese la materia: ");
        String materia = entrada.next();

        while (bandera){
            System.out.println("Ingrese la calificacion N°" +contador+":");
            String not = entrada.next();
            double nota = Double.parseDouble(not);
            notas.add(nota);
            contador++;
            System.out.println("¿Desea ingresar una calificacion mas? S/N");
            String masNota = entrada.next();
            boolean noMasNota = masNota.equals("N") || masNota.equals("n");
            if (noMasNota){
                List<Double> operaciones = operaciones(notas);
                mostrarDatos(nombre,materia,notas,operaciones);
                bandera = false;

            }

        }

    }
    public  static List<Double> operaciones(List<Double> notas){
        Double promedio = 0.0;
        List<Double> operaciones = new ArrayList<>();
        Double minimo = notas.stream().min(Double::compareTo).get();
        Double maximo = notas.stream().max(Double::compareTo).get();
        Double suma = notas.stream().mapToDouble(Double::doubleValue).sum();
        promedio = suma / notas.size();
        operaciones.add(promedio);
        operaciones.add(maximo);
        operaciones.add(minimo);
        return  operaciones;
    }
    public static void mostrarDatos(String nombre,String materia,
                                    List<Double> notas,List<Double> operaciones){
        System.out.println("El nombre del alumno es: "+nombre);
        System.out.println("La materia es: "+materia);
        System.out.println("El promedio del alumno es: " + operaciones.get(0));
        System.out.println("La nota maxima es: "+ operaciones.get(1));
        System.out.println("La nota minima es: "+ operaciones.get(2));
        for (Double nota:notas){
            System.out.println(nota);
        }

    }

}
