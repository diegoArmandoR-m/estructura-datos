/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udelp.estructura.nodos;

/**
 *
 * @author diego
 */
public class BooleanNodo {
    private BooleanNodo enlace;
    private Boolean prioridad;
    private Object valor;
    
    public BooleanNodo getEnlace() {
            return enlace;
    }
    public void setEnlace(BooleanNodo enlace) {
            this.enlace = enlace;
    }
    public Boolean getPrioridad() {
            return prioridad;
    }
    public void setPrioridad(Boolean prioridad) {
            this.prioridad = prioridad;
    }
    public Object getValor() {
            return valor;
    }
    public void setValor(Object valor) {
            this.valor = valor;
    }
    
}
