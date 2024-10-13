/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udelp.estructura.queue;

import edu.udelp.estructura.nodos.DateNodo;
import java.util.Date;
/**
 *
 * @author diego
 */
public class DatePriorityQueue {
    private DateNodo front;
    private DateNodo rear;
    private int size;
    
    public DatePriorityQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public void enqueue1(DateNodo nodo) {
        if (isEmpty()) {
            front = nodo;
            rear = nodo;
        } else {
            rear.setEnlace(nodo);
            rear = nodo;
        }       
    }
    
    public void enqueue(Object value, Date fecha) {
        DateNodo n = new DateNodo();
        n.setValor(value);
        n.setFecha(fecha);
        
        if (isEmpty()) {
            front = n;
            rear = n;
        } else {
            if (fecha.before(front.getFecha())) {
                n.setEnlace(front);
                front = n;
            } else {
                DateNodo actual = front;
                DateNodo siguiente = front.getEnlace();
                while (siguiente != null && !fecha.before(siguiente.getFecha())) {
                    actual = siguiente;
                    siguiente = siguiente.getEnlace();
                }
                actual.setEnlace(n);
                n.setEnlace(siguiente);
                if (siguiente == null) {
                    rear = n;
                }
            }
        }
        size++;
    }
    
    public Object dequeue() {
        Object value = null;
        if (!isEmpty()) {
            size--;
            value = front.getValor();
            front = front.getEnlace();
        }
        return value;
    }

    public String toString() {
        String s = new String();
        DateNodo t = front;
        while (t != null) {
            s+=t.getValor()+"<";
            t = t.getEnlace();
        }
        return s.toString();
    }

}//
