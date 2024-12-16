/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoFinal;

import edu.udelp.estructura.list.ArrayList;
import edu.udelp.estructura.stack.ArrayStack;
import java.util.Scanner;

/**
 *
 * @author diego
 */
public class Principal {

    public static void main(String[] args) {
        int nivel = 1;
        ArrayStack camioness = new ArrayStack(5);
        Scanner leer = new Scanner(System.in);
        ArrayList pasajeros1 = new ArrayList();
        ArrayList pasajeros2 = new ArrayList();
        ArrayList pasajeros3 = new ArrayList();
        ArrayList pasajeros4 = new ArrayList();
        ArrayList pasajeros5 = new ArrayList();

        String[] fila = {" ", " ", " ", " ", " "};

        String[] camionVerde = {"0", " ", " ", " "};
        String[] camionRojo = {"1", " ", " ", " "};
        String[] camionAmarillo = {"2", " ", " ", " "};
        String[] camionAzul = {"3", " ", " ", " "};
        String[] camionBlanco = {"4", " ", " ", " "};

        String[] colores = {"\033[32m", "\033[31m", "\033[33m", "\033[34m", "\033[0m"};
        String[] simbolosCarro = {colores[0] + "+" + colores[4], colores[1] + "-" + colores[4], colores[2] + "/" + colores[4], colores[3] + ";" + colores[4], colores[4] + "'"};
        String opcion1 = "";

        llenarPasajerosList(nivel, simbolosCarro, pasajeros1, pasajeros2, pasajeros3, pasajeros4);
        llenarParadaCamiones(nivel, camioness, camionVerde, camionRojo, camionAzul, camionAmarillo, camionBlanco);

        System.out.println("Bienvenid@, este juego esta inspirado en el juego Busjam. Se debe de llenar los coches con los pasajeros correspondientes\n"
                + "Los camiones muestran un simbolo que corresponde a los pasajeros que pueden subir al coche.\n"
                + "Para poder jugar deberas ingresar la letra de la columna del pasajeros que quieres que ingrese a la fila de abordar"
                + "\nSolo puede salir el pasajero que esta mas cerca de la zona de abordar"
                + "\033[31m"+"\nSi llenas la zona de abordar pierdes el juego"+"\033[0m");

        imprimirCarro(simbolosCarro, camioness);
        imprimirFilaEspera(fila);
        imprimirFilas(nivel, pasajeros1, pasajeros2, pasajeros3, pasajeros4, pasajeros5);

        while (nivel < 4 && !opcion1.equalsIgnoreCase("F")) {
            switch (nivel) {
                case 1:
                    if (!camioness.isEmpty()) {
                        opcion1=nivel1(nivel, pasajeros1, pasajeros2,pasajeros3,pasajeros4 ,camioness, leer, fila);
                        imprimirCarro(simbolosCarro, camioness);
                        imprimirFilaEspera(fila);
                        imprimirFilas(nivel, pasajeros1, pasajeros2, pasajeros3, pasajeros4, pasajeros5);
                    } else {
                        nivel = nivel(nivel);
                        llenarPasajerosList(nivel, simbolosCarro, pasajeros1, pasajeros2, pasajeros3, pasajeros4);
                        llenarParadaCamiones(nivel, camioness, camionVerde, camionRojo, camionAzul, camionAmarillo, camionBlanco);
                        System.out.println("\033[33m" + "Entro nivel 2" + "\033[0m");
                    }
                    break;

                case 2:
                    if (!camioness.isEmpty()) {
                        imprimirCarro(simbolosCarro, camioness);
                        imprimirFilaEspera(fila);
                        imprimirFilas(nivel, pasajeros1, pasajeros2, pasajeros3, pasajeros4, pasajeros5);
                        opcion1=nivel2(nivel, pasajeros1, pasajeros2, pasajeros3,pasajeros4 ,camioness, leer, fila);
                    }else {
                        nivel = nivel(nivel);
                        llenarPasajerosList(nivel, simbolosCarro, pasajeros1, pasajeros2, pasajeros3, pasajeros4);
                        llenarParadaCamiones(nivel, camioness, camionVerde, camionRojo, camionAzul, camionAmarillo, camionBlanco);
                        System.out.println("\033[33m" + "Entro nivel 3" + "\033[0m");
                    }
                    break;
                
                case 3:
                    if (!camioness.isEmpty()) {
                        imprimirCarro(simbolosCarro, camioness);
                        imprimirFilaEspera(fila);
                        imprimirFilas(nivel, pasajeros1, pasajeros2, pasajeros3, pasajeros4, pasajeros5);
                        opcion1=nivel3(nivel, pasajeros1, pasajeros2, pasajeros3,pasajeros4 ,camioness, leer, fila);
                    }else {
                        nivel = nivel(nivel);
                    }
                    break;
                    
                    
            }
        }
        System.out.println("\033[31m"+"Termino el juego"+"\033[0m");
        System.out.println("\033[31m"+"Cargalo nuevamente para poder volver a jugar"+"\033[0m");

    }

