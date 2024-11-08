/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udelp.estructura.queue;

/**
 *
 * @author diego
 */
public class CircularQueue {
    private int front;
    private int rear;
    private Object[] queue;
    private int size;
    
    public CircularQueue(int size){
        front =0;
        rear=0;
        queue=new Object[size];
        this.size=0;
    }
    
   public int size(){
      return size;
   }
   
   public boolean isEmpty(){
      return size == 0;
   }
   
   public Boolean isFull(){
      return size == queue.length;
   }
    
   public void enqueue(Object value){
       if(!isFull()){
           queue[front]=value;
           front++;
           size++;
           if(front==queue.length){
               front=0;
           }
       }
   }
   
   public Object dequeue(){
       Object value =null; 
       if(!isEmpty()){
           value=queue[rear];
           queue[rear]=null;
           rear++;
           size--;
           if(rear==queue.length){
               rear=0;
           }
       }
       return value;
   }
   
   public Object front(){
       Object value=null;
       if(!isEmpty()){
           int tempF=front-1;
           tempF=tempF==-1?queue.length-1:tempF;
           value=queue[tempF];
       }
       
       return value;
   }
   
   public Object rear(){
       Object value=null;
       if(!isEmpty()){
        value=queue[rear];   
       }
       return value;
   }
   
    @Override
   public String toString(){
       String s="";
       for(int i=0;i<size;i++){
           int tempI=i+rear;
           tempI=tempI==queue.length-1?0:tempI;
           s+=queue[tempI]+">";
           
       }
       return s;
   }
}
