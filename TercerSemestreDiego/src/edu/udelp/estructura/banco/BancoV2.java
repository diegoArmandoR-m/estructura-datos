/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udelp.estructura.banco;

import edu.udelp.estructura.queue.LinkedQueue;
import edu.udelp.estructura.queue.NumericPriorityQueue;
import java.util.Scanner;

/**
 *
 * @author diego
 */
public class BancoV2 {
    
    public static void main (String [] args) {
        Scanner leer=new Scanner(System.in);
        String opcionMenu=null;
        String opcionCuenta=null;
        String opcionCCuenta=null;
        String opcionMovi=null;
        String retiro=null;
        String depRe=null;
        double cantidad=0;
        int orden=1;
        boolean validar=true;
        
        LinkedQueue noCuenta = new LinkedQueue();
        NumericPriorityQueue cCuenta= new NumericPriorityQueue();
        
        LinkedQueue m1000 = new LinkedQueue();
        m1000.enqueue(1000);
        m1000.enqueue(1000);
        LinkedQueue m500 = new LinkedQueue();
        m500.enqueue(500);
        m500.enqueue(500);
        LinkedQueue m200 = new LinkedQueue();
        m200.enqueue(200);
        LinkedQueue m100 = new LinkedQueue();
        m100.enqueue(100);
        m100.enqueue(100);
        LinkedQueue m20 = new LinkedQueue();
        m20.enqueue(20);
        m20.enqueue(20);
        LinkedQueue m10 = new LinkedQueue();
        m10.enqueue(10);
        m10.enqueue(10);
        m10.enqueue(10);
        LinkedQueue m5  = new LinkedQueue();
        m5.enqueue(5);
        m5.enqueue(5);
        m5.enqueue(5);
        LinkedQueue m2  = new LinkedQueue();
        m2.enqueue(2);
        m2.enqueue(2);
        m2.enqueue(2);
        m2.enqueue(2);
        LinkedQueue m1  = new LinkedQueue();
        m1.enqueue(1);
        m1.enqueue(1);
        m1.enqueue(1);
        m1.enqueue(1);
        m1.enqueue(1);
        LinkedQueue m05 = new LinkedQueue();
        m05.enqueue(05);
        m05.enqueue(05);
        m05.enqueue(05);
        m05.enqueue(05);
        
        double[][] cajas = new double[4][2];
        cajas[0][1]=3500;
        cajas[1][1]=3500;
        cajas[2][1]=3500;
        cajas[3][1]=3500;
        
        do{
            System.out.println("Ingresa el numero de la opcion que desea realizar"
                + "\n1  - Ingresar Persona"
                + "\n2  - Ingreso a Caja"
                + "\n3  - Movimiento Caja"
                + "\n4  - Ingreso dinero a caja"
                + "\n5  - Retiro de dinero caja"
                + "\n6  - Imprimir estado"
                + "\n7  - Finalizar progrma");
            opcionMenu=leer.nextLine();
            
            switch(opcionMenu){
                case "1":
                    //Ingreso Persona
                    do{
                        System.out.println("Ingresa numero de la opcion"
                                + "\n1 - Persona con cuenta"
                                + "\n2 - Persona sin cuenta");
                        opcionCuenta=leer.nextLine();
                        if(opcionCuenta.equals("1")){
                            //cuenta.enqueue("1");
                            do{
                                System.out.println("Ingresa los primeros 3 numeros de tu cuenta:"
                                        + "\n(Permitidos 042 o 022 o 011");
                                opcionCCuenta=leer.nextLine();
                                if(!opcionCCuenta.equals("042")&&!opcionCCuenta.equals("022")&&!opcionCCuenta.equals("011")){
                                    System.out.println("Opcion Invalida");
                                }
                            }while(!opcionCCuenta.equals("042")&&!opcionCCuenta.equals("022")&&!opcionCCuenta.equals("011"));
                            
                            if(opcionCCuenta.equals("042")){
                                cCuenta.enqueue(opcionCCuenta, 1);
                            }else if(opcionCCuenta.equals("022")){
                                cCuenta.enqueue(opcionCCuenta, 2);
                            }else if(opcionCCuenta.equals("011")){
                                cCuenta.enqueue(opcionCCuenta, 3);
                            }
                        }else if(opcionCuenta.equals("2")){
                            noCuenta.enqueue("2");
                        }else{
                            System.out.println("Opcion Invalida");
                        }
                    }while(!opcionCuenta.equals("1")&&!opcionCuenta.equals("2"));
                    break;
                case "2":
                    //Ingreso a caja
                    if(!cCuenta.isEmpty()||!noCuenta.isEmpty()){
                        int ncaja=cajaD(cajas);
                        if(ncaja==5){
                            System.out.println("Cajas llenas espere a que se libere una");
                        }else if(cCuenta.isEmpty()){
                            System.out.println("Persona sin cuenta ingreso a Caja"+(ncaja+1)+"\n");
                            cajas[ncaja][0]=2;
                            noCuenta.dequeue();
                            break;
                        }else if(noCuenta.isEmpty()){
                            System.out.println("Persona con cuenta "+cCuenta.dequeue()+" ingreso a Caja"+(ncaja+1)+"\n");
                            cajas[ncaja][0]=1;
                            //cCuenta.dequeue();
                            break;
                        }else{
                            if(orden%2!=0){
                                System.out.println("Persona con cuenta "+cCuenta.dequeue()+" ingreso a Caja"+(ncaja+1)+"\n");
                                cajas[ncaja][0]=1;
                                orden++;
                            }else{
                                System.out.println("Persona sin cuenta ingreso a Caja"+(ncaja+1)+"\n");
                                cajas[ncaja][0]=2;
                                noCuenta.dequeue();
                                orden++;
                            }
                        }
                    }else{
                        System.out.println("No hay gente esperando\n");
                    }
                    
                    break;
                case "3":
                    //Movimiento caja 
                    if(!cajaV(cajas)){
                        do{
                            imprimirCajaM(cajas);
                            opcionMovi=leer.nextLine();
                            switch(opcionMovi){
                                case"1":
                                    if(cajas[0][0]!=0){
                                        System.out.println("Ingrese el numero de la accion que desea realizar:"
                                                + "\n1 - Deposito"
                                                + "\n2 - Retiro");
                                        depRe=leer.nextLine();
                                        if(depRe.equals("1")){
                                            deposito(cajas,0,m1000,m500,m200,m100,m20,m10,m5,m2,m1,m05);
                                            cajas[0][0]=0;
                                            validar=true;
                                            break;
                                        }else if(depRe.equals("2")){
                                            retiro(cajas,0,m1000,m500,m200,m100,m20,m10,m5,m2,m1,m05);
                                            cajas[0][0]=0;
                                            validar=true;
                                            break;
                                        }else{
                                            System.out.println("Opcion Invalida");  
                                        }
                                    }else{
                                      System.out.println("Opcion Invalida ingresa una caja disponible");  
                                      validar=false;
                                      break;
                                    }
                                case"2":
                                    if(cajas[1][0]!=0){
                                        System.out.println("Ingrese el numero de la accion que desea realizar:"
                                                + "\n1 - Deposito"
                                                + "\n2 - Retiro");
                                        depRe=leer.nextLine();
                                        if(depRe.equals("1")){
                                            deposito(cajas,1,m1000,m500,m200,m100,m20,m10,m5,m2,m1,m05);
                                            cajas[1][0]=0;
                                            validar=true;
                                            break;
                                        }else if(depRe.equals("2")){
                                            retiro(cajas,1,m1000,m500,m200,m100,m20,m10,m5,m2,m1,m05);
                                            cajas[1][0]=0;
                                            validar=true;
                                            break;
                                        }else{
                                            System.out.println("Opcion Invalida");  
                                        }
                                    }else{
                                      System.out.println("Opcion Invalida ingresa una caja disponible");  
                                      validar=false;
                                      break;
                                    }
                                case"3":
                                    if(cajas[2][0]!=0){
                                        System.out.println("Ingrese el numero de la accion que desea realizar:"
                                                + "\n1 - Deposito"
                                                + "\n2 - Retiro");
                                        depRe=leer.nextLine();
                                        if(depRe.equals("1")){
                                            deposito(cajas,2,m1000,m500,m200,m100,m20,m10,m5,m2,m1,m05);
                                            cajas[2][0]=0;
                                            validar=true;
                                            break;
                                        }else if(depRe.equals("2")){
                                            retiro(cajas,2,m1000,m500,m200,m100,m20,m10,m5,m2,m1,m05);
                                            cajas[2][0]=0;
                                            validar=true;
                                            break;
                                        }else{
                                            System.out.println("Opcion Invalida");  
                                        }
                                    }else{
                                      System.out.println("Opcion Invalida ingresa una caja disponible");  
                                      validar=false;
                                      break;
                                    }
                                case"4":
                                    if(cajas[3][0]!=0){
                                        System.out.println("Ingrese el numero de la accion que desea realizar:"
                                                + "\n1 - Deposito"
                                                + "\n2 - Retiro");
                                        depRe=leer.nextLine();
                                        if(depRe.equals("1")){
                                            deposito(cajas,3,m1000,m500,m200,m100,m20,m10,m5,m2,m1,m05);
                                            cajas[3][0]=0;
                                            validar=true;
                                            break;
                                        }else if(depRe.equals("2")){
                                            retiro(cajas,3,m1000,m500,m200,m100,m20,m10,m5,m2,m1,m05);
                                            cajas[3][0]=0;
                                            validar=true;
                                            break;
                                        }else{
                                            System.out.println("Opcion Invalida");  
                                        }
                                    }else{
                                      System.out.println("Opcion Invalida ingresa una caja disponible");  
                                      validar=false;
                                      break;
                                    }
                            }
                        }while(!validar);
                    }else{
                        System.out.println("No hay nadie en las cajas");
                    }
                    break;
                case "4":
                    //Ingresar Dinero a Caja
                    do{
                        System.out.println("Ingresa el numero de la caja a la que desea agregar dinero"
                                + "\n1 - Caja1"
                                + "\n2 - Caja2"
                                + "\n3 - Caja3"
                                + "\n2 - Caja4");
                        opcionMovi=leer.nextLine();
                        switch(opcionMovi){
                            case"1":
                                cajas[0][1]+=ingresarMonedas(m1000,m500,m200,m100,m20,m10,m5,m2,m1,m05);
                                validar=true;
                                break;
                            case"2":
                                cajas[1][1]+=ingresarMonedas(m1000,m500,m200,m100,m20,m10,m5,m2,m1,m05);
                                validar=true;
                                break;
                            case"3":
                                cajas[2][1]+=ingresarMonedas(m1000,m500,m200,m100,m20,m10,m5,m2,m1,m05);
                                validar=true;
                                break;
                            case"4":
                                cajas[3][1]+=ingresarMonedas(m1000,m500,m200,m100,m20,m10,m5,m2,m1,m05);
                                validar=true;
                                break;
                            default:
                              System.out.println("Opcion Invalida ingresa una caja existente");    
                        }
                    }while(!validar);
                    break;
                case "5":
                    //Retirar dinero de caja 
                    do{
                        System.out.println("Ingresa el numero de la caja a la que desea retirar dinero"
                                + "\n1 - Caja1"
                                + "\n2 - Caja2"
                                + "\n3 - Caja3"
                                + "\n2 - Caja4");
                        opcionMovi=leer.nextLine();
                        switch(opcionMovi){
                            case"1":
                                retiro(cajas,0,m1000,m500,m200,m100,m20,m10,m5,m2,m1,m05);
                                validar=true;
                                break;
                            case"2":
                                retiro(cajas,1,m1000,m500,m200,m100,m20,m10,m5,m2,m1,m05);
                                validar=true;
                                break;
                            case"3":
                                retiro(cajas,2,m1000,m500,m200,m100,m20,m10,m5,m2,m1,m05);
                                validar=true;
                                break;
                            case"4":
                                retiro(cajas,3,m1000,m500,m200,m100,m20,m10,m5,m2,m1,m05);
                                validar=true;
                                break;
                            default:
                              System.out.println("Opcion Invalida ingresa una caja existente");    
                        }
                    }while(!validar);
                    break;
                case "6":
                    //Imprimir 
                    System.out.println("Personas en la fila con Cuenta: "+cCuenta.size());
                    System.out.println("Personas en la fila sin Cuenta: "+noCuenta.size());
                    imprimircajas(cajas,m1000,m500,m200,m100,m20,m10,m5,m2,m1,m05);   
                    break;
                case "7":
                    //
                    break;
                default:
                    System.out.println("Opcion Invalida");    
                    break;
            }
            
        }while(!opcionMenu.equals("7"));
        
    }//
    

