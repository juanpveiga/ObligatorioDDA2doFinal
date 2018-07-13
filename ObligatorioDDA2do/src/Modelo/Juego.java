/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Date;
import mapeadores.MapeadorJuego;
import persistencia.Persistencia;

/**
 *
 * @author Juan Veiga
 */
public class Juego extends Observable {

    private int cantidad;
    private Mano mano;
    private ArrayList<Participante> participantes = new ArrayList();
    private ArrayList<Participante> participantesActivos = new ArrayList();
    private ArrayList<Participante> participantesSiguienteMano = new ArrayList();
    private int contadorMano = 0;
    private int contParticipanteProxMano = 0;
    private double luz;
    private Participante ganador;
    private double totalApostado;
    private int tiempoParaPagar;
    private int oid;
    private Date fecha = new Date();
    private MapeadorJuego mapJuego = new MapeadorJuego(this);
    
    
    
    public Juego(){
        
    }

    public Juego(double luz, int cantidadJugadores,int tiempoParaPagar) {
        this.cantidad = cantidadJugadores;
        this.luz = luz;
        this.tiempoParaPagar = tiempoParaPagar;
        
    }

    public void setParticipantes(ArrayList<Participante> participantes) {
        this.participantes = participantes;
    }

    public void setContadorMano(int contadorMano) {
        this.contadorMano = contadorMano;
    }

    public void setGanador(Participante ganador) {
        this.ganador = ganador;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    

    public double getLuz() {
        return luz;
    }
    
    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }
    
     public int getTiempoParaPagar() {
        return tiempoParaPagar;
    } 
     
    public double getTotalApostado() {
        return totalApostado;
    }

    public Date getFecha() {
        return fecha;
    }

    public Participante getGanador() {
        return ganador;
    }

    public void setTotalApostado(double totalApostado) {
        this.totalApostado += totalApostado;
    }

    public ArrayList<Participante> getParticipanteActivo() {
        return participantesActivos;
    }
    
      public enum Eventos {
        
        inicioNuevaMano,
        salioJugador,
        hayApuesta,
        jugadorAgregado,
        hayGanadorMano,
        jugadorIngresadoParaProximaMano,
        hayGanadorJuego,
        cambioCantidadJugadores,
        actualizarPozo, 
        finTimer;
    }

    public void avisar(Eventos evento) {
        setChanged();
        notifyObservers(evento);
    }
    
    /*public void agregar(Jugador j, double saldoInicial, double totalGanado, double totalApostado){
        participantes.add(new Participante(j, this, saldoInicial, totalGanado, totalApostado));
    }*/
    
    public void agregar(Participante p){
        participantes.add(p);
    }

    public void sacarJugador(Participante p) throws ExceptionClass{
        
        Modelo.getInstancia().avisar(Modelo.Eventos.cambioJuego);
        
        if (mano == null) {
            participantes.remove(p);
            participantesActivos.remove(p);
          } else {
            if (participantesActivos.contains(p)) {
                if (mano.salir(p)) {
                    participantesActivos.remove(p);
                    if(participantesSiguienteMano.contains(p)){
                        participantesSiguienteMano.remove(p);
                    }
                    if (participantesActivos.size() == participantesSiguienteMano.size())
                    {
                        iniciarNuevaMano(0);
                    }else  if(participantesActivos.size() == 1){
                        finDelJuego();
                    }
                }
            }
           
        }
        avisar(Eventos.salioJugador);
       
    }
    
    public void finDelJuego(){
        this.ganador = participantesActivos.get(0);
        Persistencia.getInstancia().guardar(mapJuego);
        avisar(Juego.Eventos.hayGanadorJuego);
        Modelo.getInstancia().avisar(Modelo.Eventos.finJuego);
    }

    public int calcularRestantes() {
        if (contadorMano == 0) {
            return cantidad - participantes.size();
        }
        return 0;
    }

    public void iniciarNuevaMano(double montoManoAnt) throws ExceptionClass {
        participantesSiguienteMano.clear();
        double total = calcularPozo() + montoManoAnt;
        Pozo pozo = new Pozo(total);
        this.mano = new Mano(participantesActivos, pozo);
        contadorMano++;
        Modelo.getInstancia().avisar(Modelo.Eventos.cambioJuego);
        avisar(Eventos.inicioNuevaMano);

    }

    public boolean salirMano(Participante aThis) throws ExceptionClass{
        return mano.salir(aThis);
    }


    /*public void cerrarJuego(Participante p) {
        ganador = p;
        
        avisar(Juego.Eventos.hayGanadorJuego);
    }*/

    public boolean confirmarParticipante(Participante p) {
        return mano.confirmarParticipante(p);
    }

    public void JugarNuevaMano(Participante p) throws ExceptionClass {
        if (chequearSaldo(p)) {
             participantesSiguienteMano.add(p);
            if (participantesActivos.size() == participantesSiguienteMano.size()) {
               
                iniciarNuevaMano(0);
             }
        } else {
            participantesActivos.remove(p);
            if(participantesActivos.size() == 1){
                finDelJuego();
            }
            throw new ExceptionClass("Se elimino del Juego por saldo insuficiente");
        }

    }

    private boolean chequearSaldo(Participante p) {
        return p.getJugador().validarSaldo(luz);
    }

    public boolean esActivo() {
        return this.mano != null;
    }
    
    public boolean fin()
    {
        return this.ganador != null;
    }

    public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
    }

    public void setLuz(double luz) {
        this.luz = luz;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Mano getMano() {
        return mano;
    }

    public ArrayList<Participante> getParticipantes() {
        return participantes;
    }

    public int getContadorMano() {
        return contadorMano;
    }
    
    public void verificarCantidadJugadores(int cantidad) throws ExceptionClass{
        if(this.participantes.size() == cantidad){
            this.cantidad = cantidad;
            iniciarJuego();
        } else if(this.participantes.size() < cantidad){
            this.cantidad = cantidad;
            avisar(Eventos.cambioCantidadJugadores);
        }
    }

    private void iniciarJuego() throws ExceptionClass {
        
        this.fecha.getTime();
        iniciarNuevaMano(0);
        Modelo.getInstancia().crearNuevoJuego();
       
    }

    private double calcularPozo() throws ExceptionClass {
        double salida = 0;

        for (Participante participante : participantesActivos) {
            if (participante.getJugador().descontarLuz(this.luz)) {
                participante.setTotalApostado(luz);
                salida = salida + luz;
            } else {
                throw new ExceptionClass("Se elimino del Juego por saldo insuficiente");
            }
        }
        this.totalApostado += salida;
        return salida;
    }

    public Participante agregarJugador(Jugador j) throws ExceptionClass {
        Participante p = null;
        if (j != null) {

            for (Participante participante : participantes) {

                if (participante.getJugador() == j) {
                    throw new ExceptionClass("El Jugador ya esta en el Juego a comenzar ");
                }
            }
            p = new Participante(j, this);
            participantes.add(p);
            participantesActivos.add(p);
            avisar(Eventos.jugadorAgregado);
            if (participantes.size() == cantidad) {
                iniciarJuego();
            }

        }
        return p;
    }
    
   
    public ArrayList<Jugador> jugadoresEnPartida(){
        ArrayList<Jugador> jugadores = new ArrayList();
        for(Participante p : this.participantesActivos){
            jugadores.add(p.getJugador());
        }
        return jugadores;
    }

 

}
