/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import mapeadores.MapeadorJugador;
import persistencia.Persistencia;

/**
 *
 * @author Juan Veiga
 */
public class Jugador extends Usuario {

    private double saldo;
    private MapeadorJugador mapJugador = new MapeadorJugador(this);

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    
    public Jugador(double saldo, String usuario, String password, String primerNombre, String segundoNombre, String PrimerApellido, String SegundoApellido) {
        super(usuario, password, primerNombre, segundoNombre, PrimerApellido, SegundoApellido);
        this.saldo = saldo;
        Persistencia.getInstancia().guardar(mapJugador);

    }
    
    public Jugador(){
        
    }


    public boolean login(String usuario, String password) throws ExceptionClass {
        boolean salida = false;
        if(super.getUsuario().equals(usuario) && super.getPassword().equals(password) ){
            if(saldo > Modelo.getInstancia().traerLuz()){
                
                salida = true;}else{throw new ExceptionClass("Saldo Insuficiente");}
    }
        return salida;
    }

    public boolean descontarLuz(double luz) {
        boolean salida = false;
        if (this.saldo > luz) {
            this.saldo = saldo - luz;
            salida = true;
            Persistencia.getInstancia().guardar(mapJugador);
        }
        return salida;
    }

   /*public boolean validarApuesta(double monto) throws ExceptionClass {
        if (monto < saldo) {
            return true;
        } else {

            throw new ExceptionClass("La apuesta debe de ser menor " + saldo + ".");
        }

    }*/

    public boolean descontarApuesta(double apuesta) throws ExceptionClass {
        boolean salida = false;
        double actual = saldo - apuesta;
        if (actual >= 0) {
            saldo = actual;
            salida = true;
            Persistencia.getInstancia().guardar(mapJugador);
        } else {
            throw new ExceptionClass("No dispone de saldo suficiente");
        }
        return salida;
    }

    public boolean validarSaldo(double luz) {
        if (luz < saldo) {
            return true;
        }
        return false;
    }

    public void cobrarApuestaGanada(double monto) {
        this.saldo = saldo + monto;

    }
    
 
}
