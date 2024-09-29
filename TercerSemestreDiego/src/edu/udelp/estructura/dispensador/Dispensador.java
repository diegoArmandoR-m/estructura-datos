/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udelp.estructura.dispensador;

import edu.udelp.estructura.queue.CircularQueue;
import java.util.Scanner;


/**
 *
 * @author diego
 */
public class Dispensador {
    
   public static void main (String [] args) {
       Scanner leer = new Scanner(System.in);
       String opcionMenu="";
       String producto=null;
       String moneda=null;
       double precio=0.0;
       int cantidad=0;
       
       
       CircularQueue producto1  = new CircularQueue(10);
       llenarProducto(producto1,"Chips");//$20
       
       CircularQueue producto2  = new CircularQueue(10);
       llenarProducto(producto2,"Principes");//$15
       
       CircularQueue producto3  = new CircularQueue(10);
       llenarProducto(producto3,"Palomitas");//$13
       
       CircularQueue producto4  = new CircularQueue(10);
       llenarProducto(producto4,"Agua");//$12.5
       
       CircularQueue producto5  = new CircularQueue(10);
       llenarProducto(producto5,"Boing");//17
      
       CircularQueue producto6  = new CircularQueue(10);
       llenarProducto(producto6,"Cacahuates");//$24
       
       CircularQueue producto7  = new CircularQueue(10);
       llenarProducto(producto7,"Cafe");//$25
       
       CircularQueue producto8  = new CircularQueue(10);
       llenarProducto(producto8,"Skwinkles");//$9.5
       
       CircularQueue producto9  = new CircularQueue(10);
       llenarProducto(producto9,"Doritos");//$17.5
       
       CircularQueue producto10 = new CircularQueue(10);
       llenarProducto(producto10,"Chicles");//$23.5
        
      
       CircularQueue m10 = new CircularQueue(15);
       llenarMonedas(m10,"10");
       
       CircularQueue m5  = new CircularQueue(15);
       llenarMonedas(m5,"5");
       
       CircularQueue m2  = new CircularQueue(15);
       llenarMonedas(m2,"2");
       
       CircularQueue m1  = new CircularQueue(15);
       
       System.out.println(m1.toString());
       CircularQueue m05 = new CircularQueue(15);
       llenarMonedas(m05,"0.5");
       
       
       
       
   do{
       boolean validar=true;
       System.out.println("Ingresa el numero de la accion que deseas realizar(Solo numero enteros del 1 al 4):"
			+ "\n1 - Agregar producto"	
			+ "\n2 - Agregar dinero"
			+ "\n3 - Elegir producto"
                        + "\n4 - Imprimir estado"
                        + "\n5 - Finalizar Programa");
       
       opcionMenu=leer.nextLine();
       
           switch(opcionMenu){
               //Agregar Producto
           case "1":
               do{
                   System.out.println("Ingresa el codigo del producto que desea agregar"
                       + "\nA1  - Chips, bolsa de papas $20"
                       + "\nA2  - Principes, galletas de chocolate $15"
                       + "\nB1  - Palomitas, acarameladas $13"
                       + "\nB2  - Agua, botella grande $12.5"
                       + "\nC1  - Boing, sabor uva 17"
                       + "\nC2  - Cacahuates, japoneses $24"
                       + "\nD1  - Cafe, americano grande $25"
                       + "\nD2  - Skwinkles, jumbo $9.5" 
                       + "\nE1  - Doritos, negros $17.5"
                       + "\nE2  - Chicles, sabor menta $23.5"
                       + "\nF1  - Volver al menu principal");
                    producto=leer.nextLine();
                    switch(producto){
                        case"A1":
                            if(producto1.isFull()){
                                System.out.println("No se pueden agregar mas de ese producto"+"\n");  
                            }else{
                              cantidad=validaNum();
                              agregarProducto(producto1,cantidad,"Chips");
                              System.out.println("Producto agregado"+"\n");
                              validar=true;
                            }
                            break;
                        case"A2":
                            if(producto2.isFull()){
                                System.out.println("No se pueden agregar mas de ese producto"+"\n");  
                            }else{
                              cantidad=validaNum();
                              agregarProducto(producto2,cantidad,"Principes");
                              System.out.println("Producto agregado"+"\n");
                              validar=true;
                            }
                            break;
                        case"B1":
                            if(producto3.isFull()){
                                System.out.println("No se pueden agregar mas de ese producto"+"\n");  
                            }else{
                              cantidad=validaNum();
                              agregarProducto(producto3,cantidad,"Palomitas");
                              System.out.println("Producto agregado"+"\n");
                              validar=true;
                            }
                            break;
                        case"B2":
                            if(producto4.isFull()){
                                System.out.println("No se pueden agregar mas de ese producto"+"\n");  
                            }else{
                              cantidad=validaNum();
                              agregarProducto(producto4,cantidad,"Agua");
                              System.out.println("Producto agregado"+"\n");
                              validar=true;
                            }
                            break;
                        case"C1":
                            if(producto5.isFull()){
                                System.out.println("No se pueden agregar mas de ese producto"+"\n");  
                            }else{
                              cantidad=validaNum();
                              agregarProducto(producto5,cantidad,"Boing");
                              System.out.println("Producto agregado"+"\n");
                              validar=true;
                            }
                            break;
                        case"C2":
                            if(producto6.isFull()){
                                System.out.println("No se pueden agregar mas de ese producto"+"\n");  
                            }else{
                              cantidad=validaNum();
                              agregarProducto(producto6,cantidad,"Cacahuates");
                              System.out.println("Producto agregado"+"\n");
                              validar=true;
                            }
                            break;
                        case"D1":
                            if(producto7.isFull()){
                                System.out.println("No se pueden agregar mas de ese producto"+"\n");  
                            }else{
                              cantidad=validaNum();
                              agregarProducto(producto7,cantidad,"Cafe");
                              System.out.println("Producto agregado"+"\n");
                              validar=true;
                            }
                            break;
                        case"D2":
                            if(producto8.isFull()){
                                System.out.println("No se pueden agregar mas de ese producto"+"\n");  
                            }else{
                              cantidad=validaNum();
                              agregarProducto(producto8,cantidad,"Skwinkles");
                              System.out.println("Producto agregado"+"\n");
                              validar=true;
                            }
                            break;
                        case"E1":
                            if(producto9.isFull()){
                                System.out.println("No se pueden agregar mas de ese producto"+"\n");  
                            }else{
                              cantidad=validaNum();
                              agregarProducto(producto9,cantidad,"Doritos");
                              System.out.println("Producto agregado"+"\n");
                              validar=true;
                            }
                            break;
                        case"E2":
                            if(producto10.isFull()){
                                System.out.println("No se pueden agregar mas de ese producto"+"\n");  
                            }else{
                              cantidad=validaNum();
                              agregarProducto(producto10,cantidad,"Chicles");
                              System.out.println("Producto agregado"+"\n");
                              validar=true;
                            }
                            break;
                        case"F1":
                            validar=false;
                            break;
                         default:
                             System.out.println("Opcion Invalida");
                             validar=true;
                             break;

                    }
               }while(validar);
               break;
               
           case "2":
               //Agregar moneda
               do{
                   System.out.println("Ingresa el numero de la moneda que desea agergar:"
                       + "\n1 - Moneda de $10"
                       + "\n2 - Moneda de $5"
                       + "\n3 - Moneda de $2"
                       + "\n4 - Moneda de $1"
                       + "\n5 - Moneda de $0.5");
                    moneda=leer.nextLine();
                    switch(moneda){
                        case"1":
                            if(m10.isFull()){
                                System.out.println("No se pueden agregar mas monedas"+"\n");  
                            }else{
                                cantidad=validaNum();
                                agregarMoneda(m10,cantidad,"10");
                                System.out.println("Monedas agregadas"+"\n");
                                validar=true;
                            }
                            break;
                        case"2":
                            if(m5.isFull()){
                                System.out.println("No se pueden agregar mas monedas"+"\n");  
                            }else{
                                cantidad=validaNum();
                                agregarMoneda(m5,cantidad,"5");
                                System.out.println("Monedas agregadas"+"\n");
                                validar=true;
                            }
                            break;
                        case"3":
                            if(m2.isFull()){
                                System.out.println("No se pueden agregar mas monedas"+"\n");  
                            }else{
                                cantidad=validaNum();
                                agregarMoneda(m2,cantidad,"2");
                                System.out.println("Monedas agregadas"+"\n");
                                validar=true;
                            }
                            break;
                        case"4":
                            if(m1.isFull()){
                                System.out.println("No se pueden agregar mas monedas"+"\n");  
                            }else{
                                cantidad=validaNum();
                                agregarMoneda(m1,cantidad,"1");
                                System.out.println("Monedas agregadas"+"\n");
                                validar=true;
                            }
                            break;
                        case"5":
                            if(m05.isFull()){
                                System.out.println("No se pueden agregar mas monedas"+"\n");  
                            }else{
                                cantidad=validaNum();
                                agregarMoneda(m05,cantidad,"0.5");
                                System.out.println("Monedas agregadas"+"\n");
                                validar=true;
                            }
                            break;
                         default:
                             System.out.println("Opcion Invalida");
                             validar=false;
                             break;
                    }
               }while(validar);
               break;
               
           case "3":
               //Comprar
               do{
                   System.out.println("Ingresa el codigo del producto que desea comprar"
                       + "\nA1  - Chips, bolsa de papas $20"
                       + "\nA2  - Principes, galletas de chocolate $15"
                       + "\nB1  - Palomitas, acarameladas $13"
                       + "\nB2  - Agua, botella grande $12.5"
                       + "\nC1  - Boing, sabor uva 17"
                       + "\nC2  - Cacahuates, japoneses $24"
                       + "\nD1  - Cafe, americano grande $25"
                       + "\nD2  - Skwinkles, jumbo $9.5" 
                       + "\nE1  - Doritos, negros $17.5"
                       + "\nE2  - Chicles, sabor menta $23.5"
                       + "\nF1  - Volver al menu principal");
                    producto=leer.nextLine();
                    switch(producto){
                        case"A1":
                            if(!producto1.isEmpty()&&ingresarMonedas(m10,m5,m2,m1,m05,20.0)){
                                producto1.dequeue();
                                System.out.print("Producto Comprado");
                                validar=true;   
                            }else{
                                System.out.println("No se puede comprar el producto"+"\n");  
                            }
                            break;
                        case"A2":
                            if(!producto2.isEmpty()&&ingresarMonedas(m10,m5,m2,m1,m05,15.0)){
                                producto2.dequeue();
                                System.out.print("Producto Comprado");
                                validar=true;   
                            }else{
                                System.out.println("No se puede comprar el producto"+"\n");  
                            }
                            break;
                        case"B1":
                            if(!producto3.isEmpty()&&ingresarMonedas(m10,m5,m2,m1,m05,13.0)){
                                producto3.dequeue();
                                System.out.print("Producto Comprado");
                                validar=true;   
                            }else{
                                System.out.println("No se puede comprar el producto"+"\n");  
                            }
                            break;
                        case"B2":
                            if(!producto4.isEmpty()&&ingresarMonedas(m10,m5,m2,m1,m05,12.5)){
                                producto4.dequeue();
                                System.out.print("Producto Comprado");
                                validar=true;   
                            }else{
                                System.out.println("No se puede comprar el producto"+"\n");  
                            }
                            break;
                        case"C1":
                            if(!producto5.isEmpty()&&ingresarMonedas(m10,m5,m2,m1,m05,17.0)){
                                producto5.dequeue();
                                System.out.print("Producto Comprado");
                                validar=true;   
                            }else{
                                System.out.println("No se puede comprar el producto"+"\n");  
                            }
                            break;
                        case"C2":
                            if(!producto6.isEmpty()&&ingresarMonedas(m10,m5,m2,m1,m05,24.0)){
                                producto6.dequeue();
                                System.out.print("Producto Comprado");
                                validar=true;   
                            }else{
                                System.out.println("No se puede comprar el producto"+"\n");  
                            }
                            break;
                        case"D1":
                            if(!producto7.isEmpty()&&ingresarMonedas(m10,m5,m2,m1,m05,25.0)){
                                producto7.dequeue();
                                System.out.print("Producto Comprado");
                                validar=true;   
                            }else{
                                System.out.println("No se puede comprar el producto"+"\n");  
                            }
                            break;
                        case"D2":
                            if(!producto8.isEmpty()&&ingresarMonedas(m10,m5,m2,m1,m05,9.5)){
                                producto8.dequeue();
                                System.out.print("Producto Comprado");
                                validar=true;   
                            }else{
                                System.out.println("No se puede comprar el producto"+"\n");  
                            }
                            break;
                        case"E1":
                            if(!producto9.isEmpty()&&ingresarMonedas(m10,m5,m2,m1,m05,17.5)){
                                producto9.dequeue();
                                System.out.print("Producto Comprado");
                                validar=true;   
                            }else{
                                System.out.println("No se puede comprar el producto"+"\n");  
                            }
                            break;
                        case"E2":
                            if(!producto10.isEmpty()&&ingresarMonedas(m10,m5,m2,m1,m05,23.5)){
                                producto10.dequeue();
                                System.out.print("Producto Comprado");
                                validar=true;   
                            }else{
                                System.out.println("No se puede comprar el producto"+"\n");  
                            }
                            break;
                        case"F1":
                            validar=false;
                            break;
                         default:
                             System.out.println("Opcion Invalida "
                                     + "\n(Ingrese el codigo del producto con letras mayusculas)");
                             validar=false;
                             break;
                    }
               }while(validar);
               break;
           case "4":
               //Imprimir estado
               System.out.println("El estado de la maquina es: ");
               System.out.println(" Productos:");
               System.out.println("     Chips hay: "+producto1.size());
               System.out.println("     Principes hay: "+producto2.size());
               System.out.println("     Palomitas hay: "+producto3.size());
               System.out.println("     Agua hay: "+producto4.size());
               System.out.println("     Boing hay: "+producto5.size());
               System.out.println("     Cacahuates hay: "+producto6.size());
               System.out.println("     Cafe hay: "+producto7.size());
               System.out.println("     Skwinkles hay: "+producto8.size());
               System.out.println("     Doritos hay: "+producto9.size());
               System.out.println("     Chicles hay: "+producto10.size());
               System.out.println(" Monedas:");
               System.out.println("     Moneda de $10 hay: "+m10.size());
               System.out.println("     Moneda de $5 hay: "+m5.size());
               System.out.println("     Moneda de $2 hay: "+m2.size());
               System.out.println("     Moneda de $1 hay: "+m1.size());
               System.out.println("     Moneda de $0.5 hay: "+m05.size());
               break;
           case "5":
               //Terminar Programa
               System.out.println("Fin del programa");
               break;
           default:
               System.out.println("Opcion Invalida");
               break;
           }
       }while(!opcionMenu.equals("5")); 
   }//
   
