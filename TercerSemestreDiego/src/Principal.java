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
public class Principal {
    public static void main(String[] args){

      Scanner leer = new Scanner(System.in);
      String ecuacion = null;
      String caracter = null;
      boolean vacio = true;
      System.out.println("Ingersa tu ecuacion");
      ecuacion = leer.nextLine();
      
      validarparentesis(ecuacion);
      
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
    
    
}//
