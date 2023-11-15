package org.example;

import java.util.Scanner;

/*
* La farmacia Sindical efectúa descuentos a sus afiliados según el importe de la compra
con la siguiente escala:
Menor de $5500.0 el descuento es del 4.5%
Entre $5500.0 y $10000.0 el descuento es del 8%
Más de $10000.0 el descuento es del 10.5%
Escribir un programa que reciba un importe e informe: el descuento
y el precio neto a cobrar, con mensajes aclaratorios.

* */
public class Farmacia {
    public static void main(String[] args) {
        final double DESCUENTO1 = 0.045;
        final double DESCUENTO2 = 0.08;
        final double DESCUENTO3 = 0.105;
        final double IMPORTE_MENOR = 5500.0;
        final double IMPORTE_MEDIO = 10000.0;
        String mensaje = "";
        double precioNeto= 0.0;
        String descuento = "";

        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese el importe de la compra en la farmacia: ");
        double importeSinDescuento = Double.parseDouble(entrada.next());

        if (importeSinDescuento < IMPORTE_MENOR){
            descuento ="4.5 %";
            precioNeto = importeSinDescuento -(importeSinDescuento*DESCUENTO1);
        }else if (importeSinDescuento >= IMPORTE_MENOR && importeSinDescuento <= IMPORTE_MEDIO){
            descuento = "8.0 %";
            precioNeto = importeSinDescuento -(importeSinDescuento*DESCUENTO2);
        }else {
            descuento = "10.5 %";
            precioNeto = importeSinDescuento -(importeSinDescuento*DESCUENTO3);
        }
        mensaje ="""
                INFORME:
                *******************************************************************
                Valor del medicamento sin descuento: $""" +importeSinDescuento+ """
    
                Por el importe de la compra descuento del\s"""+descuento+ """  
               
                Precio neto con descuento ===> $"""+precioNeto ;


        System.out.println(mensaje);


    }
}