    public static int nivel(int nivel) {
        return nivel + 1;
    }

    public static void imprimirCarro(String[] simbolos, ArrayStack camiones) {
        String reset = "\033[0m";
        if (camiones != null && !camiones.isEmpty()) {
            String[] arregloRecuperado = (String[]) camiones.peak();
            String numeros = arregloRecuperado[0];
            int numero = Integer.parseInt(numeros);

            String cadena = "         _______  \n"
                    + "        /|_||__\\`._ \n"
                    + "       (   _ " + simbolos[numero] + " _ _ |] \n"
                    + "       =`-(_)--(_)-' ";

            System.out.println(cadena);
            System.out.println("\033[33m"+"Han abordado "+espacios(arregloRecuperado)+" de 3 pasajeros"+"\033[0m");
        }
    }

    public static void imprimirFilaEspera(String[] fila) {
        String cadena = "   ___   ___   ___   ___   ___\n"
                + "  |_" + fila[0] + "_| |_" + fila[1] + "_| |_" + fila[2] + "_| |_" + fila[3] + "_| |_" + fila[4] + "_|\n";
        System.out.println(cadena);
    }

    public static void llenarParadaCamiones(int nivel, ArrayStack camiones, String[] camionVerde, String[] camionRojo, String[] camionAzul, String[] camionAmarillo, String[] camionBlanco) {
        switch (nivel) {
            case 1:
                camiones.push(camionRojo);
                camiones.push(camionAzul);
                break;
            case 2:
                vaciar(camionRojo);
                vaciar(camionAzul);
                camiones.push(camionRojo);
                camiones.push(camionVerde);
                camiones.push(camionAzul);
                camiones.push(camionAmarillo);
                break;
                
            case 3:
                vaciar(camionRojo);
                vaciar(camionVerde);
                vaciar(camionAzul);
                vaciar(camionAmarillo);
                camiones.push(camionAmarillo);
                camiones.push(camionRojo);
                camiones.push(camionVerde);
                camiones.push(camionAzul);
                camiones.push(camionAmarillo);
                camiones.push(camionVerde);
                
        }

    }
    
    public static void vaciar(String[] arreglo){
        if(arreglo!=null){
            for(int i=1;i<arreglo.length;i++){
            arreglo[i]=" ";
        }
        }
    }

