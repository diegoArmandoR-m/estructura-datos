/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udelp.estructura.queue;

import edu.udelp.estructura.nodos.Nodo;

/**
 *
 * @author diego
 */
public class LinkedQueue {
    private Nodo front;
    private Nodo rear;
    private int size;
    
    public LinkedQueue(){
        front =null;
        rear =null;
        size =0;
    }
    
    public int size(){
      return size;
   }
   
   public boolean isEmpty(){
      return size == 0;
   }
   
   public void enqueue(Object value){
       Nodo nodo= new Nodo();
       nodo.setValor(value);
       if(isEmpty()){
           front=nodo;
           rear=nodo;
       }else{
           rear.setEnlace(nodo);
           rear=nodo;
       }
       size++;
   }
   
   public Object dequeue(){
       Object value =null;
       if(!isEmpty()){
           size--;
           value=front.getValor();
           front=front.getEnlace();
       }
       return value;
   }
   
   @Override
   public String toString(){
       String s ="";
       Nodo t=front;
       while(null!=t){
         s+=t.getValor()+"<";
         t=t.getEnlace();
       }
       return s;
   }
   
}//
