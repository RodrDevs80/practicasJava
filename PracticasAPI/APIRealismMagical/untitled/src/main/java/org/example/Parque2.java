package org.example;

import java.util.Scanner;

/*
* Para acceder a cierta atracción, alcanza con que se cumpla solamente una de
las siguientes condiciones: ser mayor de 6 años o medir más de 1,50 metros.
Escribir un programa en Python que solicite al usuario su edad y estatura,
y que determine si cumple con los requisitos para subir a la atracción.
Si cumple con al menos una de las condiciones, el programa debe imprimir
"¡Puede acceder!" en la pantalla. Si no cumple con ninguna de las condiciones,
el programa debe imprimir un mensaje que lo indique.
*
* */
public class Parque2 {
    public static void main(String[] args) {
        final int edadMinima = 6;
        final double alturaMinima = 1.50;
        String mensaje="";
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese su nombre: ");
        String nombre = entrada.next();
        System.out.println("Ingrese su edad: ");
        String edad = entrada.next();
        Integer intEdad = Integer.valueOf(edad);
        System.out.println("Ingrese su altura: ");
        String altura = entrada.next();
        double doubleAltura = Double.parseDouble(altura);

        boolean edadYAlturaOk = intEdad > edadMinima || doubleAltura > alturaMinima;

        if(edadYAlturaOk){
            mensaje =nombre +"==> ¡Puede acceder!";
        }else{
            mensaje = nombre +"==> no puede ingresar,no cumple con los requisitos!!! ";
        }

        imprimir(mensaje);
    }
    public static void imprimir(String mensaje){
        System.out.println(mensaje);
    }

}
