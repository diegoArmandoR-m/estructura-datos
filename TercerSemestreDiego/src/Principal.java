/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author diego
 */
//import edu.udelp.estructura.ordenamientos.*;

import java.util.Scanner;
import edu.udelp.estructura.stack.*;
import edu.udelp.estructura.polaca.*;
import java.util.Stack;

public class Principal {
    public static void main(String[] args){
      
      Polaca polaca = new Polaca();
      Scanner leer = new Scanner(System.in);
      String ecuacion = null;
      String caracter = null;
      boolean vacio = true;
      System.out.println("Ingresa tu ecuacion");
      //ecuacion = leer.nextLine();
      ecuacion="(3+4)*2-(4+3)";
      System.out.println(ecuacion);
      if(validarparentesis(ecuacion)==true){
          polaca.resolverEcuacion(ecuacion);
      }
      
      leer.close();
    }//
    
    public static boolean validarparentesis(String ecuacion){
            boolean respuesta=false;
            boolean vacio=true;
            String caracter=null;
            ArrayStack pila = new ArrayStack(ecuacion.length());
            for(int i=0;i<ecuacion.length();i++){
                caracter=ecuacion.substring(i, i+1);
            if(caracter.equals(")")&&pila.isEmpty()){
                vacio = false;
                break;
            }
            if(caracter.equals("(")){
                pila.push(caracter);
            }else if (caracter.equals(")")){
                pila.pop();
            }
        }
        if(pila.isEmpty()&&vacio){
            respuesta=true;
        }
              return respuesta;
      }
    
    public static double resolverEcuacion(String ecuacion){
        double respuesta=0.0;
        String caracter=null;
        String operacion="";
        ArrayStack pila = new ArrayStack(ecuacion.length());
        for(int i=0;i<ecuacion.length();i++){
                caracter=ecuacion.substring(i, i+1);
                //((3+5)-(6+8))
            if(caracter.equals(")")==true){
                operacion="";
                do{
                    operacion=pila.pop()+operacion;
                }while(!pila.peak().equals("("));
                pila.pop();
                //System.out.println(operacion+" Operacion");
                //System.out.println(evaluar(operacion));
                operacion= Double.toString(evaluar(operacion));
                pila.push(operacion);
                
                
            }else{
                pila.push(caracter);
                //System.out.println(caracter);
            }
            
        }
        //System.out.println(operacion);
        return respuesta;
    }
    
    public static double evaluar(String expresion) {
        // Primero, eliminar los espacios
        expresion = expresion.replaceAll("\\s+", "");

        // Evaluar la expresión
        return eval(expresion);
    }

    private static double eval(String expresion) {
        // Pilas para números y operadores
        Stack<Double> numeros = new Stack<>();
        Stack<Character> operadores = new Stack<>();

        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);

            // Si el carácter es un número decimal, procesarlo
            if (Character.isDigit(c) || c == '.') {
                StringBuilder sb = new StringBuilder();
                while (i < expresion.length() && (Character.isDigit(expresion.charAt(i)) || expresion.charAt(i) == '.')) {
                    sb.append(expresion.charAt(i++));
                }
                i--; // Decrementar i para el próximo carácter
                numeros.push(Double.parseDouble(sb.toString()));
            }
            // Si el carácter es un operador
            else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!operadores.isEmpty() && tienePrioridad(c, operadores.peek())) {
                    numeros.push(operar(numeros.pop(), numeros.pop(), operadores.pop()));
                }
                operadores.push(c);
            }
            // Si el carácter es un paréntesis
            else if (c == '(') {
                operadores.push(c);
            }
            else if (c == ')') {
                while (operadores.peek() != '(') {
                    numeros.push(operar(numeros.pop(), numeros.pop(), operadores.pop()));
                }
                operadores.pop(); // Eliminar '('
            }
        }

        // Aplicar los operadores restantes
        while (!operadores.isEmpty()) {
            numeros.push(operar(numeros.pop(), numeros.pop(), operadores.pop()));
        }

        return numeros.pop();
    }

    private static boolean tienePrioridad(char operador1, char operador2) {
        if (operador2 == '(' || operador2 == ')') {
            return false;
        }
        if ((operador1 == '*' || operador1 == '/') && (operador2 == '+' || operador2 == '-')) {
            return false;
        }
        return true;
    }

    private static double operar(double a, double b, char operador) {
        switch (operador) {
            case '+':
                return b + a;
            case '-':
                return b - a;
            case '*':
                return b * a;
            case '/':
                return b / a;
        }
        throw new UnsupportedOperationException("Operador no soportado: " + operador);
    }
}//
