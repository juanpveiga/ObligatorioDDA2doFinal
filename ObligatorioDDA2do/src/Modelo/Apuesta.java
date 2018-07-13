/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Manuel
 */
public class Apuesta implements Runnable{

    private double montoApuesta;
    private Participante apostador;
    private int tiempoParaPagar;
    private boolean timerActivo;
    private Thread hilo;

    
    public Apuesta() {

    }
   public boolean isTimerActivo() {
        return timerActivo;
    }
    public int getTiempoParaPagar() {
        return tiempoParaPagar;
    }

    public double getMontoApuesta() {
        return montoApuesta;
    }

    public Participante getApostador() {
        return apostador;
    }
    
    public boolean pagarApuesta(Participante p) throws ExceptionClass {
        boolean salida = false;
        if( p.getJugador().descontarApuesta(montoApuesta)){
            salida =true;
          
        }
        return salida;
    }
    
    public boolean agregarDatos(double montoApuesta, Participante apostador) throws ExceptionClass{
        if(validarDatos(montoApuesta, apostador)){
            this.montoApuesta = montoApuesta;
            this.apostador = apostador;
            this.tiempoParaPagar = apostador.getJuego().getTiempoParaPagar();
            return true;
        }
        return false;
    }
    
    private boolean validarDatos(double montoApuesta, Participante apostador) throws ExceptionClass {
        if(montoApuesta > 0 && apostador != null){
            return true;
        } else{
            
            throw new ExceptionClass("La apueta tiene que ser mayor a 0");
        }
    }

 

    @Override
    public void run() {
         while(this.timerActivo){
             for(int x=this.getTiempoParaPagar(); x>0 && this.timerActivo;x--){
                 
                 try {
                     hilo.sleep(1000);
                 } catch (InterruptedException ex) {
                     Logger.getLogger(Apuesta.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 restar();
                 apostador.getJuego().avisar(Juego.Eventos.hayApuesta);
                 
             }
             this.timerActivo = false;
             apostador.getJuego().avisar(Juego.Eventos.finTimer);
        }
    }
    
     public void activarTimerPago() {
        if(timerActivo)return;
        this.timerActivo = true;
       
        hilo = new Thread(this);
          hilo.start();
    }
   
   
    public void descativarTimer() {
        this.timerActivo = false;
      //  if(hilo!=null) hilo.interrupt();
        
    }
    
     private void restar() {
        if(this.tiempoParaPagar>0)
        this.tiempoParaPagar--;
    }
     
    
}
