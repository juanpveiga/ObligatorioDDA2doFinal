/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeadores;

import Modelo.Jugador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.Mapeador;

/**
 *
 * @author Marcelo
 */
public class MapeadorJugador implements Mapeador{
    
    private Jugador j;

    
    public MapeadorJugador() {
    }

    public MapeadorJugador(Jugador j) {
        this.j = j;
    }

    public void setUsuario(Jugador j) {
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
        ArrayList<String> sqls = new ArrayList();
        sqls.add("INSERT INTO jugador values (" + getOid() + ",'" +
                    j.getUsuario() + "','" + j.getPassword()+ "','" +
                    j.getPrimerNombre() + "','" + j.getSegundoNombre() + "','" +
                    j.getPrimerApellido() + "','" + j.getSegundoApellido() + "'," +
                    j.getSaldo() + ")");
        return sqls;
    }

    @Override
    public ArrayList<String> getSqlModificar() {
        ArrayList<String> sqls = new ArrayList();
        sqls.add("UPDATE jugador set usuario='" + j.getUsuario() +
                    "',password='" + j.getPassword() +
                    "',primerNombre='" + j.getPrimerNombre() +
                    "',segundoNombre='" + j.getSegundoNombre() +
                    "',primerApellido='" + j.getPrimerApellido() +
                    "',segundoApellido='" + j.getSegundoApellido() +
                    "',saldo=" + j.getSaldo() +
                    " where oid=" + getOid());
        return sqls;
        
        
    }

    @Override
    public ArrayList<String> getSqlBorrar() {
        ArrayList<String> sqls = new ArrayList();
        
        sqls.add("DELETE FROM jugador WHERE oid =" + j.getOid());
        return sqls;
    }

    @Override
    public String getSqlSelect() {
        return "SELECT * FROM jugador";
    }

    @Override
    public void crearNuevo() {
        j = new Jugador();
    }

    @Override
    public void leerCompuesto(ResultSet rs) throws SQLException {
         j.setUsuario(rs.getString("usuario"));
         j.setPassword(rs.getString("password"));
         j.setPrimerNombre(rs.getString("primerNombre"));
         j.setSegundoNombre(rs.getString("segundoNombre"));
         j.setPrimerApellido(rs.getString("primerApellido"));
         j.setSegundoApellido(rs.getString("segundoApellido"));
         j.setSaldo(rs.getDouble("saldo"));
    }

    @Override
    public Object getObjeto() {
        return j;
    }

    @Override
    public void leerComponente(ResultSet rs) throws SQLException {
        
    }
}
