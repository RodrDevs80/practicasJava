package org.example.uso_de_var;

import java.util.LinkedList;

public class UsoVar {
    public static void main(String[] args) {
        /*var se puede usar solo como una variable local en un constructor, metodo o bloque inicializador*/
        //no se puede ser inicializada a null, a menos que se establesca un tipo de variable
        var valor2=(String)null;
        //con var java infiere el tipo de variable.
        var valor="hola mundo";
        //no esta permitido usarlo para establecer los atributos de una clase;
        // var tampoco se puede usar como parametro de una funcion

        var lista=new LinkedList<String>();

        //siempre declarar la inicializacion donde este el var!!!
        //el valor de var puede cambiar pero su tipo inferido NO!!!
        //un var no es permitido en una sola declaracion de variable multiple.
        //var es un nombre de tipo reservado. esta de la version 10 de jdk
    }
}
