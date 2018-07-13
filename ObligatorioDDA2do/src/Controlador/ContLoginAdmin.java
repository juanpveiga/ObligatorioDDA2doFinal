/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ExceptionClass;
import Modelo.Modelo;
import Modelo.Administrador;
import Vista.IVistaLoginAdmin;

import Vista.VistaLoginAdmin;
import java.awt.Component;
import javax.swing.JOptionPane;


/**
 *
 * @author Juan Veiga
 */
public class ContLoginAdmin {
    
    private Modelo modelo = Modelo.getInstancia();
    private IVistaLoginAdmin vistaLoginAdmin;
    
    public ContLoginAdmin(VistaLoginAdmin v )
    {
        this.vistaLoginAdmin = v;
    }
    
    public void login(String usu,String pass) throws ExceptionClass
    {
         try{
                Administrador ad = modelo.loginAdmin(usu,pass);
                vistaLoginAdmin.mostrarVista(modelo.traerLuz(),modelo.traerCantidadJugadores(),modelo.traerJuegos(),ad);
        }
        catch(ExceptionClass msg)
        {
               vistaLoginAdmin.mostrarError(msg.getMessage());
        }
    }
            
    }


