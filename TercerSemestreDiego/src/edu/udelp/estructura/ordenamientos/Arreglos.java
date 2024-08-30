/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udelp.estructura.ordenamientos;

/**
 *
 * @author diego
 */
import java.util.Random;
public class Arreglos {
    public static void Asignar(int[] numero){
        Random random = new Random();
        for(int i = 0;i<numero.length;i++){
          numero[i]=random.nextInt(199);
     }
    }
    
    public static void ImprimirArray(int[] numero){
        for(int i=0;i<numero.length;i++){
         System.out.println(numero[i]);
        }
    }
}

