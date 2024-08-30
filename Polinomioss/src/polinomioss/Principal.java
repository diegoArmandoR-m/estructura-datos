/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package polinomioss;

/**
 *
 * @author diego
 */
    import java.util.Scanner;
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leer = new Scanner(System.in);
        String opcionMenu = null;
        System.out.println("Ingersa el polinomio");
        
        System.out.println("Ingersa la opcion que deseas realizar");
        opcionMenu= leer.nextLine();
        switch(opcionMenu){
            case "1":
                System.out.println("");
            case "2":
                
            case "3":
                System.out.println("Fin del programa");
            case "4":
                System.out.println("Fin del programa");
        }
    }
    
}
