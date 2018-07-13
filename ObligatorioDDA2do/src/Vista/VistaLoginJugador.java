/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ContLoginJugador;
import Modelo.ExceptionClass;
import Modelo.Participante;
import java.awt.Frame;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Juan Veiga
 */
public class VistaLoginJugador extends VistaLogin implements IVistaLoginJugador
{

    private ContLoginJugador controlador;
   
    /**
     * Creates new form VistaLoginJugador
     */
    public VistaLoginJugador(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        mostrarTitulo();
        controlador = new ContLoginJugador(this);
       
    }

    @Override
    public void mostrarError(String msj) {
        JOptionPane.showMessageDialog(this, msj);
    }

  
  @Override
   public void login()
   {
        try {
            controlador.login(super.getUsuario(),super.getPassword());
        } catch (ExceptionClass ex) {
            Logger.getLogger(VistaLoginJugador.class.getName()).log(Level.SEVERE, null, ex);
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
    public void mostrarVista(Participante p) {
        dispose();
        new VistaJugador(p).setVisible(true);
    }
    
    
    @Override
    public void mostrarTitulo() {
       setTitle("Login Jugadores");
       
    }

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
