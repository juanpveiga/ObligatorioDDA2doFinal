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
public class TipoColor extends Figura{

    
   

   
   
   
    
    public TipoColor(){}
    public TipoColor(String palo,ArrayList<Carta> cartas){
       this.primerValor = 300;
       this.nombreFigura = "Color";
       }
    
    @Override
    public Figura evaluarTipo(ArrayList<Carta> cartas) {
        String primerPalo = "";
        boolean bandera = true;
        int contador = 0;
        for (Carta carta : cartas) {
            if(contador == 0) primerPalo = carta.getPalo();
            contador++;
            if(carta.getPalo() != primerPalo)bandera = false;
            
        }
        if(bandera == true){
            return new TipoColor(primerPalo,cartas);}
        else return null;
    }
    
   /* public Figura evaluarTipo(ArrayList<Carta> cartas){
        String primerPalo = cartas.get(0).getPalo();
        for(int i=1; i<cartas.size();i++){
            if(cartas.get(i).getPalo() != primerPalo){
                return null;
            }
        }
        return new TipoColor(300,"Color");
    }

    public TipoColor(int primerValor,String nombreFigura) {
        super(primerValor,nombreFigura);
    }
    
    */
    
    @Override
    public String devolverNombreFigura() {
       return this.nombreFigura;
    }

   

    @Override
    public Participante desempate(ArrayList<Participante> empatados) {
       
       ArrayList<Participante> ganadores = new ArrayList();
        int mayorPalo = Integer.MIN_VALUE;
       for (Participante p : empatados) {
             if(p.getCartas().getCartas().get(0).getValorPalo() >= mayorPalo){
                mayorPalo = p.getCartas().getCartas().get(0).getValorPalo();
              ganadores.add(p);
            }
       }
         if(ganadores.size() == 1){
              return ganadores.get(0);  
            }else{
             return segundoDesempate(ganadores);
             
         
         }
       
    }

    private Participante segundoDesempate(ArrayList<Participante> segundoEmpate) {
        Participante ganador = null;
       Carta mayor = new Carta("2","p",1);
       for (Participante p : segundoEmpate) {
           for (Carta carta : p.getCartas().getCartas()) {
               if(carta.getValor() >= mayor.getValor()){
                mayor = carta;
                ganador = p;
              
           }
             
            }
       } 
        
        return ganador;
    }
    
}
