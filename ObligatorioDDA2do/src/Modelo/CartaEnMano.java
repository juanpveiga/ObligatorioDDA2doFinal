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
public class CartaEnMano {
    
    private ArrayList<Carta> cartas = new ArrayList();;
    private Figura figura;

 
     
   public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }
 
    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public Figura getFigura() {
        return figura;
    }

    public CartaEnMano(ArrayList<Carta> c) {
       
        for (Carta carta : c) {
            cartas.add(carta);
            
        }
        
          asignarFigura();
    }
    
      private void asignarFigura() {
      ArrayList<Figura> tipoDeFiguras = new ArrayList();
      tipoDeFiguras = Modelo.getInstancia().traerFiguras();
      Figura f = null;
        for (int i = 0; i < tipoDeFiguras.size() && f == null; i++) {
           f = tipoDeFiguras.get(i).evaluarTipo(cartas);
           
        }
        if(f != null)this.figura = f;  
        else this.figura = new FiguraVacia();
       
    }

   public void dejarSoloGanadora() {
       Carta ganadora = buscarCartaMasAlta(cartas);
       cartas.clear();
       cartas.add(ganadora);
       
    }
   
   private Carta buscarCartaMasAlta(ArrayList<Carta> restantes) {
        int mayor = Integer.MIN_VALUE;
        Carta alta = null;
        for (Carta c : restantes) {
            if(c.getValorNumero() > mayor){
            mayor = c.getValorNumero();
            alta = c;
            }
        }
        
        return alta;
    }
    
}
