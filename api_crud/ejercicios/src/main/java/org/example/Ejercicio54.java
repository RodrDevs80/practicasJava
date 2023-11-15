package org.example;

import java.util.Scanner;

import org.example.Utilitarios;

/*
 * Escribir un programa que permita controlar con validación el ingreso a un sitio web.
 * Teniendo dos constantes con un nombre de usuario ("admin") y una contraseña ("123456"),
 * el programa debe permitir al usuario ingresar sus credenciales. Si las mismas son erróneas,
 * se volverán a pedir hasta un máximo de 3 intentos. Finalmente, la computadora debe mostrar
 * alguno de los siguientes mensajes según sea el caso: "Acceso concedido" o "Se ha bloqueado la cuenta"
 * */
public class Ejercicio54 {
    public static void main(String[] args) {
        String mensaje = "";
        int contador = 0;
        final String nombre = "admin";
        final String pass = "123456";
        Scanner entrada = new Scanner(System.in);
        System.out.println("INGRESAR SUS DATOS PARA SER VALIDADOS");
        int cont = Utilitarios.validarUsuario(contador, 3, entrada, nombre, pass);
        if (cont < 3) {
            mensaje = "Acceso concedido";
        } else {
            mensaje = "Se ha bloqueado la cuenta,alcanzo el maximo de intentos erroneos-->" + cont;

        }

        System.out.println(mensaje);

    }


}
