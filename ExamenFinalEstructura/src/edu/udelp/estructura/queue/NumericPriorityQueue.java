/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udelp.estructura.queue;

import edu.udelp.estructura.nodos.NumericNodo;
import java.util.Date;

/**
 *
 * @author diego
 */
public class NumericPriorityQueue {
    private NumericNodo front;
    private NumericNodo rear;
    private Object[] queue;
    private int size;
    
    public NumericPriorityQueue() {
        front=null;
        rear=null;
        size=0;
    }

    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
            return size==0;
    }
    
    public void enqueue1(NumericNodo nodo) {
        if(isEmpty()) {
            front=nodo;
            rear=nodo;
        }else {
            rear.setEnlace(nodo);
            rear=nodo;
        }		
    }
    
    public void enqueue(Object value,Integer prioridad) {
        NumericNodo n=new NumericNodo();
	n.setValor(value);
	n.setPrioridad(prioridad);
	
        if(isEmpty()) {
            front=n;
            rear=n;
		
        }else {
            if(prioridad>=rear.getPrioridad()) {
                enqueue1(n);
            }else {
                NumericNodo actual=front;
                NumericNodo siguiente=front.getEnlace();
                if(prioridad<front.getPrioridad()) {
                    n.setEnlace(front);
                    front=n;
                }else {
                    while(null!=siguiente) {
                        if(prioridad<siguiente.getPrioridad()) {
                            break;
                        }
                        siguiente=siguiente.getEnlace();
                        
                    }
                    actual.setEnlace(n);
                    n.setEnlace(siguiente);
                }	
            }
        }
        size++;
    }
    
    public void enqueue2(Object value,Integer prioridad,Integer prioridad2) {
        NumericNodo n=new NumericNodo();
	n.setValor(value);
	n.setPrioridad(prioridad);
	
        if(isEmpty()) {
            front=n;
            rear=n;
		
        }else {
            if(prioridad>=rear.getPrioridad()) {
                enqueue1(n);
            }else {
                NumericNodo actual=front;
                NumericNodo siguiente=front.getEnlace();
                if(prioridad<front.getPrioridad()) {
                    if(prioridad2<prioridad){
                        n.setEnlace(front);
                    front=n;
                    }else{
                        n.setEnlace(front);
                    front=n;
                    }
                }else {
                    while(null!=siguiente) {
                        if(prioridad<siguiente.getPrioridad()) {
                            break;
                        }
                        actual=siguiente;
                        siguiente=siguiente.getEnlace();
                    }
                    actual.setEnlace(n);
                    n.setEnlace(siguiente);
                }	
            }
        }
        size++;
    }

    public Object dequeue() {
        Object value=null;
        if(!isEmpty()) {
            size--;
            value=front.getValor();
            front=front.getEnlace();
        }
        return value;
    }
    

    public String toString() {
        String s="";
        NumericNodo t=front;
        while(null!=t) {
            s+=t.getValor()+"<";
            t=t.getEnlace();
        }
        return s;
    }
    
    
}//



