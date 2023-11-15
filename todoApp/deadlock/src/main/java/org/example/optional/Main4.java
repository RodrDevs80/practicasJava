package org.example.optional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main4 {
    public static void main(String[] args) {
        List<String> countries= new ArrayList<>();
        countries.add("Argentina");
        countries.add("Brasil");
        countries.add("Canada");
        countries.add("Colombia");
        countries.add("Peru");
        countries.add("EEUU");
        countries.add("Venezuela");

        Optional<String> arg = countries.stream()
                .filter(c -> c.startsWith("Arg"))
                .findFirst();

        if(arg.isPresent()){
            System.out.println("El pais es: "+arg.get());
        }else{
            System.out.println("no se encontro el pais!!!");
        }


    }
    public static void ejemploOptional1(){
        Optional<Double> result=promedio(1.0,4.0,6.0,10.0);
        if (result.isPresent()){
            System.out.println(result.get());
        }else{
            System.out.println("no existe ningun valor");
        }
    }

    public static Optional<Double> promedio(Double ...calificaciones){
       Double suma=0.0;
        if (calificaciones.length==0){
            return Optional.empty();
        }
       for (Double califi:calificaciones){
           suma+=califi;
       }

        return Optional.of(suma / calificaciones.length);
    }

}
