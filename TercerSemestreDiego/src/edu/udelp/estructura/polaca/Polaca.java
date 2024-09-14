/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udelp.estructura.polaca;


import edu.udelp.estructura.stack.ArrayStack;

/**
 *
 * @author diego
 */
public class Polaca {
    public double resolverEcuacion(String ecuacion){
        double respuesta=0.0;
        String caracter=null;
        String posfija="";
        String num =null;
        ArrayStack pila1 = new ArrayStack(ecuacion.length());
        ArrayStack pilacoe = new ArrayStack(ecuacion.length());
        ArrayStack pilaope = new ArrayStack(ecuacion.length());
        ArrayStack pila4 = new ArrayStack(ecuacion.length());
        for(int i=0;i<ecuacion.length();i++){
                caracter=ecuacion.substring(i, i+1);
            if(caracter.equals(")")){
                while(!pila1.isEmpty()&&!pila1.peak().equals("(")){
                    if(validaNum(pila1.peak().toString())){
                        pilacoe.push(pila1.pop());
                    }if (validaOpe(pila1.peak())){
                        pilaope.push(pila1.pop());
                    }
                }
                pila1.pop();
                while(!pilacoe.isEmpty()){
                    pila1.push(pilacoe.pop());
                }
               while(!pilaope.isEmpty()){
                    pila1.push(pilaope.pop());
                }
            }else{
                if (validaNum(caracter)) {
                    pila1.push(caracter);
                }else if (validaOpe(caracter)) {
                    while (!pilaope.isEmpty() && !operadores(caracter, pilaope.peak().toString())) {
                        pila1.push(pilaope.pop());
                    }
                    pilaope.push(caracter);
                }else if (caracter.equals("(")) {
                    pila1.push(caracter);
                }   
            }
        }
        while(!pilaope.isEmpty()){
            pila1.push(pilaope.pop());
        }
        System.out.println(pila1.toString());
        ecuacion=pila1.toString();
        for(int i=0;i<ecuacion.length();i++){
            caracter=ecuacion.substring(i, i+1);
            if(!validaOpe(caracter)){
                pilacoe.push(caracter);
            }else{
                String valor2 = pilacoe.pop().toString(); // Convertir a cadena si es necesario
                int b = Integer.parseInt(valor2);
                String valor = pilacoe.pop().toString(); // Convertir a cadena si es necesario
                int a = Integer.parseInt(valor);
                switch(caracter){
                  case"+":
                      pilacoe.push(a+b);
                      break;
                  case"-":
                      pilacoe.push(a-b);
                      break;
                  case"*":
                      pilacoe.push(a*b);
                      break;
                  case"/":
                      pilacoe.push(a/b);
                      break;
                }
            }
        }
        System.out.println(pilacoe.toString());
        
        return respuesta;
    }
    
    public static boolean validaNum(String numero) {
        boolean respuesta = false;
        String permitidos = "-?\\d+(\\.\\d+)?";
        if (numero.matches(permitidos)) {
                respuesta = true;
        }
        return respuesta;
    }
    public static boolean validaOpe(Object operador) {
    boolean respuesta = false;
        String operadores = operador.toString();
    if (operadores.equals("+") || operadores.equals("-") || 
        operadores.equals("*") || operadores.equals("/")) {
        respuesta = true;
    }
    return respuesta;
    }
    
    public static boolean operadores(String operador, String operadorAl){
        boolean respuesta =true;
        int valor=0;
        int valor2=0;
        valor = (operador.equals("+") || operador.equals("-")) ? 1 : 2;
        valor2 = (operadorAl.equals("+") || operadorAl.equals("-")) ? 1 : 2;
        if(valor<valor2){
            respuesta=false;
        }
        return respuesta;
    }
    
}//
