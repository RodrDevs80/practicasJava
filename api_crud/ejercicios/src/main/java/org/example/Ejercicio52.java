package org.example;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Arrays.*;

/*
* Escribir un programa que permita un programa que permita ingresar la estatura
* (en metros con decimales) de cada jugador de un equipo de básquet La carga finalizará
*  al ingresar cero. Calcular y mostrar la estatura promedio del equipo.
* */
import org.example.Utilitarios;
public class Ejercicio52 {
    public static void main(String[] args) {
        float estaturaPromedio = 0;
        float acumnudador = 0;
        boolean bandera = true;
        List<Float> jugadores = new ArrayList();
        int contador = 1;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese las estaturas de los jugadores, cundo quiera terminar ingrese: 0");
        while(bandera){
            System.out.println("Ingrese la estatura del jugador N° "+ contador +" : ");
            String alturaS = entrada.next();
            if (!alturaS.equals("0")) {
                try {
                    float altura = Float.parseFloat(alturaS);
                    if (altura >=1.00 && altura <=2.80){
                        jugadores.add(altura);
                        contador++;
                    }
                    else{
                        System.out.println("ERROR:Ingreso un dato no valido,ya que la altura " +
                                "minima permitida es 1 metro y la maxima permitida es 2.80 metros!!!");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Error: no se puede convertir a Float -->" + e);
                }
            }
            else {
                bandera = false;
                System.out.println(jugadores);
                String promedio = Utilitarios.calcularPromedio(jugadores);
                System.out.println("El promedio de altura de los jugadores es--> "+ promedio);
            }
        }

    }


}
