package org.example;

import java.util.Scanner;

public class PrimeroIMM {
    public static void main(String[] args) {
        Scanner  entrada = new Scanner(System.in);
        int contador = 0;
        int cantidadDeNumeros= 2;
        int [] numeros = new int[cantidadDeNumeros];

        System.out.println("Ingrese dos Numeros enteros: ");
        while (contador < cantidadDeNumeros){
            System.out.println("Ingrese el "+(contador+1)+"° numero");
                numeros[contador] = entrada.nextInt();
                contador++;
        }
        boolean esIgual = numeros[0] == numeros[1];
        boolean esMayor = numeros[0] > numeros[1];
        boolean esMenor = numeros[0] < numeros[1];

       if (esIgual){
           System.out.println("El primer numero es igual al segundo");
       } else if (esMayor) {
           System.out.println("El primer numero es mayor al segundo");
       } else {
           System.out.println("El primer numero es menor al segundo");
       }


    }
}