    public static void llenarPasajerosList(int nivel, String[] simbolos, ArrayList fila1, ArrayList fila2, ArrayList fila3, ArrayList fila4) {
        switch (nivel) {
            case 1:
                fila1.add(simbolos[1]);//rojo
                fila1.add(simbolos[3]);//azul
                fila1.add(simbolos[3]);
                fila2.add(simbolos[3]);
                fila2.add(simbolos[1]);
                fila2.add(simbolos[1]);
                break;
            case 2:
                fila1.add(simbolos[3]);
                fila1.add(simbolos[3]);
                fila1.add(simbolos[2]);//amarillo
                fila1.add(simbolos[0]);//verde
                fila2.add(simbolos[0]);
                fila2.add(simbolos[1]);
                fila2.add(simbolos[1]);
                fila2.add(simbolos[2]);
                fila3.add(simbolos[3]);
                fila3.add(simbolos[1]);
                fila3.add(simbolos[2]);
                fila3.add(simbolos[0]);
                break;
                
            case 3:
                fila1.add(simbolos[3]);
                fila1.add(simbolos[1]);
                fila1.add(simbolos[2]);
                fila1.add(simbolos[0]);
                fila2.add(simbolos[2]);
                fila2.add(simbolos[1]);
                fila2.add(simbolos[1]);
                fila2.add(simbolos[2]);
                fila3.add(simbolos[3]);
                fila3.add(simbolos[3]);
                fila3.add(simbolos[2]);
                fila3.add(simbolos[0]);
                fila4.add(simbolos[2]);
                fila4.add(simbolos[2]);
                fila4.add(simbolos[0]);
        }

    }

    public static void imprimirFilas(int nivel, ArrayList fila1, ArrayList fila2, ArrayList fila3, ArrayList fila4, ArrayList fila5) {
        int mayor = 0;
        switch (nivel) {
            case 1:
                mayor=mayor(fila1.size(),fila2.size(),fila3.size(),fila4.size());
                for (int j = (mayor - 1); j > -1; j--) {
                    System.out.println((j + 1) + " |" + fila1.get(j) + "|" + " |" + fila2.get(j) + "|");
                }
                if(!(fila1.isEmpty()&&fila2.isEmpty())){
                    System.out.println("   A   B");
                }
                break;
            case 2:
                mayor=mayor(fila1.size(),fila2.size(),fila3.size(),fila4.size());
                for (int j = (mayor - 1); j > -1; j--) {
                    System.out.println((j + 1) + " |" + fila1.get(j) + "|" + " |" + fila2.get(j) + "|" + " |" + fila3.get(j) + "|");
                }
                if(!(fila1.isEmpty()&&fila2.isEmpty()&&fila3.isEmpty())){
                    System.out.println("   A   B   C");
                }
                break;
            case 3:
                mayor=mayor(fila1.size(),fila2.size(),fila3.size(),fila4.size());
                for (int j = (mayor - 1); j > -1; j--) {
                    System.out.println((j + 1) + " |" + fila1.get(j) + "|" + " |" + fila2.get(j) + "|" + " |" + fila3.get(j) + "|" + " |" + fila4.get(j) + "|");
                }
                if(!(fila1.isEmpty()&&fila2.isEmpty()&&fila3.isEmpty()&&fila4.isEmpty())){
                    System.out.println("   A   B   C   D");
                }
                break;
        }
    }

    public static String nivel1(int nivel, ArrayList fila1, ArrayList fila2,ArrayList fila3,ArrayList fila4 ,ArrayStack camiones, Scanner leer, String[] filaEspera) {
        String columna = "";
        while (!(columna.equalsIgnoreCase("A") || columna.equalsIgnoreCase("B") || (fila1.isEmpty() && fila2.isEmpty()))) {
            columna = leerOpcionLetra(leer);
            if ((columna.equalsIgnoreCase("A") && fila1.isEmpty()) || (columna.equalsIgnoreCase("B") && fila2.isEmpty())) {
                System.out.println("\033[31m" + "Esa fila ya esta vacia, seleccione una que si tenga pasajeros" + "\033[0m");
            }else if(columna.equalsIgnoreCase("F")){
                return columna;
            }
        }
        if(!(moverPasajeroP2(filaEspera)==-1)){
            filaEspera[moverPasajeroP2(filaEspera)] = moverPasajero(fila1, fila2,fila3,fila4 ,columna, camiones);
        }else{
            columna="F";
        }
        moverCamion(filaEspera, camiones, nivel);
        return columna;
    }

