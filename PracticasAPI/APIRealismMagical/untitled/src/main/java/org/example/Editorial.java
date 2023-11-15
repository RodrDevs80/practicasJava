package org.example;

import java.util.Scanner;

/*
*Una editorial determina el precio de un libro según la cantidad de páginas que contiene.
El costo básico del libro es de $1000, más $35,10 por página con encuadernación rústica.
Si el número de páginas supera las 300 la encuadernación debe ser especial, lo que incrementa el costo en $1200.
Además, si el número de páginas sobrepasa las 600 se hace necesario otro procedimiento de encuadernación
que incrementa el costo en $880. Desarrollar un programa que calcule el
costo de un libro dado el número de páginas.

* */
public class Editorial {
    public static void main(String[] args) {
        final double costoBasicoLibro = 1000.0;
        final double encueadernacionRustica = 35.10;
        final double encuadernacionEspecial = 1200.0;
        final double encuadernacionMas600Pag = 880.0;
               double costoDelLibro = 0.0;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el numero de Paginas del libro: ");
        double paginas = Double.parseDouble(entrada.next());

        if (paginas < 300){
            costoDelLibro = costoBasicoLibro + (paginas * encueadernacionRustica);

        } else if (paginas > 300 && paginas < 600) {
            costoDelLibro = costoBasicoLibro + (paginas * encueadernacionRustica) + encuadernacionEspecial;
        }else {

            costoDelLibro = costoBasicoLibro +
                    (paginas * encueadernacionRustica) + encuadernacionEspecial +
                    encuadernacionMas600Pag;
        }

        String mensaje = "El costo del libro es de: " + costoDelLibro;

        System.out.println(mensaje);
    }


}
