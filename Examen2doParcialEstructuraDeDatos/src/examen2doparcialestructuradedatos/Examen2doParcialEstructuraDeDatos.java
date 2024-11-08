/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen2doparcialestructuradedatos;

import edu.udelp.estructura.queue.CircularQueue;
import edu.udelp.estructura.stack.ArrayList;
import edu.udelp.estructura.stack.LinkedList;
import java.util.Random;
import java.util.Scanner;


/**
 *
 * @author diego
 */
public class Examen2doParcialEstructuraDeDatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //agregarNumero();
        
        //agregarNumeroQueue();
        
        queue25();
        
    }
    
    public static void agregarNumero(){
        LinkedList lista = new LinkedList();
        Random random = new Random();
        int numero=0;
        int otro=0;
        String numeros=null;
        int suma =0;
        do{
            numero=random.nextInt(101);
            suma+=numero;
            lista.add(numero);
            System.out.println(numero);
        }while(lista.size()!=50);
        
        System.out.println("La media es: "+suma/50);
        lista=OrdenamientiosList.quickSort(lista);
        numeros=lista.toString();
        //Se ordeno la lista para ver descomentar esto 
        //System.out.println(numeros);
        
        System.out.println("La mediana es: "+ lista.get(25));
    }
    
    public static void agregarNumeroQueue(){
        CircularQueue cola= new CircularQueue(50);
        LinkedList lista = new LinkedList();
        Random random = new Random();
        int numero=0;
        String numeros=null;
        do{
            numero=random.nextInt(101);
            cola.enqueue(numero);
        }while(!cola.isFull());
        numeros=cola.toString();
        System.out.println("Cola "+numeros);
        
        while(!cola.isEmpty()){
           lista.add(cola.dequeue());
           if(cola.front()!=null){
               numeros=cola.front().toString();
               numero=Integer.parseInt(numeros);
           }
           
           if(OrdenamientiosList.doSearch(lista,numero)!=-1){ 
               lista.remove(lista.size());
           }
        }        
        numeros=lista.toString(); 
        System.out.println("Tamano de la lista "+lista.size());
        System.out.println("Lista "+numeros);
    }
    
    public static void palindromo(){
        Scanner leer =new Scanner(System.in);
        String palabra=null;
        int tamaño=0;
        System.out.println("Ingresa la palabra");
        palabra=leer.nextLine();
        tamaño=palabra.length();
        
        
    }
    
    public static void queue25(){
        CircularQueue cola= new CircularQueue(50);
        Random random = new Random();
        int numero=0;
        int contador=0;
        String numeros=null;
        do{
            numero=random.nextInt(51);
            cola.enqueue(numero);
            if(numero==25){
                cola.dequeue();
                cola.dequeue();
                cola.dequeue();
                contador++;
            }
        }while(!cola.isFull());
        numeros=cola.toString();
        System.out.println("El proceso del 25 se repitio: "+contador);
        System.out.println("Cola "+numeros);
        
    }    
    
}//
