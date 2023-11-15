package org.example;

import java.util.ArrayList;
import java.util.List;

/*
* Escribir un programa que permita al usuario ingresar dos números enteros.
La computadora debe indicar si el mayor es divisible por el menor.
(Un número entero a es divisible por un número entero b cuando
el resto de la división entre a y b es 0)
* */
public class Divisible {
    public static void main(String[] args) {
        List<Long> numeros= new ArrayList<>();
        Long maximo = 0L;
        Long minimo= 0L;
        String mensaje= "";

        for (int i=0;i<2;i++){
            numeros.add((Math.round(Math.random()*100)));
        }

        if (numeros.get(0)> numeros.get(1)){
            maximo = numeros.get(0);
            minimo = numeros.get(1);
        } else {
            maximo = numeros.get(1);
            minimo = numeros.get(0);
        }

        if (maximo % minimo==0){
            mensaje = maximo + ", es divisible por "+ minimo;
        }else {
            mensaje = maximo + ",NO es divisible por "+ minimo;
        }

        System.out.println(mensaje);
    }
}
