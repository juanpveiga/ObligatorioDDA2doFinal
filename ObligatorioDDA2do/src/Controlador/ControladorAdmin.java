/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ExceptionClass;
import Modelo.Juego;
import Modelo.Modelo;
import Modelo.SistemaJuego;
import Vista.IVistaAdmin;
import Vista.VistaAdmin;
import Vista.VistaLoginAdmin;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan Veiga
 */
public class ControladorAdmin implements Observer {

    private IVistaAdmin vista;
    private Modelo m = Modelo.getInstancia();
    private Juego detalleActual;

    public ControladorAdmin(VistaAdmin aThis) {
        this.vista = aThis;
        m.addObserver(this);

        vista.mostrarLuz(m.traerLuz());
        vista.mostrarCantidad(m.traerCantidad());
        vista.mostrarJuegosFinalizados(m.traerJuegosFinalizados());

    }

    @Override
    public void update(Observable o, Object evento) {

        
        if (evento.equals(Modelo.Eventos.cambioCantidad)) {
            vista.mostrarCantidad(m.traerCantidad());
        }

        if (evento.equals(Modelo.Eventos.cambioLuz)) {
            vista.mostrarLuz(m.traerLuz());
        }

        if (evento.equals(Modelo.Eventos.cambioJuego)) {
            /*try {
                vista.mostrarJuegos(m.traerJuegos());
                Juego j = m.traerDetalle(this.indexJuegoDetalle);
                if (this.detalleActual == j) {
                    vista.mostrarDetalleJuego(j);
                }
            } catch (ExceptionClass msg) {
                vista.mostrarError(msg.getMessage());
                vista.limpiarLista();
            }*/
            vista.mostrarJuegos(m.traerJuegos());
        }
        
        if (evento.equals(Modelo.Eventos.finJuego)) {
            vista.mostrarJuegosFinalizados(m.traerJuegosFinalizados());

        }

    }

    public void setLuz(double luz) {
        try {
            m.cambiarValorLuz(luz);
        } catch (ExceptionClass msg) {
            vista.mostrarError(msg.getMessage());
        }
    }

    public void setCantidad(int cantidad) {
        try {
            m.cambiarCantidad(cantidad);
        } catch (ExceptionClass msg) {
            vista.mostrarError(msg.getMessage());
        }
    }

    public void traerDetalle(int index, boolean activos) {
        try {
            Juego j = m.traerDetalle(index,activos);
            if (j != null) {
                this.detalleActual = j;
                vista.mostrarDetalleJuego(j);
            }
        } catch (ExceptionClass msg) {
            vista.mostrarError(msg.getMessage());
        }
    }

}
