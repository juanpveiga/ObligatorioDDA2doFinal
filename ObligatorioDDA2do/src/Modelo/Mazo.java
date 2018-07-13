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
public class Mazo {
    
    private ArrayList<Carta> cartas = new ArrayList();

   
    
  

    public Mazo() {
     llenarMazo();
    }
    
     public ArrayList<Carta> getCartas() {
        return cartas;
    }

   public void cargarMazo(Carta c)
   {
    
     cartas.add(c);
   }

    private void llenarMazo() {
      cargarMazo(new Carta("2","p",1));
      cargarMazo(new Carta("2","t",2));
      cargarMazo(new Carta("2","d",3));
      cargarMazo(new Carta("2","c",4));
      cargarMazo(new Carta("3","p",5));
      cargarMazo(new Carta("3","t",6));
      cargarMazo(new Carta("3","d",7));
      cargarMazo(new Carta("3","c",8));
      cargarMazo(new Carta("4","p",9));
      cargarMazo(new Carta("4","t",10));
      cargarMazo(new Carta("4","d",11));
      cargarMazo(new Carta("4","c",12));
      cargarMazo(new Carta("5","p",13));
      cargarMazo(new Carta("5","t",14));
      cargarMazo(new Carta("5","d",15));
      cargarMazo(new Carta("5","c",16));
      cargarMazo(new Carta("6","p",17));
      cargarMazo(new Carta("6","t",18));
      cargarMazo(new Carta("6","d",19));
      cargarMazo(new Carta("6","c",20));
      cargarMazo(new Carta("7","p",21));
      cargarMazo(new Carta("7","t",22));
      cargarMazo(new Carta("7","d",23));
      cargarMazo(new Carta("7","c",24));
      cargarMazo(new Carta("8","p",25));
      cargarMazo(new Carta("8","t",26));
      cargarMazo(new Carta("8","d",27));
      cargarMazo(new Carta("8","c",28));
      cargarMazo(new Carta("9","p",29));
      cargarMazo(new Carta("9","t",30));
      cargarMazo(new Carta("9","d",31));
      cargarMazo(new Carta("9","c",32));
      cargarMazo(new Carta("10","p",33));
      cargarMazo(new Carta("10","t",34));
      cargarMazo(new Carta("10","d",35));
      cargarMazo(new Carta("10","c",36));
      cargarMazo(new Carta("J","p",37));
      cargarMazo(new Carta("J","t",38));
      cargarMazo(new Carta("J","d",39));
      cargarMazo(new Carta("J","c",40));
      cargarMazo(new Carta("Q","p",41));
      cargarMazo(new Carta("Q","t",42));
      cargarMazo(new Carta("Q","d",43));
      cargarMazo(new Carta("Q","c",44));
      cargarMazo(new Carta("K","p",45));
      cargarMazo(new Carta("K","t",46));
      cargarMazo(new Carta("K","d",47));
      cargarMazo(new Carta("K","c",48));
      cargarMazo(new Carta("A","p",49));
      cargarMazo(new Carta("A","t",50));
      cargarMazo(new Carta("A","d",51));
      cargarMazo(new Carta("A","c",52));
    }

   
    
   
    
}
