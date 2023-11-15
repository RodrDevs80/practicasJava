package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Integer limiteInferior = 0;
        Integer limiteSuperior = 20;
        Integer numeroGanador = numeroRandom(limiteInferior,limiteSuperior);
        Integer numeroJugador;
        boolean bandera = true;
        Integer contador = 0;


        while (bandera){
            numeroJugador = ingresarNumero(limiteInferior, limiteSuperior);
            boolean esNegativo = numeroJugador < limiteInferior;
            boolean esMayorAlLimiteS = numeroJugador > limiteSuperior;
            if(esNegativo || esMayorAlLimiteS){
                System.out.println("El numero ingresado esta fuera del intervalo, ingrese otro numero");
            } else if (numeroJugador==numeroGanador) {
                System.out.println("MUY BIEN ACERTASTE!!!");
                System.out.println("Tu numero de intentos fue: "+contador);
                bandera = false;
            } else if (numeroJugador < numeroGanador) {
                System.out.println("Te quedaste corto, prueba de nuevo!!!");
                contador++;
            } else  {
                System.out.println("Te pasaste, intenta de nuevo!!!");
                contador++;
            }

        }

    }
    public  static int numeroRandom(Integer limiteInferior,Integer limiteSuperior){
      return   (int) ((Math.random() * (limiteSuperior - limiteInferior + 1)) + limiteInferior);

    }
    public static Integer ingresarNumero(Integer limiteInferior,Integer limiteSuperior){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese un numero entre " + limiteInferior + " y " + limiteSuperior);
        Integer numeroJugador = entrada.nextInt();
        return numeroJugador;
    }

}