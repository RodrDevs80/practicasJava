package org.example;

/*
* Existen dos reglas que identifican dos conjuntos de valores:
a) El número es de un solo dígito.
b) El número es impar.
A partir de estas reglas, escribir un programa que permita ingresar un número entero.
Debe asignar el valor que corresponda a las variables booleanas:
esDeUnSoloDigito
esImpar
estaEnAmbos
noEstaEnNinguno
el valor Verdadero o Falso, según corresponda, para indicar si el valor número ingresado pertenece
o no a cada conjunto. Definir un lote de prueba de varios números y probar el algoritmo,
escribiendo los resultados
* */
public class UnSoloDigitoEsPar {
    public static void main(String[] args) {
        Long numero = Math.round(Math.random() * 20);
        System.out.println(numero);
        boolean esDeUnSoloDigito = numero >= 0 && numero <= 9;
        boolean esImpar = numero % 2 != 0;
        boolean estaEnAmbos = esImpar && esDeUnSoloDigito;
        boolean noEstaEnNinguno = !esImpar && !esDeUnSoloDigito;
        String mensaje = "";

        if (estaEnAmbos) {
            mensaje = "El numero es impar y es de un solo digito";
        } else if (noEstaEnNinguno) {
            mensaje = "El numero es Par y es de dos digitos";
        } else if (esImpar) {
            mensaje = " el numero es impar y de dos digitos";
        } else {
            mensaje = "El numero es par y es de un solo digito";
        }

        System.out.println(mensaje);
    }
}
