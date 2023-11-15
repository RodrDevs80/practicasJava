package org.example;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Carrera {
    /*
    * array entero
    * tamaño ->cantidad de participantes
    * Max-> ganador
    * Min-> ultimo
    * */
    public static void main(String[] args) {
        List<Integer> tiemposDeLLegada = new ArrayList<>();
        Scanner entrada = new Scanner(System.in);
        boolean bandera = true;
        int iterador = 1;
        long participantes= 0;
        int ganador=0;
        int ultimo=0;

        System.out.println("Ingrese los tiempos de los corredores: ");
        while (bandera){
            System.out.println("Ingrese el tiempo del corredor "+ iterador);
            int tiempo = entrada.nextInt();
            iterador++;
            tiemposDeLLegada.add(tiempo);
            System.out.println("¿Desea agregar el tiempo de otro corredor? S/N");
            String agregar = entrada.next();
            if (agregar.equals("N") || agregar.equals("n")){
                participantes = tiemposDeLLegada.stream().count();
                Optional<Integer> optionalUltimo = tiemposDeLLegada.stream().max(Integer::compareTo);
                ultimo = optionalUltimo.get();
                Optional<Integer> opcionalGanador = tiemposDeLLegada.stream().min(Integer::compareTo);
                ganador = opcionalGanador.get();
                bandera = false;
            }
        }

        System.out.println("INFORME DE LA CARRERA");
        System.out.println("Cantidad de participantes: "+ participantes);
        System.out.println("El tiempo del Ganador fue: " + ganador);
        System.out.println("El peor tiempo fue: "+ ultimo);
        System.out.println("****************");
        System.out.println("Todos los tiempos: ");
        for (int t:tiemposDeLLegada) {
            System.out.print("[ "+t+" ]");
        }
    }

}
