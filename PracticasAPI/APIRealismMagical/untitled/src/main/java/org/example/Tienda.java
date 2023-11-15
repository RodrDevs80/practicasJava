package org.example;



import java.util.Scanner;

public class Tienda {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        System.out.println("Bienvenido, ingrese el nombre del cliente: ");
        String nombre = entrada.next();
        System.out.println("Ingrese la cantidad de productos que desea cargar: ");
        int cantidad = entrada.nextInt();
        int [] importes =new int[cantidad];
        int iterador =0;
        int sum =0;
        int max =0;
        int min =0;

        do {
            System.out.println("Ingrese el importe del producto: ");
            int compra = entrada.nextInt();
            importes[iterador] = compra;
            iterador++;
        }while (iterador < importes.length);

        for (int impor: importes){
           sum+= impor;
        }
        max = importes[0];
        for (int impor: importes){
            if (impor > max){
                max= impor;
            }
        }
        min = importes[0];
        for (int impor: importes){
            if (impor < min){
                min= impor;
            }
        }


        System.out.println("INFORME DE COMPRA");
        System.out.println("Cliente: "+nombre);
        System.out.println("******************************************************");
        System.out.println("Total de la compra: $"+sum);
        System.out.println("******************************************************");
        System.out.println("Importe Maximo: $"+max);
        System.out.println("******************************************************");
        System.out.println("Importe Minimo: $"+min);
        System.out.println("******************************************************");

    }
}
