/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Carta;
import Modelo.Figura;
import Modelo.Jugador;
import Modelo.Participante;
import Modelo.Figura;
import java.util.ArrayList;

/**
 *
 * @author Juan Veiga
 */
public interface IVistaJugador {

    //public void mostrarTitulo(String msg, int restantes);

    public void setTitle(String partida_Iniciada);

    public void mostrarGanador(Participante ganador);

    public void mostrarVistaApostador(double monto);

    public void pasarMano();

    public void sacarDeMano();
    
    public void mostrarError(String msj);

    public void cerrarVentana();

    public void nombreJugador();

    public void mostrarTitulo(String partida_Iniciada);

    public void mostrarGanadorJuego(Participante ganador);

    public void AguardandoNuevaMano();
    
    public void mostrarJugadoresEnPartida(ArrayList<Jugador> jugadores);
    
    public void mostrarPozo();

    public void iniciarJuego(ArrayList<Carta> cartas, Figura figura);

    public void iniciarJuegoSinFigura(ArrayList<Carta> cartas);

    public void mostrarGanador(Participante ganador, String devolverNombreFigura);

    public void mostrarApuesta(String primerNombre, String primerApellido, double montoApuesta,int tiempo);

     public void mostrarApuestaPagada(String primerNombre, String primerApellido, double montoApuesta);
    
    
}
