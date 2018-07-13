/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo;
import Modelo.Participante;
import Vista.VistaJugador;
import Vista.VistaLoginJugador;
import Modelo.ExceptionClass;
import Vista.IVistaLoginJugador;
import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan Veiga
 */
public class ContLoginJugador {

    private IVistaLoginJugador vistaLogin;
    private Modelo modelo = Modelo.getInstancia();

 
    public ContLoginJugador(IVistaLoginJugador aThis) {
        this.vistaLogin = aThis;

    }

    public void login(String usu, String pass) throws ExceptionClass {
        try {
            Participante p = modelo.loginJugador(usu, pass);
            vistaLogin.mostrarVista(p);
        } catch (ExceptionClass msg) {
            vistaLogin.mostrarError(msg.getMessage());
        }
    }
}
