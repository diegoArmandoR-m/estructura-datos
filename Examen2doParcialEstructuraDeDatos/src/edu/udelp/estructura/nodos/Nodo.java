/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udelp.estructura.nodos;

/**
 *
 * @author diego
 */
public class Nodo {
    private Object valor;
    private Nodo enlace;
    public Object getValor(){
        return valor;
    }
    
    public Nodo getNodo(){
        return enlace;
    }
    
    public void setValor(Object valor){
        this.valor=valor;
    }
    
    public void setEnlace(Nodo enlace){
        this.enlace=enlace;
    }
    public Nodo getEnlace(){
        return enlace;
    }
}
