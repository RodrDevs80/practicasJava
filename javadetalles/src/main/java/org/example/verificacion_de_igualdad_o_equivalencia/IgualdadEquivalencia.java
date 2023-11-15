package org.example.verificacion_de_igualdad_o_equivalencia;

import java.util.LinkedList;
import java.util.List;

public class IgualdadEquivalencia {
    public static void main(String[] args) {
        //tipos primitivos
        int valor=25;
        int valor2=25;
        if(valor==valor2){
            System.out.println("verdadero");
        }else {
            System.out.println("falso");
        }
        System.out.println(valor+"/"+valor2);
        //tipos referencia
        Persona personax=new Persona("CodXXX1","Orchid","ki");
        Persona personaxx=new Persona("CodXXX1","Orchid","ki");
        if(personax==personaxx){
            System.out.println("verdadero");
        }else {
            System.out.println("falso");
        }
        System.out.println(personax+"/"+personaxx);
        //metodo equals() comparar objetos.como debo hacer.

        Persona persona1=new Persona("CodXXX1","Fulgure","ki");
        Persona persona2=new Persona("CodXXX2","Orchid","ki");
        Persona persona3=new Persona("CodXXX3","Jago","ki");
        Persona persona4=new Persona("CodXXX3","Jago","ki");

        System.out.println(persona3==persona4);
        System.out.println(persona3.equals(persona4));

        List<Persona> personas=new LinkedList<Persona>();

        personas.add(persona1);
        personas.add(persona2);
        personas.add(persona3);
        System.out.println("¿En la lista se encuentra el objeto?");
        System.out.println(personas.contains(new Persona("CodXXX3")));


    }
}
