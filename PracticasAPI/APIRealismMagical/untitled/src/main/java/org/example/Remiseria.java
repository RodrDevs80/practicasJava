package org.example;

import java.util.Scanner;

/*
* Una remisería requiere un sistema que calcule el precio de un viaje a partir de la cantidad de
km que desea recorrer el usuario.
Tiene la siguiente tarifa:
Viaje mínimo $50
Si recorre entre 0 y 10km: $20/km
Si recorre 10km o más: $15/km
Escribir un programa que permita ingresar la cantidad de km que desea recorrer
el usuario y muestre el precio del viaje.

* */
public class Remiseria {
    public static void main(String[] args) {

        final int BAJADA_DE_BANDERA = 50;
        final int KM_HASTA_10 = 20;
        final int KM_MAS_10 = 15;

        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de KM: ");
        int km = Integer.parseInt(entrada.next());
        String mensaje = "";
        int precioFinal = 0;

        if (km >= 0 && km <= 10){
            precioFinal = BAJADA_DE_BANDERA + (km * KM_HASTA_10);
        }
        else {
            precioFinal = BAJADA_DE_BANDERA + (km * KM_MAS_10);
        }
        mensaje = "El precio para " + km + " KM es de ==> $"+ precioFinal;

        System.out.println(mensaje);
    }
}