    public static int cajaD(double[][] cajas){
        int nCaja=0;
        nCaja = (cajas[0][0]==0) ? 0 :
            (cajas[1][0]==0) ? 1 :
            (cajas[2][0]==0) ? 2 :
            (cajas[3][0]==0) ? 3 :5;
        return nCaja;        
    }
    
    public static boolean cajaV(double[][] cajas){
        boolean respuesta=true;
        for(int i=0;i<cajas.length;i++){
            if(cajas[i][0]!=0){
                respuesta=false;
            }
        }
        return respuesta;
    }
    
    public static void imprimirCajaM(double[][] cajas){
        System.out.println("Ingrese el numero de la caja en la que quiere realizar movimiento:");
        if(cajas[0][0]!=0){
            System.out.println("1 -Caja 1");
        }
        if(cajas[1][0]!=0){
            System.out.println("2 -Caja 2");
        }
        if(cajas[2][0]!=0){
            System.out.println("3 -Caja 3");
        }
        if(cajas[3][0]!=0){
            System.out.println("4 -Caja 4");
        }
    }
    
    public static void imprimircajas(double[][] cajas,LinkedQueue m1000,LinkedQueue m500,LinkedQueue m200,LinkedQueue m100,LinkedQueue m20,LinkedQueue m10,LinkedQueue m5,LinkedQueue m2,LinkedQueue m1,LinkedQueue m05){
        for(int i=0;i<cajas.length;i++){
            if(cajas[i][0]==0){
                System.out.println("Caja"+(i+1)+" Vacia con $"+cajas[i][1]);
                
            }else{
                System.out.println("Caja"+(i+1)+" Ocupada con $"+cajas[i][1]);
            }
        }
        System.out.println("En total el banco tiene:");
        if(m1000.size()!=0){
            System.out.println("    De billetes de $1000 hay: "+m1000.size());
        }
        
        if(m500.size()!=0){
            System.out.println("    De billetes de $500 hay: "+m500.size());
        }
        
        if(m200.size()!=0){
            System.out.println("    De billetes de $200 hay: "+m200.size());
        }
        
        if(m100.size()!=0){
            System.out.println("    De billetes de $100 hay: "+m100.size());
        }
        
        if(m20.size()!=0){
            System.out.println("    De billetes de $20 hay: "+m20.size());
        }
        
        if(m10.size()!=0){
            System.out.println("    De monedas de $10 hay: "+m10.size());
        }
        
        if(m5.size()!=0){
            System.out.println("    De monedas de $5 hay: "+m5.size());
        }
        
        if(m2.size()!=0){
            System.out.println("    De monedas de $2 hay: "+m2.size());
        }
        
        if(m1.size()!=0){
            System.out.println("    De monedas de $1 hay: "+m1.size());
        }
        
        if(m05.size()!=0){
            System.out.println("    De monedas de $0.5 hay: "+m5.size());
        }
    }
    
