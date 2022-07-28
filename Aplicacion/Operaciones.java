/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;

/**
 *
 * @author pablo
 */
public class Operaciones {
    
       public float calcularPotencia(Punto p) {
        double rendimiento = 0.9;
        double densidadAguaGravedad = 9810;
        float P=0;
        double pt = (rendimiento * densidadAguaGravedad * p.getX() * p.getY()) / 1000;
        if (pt < 0.09) {
            P = 0f;
        }else if(pt<0.19){
            P=0.1f;
        }else if(pt<0.29){
            P=0.2f;
        }else if(pt<0.40){
            P=0.3f;
        }else if(pt<0.5){
            P=0.4f;
        }else if (pt < 1) {
            P = 0.5f;
        } else if (pt < 6) {//si va de 1 a 6 hay una diferencia de 1
            int aux = (int) pt;
            P = (float) aux;
        } else if (pt < 10) {
            P = 6f;
        } else if (pt < 15) {
            P = 10f;
        } else if (pt < 20) {
            P = 15;
        } else if (pt < 30) {
            P = 20;
        } else if (pt < 40) {
            P = 30;
        } else if (pt < 50) {
            P = 40;
        } else if (pt < 60) {
            P = 50;
        } else if (pt < 80) {
            P = 60;
        } else if (pt < 100) {
            P = 80;
        } else if (pt < 120) {
            P = 100;
        } else if (pt < 150) {
            P = 120;
        } else if (pt < 200) {
            P = 150;
        } else if (pt < 500) {
            P = 200;
        } else if (pt < 1000) {
            P = 500;
        } else if (pt < 2000) {
            P = 1000;
        } else if (pt < 5000) {
            P = 2000;
        } else if (pt < 10000) {
            P = 5000;
        } else {
            P = 10000;
        }
        return P;
    }

    public float calcularSaltoNeto(float sb, float caudal, float diametro, float longitud, int coeficienteMaterial) {
       //hf=(10.679/C^1852)*(L/D^4.87)*Q1.852
        float hf=(float)((10.679/Math.pow(coeficienteMaterial,1.852))
                *(longitud/Math.pow(diametro,4.87))*Math.pow(caudal,1.852));
        
        return sb-hf;//esto devuelve el salto neto
    }

}
