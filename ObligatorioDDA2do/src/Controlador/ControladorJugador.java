/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Carta;
import Modelo.ExceptionClass;
import Modelo.Juego;
import Modelo.Modelo;
import Modelo.Participante;
import Vista.IVistaJugador;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan Veiga
 */
public class ControladorJugador implements Observer {

    private IVistaJugador vistaJugador;
    private Participante p = null;
    private Modelo modelo = Modelo.getInstancia();
    private int restantes;

    public ControladorJugador(IVistaJugador aThis, Participante p) {

        this.p = p;
        this.vistaJugador = aThis;
        this.restantes = this.p.getJuego().calcularRestantes();
        vistaJugador.nombreJugador();
        mostrarJugadoresEnPartida();
        if (restantes > 0) {

            String msg = "Esperando inicio del juego Faltan: " + restantes;
            vistaJugador.mostrarTitulo(msg);

        }
        if (restantes == 0) {

            vistaJugador.nombreJugador();
            vistaJugador.mostrarTitulo("Partida Iniciada");
            if (p.getCartas().getFigura().devolverNombreFigura() != "Vacia") {
                vistaJugador.iniciarJuego(p.getCartas().getCartas(), p.getCartas().getFigura());
            } else {
                vistaJugador.iniciarJuegoSinFigura(p.getCartas().getCartas());
            }
            vistaJugador.mostrarPozo();
            mostrarJugadoresEnPartida();

        }
        p.getJuego().addObserver(this);
        modelo.addObserver(this);

    }