    public static void deposito(double[][]cajas,int index,LinkedQueue m1000,LinkedQueue m500,LinkedQueue m200,LinkedQueue m100,LinkedQueue m20,LinkedQueue m10,LinkedQueue m5,LinkedQueue m2,LinkedQueue m1,LinkedQueue m05){
        if(cajas[index][0]!=0){
            cajas[index][1]+=ingresarMonedas(m1000,m500,m200,m100,m20,m10,m5,m2,m1,m05);
        }
    }
    
    public static void retiro(double[][]cajas,int index,LinkedQueue m1000,LinkedQueue m500,LinkedQueue m200,LinkedQueue m100,LinkedQueue m20,LinkedQueue m10,LinkedQueue m5,LinkedQueue m2,LinkedQueue m1,LinkedQueue m05){
        Scanner leer=new Scanner(System.in);
        String monto=null;
        do{
            System.out.println("Ingresa la cantidad que desea retirar ");
            monto=leer.nextLine();
            if(!esNumero(monto)){
                System.out.println("No es un numero valido");
            }
        }while(!esNumero(monto));
        double montos =Double.parseDouble(monto);
        double montoO =montos;
        if(montos<cajas[index][1]){
            do{
                if(montos>=1000){
                    montos-=1000;
                    m1000.enqueue(1000);
                }else if(montos>=500){
                    montos-=500;
                    m500.enqueue(500);
                }else if(montos>=200){
                    montos-=200;
                    m200.enqueue(200);
                }else if(montos>=100){
                    montos-=100;
                    m100.enqueue(100);
                }else if(montos>=20){
                    montos-=20;
                    m20.enqueue(20);
                }else if(montos>=10){
                    montos-=10;
                    m10.enqueue(10);
                }else if(montos>=5){
                    montos-=5;
                    m5.enqueue(5);
                }else if(montos>=2){
                    montos-=2;
                    m2.enqueue(2);
                }else if(montos>=1){
                    montos-=1;
                    m5.enqueue(1);
                }else if(montos>=0.5){
                    montos-=0.5;
                    m5.enqueue(0.5);
                }
            }while(montos>0);
            
            System.out.println("Se da el siguiente dinero:");
            if(m1000.size() != 0) {
                System.out.println(m1000.size() + " bille(s) de $1000");
            }
            if(m500.size() != 0) {
                System.out.println(m500.size() + " bille(s) de $500");
            }
            if(m200.size() != 0) {
                System.out.println(m200.size() + " bille(s) de $200");
            }
            if(m100.size() != 0) {
                System.out.println(m100.size() + " bille(s) de $100");
            }
            if(m20.size() != 0) {
                System.out.println(m20.size() + " bille(s) de $20");
            }
            if(m10.size() != 0) {
                System.out.println(m10.size() + " bille(s) de $10");
            }
            if(m5.size() != 0) {
                System.out.println(m5.size() + " bille(s) de $5");
            }
            if(m2.size() != 0) {
                System.out.println(m2.size() + " bille(s) de $2");
            }
            if(m1.size() != 0) {
                System.out.println(m1.size() + " bille(s) de $1");
            }
            if(m05.size() != 0) {
                System.out.println(m05.size() + " bille(s) de $0.5");
            }
            cajas[index][1]-=montoO;
        }else{
            System.out.println("No hay dinero suficiente en la caja");
        }
    }
    
