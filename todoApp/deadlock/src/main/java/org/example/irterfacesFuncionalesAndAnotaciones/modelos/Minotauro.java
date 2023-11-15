package org.example.irterfacesFuncionalesAndAnotaciones.modelos;

public class Minotauro extends Enemigo{
    public void fight(){
        attack((int endX,int endY)->{
        int diffX=endX-this.getPosX();
        int diffY=endY-this.getPosY();
        return diffX * diffX + diffY*diffY;
        }
        );

    }
    public void attack(InterfaceFunctional calcular){
      int distance=calcular.calcular(this.getPosX()+10,this.getPosY());
    }
}
