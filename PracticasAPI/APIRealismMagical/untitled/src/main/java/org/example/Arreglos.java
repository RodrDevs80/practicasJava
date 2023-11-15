package org.example;

import java.awt.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Arreglos {


    public static void main(String[] args) {
        int [] numeros={1,23,67,9,3,5,5,7};
        int sum = 0;
        int sum2 =0;
        int sum3 =0;
        int max = 0;
        int min = 0;

        for (int i=0;i < numeros.length;i++){
            sum += numeros[i];
        }

        for (int numero: numeros){
            sum2+=numero;
        }

        //stream
        OptionalInt max1 = Arrays.stream(numeros).max();
        OptionalInt min1 = Arrays.stream(numeros).min();
        int sum1 = Arrays.stream(numeros).sum();
        long count = Arrays.stream(numeros).count();



        max = numeros[0];
        for (int numero: numeros){

            if (numero > max){
                max = numero;
            }
        }

        min = numeros[0];
        for (int numero: numeros){

            if (numero < min){
                min = numero;
            }
        }

        System.out.println("SUMA");
        System.out.println(sum);
        System.out.println("**************************");
        System.out.println(sum2);
        System.out.println("**************************");
        System.out.println(sum1);
        System.out.println("MAXIMO");
        System.out.println(max);
        System.out.println(max1.getAsInt());
        System.out.println("MINIMO");
        System.out.println(min);
        System.out.println("CONTEO");
        System.out.println(count);

    }

}
