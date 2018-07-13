/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Participante;

/**
 *
 * @author Juan Veiga
 */
public interface IVistaLoginJugador {
    
    public void login();
    
    public void mostrarError(String msj);
    
    public void mostrarVista(Participante p);
    
    public void mostrarTitulo();
    
}
