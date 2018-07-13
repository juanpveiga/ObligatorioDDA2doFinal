/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Juan Veiga
 */
public class Pozo {
    
    private double pozo;

    public double getPozo() {
        return pozo;
    }

    public Pozo(double pozo) {
        this.pozo = pozo;
    }
    
    public void actualizar(double apuesta) {
       pozo = apuesta + pozo;
    }
    
}
