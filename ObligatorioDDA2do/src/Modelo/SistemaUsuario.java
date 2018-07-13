/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import mapeadores.MapeadorAdministrador;
import mapeadores.MapeadorJugador;
import persistencia.Persistencia;

/**
 *
 * @author Juan Veiga
 */
public class SistemaUsuario {

    private MapeadorJugador mj = new MapeadorJugador();
    private MapeadorAdministrador ma = new MapeadorAdministrador();
    private ArrayList<Jugador> jugadores = new ArrayList();
    private ArrayList<Administrador> administradores = new ArrayList();

    public Participante loginJugador(String usuario, String password) throws ExceptionClass {
        Participante p = null;
        if (jugadores.size() == 0) {
            throw new ExceptionClass("Lista de jugadores vacia");
        } else {
            for (Jugador j : jugadores) {

                if (j.login(usuario, password)) {
                    return Modelo.getInstancia().agregarJugadorJuego(j);
                }
            }
            if (p == null) {
                throw new ExceptionClass("Datos Incorrectos");
            }
        }
        return p;
    }

    public Administrador loginAdmin(String usu, String pass) throws ExceptionClass {
        Administrador ad = null;

        if (administradores.size() == 0) {
            throw new ExceptionClass("Lista de administradores vacia");
        } else {
            for (Administrador a : administradores) {

                if (a.login(usu, pass)) {
                    ad = a;
                }
            }
            if (ad == null) {
                throw new ExceptionClass("Datos Incorrectos");
            }
        }
        return ad;
    }

    public void agregarJugador(Jugador j) {
        if (j == null) {
        } else {
            jugadores.add(j);
        }

    }

    public void agregarAdmin(Administrador a) {

        if (a == null) {
        } else {
            administradores.add(a);
        }
    }
    
    public void cargarJugadores(){
        jugadores.addAll(Persistencia.getInstancia().todos(mj));
    }
    
    public void cargarAdministradores(){
        administradores.addAll(Persistencia.getInstancia().todos(ma));
    }
    
    public Jugador buscarJugador(int oid){
        for(Jugador j : jugadores){
            if(j.getOid() == oid)
                return j;
        }
        return null;
    }
    
    public Jugador buscarJugador(String usuario){
        for(Jugador j:jugadores){
            if(j.getUsuario() == usuario){
                return j;
            }
        }
        return null;
    }
            
}
