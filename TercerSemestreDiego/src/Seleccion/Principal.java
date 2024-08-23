/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Seleccion;

/**
 *
 * @author diego
 */
public class Principal {
            public static void main(String[] args) {
     //Scanner leer = new Scanner(System.in);
     int ordenador = 0;
     int indice = 0;
     int menor = 0;
     int[] numero = {
            27, 83, 14, 65, 39, 2, 58, 71, 99, 46,
            33, 90, 4, 75, 17, 52, 68, 11, 86, 24,
            32, 91, 6, 44, 81, 13, 56, 72, 98, 29,
            50, 87, 3, 63, 18, 94, 21, 48, 35, 77,
            15, 66, 1, 85, 30, 41, 53, 12, 79, 92
        };
     System.out.println("El arreglo desordenado esta de esta manera:");
        ///numero.length
     for(int i=0;i<numero.length;i++){
         System.out.println(numero[i]);
     } 
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
     System.out.println("El arreglo ordenado es el siguiente:");
     for(int i=0;i<numero.length;i++){
         System.out.println(numero[i]);
     }
     
   }//
}