    public static boolean esNumero(String cadena) {
        try {
            Double.parseDouble(cadena);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static double ingresarMonedas(LinkedQueue m1000,LinkedQueue m500,LinkedQueue m200,LinkedQueue m100,LinkedQueue m20,LinkedQueue m10,LinkedQueue m5,LinkedQueue m2,LinkedQueue m1,LinkedQueue m05) {
        Scanner leer = new Scanner(System.in);
        boolean respuesta = true;
        String moneda;
        double suma = 0;

        System.out.println("Ingresa el numero de la moneda o billete que deseas ingresar. Denominaciones aceptadas: $1000, $500, $200, $100, $20, $10, $5, $2, $1, $0.5"
                + "\n(Ejemplo: ingresa '10' para agregar una moneda de $10, '0.5' para $0.5)"
                + "\nIngresa 'x' para terminar de ingresar");
        do {
            moneda = leer.nextLine().toLowerCase();

            switch (moneda) {
                case "1000":
                    suma += 1000;
                    m1000.enqueue(1000);
                    break;
                case "500":
                    suma += 500;
                    m500.enqueue(500);
                    break;
                case "200":
                    suma += 200;
                    m200.enqueue(200);
                    break;
                case "100":
                    suma += 100;
                    m100.enqueue(100);
                    break;
                case "20":
                    suma += 20;
                    m20.enqueue(20);
                    break;
                case "10":
                    suma += 10;
                    m10.enqueue(10);
                    break;
                case "5":
                    suma += 5;
                    m5.enqueue(5);
                    break;
                case "2":
                    suma += 2;
                    m2.enqueue(2);
                    break;
                case "1":
                    suma += 1;
                    m1.enqueue(1);
                    break;
                case "0.5":
                    suma += 0.5;
                    m05.enqueue(05);
                    break;
                case "x":
                    System.out.println("Total ingresado: $" + suma);
                    respuesta = false;
                    break;
                default:
                    System.out.println("Opcion inválida. Ingresa monedas aceptadas de $1000, $500, $200, $100, $20, $10, $5, $2, $1 o $0.5.");
                    break;
            }
            System.out.println("Ingresado: $" + suma);
        } while (respuesta);
        return suma;
    }
    
    
}
