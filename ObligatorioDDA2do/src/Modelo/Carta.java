/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Juan Veiga
 */
public class Carta {
    private String numero;
    private String palo;
    private int valor;
    private int valorNumero;
    private int valorPalo;

    public int getValorPalo() {
        return valorPalo;
    }

  
     public Carta(String numero, String palo, int valor) {
        this.numero = numero;
        this.palo = palo;
        this.valor = valor;
        asignarValorNumero();
        asignarValorPalo(palo);
    }
     
    public void asignarValorNumero(){
    switch (numero) {

        case "2":

        this.valorNumero = 1;

        break;

        case "3":

       this.valorNumero = 2;

        break;
        case "4":

       this.valorNumero = 3;

        break;
        case "5":

       this.valorNumero = 4;

        break;
       case "6":

       this.valorNumero = 5;

        break;
         case "7":

       this.valorNumero = 6;

        break;
        
         case "8":

       this.valorNumero = 7;

        break;
        
         case "9":

       this.valorNumero = 8;

        break;
        
         case "10":

       this.valorNumero = 9;

        break;
         case "j":

       this.valorNumero = 10;

        break;
        
         case "Q":

       this.valorNumero = 11;

        break;
        
         case "K":

       this.valorNumero = 12;

        break;
        
         case "A":

       this.valorNumero = 13;

        break;
        default:

        this.valorNumero = 0;

        break;

 

 }
    }
    
    public int getValorNumero() {
        return valorNumero;
    }
    
    public int getValor() {
        return valor;
    }
    
    public String getNumero() {
        return numero;
    }

    public String getPalo() {
        return palo;
    }
    
 private void asignarValorPalo(String palo) {
         switch (palo) {

        case "p":

         this.valorPalo = 1;

        break;

        case "t":

        this.valorPalo = 2;

        break;
        
         case "d":

        this.valorPalo = 3;

        break;
        
          case "c":

        this.valorPalo = 4;

        break;
        
        
        default:

        this.valorPalo = 0;

        break;

 

 }
    }
   
    
}
