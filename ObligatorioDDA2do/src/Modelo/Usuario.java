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
public abstract class Usuario {
    
    private String usuario;
    private String password;
    private String primerNombre;
    private String segundoNombre;
    private String PrimerApellido;
    private String SegundoApellido;
    private int oid;
    
    public int getOid(){
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public void setPrimerApellido(String PrimerApellido) {
        this.PrimerApellido = PrimerApellido;
    }

    public void setSegundoApellido(String SegundoApellido) {
        this.SegundoApellido = SegundoApellido;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public String getPrimerApellido() {
        return PrimerApellido;
    }

    public String getSegundoApellido() {
        return SegundoApellido;
    }

    public Usuario(String usuario, String password, String primerNombre, String segundoNombre, String PrimerApellido, String SegundoApellido) {
        this.usuario = usuario;
        this.password = password;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.PrimerApellido = PrimerApellido;
        this.SegundoApellido = SegundoApellido;
    }
    
    public Usuario(){
        
    }
}
