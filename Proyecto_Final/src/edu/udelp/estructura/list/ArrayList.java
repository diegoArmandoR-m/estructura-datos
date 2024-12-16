/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udelp.estructura.list;

/**
 *
 * @author diego
 */
public class ArrayList {
    private int size;
    private Object[] list;
    private int increment ;
    
    public ArrayList(){
        this.size=0;
        this.list=new Object[10];
        this.increment=10;
    }
    
    public ArrayList(int intSize){
        this.size=0;
        this.list=new Object[intSize];
        this.increment=10;
    }
    
    public ArrayList(int intSize,int increment){
        this.size=0;
        this.list=new Object[intSize];
        this.increment=increment;
        
    }
    
    public int size(){
      return size;
   }
    
   public boolean isEmpty(){
      return size == 0;
   }
   
   public void add(Object value){
       list[size]=value;
       size++;
       if(size==list.length){
           incrementa();
       }
   }
   
   public void incrementa(){
       Object[] tempList=new Object[list.length+increment];
       for(int i=0;i<list.length;i++){
           tempList[i]=list[i];
       }
       list=tempList;
   }
   
   private void add(int index, Object value){
       if(size==index){
           add(value);
       }else if (index<size){
           for(int i=index; i<size;i++){
               list[i+1]=list[i];
           }
           list[index]=value;
           size++;
           if(size==list.length){
           incrementa();
           }
       }
   }
   
   
   
   
    public Object remove(int index) {
        Object value = null;
        if (size == index && !isEmpty()) {
            value = list[index];
            list[index] = null;
            size--;
        } else if (index < size && index >= 0) {
            value = list[index];
            for (int i = index + 1; i < size; i++) {
                list[i - 1] = list[i];
            }
            list[size] = null;
            size--;

        }
        return value;
    }
   
   public Object get(int index){
        Object value=" ";
        //Object value=null;
        if(index>=0&&index<size&&!isEmpty()){
            value=list[index];
        }
        return value;
    }
    public Object set(int index, Object value){
        Object returnValue=null;
        if(index>0&&index<size&&!isEmpty()){
            returnValue=list[index];
            list[index]=value;
        }
        return returnValue;
    }   

    @Override
   public String toString(){
      String s = "";
      for(int i = 0; i<size; i++){
         //s += stack[i]+ "="; 
         s +=list[i]+" ";//Juego
      }
      return s;
   }    
    
    
}//

