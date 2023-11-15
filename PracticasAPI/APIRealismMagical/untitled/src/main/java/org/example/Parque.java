package org.example;

import java.util.Scanner;

public class Parque {
    /*
    * Escribir un programa que solicite al usuario su edad y estatura,
    * y que determine si cumple con los requisitos para subir a la atracción.
    * Si cumple con ambos requisitos, el programa debe imprimir "¡Puede acceder!"
    * en la pantalla. Si no cumple con alguno de los requisitos, el programa debe imprimir
    * un mensaje que indique el motivo por el cual no puede subir. Por ejemplo,
    * si no cumple con el requisito de la edad, el programa debe imprimir
    * "Lo siento, eres demasiado joven para acceder." Si no cumple con el requisito de la estatura,
    * el programa debe imprimir "Lo siento, eres demasiado bajo para acceder"
    * */

    public static void main(String[] args) {

        int edadMinima = 10;
        double alturaMinima = 1.60;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese su nombre: ");
        String nombre = entrada.next();
        System.out.println("Ingrese su edad: ");
        String edad = entrada.next();
        Integer intEdad = Integer.valueOf(edad);
        System.out.println("Ingrese su altura: ");
        String altura = entrada.next();
        double doubleAltura = Double.parseDouble(altura);

        boolean edadYAlturaOk = intEdad >= edadMinima && doubleAltura > alturaMinima;
        boolean noPasaEdad = intEdad < edadMinima;


        if(edadYAlturaOk){
            System.out.println(nombre +" ¡Puede acceder!");
        } else if (noPasaEdad) {
            System.out.println("Lo siento " + nombre +", eres demasiado joven para acceder.");
        }else {
            System.out.println("Lo siento "+ nombre +", eres demasiado bajo para acceder");
        }


    }
}
