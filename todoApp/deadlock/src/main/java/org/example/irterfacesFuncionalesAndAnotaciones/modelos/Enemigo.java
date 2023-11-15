package org.example.irterfacesFuncionalesAndAnotaciones.modelos;

public  abstract class Enemigo {
    protected Double salud;
    protected Integer posX;
    protected Integer posY;

    public Enemigo() {
    }

    public Enemigo(Double salud, Integer posX, Integer posY) {
        this.salud = salud;
        this.posX = posX;
        this.posY = posY;
    }

    public Double getSalud() {
        return salud;
    }

    public void setSalud(Double salud) {
        this.salud = salud;
    }

    public Integer getPosX() {
        return posX;
    }

    public void setPosX(Integer posX) {
        this.posX = posX;
    }

    public Integer getPosY() {
        return posY;
    }

    public void setPosY(Integer posY) {
        this.posY = posY;
    }
}
