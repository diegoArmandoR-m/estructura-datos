/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udelp.estructura.nodos;
import java.util.Date;

/**
 *
 * @author diego
 */
public class DateNodo {

    private DateNodo enlace;
    private Date fecha;
    private Object valor;
    
    public DateNodo getEnlace() {
        return enlace;
    }
    
    public void setEnlace(DateNodo enlace) {
        this.enlace = enlace;
    }
    
    public Date getFecha() {
        return fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public Object getValor() {
        return valor;
    }
    
    public void setValor(Object dato) {
        this.valor = dato;
    }
}
