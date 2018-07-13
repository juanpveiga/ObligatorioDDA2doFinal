/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Juan Veiga
 */
public abstract class Figura {
    
     protected int primerValor;
     protected String nombreFigura;
    
     
    
     public abstract Figura evaluarTipo(ArrayList<Carta> cartas);
     public abstract String devolverNombreFigura();
     public abstract Participante desempate(ArrayList<Participante> p);
}

