package org.example;

import java.util.Scanner;

/*
*Escribir un programa que permita ingresar una edad (entre 1 y 120 años),
un género ('F'para mujeres, 'M' para hombres) y un nombre.
En caso de haber ingresado valores erróneos (edad fuera de rango o género inválido),
informar tal situación indicando el nombre de la persona. Si los datos
están bien ingresados el programa debe indicar, sabiendo que las mujeres se jubilan con 60 años
o más y los hombres con 65 años o más, si la persona está en edad de jubilarse.
* */
public class Jubilatoria {
    public static void main(String[] args) {
        final int edadMinima = 1;
        final int edadMaxima = 120;
        final int edadMujer = 60;
        final int edadHombre = 65;
        Scanner entrada = new Scanner(System.in);
        String nombre ="";
        String edad ="";
        String genero = "";
        int edadInt= 0;
        boolean laInfoEsValida;
        boolean esValidaEdad;
        boolean esValidoGenero;
        boolean esMujer;
        String mensaje ="";

        System.out.println("Ingrese su nombre: ");
        nombre = entrada.next();

        do {
            System.out.println("Ingrese su edad: ");
            edad = entrada.next();
            edadInt = Integer.parseInt(edad);
            System.out.println("Ingrese su genero: ==> M/F");
            genero = entrada.next();
            esValidaEdad = edadInt >= edadMinima && edadInt <=edadMaxima;
            esValidoGenero = genero.equals("M")||genero.equals("m")||genero.equals("F")||genero.equals("f");
            laInfoEsValida = esValidaEdad && esValidoGenero;
            if(!laInfoEsValida){
                System.out.println(nombre+"==> Ingresa numevamente los datos,ya que los mismos no " +
                        "pasaron la validacion:");
            }
        }while (!laInfoEsValida);
        esMujer = genero.equals("F") || genero.equals("f");

        if (esMujer){
            if(edadInt >= edadMujer){
                mensaje = nombre+": usted está en edad de jubilarse. ";
            }else {
                mensaje = nombre+": usted NO está en edad de jubilarse. ";
            }
        }else{
            if (edadInt >= edadHombre){
                mensaje = nombre+": usted está en edad de jubilarse. ";
            }else {
                mensaje = nombre+": usted NO está en edad de jubilarse. ";
            }
        }

        System.out.println(mensaje);

    }
}
