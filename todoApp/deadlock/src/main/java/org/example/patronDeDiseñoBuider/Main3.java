package org.example.patronDeDiseñoBuider;

public class Main3 {
    public static void main(String[] args) {
      Persona persona= Persona.Builder.aPersona()
              .withNombre("Carlos")
              .withApellido("Rodriguez")
              .withEmail("libertad-cer@hotmail.com")
              .withTelefono("3844418268")
              .build();


    }
}
