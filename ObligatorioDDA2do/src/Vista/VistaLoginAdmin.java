/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ContLoginAdmin;
import Modelo.Administrador;
import Modelo.ExceptionClass;
import Modelo.Juego;
import Modelo.Participante;
import Modelo.SistemaJuego;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Juan Veiga
 */
public class VistaLoginAdmin extends VistaLogin implements IVistaLoginAdmin{

    private ContLoginAdmin controlador; 
   
    public VistaLoginAdmin(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        mostrarTitulo();
        controlador = new ContLoginAdmin(this);
       
    }

   

    @Override
    public void login()
{
            if(super.getUsuario() != "" && super.getPassword() != "")
          
              try {
                   controlador.login(super.getUsuario(),super.getPassword());
            } catch (ExceptionClass ex) {
                Logger.getLogger(VistaLoginAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
           
           
            }
       

  
   
   
    @SuppressWarnings("unchecked")
                      

                
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        setBounds(0, 0, 416, 339);
    }// </editor-fold>//GEN-END:initComponents

   

   

    @Override
    public void mostrarError(String msj) {
         JOptionPane.showMessageDialog(this, msj);
    }
    
    @Override
    public void mostrarTitulo() {
       setTitle("Login Administradores");
       repaint();
    }

    @Override
    public void mostrarVista(double luz, int cantidadJugadores, ArrayList<Juego> listaJuegos,Administrador ad) {
        dispose();  
        new VistaAdmin(null,false,luz,cantidadJugadores,listaJuegos,ad).setVisible(true);
    }

 

   

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
