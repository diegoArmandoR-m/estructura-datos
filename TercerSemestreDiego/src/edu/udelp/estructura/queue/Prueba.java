/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udelp.estructura.queue;

import java.util.Date;
import java.util.Scanner;


/**
 *
 * @author diego
 */
public class Prueba {
    public static void main (String [] args) {
        DatePriorityQueue fechas= new DatePriorityQueue();
        Scanner leer=new Scanner(System.in);
        String variable;
        
        //Date fecha=new Date();
        //System.out.println(fecha);
        Date fecha1s = new Date(2024 - 1900, 9, 12, 20, 52, 1);
        System.out.println(fecha1s);
        //fechas.enqueue(5, fecha);
        fechas.enqueue(5, fecha1s);
        System.out.println(fechas.toString());
        //Coloque esto para que sean mayor el lapso entre cada dato
        //variable=leer.nextLine();
        
        
        Date fecha2s = new Date(2014 - 1900, 9, 12, 20, 52, 1);
        System.out.println(fecha2s);
        //fechas.enqueue(5, fecha);
        fechas.enqueue(10, fecha2s);
        System.out.println(fechas.toString());
        //Coloque esto para que sean mayor el lapso entre cada dato
        //variable=leer.nextLine();
        
        
        Date fecha3s = new Date(2023 - 1900, 9, 12, 20, 52, 1);
        System.out.println(fecha2s);
        //fechas.enqueue(5, fecha);
        fechas.enqueue(20, fecha2s);
        System.out.println(fechas.toString());
    }
}
