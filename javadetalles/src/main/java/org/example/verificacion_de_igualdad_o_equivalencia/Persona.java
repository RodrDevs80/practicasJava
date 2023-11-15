package org.example.verificacion_de_igualdad_o_equivalencia;

public class Persona {
    private String codigo;
    private String nombre;

    private String ki;


    public Persona() {
    }

    public Persona(String codigo, String nombre, String ki) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ki=ki;
    }

    public Persona(String codXXX3) {
        this.codigo=codXXX3;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getKi() {
        return ki;
    }

    public void setKi(String ki) {
        this.ki = ki;
    }

    @Override
    public boolean equals(Object obj) {
        Persona personaComparacion=(Persona)obj;
        return this.getCodigo().equals(personaComparacion.getCodigo());
    }
}
