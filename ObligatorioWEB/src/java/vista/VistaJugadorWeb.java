/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Controlador.ControladorJugador;
import Modelo.Carta;
import Modelo.Figura;
import Modelo.Jugador;
import Modelo.Participante;
import Vista.IVistaJugador;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Juan Veiga
 */
public class VistaJugadorWeb implements IVistaJugador {

    private ControladorJugador controlador;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private PrintWriter out;

    @Override
    public void setTitle(String partida_Iniciada) {
    }

    @Override
    public void mostrarVistaApostador(double monto) {

        String salida = "Ha apostado $ " + monto + " ... Esperando al resto de jugadores";
        enviar("mostrarApostador", salida);
    }

    @Override
    public void pasarMano() {
        enviar("pasarMano", "no");
    }

    @Override
    public void sacarDeMano() {
        enviar("sacarDeLaMano", "no");
    }

    @Override
    public void mostrarError(String msj) {
        enviar("error", msj);
    }

    @Override
    public void cerrarVentana() {
    }

    @Override
    public void nombreJugador() {
        Participante p = (Participante) request.getSession(false).getAttribute("participante");
        String nombre = p.getJugador().getPrimerNombre() + "" + p.getJugador().getPrimerApellido() + " ";
        enviar("mostrarNombre", nombre);
    }

    @Override
    public void mostrarTitulo(String partida_Iniciada) {
        enviar("mostrarTitulo", partida_Iniciada);
    }

    @Override
    public void mostrarGanadorJuego(Participante ganador) {

        String salida = "Felicitaciones " + ganador.getJugador().getPrimerNombre() + " " + ganador.getJugador().getPrimerApellido() + " Ganaste La Partida " + ganador.getJugador().getSaldo() + ".";
        enviar("ganadorJuego", salida);
    }

    @Override
    public void AguardandoNuevaMano() {
        String salida = "Aguardando comienzo de nueva mano";
        enviar("esperaNuevaMano", salida);
    }

    @Override
    public void mostrarJugadoresEnPartida(ArrayList<Jugador> jugadores) {
        String salida = "<h2>Jugadores en Aprtida : </h2><br>";
        for (Jugador j : jugadores) {
            salida += "<p>" + j.getPrimerNombre() + " " + j.getPrimerApellido() + "</p>";

        }
        enviar("jugadores", salida);
    }

    @Override
    public void mostrarPozo() {
        Participante p = (Participante) request.getSession(false).getAttribute("participante");
        double pozo = p.getJuego().getMano().getPozo().getPozo();
        enviar("montoPozo", "" + pozo + ".");
    }

    @Override
    public void iniciarJuego(ArrayList<Carta> cartas, Figura figura) {

        String mensaje = "";
        for (Carta carta : cartas) {
            String path = "http://localhost:8084/ObligaDDAWEB//cartas/" + carta.getNumero() + carta.getPalo() + ".gif";
            mensaje += "<image width ='110'height='160' src='" + path + "'>";

        }
        if (figura != null) {

            mensaje += "<br>Figura : " + figura.devolverNombreFigura();
        }
        enviar("iniciarJuego", mensaje);
    }

    @Override
    public void iniciarJuegoSinFigura(ArrayList<Carta> cartas) {

        String mensaje = "";
        for (Carta carta : cartas) {
            String path = "http://localhost:8084/ObligaDDAWEB//cartas/" + carta.getNumero() + carta.getPalo() + ".gif";
            mensaje += "<image width ='110'height='160' src='" + path + "'>";

        }
        enviar("iniciarJuego", mensaje);
    }

    @Override
    public void mostrarGanador(Participante ganador) {
        ArrayList<Carta> cartas = new ArrayList();
        String mensaje = "Ganador de la Mano " + ganador.getJugador().getPrimerNombre() + " " + ganador.getJugador().getPrimerApellido() + ".";
        String ganadora = ""; 
        cartas = ganador.getJuego().getMano().getGanadoras();
        for (Carta carta : cartas) {
            String path = "http://localhost:8084/ObligaDDAWEB//cartas/" + carta.getNumero() + carta.getPalo() + ".gif";
            ganadora += "<image width ='110'height='160' src=' " + path + "'>";

        }
        
        enviar("mostrarGanadorMano", mensaje);
        enviar("mostrarGanadoras", ganadora);
        

    }

    @Override
    public void mostrarGanador(Participante ganador, String devolverNombreFigura) {
        ArrayList<Carta> cartas = new ArrayList();
        String mensaje = "Ganador de la Mano " + ganador.getJugador().getPrimerNombre() + " " + ganador.getJugador().getPrimerApellido() + ". Gano con la figura " + devolverNombreFigura + ".";
        String ganadoras = ""; 
        cartas = ganador.getJuego().getMano().getGanadoras();
        for (Carta carta : cartas) {
            String path = "http://localhost:8084/ObligaDDAWEB//cartas/" + carta.getNumero() + carta.getPalo() + ".gif";
            ganadoras += "<image width ='110'height='160' src=' " + path + "'>";

        }
        //mensaje += "<br>Figura : " + devolverNombreFigura;
        enviar("mostrarGanadorMano", mensaje);
        enviar("mostrarGanadoras", ganadoras);

    }

    @Override
    public void mostrarApuesta(String primerNombre, String primerApellido, double montoApuesta, int tiempo) {
        String salida = "";
        String montoTxt = Integer.toString((int) montoApuesta);
        String tiempoPagar = Integer.toString(tiempo);
        salida = primerNombre
                + " " + primerApellido + " aposto $ " + montoTxt + " Tiempo : " + tiempoPagar;
        enviar("mostrarApuesta", salida);

    }

    @Override
    public void mostrarApuestaPagada(String primerNombre, String primerApellido, double montoApuesta) {

        String salida = primerNombre
                + " " + primerApellido + " aposto $ " + montoApuesta + " Usted ya Pago.";
        enviar("mostrarApuestaPagada", salida);
    }

    public void conectarSSE(HttpServletRequest request) throws IOException {
        request.setAttribute("org.apache.catalina.ASYNC_SUPPORTED", true);
        AsyncContext contexto = request.startAsync();
        this.request = (HttpServletRequest) contexto.getRequest();
        contexto.getResponse().setContentType("text/event-stream");
        contexto.getResponse().setCharacterEncoding("UTF-8");
        contexto.setTimeout(0);//SIN TIMEOUT
        out = contexto.getResponse().getWriter();
    }

    public void enviar(String evento, String dato) {
        out.write("event: " + evento + "\n");
        dato = dato.replace("\n", "");
        out.write("data: " + dato + "\n\n");
        if (out.checkError()) {//checkError llama a flush, si da false evio bien
            //out.flush();
        } else {
            //TODO OK!
            System.out.println("Enviado");
        }
    }

    public void inicializar() {
        Participante p = (Participante) request.getSession(false).getAttribute("participante");
        controlador = new ControladorJugador(this, p);
    }

    public void procesar(HttpServletRequest request, String accion) {
        switch (accion) {
            case "pasar":
                controlador.pasarMano();
                break;

            case "apostar":
                double doble = Double.parseDouble(request.getParameter("monto"));
                controlador.apuesta(doble);
                break;
            case "salir":
                controlador.salirDelJuego();
                break;
            case "salirDeLaMano":
                controlador.salirDeMano();
                break;
            case "nuevaMano":
                controlador.nuevaMano();
                break;
            case "pagarApuesta":
                controlador.pagarApuesta();
        }
    }

}
