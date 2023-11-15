package org.example;

import java.util.Scanner;

/*
*Crear un programa que pida un número de mes (ejemplo 4)
y escriba el nombre del mes en letras ("abril").
Verificar que el mes sea válido e informar en caso que no lo sea.
*
*
* */
public class Mes {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese un mes del año expresado en un  numero: ");
        int mes = Integer.parseInt(entrada.next());

        switch (mes) {
            case 1:
                System.out.println("Enero");
                break;
            case 2:
                System.out.println("Febrero");
                break;
            case 3:
                System.out.println("Marzo");
            case 4:
                System.out.println("Abril");
                break;
            case 5:
                System.out.println("Mayo");
                break;
            case 6:
                System.out.println("Junio");
                break;
            case 7:
                System.out.println("Julio");
                break;
            case 8:
                System.out.println("Agosto");
                break;
            case 9:
                System.out.println("Septiembre");
                break;
            case 10:
                System.out.println("Octubre");
                break;
            case 11:
                System.out.println("Noviembre");
                break;
            case 12:
                System.out.println("Diciembre");
                break;
            default:
                System.out.println("El mes ingresado no existe!!!");
         }

    }


}
