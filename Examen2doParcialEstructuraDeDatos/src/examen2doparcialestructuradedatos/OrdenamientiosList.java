/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen2doparcialestructuradedatos;

import edu.udelp.estructura.queue.CircularQueue;
import edu.udelp.estructura.stack.LinkedList;
import java.util.Random;

/**
 *
 * @author diego
 */
class OrdenamientiosList {
    public static void llenarList(LinkedList lista){
        
        //Agregue un numero para poder hacer la prueba de la Busqueda Binaria
        lista.add(55);
        for(int i = 0;i<9;i++){
            Random random = new Random();
            lista.add(random.nextInt(199));
            //lista.add(9-i);
        }
        System.out.println("Lista nueva "+lista.toString());
    }
    
    public static void shellSort(LinkedList lista) {
        int limite = lista.size();
        int rango = limite / 2;
        while (rango > 0) {
            for (int i = rango; i < limite; i++) {
                Object value = lista.get(i);
                int j = i;
                while (j >= rango &&(int)lista.get(j - rango) >(int)value) {
                    lista.set(j, lista.get(j - rango));
                    j -= rango;
                }
                lista.set(j, value);
            }
            rango /= 2;
        }
    }
    
    public static LinkedList quickSort(LinkedList lista) {
        if (lista.size() <= 1) {
        return lista;
        }
        int pivote = (int) lista.get(lista.size() - 1);
        LinkedList menores = new LinkedList();
        LinkedList mayores = new LinkedList();

        for (int i = 0; i < lista.size() - 1; i++) {
            int actual = (int) lista.get(i);
            if (actual <= pivote) {
                menores.add(actual);
            } else {
                mayores.add(actual);
            }
        }
        menores = quickSort(menores);
        mayores = quickSort(mayores);

        LinkedList listaOrdenada = new LinkedList();
        agregarList(menores, listaOrdenada);
        listaOrdenada.add(pivote); 
        agregarList(mayores, listaOrdenada);

        return listaOrdenada;
    }
    
    public static void agregarList(LinkedList origen, LinkedList destino) {
    for (int i = 0; i < origen.size(); i++) {
        destino.add(origen.get(i));
    }
}
        
    
    static int doSearch(LinkedList lista, int numero) {
        int menor = 0;
        int mayor = lista.size()-1;
        int num;
        while(menor<=mayor){
            num = (int) Math.floor((menor+mayor)/2);
            if((int)lista.get(num)==numero){
            return num+1;}
            else if((int)lista.get(num)<numero){menor=num+1;}
            else{ mayor=num-1; }
        }
        return -1;
    }
    
}
