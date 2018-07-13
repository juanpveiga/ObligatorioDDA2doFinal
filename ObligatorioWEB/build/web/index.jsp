<%-- 
    Document   : index
    Created on : 12/06/2018, 09:42:24 PM
    Author     : Juan Veiga
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OBligatorioDDAweb</title>
      
    </head>
     
    <body>
        
<%
    String mensaje = request.getParameter("mensaje");
%>
        <h1>Bienvenido Login Jugador :</h1>
     
            <form method='get' action='loginJugador'>
            Usuario: <input type='text' name='usuario'><br>
            Password: <input type='password' name='password'><br>
            <input type='submit' value='Login'>
            <span name="mensaje"></span>
            </form>
        
          <%
            if(mensaje!=null){
                out.println("Error:" + mensaje);
            }
        %>
    </body>
</html>
