package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IgualesODistintos {
    public static void main(String[] args) {
        List<Integer> numeros = ingresarDosNumeros();
        String iguales = sonIguales(numeros.get(0), numeros.get(1));
        System.out.println(iguales);
    }

    public static List<Integer> ingresarDosNumeros(){
        List<Integer> numeros = new ArrayList<>();
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese un numero: ");
        int numero1 = entrada.nextInt();
        numeros.add(numero1);
        System.out.println("Ingrese otro numero: ");
        int numero2 = entrada.nextInt();
        numeros.add(numero2);
        return numeros;
    }
    public static String sonIguales(Integer numero1,Integer numero2){
        String mensaje;
        if (numero1.equals(numero2)){
            mensaje = "Los numeros son IGUALES!!!";
        }else {
            mensaje = "Los numeros son NO SON IGUALES!!!";
        }
        return mensaje;
    }
}
