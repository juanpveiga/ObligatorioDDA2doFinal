/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Controlador.ContLoginJugador;
import Controlador.ControladorJugador;
import Modelo.ExceptionClass;
import Modelo.Participante;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Juan Veiga
 */
public class VistaLoginWeb implements Vista.IVistaLoginJugador{

    private ContLoginJugador controlador;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private PrintWriter out;
    
    public VistaLoginWeb(){
       
      
    }
    
    public void procesar(HttpServletRequest request, HttpServletResponse response) throws ExceptionClass {
        this.request = request;
        this.response = response;
        this.controlador = new ContLoginJugador(this);
        login();
      
       
    }

    @Override
    public void login() {
       
        try {
            controlador.login(request.getParameter("usuario"),
                              request.getParameter("password"));
        } catch (ExceptionClass ex) {
            Logger.getLogger(VistaLoginWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }

    @Override
    public void mostrarError(String msj) {
       
    try {
            response.sendRedirect("index.jsp?mensaje=" + msj);
        } catch (IOException ex) { }
    
    }

    @Override
    public void mostrarVista(Participante p) {
        try {
            request.getSession().setAttribute("participante", p);
           
            request.getSession().setAttribute("vista",this);
            response.sendRedirect("jugador.jsp");
        } catch (IOException ex) {
            Logger.getLogger(VistaLoginWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    @Override
    public void mostrarTitulo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     public void conectarSSE(HttpServletRequest request) throws IOException {
         request.setAttribute("org.apache.catalina.ASYNC_SUPPORTED", true);
        AsyncContext contexto = request.startAsync();
        this.request = (HttpServletRequest)contexto.getRequest();
        contexto.getResponse().setContentType("text/event-stream");
        contexto.getResponse().setCharacterEncoding("UTF-8");
        contexto.setTimeout(0);//SIN TIMEOUT
        out = contexto.getResponse().getWriter();
    }
    
     public void enviar(String evento, String dato) {
        out.write("event: " + evento + "\n");
        dato = dato.replace("\n", "");
        out.write("data: " + dato + "\n\n");
        if (out.checkError()) {//checkError llama a flush, si da false evio bien
            cerrarVentana();            
        } else {
            //TODO OK!
             System.out.println("Enviado");
        }
    }

    private void cerrarVentana() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     
    
}
