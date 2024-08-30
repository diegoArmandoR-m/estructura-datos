/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udelp.estructura.ordenamientos;

/**
 *
 * @author diego
 */
public class Burbuja {
    public static void MetodoBurbuja(int[] numero){
     Arreglos.Asignar(numero);
     System.out.println("Metodo Burbuja");
     System.out.println("Arreglo Desordenado");
     Arreglos.ImprimirArray(numero);
        int ordenador = 0;
        for(int i=0;i<numero.length;i++){
         for(int j=0;j<numero.length-1;j++){
         if(numero[j]<numero[j+1]){
             ordenador=numero[j+1];
             numero[j+1]=numero[j];
             numero[j]=ordenador;
         }
        } 
     }
     System.out.println("Arreglo Ordenado");
     Arreglos.ImprimirArray(numero);    
     System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }
}
