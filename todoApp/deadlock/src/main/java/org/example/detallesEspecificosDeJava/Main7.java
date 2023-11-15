package org.example.detallesEspecificosDeJava;

import java.util.Arrays;

public class Main7 {
    public static void main(String[] args) {
        System.out.println("hello junior");
        Arrays.stream(args).forEach(System.out::println);
    }
}
