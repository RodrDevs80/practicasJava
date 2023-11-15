
/*
Escribir un programa que permita al usuario ingresar números
hasta que se introduzca un 0.
La computadora debe mostrar el número máximo y el número mínimo.
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Ejercicio51 {
    public static void main(String[] args) {
        boolean bandera = true;
        List listaDeNumeros= new ArrayList<>();
        Scanner entrada = new Scanner(System.in);
        while(bandera){

            System.out.println("Ingresa un numero: ");
            String num=entrada.next();
            if (esUnNumero(num)) {
                Integer numero = Integer.parseInt(num);
                if (numero== 0){
                    bandera= false;
                }else{
                    listaDeNumeros.add(numero);
                }
            } else {
                System.out.println("ERROR:El dato ingresado no es numero");
                continue;
            }

        }
        System.out.println(listaDeNumeros);
        System.out.println("El numero maximo es: " + maximo(listaDeNumeros));
        System.out.println("El numero maximo es: " +minimo(listaDeNumeros));
    }

    public static boolean esUnNumero(String entrada){
        try {
            Integer.parseInt(entrada);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
    public static Integer maximo(List<Integer> lista){
        Optional<Integer> max;
        max = lista.stream().max(Integer::compareTo);
        return max.get();
    }

    public static Integer minimo(List<Integer> lista){
        Optional<Integer> min;
        min = lista.stream().min(Integer::compareTo);
        return min.get();
    }
}

