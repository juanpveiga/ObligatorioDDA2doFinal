/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Juan Veiga
 */
public class Administrador extends Usuario {

    
    public Administrador(String usuario, String password, String primerNombre, String segundoNombre, String PrimerApellido, String SegundoApellido) {
        super(usuario, password, primerNombre, segundoNombre, PrimerApellido, SegundoApellido);
        
    }

    public Administrador(){
        
    }

    public boolean login(String usu, String pass)  {
       
         return super.getUsuario().equals(usu) && super.getPassword().equals(pass); 
          
       
    }
    
}
