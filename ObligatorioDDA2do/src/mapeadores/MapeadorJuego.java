/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeadores;

import Modelo.Modelo;
import Modelo.Juego;
import Modelo.Jugador;
import Modelo.Participante;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.Mapeador;

/**
 *
 * @author Marcelo
 */
public class MapeadorJuego implements Mapeador{
    
    private Juego j;
    //private Modelo m = Modelo.getInstancia();
    private String ganador;
    
    public MapeadorJuego() {
    }

    public MapeadorJuego(Juego j) {
        this.j = j;
    }

    public void setFactura(Juego j) {
        this.j = j;
    }
    

    @Override
    public int getOid() {
        return j.getOid();
    }

    @Override
    public void setOid(int oid) {
        j.setOid(oid);
    }

    @Override
    public ArrayList<String> getSqlInsertar() {
        java.sql.Date fecha = new java.sql.Date(j.getFecha().getTime());
        ArrayList<String> sqls = new ArrayList();
        sqls.add("INSERT INTO juego VALUES (" + getOid() + "," 
                                                + "'" + fecha + "'" + ","
                                                + j.getContadorMano() + ",'" 
                                                + j.getGanador().getJugador().getUsuario() + "',"
                                                + j.getTotalApostado() + ","
                                                + j.getLuz() + ")");
        generarParticipantes(sqls);
        return sqls;
    }
    private void generarParticipantes(ArrayList<String> sqls){
        for(Participante p:j.getParticipantes()){
            sqls.add("INSERT INTO participante VALUES (" + getOid() + ","
                                                  + p.getSaldoInicial() + ","
                                                  + p.getTotalGanado() + ","
                                                  + p.getTotalApostado() + ",'"
                                                  + p.getJugador().getOid() + "')" 
            );
        }
    }

    @Override
    public ArrayList<String> getSqlModificar() {
        ArrayList<String> sqls = new ArrayList();
        sqls.add("UPDATE juego set cantMano = '" + j.getContadorMano()
                + ", ganador = '" + j.getGanador().getJugador().getUsuario() + "',"
                + "totalaApostado = " + j.getTotalApostado() + ","
                + "luz = " + j.getLuz()
                + "' WHERE oid=" + j.getOid());
        sqls.add("DELETE from participante where oid=" + j.getOid());
        generarParticipantes(sqls);
        return sqls;
    }

    @Override
    public ArrayList<String> getSqlBorrar() {
        ArrayList<String> sqls = new ArrayList();
        sqls.add("DELETE from participante WHERE oid=" + j.getOid());
        sqls.add("DELETE from juego WHERE oid = " + j.getOid());
        return sqls;
    }

    @Override
    public String getSqlSelect() {
        return "SELECT * FROM juego j,participante p, jugador ju"
                + " WHERE j.oid = p.juego AND p.jugador = ju.oid";
    }

    @Override
    public void crearNuevo() {
        j = new Juego();
    }

    @Override
    public void leerCompuesto(ResultSet rs) throws SQLException {
        j.setFecha(rs.getDate("fecha"));
        j.setContadorMano(rs.getInt("cantManos"));
        this.ganador = rs.getString("ganador");//VER SI ESTO ES VIABLE
        j.setTotalApostado(rs.getDouble("totalApostado"));
        j.setLuz(rs.getDouble("luz"));
    }

    @Override
    public Object getObjeto() {
        return j;
    }

    @Override
    public void leerComponente(ResultSet rs) throws SQLException {
        
        /*Jugador jugador = new Jugador(rs.getDouble("saldo"), rs.getString("usuario"), rs.getString("password"), 
                rs.getString("primerNombre"), rs.getString("segundoNombre"), rs.getString("primerApellido"), 
                rs.getString("segundoApellido"));*/
        Jugador jugador = Modelo.getInstancia().buscarJugador(rs.getInt("jugador"));
        
        Participante p = new Participante(jugador, j, rs.getDouble("saldoInicial"), rs.getDouble("totalGanado"), 
                rs.getDouble("totalApostado"));
        
        if(rs.getString("ganador") == this.ganador){
            j.setGanador(p);
        }
        j.agregar(p);
    }
    
}
