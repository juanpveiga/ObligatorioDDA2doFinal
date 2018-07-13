/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Juan Veiga
 */
public class FiguraVacia extends Figura{
    
    public FiguraVacia()
    {
        this.nombreFigura = "Vacia";
        this.primerValor = 0;
    }

    @Override
    public Figura evaluarTipo(ArrayList<Carta> cartas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String devolverNombreFigura() {
      return this.nombreFigura;
    }

    @Override
    public Participante desempate(ArrayList<Participante> participantes) {
          Carta mayor = new Carta("2", "p", 1);
        Participante ganador = null;
        for (Participante p : participantes) {

            for (Carta c : p.getCartas().getCartas()) {
                Carta candidata;
                int valor = Integer.MIN_VALUE;
                if (c.getValor() > valor) {
                    valor = c.getValor();
                    candidata = c;
                    if (candidata.getValor() > mayor.getValor()) {
                    mayor = candidata;
                    ganador = p;
                    }
                }
            }
        }
        ganador.getCartas().dejarSoloGanadora();
        return ganador;
    }
    }
    

