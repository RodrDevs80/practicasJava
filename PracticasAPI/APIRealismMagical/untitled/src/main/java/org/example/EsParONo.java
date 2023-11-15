package org.example;

import java.util.Scanner;

public class EsParONo {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese un numero entero: ");
        String numero = entrada.next();
        double num = Double.parseDouble(numero);

        boolean esEntero = num % 1 == 0;

        System.out.println(esEntero);

       if (esEntero){
            System.out.println(comprobarPar(num));
        }else {
            System.out.println("El numero ingresado no es ENTERO!!");
        }

    }

    public static String comprobarPar(Double numero){
        String mensaje;
        boolean esPar = numero % 2 ==0;
        if (esPar){
            mensaje = "El numero es PAR!!";
        }else {
            mensaje = "El numero No es PAR!!";
        }
        return mensaje;
    }


}
