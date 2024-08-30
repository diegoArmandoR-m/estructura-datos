/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udelp.estructura.ordenamientos;

/**
 *
 * @author diego
 */
public class Insercion {
    public static void MetodoInsercion(int[] numero){
     Arreglos.Asignar(numero);
     System.out.println("Metodo Insercion");
     System.out.println("Arreglo Desordenado");
     Arreglos.ImprimirArray(numero);
        int ordenador = 0;
        for(int i=0;i<numero.length;i++){
         for(int j=i;j>0;j--){
             if(numero[j]>numero[j-1]){
             ordenador =numero[j];
             numero[j]=numero[j-1];
             numero[j-1]= ordenador;
             }
         }
        }
     System.out.println("Arreglo Ordenado");
     Arreglos.ImprimirArray(numero);
     System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }
}
