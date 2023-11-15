package org.example;

import java.util.Scanner;

/*
*Ejercicio 029
Escribir un programa que permita Ingresar las notas de los dos parciales de
un alumno e indicar si promocionó, aprobó o debe recuperar.
Si el valor de la nota no esta entre 0 y 10, debe informar un error.
Se promociona cuando las notas de ambos parciales son mayores o iguales a 7.
Se aprueba cuando las notas de ambos parciales son mayores o iguales a 4.
Se debe recuperar cuando al menos una de las dos notas es menor a 4.
"""
* */
public class Promociona {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Igrese el nombre del alumno: ");
        String nombre = entrada.next();
        System.out.println("Igrese el nombre del espacio curricular: ");
        String materia = entrada.next();
        System.out.println("Igrese la nota del parcial 1: ");
        int parcial1 = Integer.parseInt(entrada.next());
        System.out.println("Igrese la nota del parcial 2: ");
        int parcial2 = Integer.parseInt(entrada.next());
        String mensaje= "";
        boolean promociona = parcial1 >= 7 && parcial2 >=7;
        boolean aprueba = parcial1 >= 4 && parcial2 >=4;


        if((parcial1 >= 0 && parcial1 <=10) && (parcial2 >= 0 && parcial2 <=10)  ){
           if (promociona){
               mensaje =nombre+", usted promociona ==>"+materia;
           } else if (aprueba) {
               mensaje =nombre+", usted aprueba ==>"+materia;
           }
           else {
               mensaje =nombre+", usted recupera ==>"+materia;
           }

        }else{
            mensaje= "ERROR==> los datos ingresados estan fuera de rango!!!";
        }

        System.out.println(mensaje);

    }
}