    public static String nivel2(int nivel, ArrayList fila1, ArrayList fila2, ArrayList fila3,ArrayList fila4 ,ArrayStack camiones, Scanner leer, String[] filaEspera) {
        String columna = "";
        moverCamion(filaEspera, camiones, nivel);
        if (!camiones.isEmpty()) {
            while (!(columna.equalsIgnoreCase("A") || columna.equalsIgnoreCase("B") || columna.equalsIgnoreCase("C"))) {
                columna = leerOpcionLetra(leer);
                if ((columna.equalsIgnoreCase("A") && fila1.isEmpty()) || (columna.equalsIgnoreCase("B") && fila2.isEmpty()) || (columna.equalsIgnoreCase("C") && fila3.isEmpty())) {
                    System.out.println("\033[31m" + "Esa fila ya esta vacia, seleccione una que si tenga pasajeros" + "\033[0m");
                } else if (columna.equalsIgnoreCase("F")) {
                    return columna;
                }
            }
            if (!(moverPasajeroP2(filaEspera) == -1)) {
                filaEspera[moverPasajeroP2(filaEspera)] = moverPasajero(fila1, fila2, fila3,fila4 ,columna, camiones);
            } else {
                columna = "F";
            }
            moverCamion(filaEspera, camiones, nivel);
        }
        return columna;
    }
    
    public static String nivel3(int nivel, ArrayList fila1, ArrayList fila2, ArrayList fila3,ArrayList fila4 ,ArrayStack camiones, Scanner leer, String[] filaEspera) {
        String columna = "";
        moverCamion(filaEspera, camiones, nivel);
        if (!camiones.isEmpty()) {
            while (!(columna.equalsIgnoreCase("A") || columna.equalsIgnoreCase("B") || columna.equalsIgnoreCase("C")|| columna.equalsIgnoreCase("D"))) {
                columna = leerOpcionLetra(leer);
                if ((columna.equalsIgnoreCase("A") && fila1.isEmpty()) || (columna.equalsIgnoreCase("B") && fila2.isEmpty()) || (columna.equalsIgnoreCase("C") && fila3.isEmpty())|| (columna.equalsIgnoreCase("D") && fila4.isEmpty())) {
                    System.out.println("\033[31m" + "Esa fila ya esta vacia, seleccione una que si tenga pasajeros" + "\033[0m");
                } else if (columna.equalsIgnoreCase("F")) {
                    return columna;
                }
            }
            if (!(moverPasajeroP2(filaEspera) == -1)) {
                filaEspera[moverPasajeroP2(filaEspera)] = moverPasajero(fila1, fila2, fila3, fila4,columna, camiones);
            } else {
                columna = "F";
            }
            moverCamion(filaEspera, camiones, nivel);
        }
        return columna;
    }

    public static void moverCamion(String[] filas, ArrayStack camiones, int nivel) {
        if (camiones.size() != 0) {
            String[] tipoCamion = (String[]) camiones.peak();
            if (camionLleno(tipoCamion)) {
                camiones.pop();
                tipoCamion = (String[]) camiones.peak();

            }
            for (int i = 0; i < filas.length && tipoCamion != null; i++) {
                if (filas[i] == null) {
                    filas[i] = " ";
                    break;
                }
                if (tipoCamion[0].equals("1") && filas[i].equals("\033[32m" + "+" + "\033[0m")) {
                    tipoCamion[moverCamionP2(tipoCamion)] = filas[i];
                }

                switch (tipoCamion[0]) {
                    case "0":
                        if (filas[i].equals("\033[32m" + "+" + "\033[0m")) {
                            tipoCamion[moverCamionP2(tipoCamion)] = filas[i];
                            filas[i] = " ";
                        }
                        break;
                    case "1":
                        if (filas[i].equals("\033[31m" + "-" + "\033[0m")) {
                            tipoCamion[moverCamionP2(tipoCamion)] = filas[i];
                            filas[i] = " ";
                        }
                        break;
                    case "2":
                        if (filas[i].equals("\033[33m" + "/" + "\033[0m")) {
                            tipoCamion[moverCamionP2(tipoCamion)] = filas[i];
                            filas[i] = " ";
                        }
                        break;
                    case "3":
                        if (filas[i].equals("\033[34m" + ";" + "\033[0m")) {
                            tipoCamion[moverCamionP2(tipoCamion)] = filas[i];
                            filas[i] = " ";
                        }
                        break;
                }
                if (camionLleno(tipoCamion)) {
                    camiones.pop();
                    tipoCamion = (String[]) camiones.peak();
                    System.out.println("\033[32m" + "Camion Lleno, sale de la parada" + "\033[0m");
                    vaciar(tipoCamion);
                    break;
                }

                camiones.pop();
                if (tipoCamion != null) {
                    camiones.push(tipoCamion);
                }
            }
        }
    }

