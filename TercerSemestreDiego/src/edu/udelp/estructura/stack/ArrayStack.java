/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udelp.estructura.stack;

/**
 *
 * @author diego
 */
public class ArrayStack {
    private Object[] stack;
   private int a;
   public ArrayStack(int size){
      this.stack = new Object[size];
      this.a = 0;
   }
   //Size
   public int size(){
      return a;
   }
   //isEmpty
   public boolean isEmpty(){
      return a == 0;
   }
   public Boolean isFull(){
      return a == stack.length;
   }
   //Peak
   public Object peak(){
      Object val = null;
      if(!isEmpty()){
         val = stack[a-1];
      }
      return val;
   }
   //push
   public void  push (Object val){
      if(!isFull()){
         stack[a] = val;
         a ++;
      }
   }
   //pop
   public Object pop(){
    Object val = null;
    if(!isEmpty()){
       a --;
       val = stack[a];
    }
    return val;
   }
   //Imprimir arreglo
   //Override es para 
    @Override
   public String toString(){
      String s = " ";
      for(int i = 0; i<a; i++){
         s += stack[i]+ "=";
      }
      return s;
   }
   
}
