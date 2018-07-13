<%-- 
    Document   : jugador
    Created on : 16/06/2018, 07:21:46 PM
    Author     : Juan Veiga
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Vista Jugador </title>
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>

    </head>

    <script type="text/javascript">

        var vistaWeb = new EventSource("Jugador?accion=new");

        vistaWeb.onerror = function (evento) {
            alert("Sin conexion con el servidor");
            vistaWeb.close();
            document.location = "/ObligaDDAWEB/";
        };
        vistaWeb.addEventListener("inicializarPagina", function (evento) {
            document.body.innerHTML = evento.data;





        }, false);


        vistaWeb.addEventListener("mostrarTitulo", function (evento) {

            document.getElementById("titulo").innerHTML = evento.data;
            document.getElementById("jugadores").style.visibility = "visible";
            document.getElementById("nuevaManoButtom").style.visibility = "hidden";
            document.getElementById("salirDeLaManoButtom").style.visibility = "hidden";
            document.getElementById("pagarApuestaButtom").style.visibility = "hidden";
            document.getElementById("apostarButtom").style.visibility = "hidden";
            document.getElementById("pasarManoButtom").style.visibility = "hidden";
            document.getElementById("apuesta").style.visibility = "hidden";
            document.getElementById("pozo").style.visibility = "hidden";



        }, false);
        vistaWeb.addEventListener("mostrarNombre", function (evento) {

            document.getElementById("nombre").innerHTML = evento.data;


        }, false);

        vistaWeb.addEventListener("jugadores", function (evento) {
            document.getElementById("jugadores").innerHTML = evento.data;

        }, false);

        vistaWeb.addEventListener("iniciarJuego", function (evento) {

            document.getElementById("cartas").innerHTML = evento.data;
            $("#monto").val("");
            document.getElementById("mensaje").style.visibility = "hidden";
            document.getElementById("cartas").style.visibility = "visible";
            document.getElementById("apostarButtom").style.visibility = "visible";
            document.getElementById("pasarManoButtom").style.visibility = "visible";

            document.getElementById("nuevaManoButtom").style.visibility = "hidden";
            document.getElementById("salirDeLaManoButtom").style.visibility = "hidden";
            document.getElementById("pagarApuestaButtom").style.visibility = "hidden";

            document.getElementById("apuesta").style.visibility = "visible";
            document.getElementById("pozo").style.visibility = "visible";
            //document.getElementById("nuevaMano").style.visibility = "hidden";
            //document.getElementById("mostrarApuestaApostador").style.visibility = "hidden";
            //document.getElementById("mostrarApuesta").style.visibility = "hidden";
            //document.getElementById("ganadorMano").style.visibility = "hidden";

        }, false);
        vistaWeb.addEventListener("mostrarGanadoras", function (evento) {
            document.getElementById("cartas").innerHTML = evento.data;
            document.getElementById("cartas").style.visibility = "visible";

        }, false);

        vistaWeb.addEventListener("ganadorJuego", function (evento) {
 
            document.getElementById("mensaje").innerHTML = evento.data;
            document.getElementById("mensaje").style.visibility = "visible";
            document.getElementById("cartas").style.visibility = "hidden";
            //document.getElementById("mostrarApuestaPagada").style.visibility = "hidden";
            document.getElementById("apuesta").style.visibility = "hidden";
            document.getElementById("pozo").style.visibility = "hidden";
            document.getElementById("nuevaManoButtom").style.visibility = "hidden";
            document.getElementById("apostarButtom").style.visibility = "hidden";
            document.getElementById("pasarManoButtom").style.visibility = "hidden";
            //document.getElementById("nuevaMano").style.visibility = "hidden";
            //document.getElementById("mostrarApuestaApostador").style.visibility = "hidden";
            //document.getElementById("mostrarApuesta").style.visibility = "hidden";
            //document.getElementById("ganadorMano").style.visibility = "hidden";

        }, false);

        vistaWeb.addEventListener("mostrarApuesta", function (evento) {


            document.getElementById("mensaje").innerHTML = evento.data;
            document.getElementById("mensaje").style.visibility = "visible";
            //document.getElementById("mostrarApuesta").style.visibility = "visible";
            document.getElementById("pagarApuestaButtom").style.visibility = "visible";
            document.getElementById("salirDeLaManoButtom").style.visibility = "visible";
            document.getElementById("pasarManoButtom").style.visibility = "hidden";
            document.getElementById("apuesta").style.visibility = "hidden";
            document.getElementById("apostarButtom").style.visibility = "hidden";

        }, false);



        vistaWeb.addEventListener("mostrarApostador", function (evento) {

            document.getElementById("mensaje").innerHTML = evento.data;
            document.getElementById("mensaje").style.visibility = "visible";
            //document.getElementById("mostrarApuestaApostador").style.visibility = "visible";
            document.getElementById("nuevaManoButtom").style.visibility = "hidden";

            document.getElementById("pagarApuestaButtom").style.visibility = "hidden";
            document.getElementById("pasarManoButtom").style.visibility = "hidden";
            document.getElementById("apuesta").style.visibility = "hidden";
            document.getElementById("apostarButtom").style.visibility = "hidden";


        }, false);

        vistaWeb.addEventListener("pasarMano", function (evento) {

            document.getElementById("apostarButtom").style.visibility = "hidden";

        }, false);

        vistaWeb.addEventListener("montoPozo", function (evento) {

            document.getElementById("montoPozo").innerHTML = evento.data;


        }, false);

        vistaWeb.addEventListener("error", function (evento) {

            document.getElementById("mensaje").innerHTML = evento.data;


        }, false);

        vistaWeb.addEventListener("sacarDeLaMano", function (evento) {
            document.getElementById("mensaje").style.visibility = "hidden";
            document.getElementById("pozo").style.visibility = "hidden";
            document.getElementById("nuevaManoButtom").style.visibility = "visible";
            document.getElementById("cartas").style.visibility = "hidden";
            document.getElementById("pagarApuestaButtom").style.visibility = "hidden";



        }, false);

        vistaWeb.addEventListener("mostrarGanadorMano", function (evento) {

           //document.getElementById("ganadorMano").innerHTML = evento.data;
            
            document.getElementById("mensaje").innerHTML = evento.data;
            document.getElementById("mensaje").style.visibility = "visible";
            //document.getElementById("ganadorMano").style.visibility = "visible";
            document.getElementById("nuevaManoButtom").style.visibility = "visible";

            //document.getElementById("cartas").style.visibility = "hidden";
            document.getElementById("salirDeLaManoButtom").style.visibility = "hidden";
            document.getElementById("pagarApuestaButtom").style.visibility = "hidden";

            //document.getElementById("mostrarApuestaPagada").style.visibility = "hidden";
            document.getElementById("apostarButtom").style.visibility = "hidden";
            document.getElementById("apuesta").style.visibility = "hidden";
            document.getElementById("pozo").style.visibility = "hidden";
            //document.getElementById("mostrarApuestaApostador").style.visibility = "hidden";
            //document.getElementById("mostrarApuesta").style.visibility = "hidden";
        }, false);

        vistaWeb.addEventListener("mostrarApuestaPagada", function (evento) {

            document.getElementById("mensaje").innerHTML = evento.data;
            document.getElementById("mensaje").style.visibility = "visible";
            //document.getElementById("mostrarApuestaPagada").style.visibility = "visible";
            document.getElementById("pagarApuestaButtom").style.visibility = "hidden";
            document.getElementById("salirDeLaManoButtom").style.visibility = "hidden";

        }, false);

        vistaWeb.addEventListener("esperaNuevaMano", function (evento) {

            document.getElementById("mensaje").innerHTML = evento.data;
            document.getElementById("mensaje").style.visibility = "visible";
            //document.getElementById("nuevaMano").style.visibility = "visible";
            document.getElementById("nuevaManoButtom").style.visibility = "visible";
            //document.getElementById("nuevaMano").style.visibility = "hidden";
            //document.getElementById("ganadorMano").style.visibility = "hidden";

        }, false);


        function salirDelJuego() {
            $.get("Jugador?accion=salir", function (data) {
                document.location = "/ObligaDDAWEB";
            });
        }
        ;


        function apostar() {
            var monto = $("#monto").val();
            $.get("Jugador?accion=apostar&monto=" + monto, function (data) {

            });
        }
        ;

        function pasar() {

            $.get("Jugador?accion=pasar", function (data) {

            });
        }
        ;


        function salirDeLaMano() {

            $.get("Jugador?accion=salirDeLaMano", function (data) {

            });
        }
        ;

        function nuevaMano() {

            $.get("Jugador?accion=nuevaMano", function (data) {

            });
        }
        ;

        function pagarApuesta() {

            $.get("Jugador?accion=pagarApuesta", function (data) {

            });
        }
        ;


    </script> 
    <body> 


        <h1> <span id="nombre"></span><span id="titulo"></span></h1>

        <div id="cartas"></div>
        <br>
        <div id="mensaje"></div>
        <br>

        <div id="apuesta">
            Monto Apuesta : <input type="text" id="monto">
        </div>


        <input type="button" id="pagarApuestaButtom" value="Pagar Apuesta" onclick="pagarApuesta()">
        <input type="button" id="apostarButtom" value="Apostar"  onclick="apostar()">
        <input type="button" value="Pasar" id="pasarManoButtom" onclick="pasar()">
        <input type="button" id="nuevaManoButtom" value="Jugar Nueva Mano" onclick="nuevaMano()">
        <input type="button" id = "salirDeLaManoButtom" value="Salir de la Mano" onclick="salirDeLaMano()">


        
        <input type="button" id="salirJuegoButtom" value="Salir del Juego" onclick="salirDelJuego()">

        <p id="pozo">Pozo :<span id ="montoPozo"> </span></p>
        <span id="jugadores"></span>


        <!--<span id="mostrarApuesta"></span>  

        <div id="ganadorJuego"></div>
        <div id="mostrarApuestaApostador"></div> 
        <div id="mostrarApuestaPagada"></div>
        <div id="nuevaMano"></div>
        <span id="ganadorMano"></span>  -->

    </body>
</html>
