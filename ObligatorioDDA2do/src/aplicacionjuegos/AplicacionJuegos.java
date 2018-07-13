/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionjuegos;

import Modelo.Administrador;
import Modelo.Jugador;
import Modelo.Modelo;
import Modelo.TipoColor;
import Modelo.TipoDoblePar;
import Modelo.TipoPar;

import Vista.Inicio;
import mapeadores.MapeadorAdministrador;
import mapeadores.MapeadorJuego;
import mapeadores.MapeadorJugador;



/**
 *
 * @author Juan Veiga
 */
public class AplicacionJuegos {

  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
     Modelo m = Modelo.getInstancia();
     
     m.crearNuevoJuego();  
     /*m.agregarJugador(new Jugador(200,"Juan","12345", "Juan", "Pedro","Veiga","Zabala"));
     m.agregarJugador(new Jugador(200,"Jose","12345", "Jose", "Pablo","Gonzalez","Oviedo"));
     m.agregarJugador(new Jugador(200,"Jorge","12345", "Jorge", "Pedro","Fernandez","Brum"));
     m.agregarJugador(new Jugador(200,"Marcelo","12345", "Marcelo", "","Zanchez","Rodriguez"));
     m.agregarJugador(new Jugador(200,"LEON","12345", "Leon", "Agustin","Viega","Palleiro"));
     m.agregarJugador(new Jugador(200,"Lucas","12345","Lucas", "Martin", "Lorenzo", "Lorenzo"));
     m.agregarJugador(new Jugador(200,"Mariano","12345","Mariano", "Manuel", "Fernandez", "Suarez"));
     
     m.agregarAdmin(new Administrador("Gervaz","asdf","Armando","Esteban","Quito",""));
     m.agregarAdmin(new Administrador("Gamboa","asdf","Adriana","Lucia","Reyes","Gonzalez"));*/
     
     //MapeadorJugador mj = new MapeadorJugador();
     //MapeadorAdministrador ma = new MapeadorAdministrador();
     //MapeadorJuego mjuego = new MapeadorJuego();
     m.agregarJugador(new Jugador(200,"TATU","12345", "Tatu", "Tatu","Tatu","Palleiro"));
     m.agregarAdmin(new Administrador("Arveja","asdf","Armando","Esteban","Quito",""));
     m.cargarJugadores();
     m.cargarAdministradores();
     m.cargarJuegos();
     
     
     m.agregarFigura(new TipoPar());
     m.agregarFigura(new TipoDoblePar());
     m.agregarFigura(new TipoColor());
    
      
     new Inicio(null,false).setVisible(true);
     
     
        // TODO code application logic here
    }
    
}
