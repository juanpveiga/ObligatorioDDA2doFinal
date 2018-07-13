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
public class TipoPar extends Figura {

  
    

    public TipoPar(){}
    private TipoPar(ArrayList<Carta> cartas) {
        this.primerValor = 100;
        this.nombreFigura= "Par";
      
    }
     
    @Override
    public Figura evaluarTipo(ArrayList<Carta> cartas) {
       int contador = 0;
   
       if(cartasPar(cartas).size() == 2 )return new TipoPar(cartas);
        else return null;
                
            }

    @Override
    public String devolverNombreFigura() {
          return this.nombreFigura;
    }

   
    private ArrayList<Carta> cartasPar(ArrayList<Carta> cartasEvaluar)
    {  ArrayList<Carta> cartasEvaluadas = new ArrayList();
       ArrayList<Carta> pares = new ArrayList();
        for (Carta carta : cartasEvaluar) {
            cartasEvaluadas.add(carta);
           }
        for (Carta c : cartasEvaluar) {
            for (Carta cartasEval : cartasEvaluadas) {
              if(c.getNumero()==cartasEval.getNumero() && c != cartasEval)  
                  pares.add(c);
            }
            
        }
        return pares;
    }

    private int buscarCartaMasAlta(ArrayList<Carta> restantes) {
        int mayor = Integer.MIN_VALUE;
        Carta alta = null;
        for (Carta c : restantes) {
            if(c.getValorNumero() > mayor){
            mayor = c.getValorNumero();
           
            }
        }
        return mayor;
    }

    @Override
    public Participante desempate(ArrayList<Participante> participantes) {
       Participante ganador = null;
        ArrayList<Participante> ganadores = new ArrayList();
        int mayor = Integer.MIN_VALUE;
        for (Participante p : participantes) {
            
            for (Carta c : cartasPar(p.getCartas().getCartas())) {
                if(c.getValorNumero()> mayor){
                ganadores.clear();
                mayor = c.getValorNumero();
                ganadores.add(p);
                }else if(c.getValorNumero()== mayor) {
                    if(!ganadores.contains(p))ganadores.add(p);}
            }
            
        }
        if(ganadores.size() == 1){
            ganador = ganadores.get(0);
        return ganador;
        }else{
            ganador = segundoDesempate(ganadores);
            return ganador;
        }
    }

    private Participante segundoDesempate(ArrayList<Participante> participantes) {
         Participante ganador = null;
        ArrayList<Participante> ganadores = new ArrayList();
       ArrayList<Carta> pares = new ArrayList();
      
        int mayor = Integer.MIN_VALUE;
        for (Participante p : participantes) {
            
           pares = cartasPar(p.getCartas().getCartas());
           for (Carta c : p.getCartas().getCartas()) {
                 if(!pares.contains(c)){
                    
                if(c.getValorNumero() > mayor){
                ganadores.clear();
                mayor = c.getValorNumero();
                ganadores.add(p);
                }else if(c.getValorNumero() == mayor) {
                    if(!ganadores.contains(p))ganadores.add(p);}
            }
            
           }
        }
        if(ganadores.size() == 1){
            ganador = ganadores.get(0);
        return ganador;
        }else{
           
            return ganador;
        }
    }
            
       
    }
    

