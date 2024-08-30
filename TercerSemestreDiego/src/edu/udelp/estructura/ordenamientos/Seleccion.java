/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udelp.estructura.ordenamientos;

/**
 *
 * @author diego
 */

public class Seleccion {
    public static void MetodoSeleccion(int[] numero){
     System.out.println("Metodo Seleccion");
     Arreglos.Asignar(numero);
     System.out.println("Arreglo Desordenado");
     Arreglos.ImprimirArray(numero);
     int ordenador = 0;
     int indice = 0;
     int menor = 0;
     for(int i=0;i<numero.length;i++){
      menor=numero[i];
      indice=i;
       for(int j=i+1;j<numero.length;j++){
         if(numero[j]<menor){
            menor=numero[j];
            indice=j;
         }
       } 
       ordenador=numero[i];
       numero[i]=menor;
       numero[indice]=ordenador;
     }
     System.out.println("Arreglo Ordenado");
     Arreglos.ImprimirArray(numero);
     System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }
}
