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
public class LinkedList {
    private int size;
    private Nodo a;
    
    public LinkedList() {
        size=0;
        a=null;
    }

    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size==0;
    }
    
    public void add(Object value) {
        Nodo n=new Nodo();
        n.setValor(value);
        if(!isEmpty()) {
                n.setEnlace(a);	
        }
        a=n;
        size++;
    }
    
    public void add(int index,Object value) {
        Nodo n=new Nodo();
        n.setValor(value);
        if(size==index) {
                add(value);
        }else if(index==0) {
            Nodo actual=a;
            Nodo siguiente=a.getEnlace();
            while(null!=siguiente) {
                actual=siguiente;
                siguiente=siguiente.getEnlace();
            }
            actual.setEnlace(n);
            size++;
        }else if(index>0&&index<size) {
            Nodo actual=a;
            Nodo siguiente=a.getEnlace();
            for(int i=size-1;i>index;i--) {
                    actual=siguiente;
                    siguiente=siguiente.getEnlace();
            }
            actual.setEnlace(n);
            n.setEnlace(siguiente);
            size++;
        }
    }
    
    public Object get(int index) {
        Object value=null;
        if(index>=0&&index<size&&!isEmpty()) {
            Nodo actual=a;
            for(int i=size-1;i>index;i--) {
                actual=actual.getEnlace();
            }
            value=actual.getValor();
        }
        return value;
    }
    
    public Object set(int index,Object value) {
        Object returnVal=null;
        if(index>=0&&index<size&&!isEmpty()) {
            Nodo actual=a;
            for(int i=size-1;i>index;i--) {
                    actual=actual.getEnlace();
            }
            returnVal=actual.getValor();
            actual.setValor(value);
        }
        return returnVal;
    }

    public Object remove(int index) {
        Object value=null;
        if(!isEmpty()) {
            size--;
            if(index==0) {
                Nodo actual=a;
                Nodo siguiente=a.getEnlace();
                while(null!=siguiente) {
                    actual=siguiente;
                    siguiente=siguiente.getEnlace();
                }
                value=siguiente.getValor();
                actual.setEnlace(null);
            }else if(index>0&&index<size) {
                Nodo actual=a;
                Nodo siguiente=a.getEnlace();
                for(int  i=size;i>index;i--) {
                        actual=siguiente;
                        siguiente=siguiente.getEnlace();
                }
                value=siguiente.getValor();
                siguiente=siguiente.getEnlace();
                actual.setEnlace(siguiente);
            }else if(size==index){
                value=a.getValor();
                a=a.getEnlace();
                }
        }
        return value;
    }

    @Override
    public String toString() {
        String s="";
        Nodo temp=a;
        while(null!=temp) {
            s=temp.getValor()+" "+s;
            temp=temp.getEnlace();
        }
        return s;
    }
}
