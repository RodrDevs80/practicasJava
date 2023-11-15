package org.example;

import java.util.Scanner;

/*
* Escribir un programa que permita ingresar la cantidad de invitados a una fiesta y
la cantidad de asientos disponibles en el salon. Debes indicar si alcanzan los asientos,
Si los asientos no alcanzaran indicar cuántos faltan para que todos los invitados puedan sentarse.
* */
public class SillasFiesta {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de invitados: ");
        String next = entrada.next();
        Integer invitados = Integer.valueOf(next);

        System.out.println("Ingrese la cantidad de sillas: ");
        String next1 = entrada.next();
        Integer cantSillas = Integer.valueOf(next1);

        String faltanOsobranSillas = calcularSiFaltanOsobranSillas(invitados, cantSillas);

        System.out.println(faltanOsobranSillas);
    }
    public static  String calcularSiFaltanOsobranSillas(int invitados, int cantSillas){

        int faltan = invitados - cantSillas;
        int sobran = cantSillas - invitados;
        String cartel = "";

        if(invitados > cantSillas){
            cartel = "Falta la sguiente cantidad de sillas: "+faltan;
        }else {
            cartel = "La cantidad de sillas es suficiente y sobran: "+sobran;
        }

        return cartel;
    }
}
