/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeadores;

import Modelo.Administrador;
import Modelo.Jugador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.Mapeador;

/**
 *
 * @author Marcelo
 */
public class MapeadorAdministrador implements Mapeador{
    
    
    private Administrador a;

    
    public MapeadorAdministrador() {
    }

    public MapeadorAdministrador(Administrador a) {
        this.a = a;
    }

    public void setUsuario(Administrador a) {
        this.a = a;
    }
    
    @Override
    public int getOid() {
        return a.getOid();
    }

    @Override
    public void setOid(int oid) {
        a.setOid(oid);
    }

    @Override
    public ArrayList<String> getSqlInsertar() {
        ArrayList<String> sqls = new ArrayList();
        sqls.add("INSERT INTO administrador values (" + getOid() + ",'" +
                    a.getUsuario() + "','" + a.getPassword()+ "','" +
                    a.getPrimerNombre() + "','" + a.getSegundoNombre() + "','" +
                    a.getPrimerApellido() + "','" + a.getSegundoApellido() + "')");
        return sqls;
    }

    @Override
    public ArrayList<String> getSqlModificar() {
        ArrayList<String> sqls = new ArrayList();
        sqls.add("UPDATE administrador set usuario='" + a.getUsuario() +
                    "',password='" + a.getPassword() +
                    "',primerNombre='" + a.getPrimerNombre() +
                    "',segundoNombre='" + a.getSegundoNombre() +
                    "',primerApellido='" + a.getPrimerApellido() +
                    "',segundoApellido='" + a.getSegundoApellido() +
                    "' where oid=" + getOid());
        return sqls;
        
        
    }

    @Override
    public ArrayList<String> getSqlBorrar() {
        ArrayList<String> sqls = new ArrayList();
        
        sqls.add("DELETE FROM administrador WHERE oid =" + a.getOid());
        return sqls;
    }

    @Override
    public String getSqlSelect() {
        return "SELECT * FROM administrador";
    }

    @Override
    public void crearNuevo() {
        a = new Administrador();
    }

    @Override
    public void leerCompuesto(ResultSet rs) throws SQLException {
         a.setUsuario(rs.getString("usuario"));
         a.setPassword(rs.getString("password"));
         a.setPrimerNombre(rs.getString("primerNombre"));
         a.setSegundoNombre(rs.getString("segundoNombre"));
         a.setPrimerApellido(rs.getString("primerApellido"));
         a.setSegundoApellido(rs.getString("segundoApellido"));
    }

    @Override
    public Object getObjeto() {
        return a;
    }

    @Override
    public void leerComponente(ResultSet rs) throws SQLException {
        
    }
}
