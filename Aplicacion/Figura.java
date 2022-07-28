/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;

import java.util.ArrayList;

/**
 *
 * @author pablo
 */
public class Figura {

    private final Punto [] F;

    public Figura(Punto[] F) {
        this.F = F;
    }
    /*
    *El metodo "dentro" es una modificacion y traduccion de un codigo escrito en
    *C que se encuentra en el siguiente blog.
    *https://jsbsan.blogspot.com/2011/01/saber-si-un-punto-esta-dentro-o-fuera.html?m=1
    */
    public boolean dentro(Punto p) {
        Punto vertice1, vertice2;
        int numVertices = F.length;
        double xinters;
        int counter=0;
        vertice1 = F[0];
        for (int i = 1; i <=numVertices; i++) {
            vertice2 = F[i % numVertices];
            if(vertice1.getY()==p.getY() && vertice1.getX()==p.getX())//esto devuelve true si el punto es un vertice
                return true;
            if (p.getY() > Punto.menor(vertice1.getY(), vertice2.getY())) {
                if (p.getY() <= Punto.mayor(vertice1.getY(), vertice2.getY())) {
                    if (p.getX() <= Punto.mayor(vertice1.getX(), vertice2.getX())) {
                        if (vertice1.getY() != vertice2.getY()) {
                            xinters=((p.getY()-vertice1.getY())*(vertice2.getX()-vertice1.getX())
                                                /(vertice2.getY()-vertice1.getY())+vertice1.getX());
                            if(vertice1.getX()==vertice2.getX() || p.getX()<=xinters)
                                counter++;
                        }
                    }
                }
                
            }
            vertice1=vertice2;

        }
        
        if(counter %2==0) return false;
        else return true;
    }
    
    
   /* public static void main (String [ ] args) {

         Punto[] puntos={new Punto(0.0,0.0),new Punto(10.0,0.0),new Punto(10.0,10.0),new Punto(0.0,10.0)};
         Figura f=new Figura(puntos);
         
         if(f.dentro(new Punto(9.0,0.0)))
             System.out.println("Dentro");
         else System.out.println("Afuera");
        }*/

}
