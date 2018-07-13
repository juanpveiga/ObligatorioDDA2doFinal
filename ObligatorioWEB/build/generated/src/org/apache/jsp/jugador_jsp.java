package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class jugador_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title> Vista Jugador </title>\n");
      out.write("         <script src=\"http://code.jquery.com/jquery-latest.min.js\"></script>\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("            var vistaWeb = new EventSource(\"Jugador\");\n");
      out.write("            \n");
      out.write("            vistaWeb.onerror = function(evento) {\n");
      out.write("               alert(\"Sin conexion con el servidor\");\n");
      out.write("                vistaWeb.close();\n");
      out.write("                document.location=\"/ObligaDDAWEB/\";\n");
      out.write("            };\n");
      out.write("            vistaWeb.addEventListener(\"mostrarTitulo\", function (evento){\n");
      out.write("                document.getElementById(\"titulo\").innerHTML=evento.data;\n");
      out.write("                \n");
      out.write("            },false);\n");
      out.write("            vistaWeb.addEventListener(\"mostrarNombre\", function (evento){\n");
      out.write("                document.getElementById(\"nombre\").innerHTML=evento.data;\n");
      out.write("                \n");
      out.write("            },false);\n");
      out.write("            \n");
      out.write("             vistaWeb.addEventListener(\"jugadores\", function (evento){\n");
      out.write("                document.getElementById(\"jugadores\").innerHTML=evento.data;\n");
      out.write("                \n");
      out.write("            },false);\n");
      out.write("            \n");
      out.write("            vistaWeb.addEventListener(\"iniciarJuego\", function (evento){\n");
      out.write("                document.getElementById(\"cartas\").innerHTML=evento.data;\n");
      out.write("                \n");
      out.write("            },false);\n");
      out.write("            \n");
      out.write("             vistaWeb.addEventListener(\"ganadorJuego\", function (evento){\n");
      out.write("                document.getElementById(\"mensaje\").innerHTML=evento.data;\n");
      out.write("                document.getElementById(\"cartas\").hidden;\n");
      out.write("                \n");
      out.write("            },false);\n");
      out.write("            \n");
      out.write("             vistaWeb.addEventListener(\"mostrarApuesta\", function (evento){\n");
      out.write("                document.getElementById(\"mostrarApuesta\").innerHTML=evento.data;\n");
      out.write("             \n");
      out.write("                \n");
      out.write("            },false);\n");
      out.write("            \n");
      out.write("             vistaWeb.addEventListener(\"mostrarApostador\", function (evento){\n");
      out.write("                document.getElementById(\"mostrarApuesta\").innerHTML=evento.data;\n");
      out.write("             \n");
      out.write("                \n");
      out.write("            },false);\n");
      out.write("            \n");
      out.write("             function salirDelJuego() {\n");
      out.write("            $.get(\"Jugador?accion=salir\", function (data) {\n");
      out.write("                document.location = \"/ObligaDDAWEB\";\n");
      out.write("            });\n");
      out.write("        }\n");
      out.write("        ;\n");
      out.write("        \n");
      out.write("        function apostar() {\n");
      out.write("             var monto = $(\"#monto\").val();\n");
      out.write("            $.get(\"Jugador?accion=apostar&monto=\"+monto, function (data) {\n");
      out.write("                document.location = \"/ObligaDDAWEB\";\n");
      out.write("            });\n");
      out.write("        }\n");
      out.write("        ;\n");
      out.write("        \n");
      out.write("       \n");
      out.write("            \n");
      out.write("    </script>\n");
      out.write("        <h1> <span id=\"nombre\"></span><span id=\"titulo\"></span></h1>\n");
      out.write("        <span id=\"jugadores\"></span>\n");
      out.write("         <span id=\"cartas\"></span>\n");
      out.write("         <span id=\"mensaje\"><span>\n");
      out.write("                 <span id=\"mostrarApuesta\">\n");
      out.write("                 <div id=\"apuesta\">\n");
      out.write("         Monto Apuesta : <input type=\"text\" id=\"monto\">\n");
      out.write("                 </div>\n");
      out.write("        <br>\n");
      out.write("        <input type=\"button\" value=\"Apostar\" onclick=\"apostar()\"></input>\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        <input type=\"button\" value=\"Pasar\" onclick=\"pasar()\"></input>\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        <input type=\"button\" value=\"Salir del Juego\" onclick=\"salirDelJuego()\"></input>\n");
      out.write("        <br>\n");
      out.write("      \n");
      out.write("                \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
