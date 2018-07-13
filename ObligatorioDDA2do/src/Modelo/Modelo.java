/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author Juan Veiga
 */
public class Modelo extends Observable {

    private SistemaJuego sj = new SistemaJuego();
    private SistemaUsuario su = new SistemaUsuario();

    //Singleton
    private static Modelo instancia = new Modelo();

    public static Modelo getInstancia() {

        return instancia;
    }

    private Modelo() {
    }

    public void cargarJuegos() {
       sj.cargarJuegos();
    }

    public enum Eventos {
        cambioLuz, cambioCantidad, cambioJuego, finJuego;
    }

    public void avisar(Eventos evento) {
        setChanged();
        notifyObservers(evento);
    }

    public Participante loginJugador(String usuario, String password) throws ExceptionClass {
        return su.loginJugador(usuario, password);
    }

    //metodos delegados sistema juego
    public Juego traerDetalle(int index, boolean activos) throws ExceptionClass {
        return sj.devolverJuego(index, activos);
    }

    public int traerCantidadJugadores() {
        return sj.getCantidadJugadores();
    }

    public void setCantidadJugadores(int cantidadJugadores) {
        sj.setCantidadJugadores(cantidadJugadores);
    }

    public double traerLuz() {
        return sj.getLuz();

    }

    public int traerCantidad() {
        return sj.getCantidadJugadores();
    }

    public void crearNuevoJuego() {
        sj.crearNuevoJuego();
    }

    public Participante agregarJugadorJuego(Jugador j) throws ExceptionClass {
        return sj.agregarJugadorJuego(j);

    }

    public void cambiarValorLuz(double luz) throws ExceptionClass {
        sj.cambiarValorLuz(luz);
    }

    public void cambiarCantidad(int cantidad) throws ExceptionClass {
        sj.cambiarCantidad(cantidad);
    }

    public int calcularRestantes() {
        return sj.calcularRestantes();

    }

    public boolean hayRestantes() {
        return sj.hayRestantes();
    }

    public ArrayList<Juego> traerJuegos() {
        return sj.traerJuegosActivos();
    }
    
    public ArrayList<Juego> traerJuegosFinalizados(){
        return sj.traerJuegosFinalizados();
    }

// metodos delegados a sitema usuario
    
    public void cargarJugadores(){
        su.cargarJugadores();
    }
    
    public void cargarAdministradores(){
        su.cargarAdministradores();
    }
    
    public void agregarJugador(Jugador jugador) {
        su.agregarJugador(jugador);
    }
    
    public Jugador buscarJugador(int oid){
        return su.buscarJugador(oid);
    }
    
    /*public Jugador buscarJugador(String usuario){
        return su.buscarJugador(usuario);
    }*/

    public Administrador loginAdmin(String usuario, String password) throws ExceptionClass {
        return su.loginAdmin(usuario, password);

    }

    public void agregarAdmin(Administrador administrador) {
        su.agregarAdmin(administrador);
    }

    public void agregarFigura(Figura t) {
        sj.agregarFigura(t);
    }

    public ArrayList<Figura> traerFiguras() {
        return sj.getFigurasEnJuego();
    }
}
