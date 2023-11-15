package org.example;
/*
* "!Bienvenido! En esta aplicación podrán gestionar las notas de su materia"
*
* */

import java.util.Scanner;

public class EjercicioPromedio {
    public static void main(String[] args) {
        final int porcentaje = 100;
        System.out.println("!Bienvenido! En esta aplicación podrán gestionar las notas de su materia");
        Scanner entrada= new Scanner(System.in);
        System.out.println("Ingrese su nombre completo: ");
        String nombreAlumno = entrada.nextLine();
        System.out.println("Ingrese la materia: ");
        String materia = entrada.nextLine();
        boolean bandera = true;
        float promedio;
        int sumaNotas = 0;
        int contador = 0;
        int sumaPorcentaje_nota = 0;

        while (bandera){
            System.out.println("Ingrese la nota obtenida: ");
            int nota = entrada.nextInt();
            System.out.println("Ingrese el porcentaje que representa la nota: ");
            int porcentaje_nota = entrada.nextInt();
            sumaNotas+=nota;
            contador++;
            sumaPorcentaje_nota+=porcentaje_nota;
            if(sumaPorcentaje_nota == porcentaje){
                bandera = false;
            }else if (porcentaje_nota < porcentaje){
                System.out.println("Ingrese la nota faltante para completar el 100% " +
                        "del porcentaje de evaluacion");
            }else{
                System.out.println("El porcentaje evaluado de una materia no puede ser" +
                        " mayor a 100");
                sumaPorcentaje_nota =0;
            }

        }
        promedio = sumaNotas / contador;
        System.out.println("Nombre del Alumno: "+nombreAlumno);
        System.out.println("Materia: "+materia);
        System.out.println("Promedio: "+ promedio );

    }
}
