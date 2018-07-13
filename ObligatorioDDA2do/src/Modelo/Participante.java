/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan Veiga
 */
public class Participante {

    private Jugador jugador;
    private Juego juego;
    //private ArrayList<Carta> cartas = new ArrayList();
    private CartaEnMano cartas;
    private double saldoInicial;
    private double totalGanado;
    private double totalApostado;

    public Participante(Jugador jugador, Juego j, double saldoInicial, double totalGanado, double totalApostado) {
        this.jugador = jugador;
        this.juego = j;
        this.totalGanado = totalGanado;
        this.totalApostado = totalApostado;
        this.saldoInicial = saldoInicial;
    }

    public CartaEnMano getCartas() {
        return cartas;
    }

    public double getTotalGanado() {
        return totalGanado;
    }

    public double getSaldoInicial() {
        return saldoInicial;
    }

    public double getTotalApostado() {
        return totalApostado;
    }

    public void setTotalGanado(double totalGanado) {
        this.totalGanado += totalGanado;
    }

    public void setTotalApostado(double totalApostado) {
        this.totalApostado += totalApostado;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public Juego getJuego() {
        return juego;
    }

    public void cargarCartas(ArrayList<Carta> c) {
        this.cartas = new CartaEnMano(c);

    }

    public Participante(Jugador j, Juego ju) {
        this.juego = ju;
        this.jugador = j;
        this.saldoInicial = j.getSaldo();

    }

    public void apostar(double monto) throws ExceptionClass {

        juego.getMano().hayApuesta(this, monto);
    }

    public boolean salirDeMano() throws ExceptionClass {

        if (this.juego.getMano().salir(this)) {

            return true;
        }
        return false;
    }

    public boolean pagarApuesta() throws ExceptionClass {
        return juego.getMano().pagarApuesta(this);
    }

    public boolean confParticipanteEnJuego() {
        return juego.confirmarParticipante(this);
    }

    public void jugarNuevaMano() throws ExceptionClass {
        juego.JugarNuevaMano(this);
    }

    public void salirDelJuego() throws ExceptionClass {
        juego.sacarJugador(this);
    }

    public boolean hayCartaGanadora() {
        return this.juego.getMano().getGanadoras().size() != 0;
    }

    public void pasarMano() throws ExceptionClass {
        this.juego.getMano().pasar(this);
    }

}