    public static boolean camionLleno(String[] camion) {
        int i = 0;
        while (i < camion.length) {
            if (camion[i].equalsIgnoreCase(" ")) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static int moverCamionP2(String[] camion) {
        int i = 0;
        while (i < camion.length && !camion[i].equalsIgnoreCase(" ")) {
            i++;
        }
        return i;
    }

    public static int moverPasajeroP2(String[] filas) {
        int i = 0;
        
        while (!filas[i].equalsIgnoreCase(" ")) {
            i++;
            if (i == filas.length) {
                return i = -1;
            }
        }
        return i;
    }

    public static String moverPasajero(ArrayList fila1, ArrayList fila2,ArrayList fila3 ,ArrayList fila4,String columna, ArrayStack camiones) {
        String respuesta = "";
        if(fila1.isEmpty()&&fila2.isEmpty()&&fila3.isEmpty()){
            respuesta=" ";
        }
        if (columna.equalsIgnoreCase("A")) {
            respuesta = (String) fila1.remove(fila1.size() - 1);
        } else if(columna.equalsIgnoreCase("B")) {
            respuesta = (String) fila2.remove(fila2.size() - 1);
        }else if(columna.equalsIgnoreCase("C")) {
            respuesta = (String) fila3.remove(fila3.size() - 1);
        }else if(columna.equalsIgnoreCase("D")) {
            respuesta = (String) fila4.remove(fila4.size() - 1);
        }
        return respuesta;
    }

    public static String leerOpcionLetra(Scanner scanner) {
        String letra = "";
        boolean validar = false;
        while (!validar) {
            System.out.println("Ingresa la columna del pasajero que desea que pase a la fila de abordar:"
                    + "\n(Si deaeas terminar el juego solo ingresa la letra F)");
            letra = (scanner.nextLine().trim().toUpperCase());
            if (letra.matches("[A-F]")) {
                validar = true;
            } else {
                System.out.println("\033[31m" + "Entrada no valida. Por favor, introduce una letra valida para una columna (A-E)" + "\033[0m\n");
            }
        }
        return letra;
    }

    public static int leerOpcionNumero(Scanner scanner) {
        int numero = 0;
        boolean validar = false;
        while (!validar) {
            System.out.println("Ingresa la fila del pasajero que desea que pase a la fila de abordar:");
            if (scanner.hasNextInt()) {
                numero = scanner.nextInt();
                if (numero >= 1 && numero <= 5) {
                    validar = true;
                } else {
                    System.out.println("\033[31m" + "Numero fuera de rango. Por favor, introduce un número entre 1 y 5" + "\033[0m\n");
                }
            } else {
                System.out.println("\033[31m" + "Entrada no válida. Por favor, introduce un número entero" + "\033[0m\n");
                scanner.next();
            }
        }

        return numero;
    }

    public static int espacios(String[] camion) {
        int contador = 0;
        for (String elemento : camion) {
            if (elemento != null && !elemento.equals(" ")) {
                contador++;
            }
        }
        return contador-1;
    }
    
    public static int mayor(int num1, int num2, int num3, int num4) {
        int mayor = num1; 
        if (num2 > mayor) {
            mayor = num2;
        }
        if (num3 > mayor) {
            mayor = num3;
        }
        if (num4 > mayor) {
            mayor = num4;
        }
        return mayor;
    }
}//

