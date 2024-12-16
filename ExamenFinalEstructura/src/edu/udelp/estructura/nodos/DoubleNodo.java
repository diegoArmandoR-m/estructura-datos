/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udelp.estructura.nodos;

/**
 *
 * @author diego
 */
public class DoubleNodo {
	private Object valor;	
	private DoubleNodo izquierda;
	private DoubleNodo derecha;
	public Object getValor() {
		return valor;
	}
	public void setValor(Object valor) {
		this.valor = valor;
	}
	public DoubleNodo getIzquierda() {
		return izquierda;
	}
	public void setIzquierda(DoubleNodo izquierda) {
		this.izquierda = izquierda;
	}
	public DoubleNodo getDerecha() {
		return derecha;
	}
	public void setDerecha(DoubleNodo derecha) {
		this.derecha = derecha;
	}
}
