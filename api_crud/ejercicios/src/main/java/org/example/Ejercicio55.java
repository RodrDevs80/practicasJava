package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
* Escribir un programa que permita para cada cliente que va al banco "Express".
Cada cliente indica su número de documento y aguarda a ser atendido, cuando finaliza
* la atención del día se ingresa -1 para indicar que no hay más clientes para ser atendidos.
* El banco desea saber quién fue el primer cliente atendido y quién fue el último.*/
public class Ejercicio55 {
    public static void main(String[] args) {
        List<Double> listaDeClientes = new ArrayList();
        boolean bandera = true;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Sistema de atencion del BANCO-RED, ingrese su DNI y espere ser atendido");
        while (bandera) {
            System.out.println("Ingrese su DNI: ");
            String dni = entrada.next();
            if (!dni.equals("-1")) {
                String dniL = dni.replace(".", "");
                try {
                    double dniD = Double.parseDouble(dniL);
                    listaDeClientes.add(dniD);
                } catch (NumberFormatException e) {
                    System.out.println("ERROR:Ingreso un valor no valido!!!");
                }

            } else {
                System.out.println("La atencion del dia de hoy a terminado!!!");
                bandera = false;

            }

        }
            for (Double cliente:listaDeClientes) {
                System.out.println(cliente);
            }
    }
}
