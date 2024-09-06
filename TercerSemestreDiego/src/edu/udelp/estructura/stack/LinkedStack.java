/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udelp.estructura.stack;

import edu.udelp.estructura.nodos.Nodo;

/**
 *
 * @author diego
 */

public class LinkedStack {
    private Nodo apuntador;
    private int size;
    
    public LinkedStack(){
        this.apuntador=null;
        this.size=0;
    }
    public void push(Object valor){
        Nodo nodo=new Nodo();
        nodo.setValor(valor);
        if(!isEmpty()){
            nodo.setEnlace(apuntador);
        }
        apuntador=nodo;
        size++;
    }
    
    public int size(){
      return size;
   }
   //isEmpty
   public boolean isEmpty(){
      return size == 0;
   }
   
   public Object pop(){
    Object valor=null;
    if(!isEmpty()){
        valor=apuntador.getValor();
        Nodo nodo= apuntador.getEnlace();
        apuntador=nodo;
        size--;
    }
    return valor;
   }
   
   public String toString(){
       String s="";
       Nodo temp = apuntador;
       while(null!=temp){
           s+="<"+temp.getEnlace();
       }
       return s;
   }
   
}//
