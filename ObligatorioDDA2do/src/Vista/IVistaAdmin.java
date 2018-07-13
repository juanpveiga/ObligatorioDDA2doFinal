/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Juego;
import java.util.ArrayList;

/**
 *
 * @author Juan Veiga
 */
public interface IVistaAdmin {

    public void mostrarLuz(double traerLuz);

    public void mostrarCantidad(int traerCantidad);

    public void mostrarError(String message);
    
    public void mostrarJuegos(ArrayList<Juego> juegos);
    
    public void mostrarJuegosFinalizados(ArrayList<Juego> juegos);
    
    public void mostrarDetalleJuego(Juego j);

    public void limpiarLista();
    
    
}
