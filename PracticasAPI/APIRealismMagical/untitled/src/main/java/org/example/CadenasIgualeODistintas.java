package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadenasIgualeODistintas {
    public static void main(String[] args) {
        List<String> dosCadenas = ingresarDosCadenas();
        String sonIguales = sonIguales(dosCadenas.get(0), dosCadenas.get(1));
        System.out.println(sonIguales);
    }

    public static List<String> ingresarDosCadenas(){
        Scanner entrada = new Scanner(System.in);
        List<String> cadenas= new ArrayList<>();
        for (int i =0;i<2;i++){
            System.out.println("Ingrese la "+(i+1)+"° frase: ");
            cadenas.add(entrada.next());
        }
        return cadenas;
    }
    public static String sonIguales(String cadena1,String cadena2){
        boolean iguales = cadena1.equals(cadena2);
        String mensaje;
        if (iguales){
            mensaje = "SON IGUALES!!!";
        }else{
            mensaje = "NO SON IGUALES!!!";
        }
        return mensaje;
    }
}
