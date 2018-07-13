/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Juego.Eventos;
import java.util.ArrayList;
import Modelo.Participante;
import mapeadores.MapeadorJuego;
import persistencia.Persistencia;

/**
 *
 * @author Juan Veiga
 */
public class SistemaJuego {

    private ArrayList<Figura> figurasEnJuego = new ArrayList();
    private ArrayList<Juego> juegos = new ArrayList();
    private ArrayList<Juego> juegosActivos = new ArrayList();//se agrego los juegos activos para mostrar en la interface del admin
    private ArrayList<Juego> juegosFinalizados = new ArrayList();//se agrego los juegos activos para mostrar en la interface del admin
    private ArrayList<Participante> participantes = new ArrayList();
    private int cantidadJugadores = 3;
    private double luz = 20;
    private Juego juegoProx;
    private int tiempoParaPagar = 20;
    private MapeadorJuego mj = new MapeadorJuego();

    public ArrayList<Figura> getFigurasEnJuego() {
        return figurasEnJuego;
    }

    public ArrayList<Juego> getJuegos() {
        return juegos;
    }

    public int getCantidadJugadores() {
        return cantidadJugadores;
    }

    public void setCantidadJugadores(int cantidadJugadores) {
        this.cantidadJugadores = cantidadJugadores;
    }

    public double getLuz() {
        return luz;
    }

    public Juego getJuegoProx() {
        return juegoProx;
    }

    public Participante agregarJugadorJuego(Jugador j) throws ExceptionClass {
        Participante p = null;
        if (j != null) {
            p = juegoProx.agregarJugador(j);
        }
        return p;
    }

    public void crearNuevoJuego() {

        Juego j = new Juego(luz, cantidadJugadores, tiempoParaPagar);
        juegos.add(j);
        juegoProx = j;
    }

    public void cambiarValorLuz(double luz) throws ExceptionClass {
        if (luz > 0) {
            this.luz = luz;
            Modelo.getInstancia().avisar(Modelo.Eventos.cambioLuz);
            if (juegoProx.getParticipantes().size() == 0) {
                juegoProx.setLuz(luz);
            }
        } else {
            throw new ExceptionClass("La luz debe ser Mayor a 0");
        }
    }

    public void cambiarCantidad(int cantidad) throws ExceptionClass {
        if (cantidad < 6 && cantidad > 1) {
            this.cantidadJugadores = cantidad;
            Modelo.getInstancia().avisar(Modelo.Eventos.cambioCantidad);

            juegoProx.verificarCantidadJugadores(cantidad);

        } else {
            throw new ExceptionClass("La cantidad debe ser mayor que 1 y menor que 6.");
        }
    }

    public int calcularRestantes() {
        return juegoProx.calcularRestantes();
    }

    public boolean hayRestantes() {
        return calcularRestantes() > 0;
    }

    public Juego devolverJuego(int index, boolean activos) throws ExceptionClass {
        /*if (juegosActivos.size() != 0) {
            return juegosActivos.get(index);
        } else {
            throw new ExceptionClass("No hay juegos activos en el momento");
        }*/
        if(activos){
            return juegosActivos.get(index);
        }else{
            return juegosFinalizados.get(index);
        }
    }

    public ArrayList<Juego> traerJuegosActivos() {// aca se chequea que el juego este activo o sea que ya empezo mano!=null
        this.juegosActivos = new ArrayList();
        for (Juego j : juegos) {
            if (j.esActivo() && !j.fin()) //chequea si estan jugando y no ha terminado
            {
                juegosActivos.add(j);
            }
        }
        return juegosActivos;
    }
    
    public ArrayList<Juego> traerJuegosFinalizados(){
        return this.juegosFinalizados;
    }

    public void agregarFigura(Figura t) {
        figurasEnJuego.add(t);
    }

    void cargarJuegos() {
        juegosFinalizados.addAll(Persistencia.getInstancia().todos(mj));
    }

}