   public static void llenarProducto(CircularQueue producto, String product){
       while(!producto.isFull()){
           producto.enqueue(product);
       }      
   }
   public static void llenarMonedas(CircularQueue moneda, String valor){
       while(moneda.size()<9){
          moneda.enqueue(valor); 
       }
   }
   public static int validaNum() {
        Scanner leer = new Scanner(System.in);
        String numero=null;
        boolean validar=false;
        int respuesta = 0;
        String permitidos = "-?\\d+";
        do{
            System.out.println("Ingresa la cantidad que desea agregar:");
            numero=leer.nextLine();
            if (numero.matches(permitidos)) {
                respuesta=Integer.parseInt(numero);
                validar=true;
            }else{
                System.out.println("Cantidad ivalida solo se pueden ingresar numeros enteros");
            }
        }while(!validar);
        return respuesta;
    }
   public static void agregarProducto(CircularQueue producto,int cantidad,String cadena){
       if(cantidad<=10-producto.size()){
           for(int i=0;i<cantidad;i++){
               producto.enqueue(cadena);
           }
       }else{
           System.out.println("No se pueden agregar esa cantidad de productos"
                   + "\n");
       }
   } 
   public static void agregarMoneda(CircularQueue moneda,int cantidad,String cadena){
       if(cantidad<=15-moneda.size()){
           for(int i=0;i<cantidad;i++){
               moneda.enqueue(cadena);
           }
       }else{
           System.out.println("No se pueden agregar esa cantidad de monedas"
                   + "\n");
       }
   }
   public static boolean ingresarMonedas(CircularQueue m10, CircularQueue m5, CircularQueue m2, CircularQueue m1, CircularQueue m05, double precio) {
        Scanner leer = new Scanner(System.in);
        boolean respuesta = true;
        String moneda;
        boolean validar = true;
        double suma = 0;
        double cambio = 0;
        int nm10 = 0, nm5 = 0, nm2 = 0, nm1 = 0, nm05 = 0;

        System.out.println("Ingresa el numero de la moneda que deseas ingresar, monedas aceptadas de $10, $5, $2, $1, $0.5"
                + "\n(Ejemplo: $10 ingreso 10, $0.5 ingreso 0.5"
                + "\nIngresa 'x' para cancelar la operacion.");

        do {
            moneda = leer.nextLine().toLowerCase();
            switch (moneda) {
                case "10":
                    if (!m10.isFull()) {
                        nm10++;
                        suma += 10;
                        m10.enqueue("10");
                    } else {
                        System.out.println("No se pueden agregar mas monedas de $10.");
                    }
                    break;
                case "5":
                    if (!m5.isFull()) {
                        nm5++;
                        suma += 5;
                        m5.enqueue("5");
                    } else {
                        System.out.println("No se pueden agregar mas monedas de $5.");
                    }
                    break;
                case "2":
                    if (!m2.isFull()) {
                        nm2++;
                        suma += 2;
                        m2.enqueue("2");
                    } else {
                        System.out.println("No se pueden agregar mas monedas de $2.");
                    }
                    break;
                case "1":
                    if (!m1.isFull()) {
                        nm1++;
                        suma += 1;
                        m1.enqueue("1");
                    } else {
                        System.out.println("No se pueden agregar mas monedas de $1.");
                    }
                    break;
                case "0.5":
                    if (!m05.isFull()) {
                        nm05++;
                        suma += 0.5;
                        m05.enqueue("0.5");
                    } else {
                        System.out.println("No se pueden agregar mas monedas de $0.5.");
                    }
                    break;
                case "x":
                    System.out.println("Operacion cancelada\nDevolviendo monedas:");
                    devolverMonedas(nm10, m10, nm5, m5, nm2, m2, nm1, m1, nm05, m05);
                    validar = false;
                    respuesta = false;
                    break;
                default:
                    System.out.println("Opcion inválida\nIngresa monedas aceptadas de $10, $5, $2, $1 o $0.5.");
                    break;
            }
            System.out.println("Total ingresado: $" + suma + " de $" + precio);
        } while (suma < precio && validar);

        if (suma > precio) {
            cambio = suma - precio;
            int cambio10 = 0, cambio5 = 0, cambio2 = 0, cambio1 = 0, cambio05 = 0;
            do {
                if (cambio >= 10 && !m10.isEmpty()) {
                    m10.dequeue();
                    cambio10++;
                    cambio -= 10;
                } else if (cambio >= 5 && !m5.isEmpty()) {
                    m5.dequeue();
                    cambio5++;
                    cambio -= 5;
                } else if (cambio >= 2 && !m2.isEmpty()) {
                    m2.dequeue();
                    cambio2++;
                    cambio -= 2;
                } else if (cambio >= 1 && !m1.isEmpty()) {
                    m1.dequeue();
                    cambio1++;
                    cambio -= 1;
                } else if (cambio >= 0.5 && !m05.isEmpty()) {
                    m05.dequeue();
                    cambio05++;
                    cambio -= 0.5;
                } else {
                    break;
                }
            } while (cambio > 0);
            if (cambio > 0) {
                System.out.println("No hay cambio suficiente");
                devolverMonedas(nm10, m10, nm5, m5, nm2, m2, nm1, m1, nm05, m05);
            } else {
                // Imprimir cambio
                System.out.println("Cambio devolviendo monedas:");
                if (cambio10 > 0) { System.out.println(cambio10 + " moneda(s) de $10."); }
                if (cambio5 > 0) { System.out.println(cambio5 + " moneda(s) de $5."); }
                if (cambio2 > 0) { System.out.println(cambio2 + " moneda(s) de $2."); }
                if (cambio1 > 0) { System.out.println(cambio1 + " moneda(s) de $1."); }
                if (cambio05 > 0) { System.out.println(cambio05 + " moneda(s) de $0.5."); }
                System.out.println("");
            }
        }
        return respuesta;
   }

