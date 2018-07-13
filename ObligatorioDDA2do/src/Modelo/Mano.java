/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Juego.Eventos;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Juan Veiga
 */
public class Mano {

    private Mazo mazo;
    private Pozo pozo;
    private Apuesta apuesta;
    private ArrayList<Participante> participantes;
    private ArrayList<Participante> participantesPasaron = new ArrayList();
    private Participante ganador;
    //private Carta ganadora;
    private ArrayList<Carta> ganadoras = new ArrayList();
    private ArrayList<Participante> listaDePagos = new ArrayList();

    public Mano(ArrayList<Participante> participantes, Pozo pozo) {

        this.pozo = pozo;
        this.mazo = new Mazo();
        this.participantes = new ArrayList(participantes);
        repartirCartas();
    }

    public ArrayList<Participante> getParticipantes() {
        return participantes;
    }

    public ArrayList<Participante> getListaDePagos() {
        return listaDePagos;
    }

    public Pozo getPozo() {
        return pozo;
    }

    public ArrayList<Carta> getGanadoras() {
        return ganadoras;
    }

    public Participante getGanador() {
        return ganador;
    }

    public Apuesta getApuesta() {
        return apuesta;
    }

    public void hayApuesta(Participante aThis, double monto) throws ExceptionClass {
        Apuesta a = new Apuesta();
        if (a.agregarDatos(monto, aThis)) {
            boolean salida = true;
            double menor = saldoMenor();
            if (menor < monto) {
                throw new ExceptionClass("El saldo debe ser menor a " + menor);
            }

            if (salida) {
                this.apuesta = a;
                participantesPasaron.clear();
                pagarApuesta(aThis);
                this.apuesta.activarTimerPago();
                aThis.getJuego().avisar(Eventos.hayApuesta);
            }
        }

    }

    private double saldoMenor() {
        double menor = Double.MAX_VALUE;
        for (Participante p : participantes) {
            if (p.getJugador().getSaldo() < menor) {
                menor = p.getJugador().getSaldo();
            }
        }
        return menor;
    }

    private void repartirCartas() {

        ArrayList<Carta> cartas = this.mazo.getCartas();
        ArrayList<Carta> nuevo = new ArrayList();
        Collections.shuffle(cartas);
        int j = 0;
        for (Participante p : participantes) {
            int contador = 0;
            nuevo.clear();

            for (int i = j; i < cartas.size() && contador < 5; i++) {

                Carta get = cartas.get(i);
                contador++;
                nuevo.add(get);
                j = i + 1;
            }

            p.cargarCartas(nuevo);

        }

    }

    public void pasar(Participante p) throws ExceptionClass {

        if (!participantesPasaron.contains(p)) {
            participantesPasaron.add(p);

            if (participantesPasaron.size() == participantes.size()) {
                participantesPasaron.clear();
                p.getJuego().iniciarNuevaMano(pozo.getPozo());
            }
        } else {
            throw new ExceptionClass("Ya ha pasado de mano... debe esperar al resto de jugadores");
        }
    }

    public boolean salir(Participante p) throws ExceptionClass {
        boolean salida = false;
        if(participantes.contains(p)){
        participantes.remove(p);
        if (listaDePagos.contains(p)) {
            listaDePagos.remove(p);

        }
        if (!participantes.contains(p)) {
            salida = true;

        }

        if (participantes.size() == listaDePagos.size() || participantes.size() == 1) {

            buscarGanador();
            Modelo.getInstancia().avisar(Modelo.Eventos.cambioJuego);

        }

        if (participantes.size() == participantesPasaron.size()) {
            participantesPasaron.clear();
            p.getJuego().iniciarNuevaMano((int) pozo.getPozo());
        }
        }
        return salida;
    }

    public boolean pagarApuesta(Participante p) throws ExceptionClass {
        boolean salida = true;
        if (!listaDePagos.contains(p)) {
            if (participantes.contains(p)) {

                if (this.apuesta.pagarApuesta(p)) {
                    salida = true;
                    listaDePagos.add(p);
                    pozo.actualizar(apuesta.getMontoApuesta());
                    p.getJuego().setTotalApostado(apuesta.getMontoApuesta());
                    p.setTotalApostado(apuesta.getMontoApuesta());

                    p.getJuego().avisar(Eventos.actualizarPozo);
                }

                if (participantes.size() == listaDePagos.size()) {

                    buscarGanador();
                }

                Modelo.getInstancia().avisar(Modelo.Eventos.cambioJuego);

            } else {
                throw new ExceptionClass("No se encuentra en Juego en esta mano ");
            }
        } else {
            throw new ExceptionClass("Usted ya pago la apuesta.");

        }
        return salida;
    }

    private void buscarGanador() {
        if(apuesta!=null){
            apuesta.descativarTimer();
        }
        
        if (this.ganador == null) {
            this.ganador = evaluarFigura();
        }
        if (ganador != null) {
            cobrarApuestaGanada();
            listaDePagos.add(ganador);
            this.ganador.getJuego().avisar(Eventos.hayGanadorMano);
        }

    }

    public boolean confirmarParticipante(Participante p) {
        if (participantes.contains(p)) {
            return true;
        }
        return false;
    }

    private void cobrarApuestaGanada() {
        this.ganador.setTotalGanado(this.getPozo().getPozo());
        this.ganador.getJugador().cobrarApuestaGanada(this.getPozo().getPozo());
    }

    public boolean soyElUltimo(Participante p) {
        return participantesPasaron.isEmpty();
    }

    private Participante evaluarFigura() {
        this.ganadoras.clear();
        Participante ganador = null;
        Figura fGanadora = null;
        ArrayList<Participante> ganadores = new ArrayList();
        int mayor = Integer.MIN_VALUE;
        for (Participante p : participantes) {
            if (p.getCartas().getFigura() != null) {
                if (p.getCartas().getFigura().primerValor >= mayor) {
                    mayor = p.getCartas().getFigura().primerValor;
                    fGanadora = p.getCartas().getFigura();
                    ganadores.add(p);

                }
            }
        }
        if (ganadores.size() == 1) {
            ganador = ganadores.get(0);
            if (fGanadora.devolverNombreFigura().equals("Vacia")) {
                ganador.getCartas().dejarSoloGanadora();
            }
            for (Carta c : ganador.getCartas().getCartas()) {
                this.ganadoras.add(c);
            }

            return ganador;
        } else {
            ganador = fGanadora.desempate(ganadores);
            if (ganador != null) {
                if (fGanadora.devolverNombreFigura().equals("Vacia")) {
                    ganador.getCartas().dejarSoloGanadora();
                }
                for (Carta c : ganador.getCartas().getCartas()) {
                    this.ganadoras.add(c);
                }
            }
            return ganador;
        }

    }

}