    @Override
    public void update(Observable o, Object evento) {

        if (evento.equals(Juego.Eventos.hayGanadorMano) && p.confParticipanteEnJuego()) {

            if (p.getJuego().getMano().getGanador().getCartas().getFigura().devolverNombreFigura() != "Vacia") {
                vistaJugador.mostrarGanador(p.getJuego().getMano().getGanador(), p.getJuego().getMano().getGanador().getCartas().getFigura().devolverNombreFigura());
            } else {
                vistaJugador.mostrarGanador(p.getJuego().getMano().getGanador());
            }

        }
        if (evento.equals(Juego.Eventos.hayApuesta) && p.getJuego().getMano().getApuesta().isTimerActivo()) {
            if (p.getJuego().getMano().getParticipantes().contains(p)) {
                if (p != p.getJuego().getMano().getApuesta().getApostador()) {
                    if (!p.getJuego().getMano().getListaDePagos().contains(p)) {

                        vistaJugador.mostrarApuesta(p.getJuego().getMano().getApuesta().getApostador().getJugador().getPrimerNombre(), p.getJuego().getMano().getApuesta().getApostador().getJugador().getPrimerApellido(),
                                p.getJuego().getMano().getApuesta().getMontoApuesta(), p.getJuego().getMano().getApuesta().getTiempoParaPagar());
                    } else {
                        vistaJugador.mostrarApuestaPagada(p.getJuego().getMano().getApuesta().getApostador().getJugador().getPrimerNombre(),
                                p.getJuego().getMano().getApuesta().getApostador().getJugador().getPrimerApellido(), p.getJuego().getMano().getApuesta().getMontoApuesta());

                    }

                } else {
                    vistaJugador.mostrarVistaApostador(p.getJuego().getMano().getApuesta().getMontoApuesta());
                }
            }
        }
        if (evento.equals(Juego.Eventos.actualizarPozo)) {
            vistaJugador.mostrarPozo();
        }
        if (evento.equals(Juego.Eventos.inicioNuevaMano)) {//antes el evento se llamaba cantidadAlcanzada

            vistaJugador.nombreJugador();
            vistaJugador.mostrarTitulo("Partida Iniciada");
            if (p.getCartas().getFigura().devolverNombreFigura() != "Vacia") {
                vistaJugador.iniciarJuego(p.getCartas().getCartas(), p.getCartas().getFigura());
            } else {
                vistaJugador.iniciarJuegoSinFigura(p.getCartas().getCartas());
            }
            vistaJugador.mostrarPozo();
            mostrarJugadoresEnPartida();

        }

        if (evento.equals(Juego.Eventos.jugadorAgregado) && modelo.hayRestantes()) {
            restantes = modelo.calcularRestantes();
            String msg = "Esperando inicio del juego Faltan: " + restantes;
            vistaJugador.mostrarTitulo(msg);
            mostrarJugadoresEnPartida();
        }
        if (evento.equals(Juego.Eventos.salioJugador) && modelo.hayRestantes()) {
            mostrarJugadoresEnPartida();
            if (!p.getJuego().esActivo()) {
                String msg = "Esperando inicio del juego" + modelo.calcularRestantes();
                vistaJugador.mostrarTitulo(msg);
            }

        }

        if (evento.equals(Juego.Eventos.hayGanadorJuego)) {
            vistaJugador.mostrarGanadorJuego(p.getJuego().getGanador());

        }

        if (evento.equals(Juego.Eventos.cambioCantidadJugadores)) {
            restantes = modelo.calcularRestantes();
            String msg = "Esperando inicio del juego Faltan: " + restantes;
            vistaJugador.mostrarTitulo(msg);
            mostrarJugadoresEnPartida();
        }
        if (evento.equals(Juego.Eventos.finTimer)) {
            if (!p.getJuego().getMano().getListaDePagos().contains(p)) {

                try {
                   
                   vistaJugador.sacarDeMano();
                   p.getJuego().getMano().salir(p);

                } catch (ExceptionClass ex) {
                    Logger.getLogger(ControladorJugador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public void pasarMano() {
        try {
            p.pasarMano();
            if (p.getJuego().getMano().soyElUltimo(p)) {
                vistaJugador.nombreJugador();
                vistaJugador.mostrarTitulo("Partida Iniciada");
                vistaJugador.iniciarJuego(p.getCartas().getCartas(), p.getCartas().getFigura());
                vistaJugador.mostrarPozo();
                mostrarJugadoresEnPartida();
            } else {
                vistaJugador.pasarMano();
            }
        } catch (ExceptionClass msg) {
            vistaJugador.mostrarError(msg.getMessage());
        }

    }

    public void apuesta(double monto) {
        try {
            p.apostar(monto);
        } catch (ExceptionClass msg) {
            vistaJugador.mostrarError(msg.getMessage());
        }
    }

    public void salirDeMano() {
        try {
            if (p.salirDeMano()) {
                vistaJugador.sacarDeMano();
            }
        } catch (ExceptionClass msg) {
            vistaJugador.mostrarError(msg.getMessage());
        }

    }

    public void pagarApuesta() {

        try {
            if (p.pagarApuesta() && p.getJuego().getMano().soyElUltimo(p)) {
            } else {
                if (p.pagarApuesta()) {
                    vistaJugador.mostrarApuestaPagada(p.getJuego().getMano().getApuesta().getApostador().getJugador().getPrimerNombre(), p.getJuego().getMano().getApuesta().getApostador().getJugador().getPrimerApellido(), p.getJuego().getMano().getApuesta().getMontoApuesta());
                }
            }
        } catch (ExceptionClass msg) {
            vistaJugador.mostrarError(msg.getMessage());
        }

    }

    public void nuevaMano() {

        try {
            vistaJugador.AguardandoNuevaMano();
            p.jugarNuevaMano();
        } catch (ExceptionClass msg) {
            vistaJugador.mostrarError(msg.getMessage());
            vistaJugador.cerrarVentana();
        }

    }

    public void mostrarJugadoresEnPartida() {
        ArrayList jugadores = p.getJuego().jugadoresEnPartida();

        vistaJugador.mostrarJugadoresEnPartida(jugadores);
    }

    public void salirDelJuego() {
        try {
            p.salirDelJuego();
            vistaJugador.cerrarVentana();
        } catch (ExceptionClass msg) {
            vistaJugador.mostrarError(msg.getMessage());
        }
    }

}