    public static void regresarMonedas(CircularQueue moneda, int num) {
        for (int i = 0; i < num; i++) {
            moneda.dequeue();
        }
    }
    public static void vaciarMonedas(CircularQueue moneda) {
        while(!moneda.isEmpty()){
            moneda.dequeue();
        }
    }
    private static void devolverMonedas(int nm10, CircularQueue m10, int nm5, CircularQueue m5, int nm2, CircularQueue m2, int nm1, CircularQueue m1, int nm05, CircularQueue m05) {
        if (nm10 > 0) { 
            System.out.println(nm10 + " moneda(s) de $10."); 
            regresarMonedas(m10, nm10); 
        }
        if (nm5 > 0) { 
            System.out.println(nm5 + " moneda(s) de $5."); 
            regresarMonedas(m5, nm5); 
        }
        if (nm2 > 0) { 
            System.out.println(nm2 + " moneda(s) de $2."); 
            regresarMonedas(m2, nm2); 
        }
        if (nm1 > 0) { 
            System.out.println(nm1 + " moneda(s) de $1.");
            regresarMonedas(m1, nm1); 
        }
        if (nm05 > 0) { 
            System.out.println(nm05 + " moneda(s) de $0.5.");
            regresarMonedas(m05, nm05); 
        }
    }
}//
