/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examenfinalestructura;

import edu.udelp.estructura.queue.NumericPriorityQueue;
import edu.udelp.estructura.tree.BTree;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author diego
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Ejecutar los proggramas descomente el llamado
        //1
        libros();
        
        //2
        //
        
        //3 Cola de prioridad
        //vocales();//Si quiere ver el conteo de las vocales descomente la linea 45 y 51
        
        //4
        //arbol();
    }
    
    public static void vocales(){
        NumericPriorityQueue cola =new NumericPriorityQueue();
        String[] palabras={"Menos","Nabucodonoso","Bebida",
            " Angelopolis", "Corleone","Avion", "Planta", "Centro comercial"
                ,"Ana"," Cthulhu"};
        for(int k=0;k<palabras.length;k++){
            int contador=0;
            String cadena=palabras[k];
            //System.out.println("Cadena:"+cadena);
            for (int i = 0; i < cadena.length(); i++) {
                String subcadena = cadena.substring(i, i + 1);
                //System.out.println("Subcadena:"+subcadena);
                if (subcadena.equalsIgnoreCase("a") || subcadena.equalsIgnoreCase("e") || subcadena.equalsIgnoreCase("i") || subcadena.equalsIgnoreCase("o") || subcadena.equalsIgnoreCase("u")) {
                        contador++;
                        //System.out.println(contador);
                    }
            }
            //System.out.println("Numero de vocales: "+contador);
            cola.enqueue(cadena, contador);
        }
        System.out.println("La cola quedo:"+cola.toString());
    }
    
    public static void arbol(){
        BTree arbol =new BTree();
        arbol.add("67");
        arbol.add("43");
        arbol.add("80");
        arbol.add("11");
        arbol.add("55");
        arbol.add("5");
        arbol.add("23");
        arbol.add("50");
        arbol.add("56");
        arbol.add("70");
        arbol.add("92");
        arbol.add("90");
        arbol.add("65");
        arbol.preorden();
        
    }
    
    public static void libros(){
        Scanner leer=new Scanner(System.in);
        NumericPriorityQueue colaAño =new NumericPriorityQueue();
        NumericPriorityQueue colaNum =new NumericPriorityQueue();
        Random random = new Random();
        int opcion=0;
        int numero=0;
        int año=0;
        while(opcion!=2){
            String cadena="ISBN";
            opcion=leerOpcionNumero(leer);
            switch (opcion) {
                case 1:
                    System.out.println();
                    numero=random.nextInt(9999);
                    numero=agregar0(numero);
                    año=random.nextInt(1990, 2008);
                    cadena+="-"+año+"-"+numero;
                    colaAño.enqueue2(cadena, año,numero);
                    System.out.println("Clave ingresada: "+cadena);
                    
                    break;    
                case 2:                    
                    System.out.println("Ordenado"+ colaAño.toString());
                    
                default:
                    System.out.println("Opcion Invalida");
                    break;
                    
            }
        }
    }
    
    public static int agregar0(int numero){
        String cadena=String.valueOf(numero);
        while(cadena.length()<4){
            cadena="0"+cadena;
        }
        return Integer.parseInt(cadena);
    }
    
    public static int leerOpcionNumero(Scanner scanner) {
        int numero = 0;
        boolean validar = false;
        while (!validar) {
            System.out.println("Ingersa la opcion que desea realizar:"
                    + "\n1 - Agregar Libro"
                    + "\n2 - Mostrar Lista");
            if (scanner.hasNextInt()) {
                numero = scanner.nextInt();
                if (numero >= 1 && numero <= 2) {
                    validar = true;
                } else {
                    System.out.println("\033[31m" + "Opcion Invalida" + "\033[0m\n");
                }
            } else {
                System.out.println("\033[31m" + "Opcion Invalida" + "\033[0m\n");
                scanner.next();
            }
        }

        return numero;
    }
    
    
}
