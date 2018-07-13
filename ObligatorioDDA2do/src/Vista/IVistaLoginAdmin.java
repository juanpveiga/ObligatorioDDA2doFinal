/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Administrador;
import Modelo.Juego;
import java.util.ArrayList;

/**
 *
 * @author Juan Veiga
 */
public interface IVistaLoginAdmin {
    
     public void login();
    
    public void mostrarError(String msj);
    
    public void mostrarVista(double luz, int cantidadJugadores, ArrayList<Juego> listaJuegos,Administrador ad);
    
    public void mostrarTitulo();
}
