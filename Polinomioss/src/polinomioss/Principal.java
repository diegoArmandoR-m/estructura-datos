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
        String tamanoArreglo = null;
        String coeficiente= null;
        String x0=null;
        String x1=null;
        String incremento= null;
        //double[] coeficientes;
        
        //coeficientes=ecuacion();
        do{
            do{
                System.out.println(Constantes.getInGrado());
                tamanoArreglo=leer.nextLine();
            }while(ValidarPolinomio.esNumeroEntero(tamanoArreglo)==false);
            double[] coeficientes= new double[Integer.parseInt(tamanoArreglo)+1];
            System.out.println(Constantes.getInCoePolinomio());
            for(int i=0;i<coeficientes.length;i++){
                do{
                    coeficiente=leer.nextLine();
                    if(ValidarPolinomio.esNumero(coeficiente)==false){System.out.println(Constantes.getInvalido()); }
                }while(ValidarPolinomio.esNumero(coeficiente)==false);
                coeficientes[i]=Double.parseDouble(coeficiente);
                System.out.println("Siguiente coeficiente");
            }
            //coeficientes=ecuacion();
            System.out.println(Constantes.getMenu());
            opcionMenu= leer.nextLine();
            
            switch(opcionMenu){
            case "1":
                //Método Gráfico
                do{
                    System.out.println(Constantes.getXInicial());
                    x0=leer.nextLine();
                    if(ValidarPolinomio.esNumero(x0)==false){System.out.println(Constantes.getInvalido()); }
                }while(ValidarPolinomio.esNumero(x0)==false);
                do{
                    System.out.println(Constantes.getXFinal());
                    x1=leer.nextLine();
                    if(ValidarPolinomio.esNumero(x0)==false){System.out.println(Constantes.getInvalido()); }
                }while(ValidarPolinomio.esNumero(x1)==false);
                MetodoGrafico.metodo_grafico(coeficientes,Double.parseDouble(x0),Double.parseDouble(x1));
                break;
            case "2":
                //Método Bisección
                do{
                    System.out.println(Constantes.getXInicial());
                    x0=leer.nextLine();
                    if(ValidarPolinomio.esNumero(x0)==false){System.out.println(Constantes.getInvalido()); }
                }while(ValidarPolinomio.esNumero(x0)==false);
                do{
                    System.out.println(Constantes.getXFinal());
                    x1=leer.nextLine();
                    if(ValidarPolinomio.esNumero(x0)==false){System.out.println(Constantes.getInvalido()); }
                }while(ValidarPolinomio.esNumero(x1)==false);
                MetodoBiseccion.encontrarVariasRaices(coeficientes, Double.parseDouble(x0), Double.parseDouble(x1),20);
                break;
            case "3":
                //Método de la Secante
                do{
                    System.out.println(Constantes.getXInicial());
                    x0=leer.nextLine();
                    if(ValidarPolinomio.esNumero(x0)==false){System.out.println(Constantes.getInvalido()); }
                }while(ValidarPolinomio.esNumero(x0)==false);
                do{
                    System.out.println(Constantes.getXFinal());
                    x1=leer.nextLine();
                    if(ValidarPolinomio.esNumero(x0)==false){System.out.println(Constantes.getInvalido()); }
                }while(ValidarPolinomio.esNumero(x1)==false);
                MetodoSecante.metodo_secantes(coeficientes,Double.parseDouble(x0), Double.parseDouble(x1));
                break;
            case "4":
                //Método Newton 
                do{
                    System.out.println(Constantes.getXInicial());
                    x0=leer.nextLine();
                    if(ValidarPolinomio.esNumero(x0)==false){System.out.println(Constantes.getInvalido()); }
                }while(ValidarPolinomio.esNumero(x0)==false);
                MetodoNewtonRapson.metodoNewtonRaphson(coeficientes,Double.parseDouble(x0));
                
               
                break;
            case "5":
                coeficientes=ecuacion();
                break;
            case "6":
                System.out.println("Fin del programa");
                break;
            default:
                System.out.println(Constantes.getInvalido());
                break;
        }
        }while(!opcionMenu.equals("6"));
        leer.close();
    }//
    
    public static double[] ecuacion(){
        Scanner leer = new Scanner(System.in);
        String tamanoArreglo = null;
        String coeficiente= null;
        double[] arreglo=null;
        do{
                System.out.println(Constantes.getInGrado());
                tamanoArreglo=leer.nextLine();
            }while(ValidarPolinomio.esNumeroEntero(tamanoArreglo)==false);
            double[] coeficientes= new double[Integer.parseInt(tamanoArreglo)+1];
            System.out.println(Constantes.getInCoePolinomio());
            for(int i=0;i<coeficientes.length;i++){
                do{
                    coeficiente=leer.nextLine();
                    if(ValidarPolinomio.esNumero(coeficiente)==false){System.out.println(Constantes.getInvalido()); }
                }while(ValidarPolinomio.esNumero(coeficiente)==false);
                coeficientes[i]=Double.parseDouble(coeficiente);
                System.out.println("Siguiente coeficiente");
            }
        
        
        return arreglo;
    }
    
}//
