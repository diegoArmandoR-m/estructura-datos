/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polinomioss;

/**
 *
 * @author diego
 */
public class Constantes {
    private static final String Menu="Ingresa el número de la acción que deseas realizar(Solo numero enteros del 1 al 5):"
			+ "\n1 - Buscar raices por el Metodo de Gráfico"	
			+ "\n2 - Buscar raices por el Metodo de Bisección"
			+ "\n3 - Buscar raices por el Metodo de la Secante"
                        + "\n4 - Buscar raices por el Metodo de Newton-Rapson"
			+ "\n5 - Cambiar polinomio"
			+ "\n6 - Fin del Programa";
    
    private static final String InGrado="Ingersa el grado de la ecuacion"
            +"\n(Solo numeros enteros)";
    
    private static final String InCoePolinomio="Ingersa uno por uno los coeficientes del polinomio"
            + "(De mayor a menor grado)";
    
    private static final String Invalido="El dato ingresado es invalido";
    
    private static final String XInicial="Ingresa el inicio del intervalo";
    
    private static final String XFinal="Ingresa el final del intervalo";
    
    private static final String Incremento="Ingresa el incremento";
    
    public static String getIncremento() {
		return Incremento;
	}
    public static String getXFinal() {
		return XFinal;
	}
    public static String getXInicial() {
		return XInicial;
	}
    public static String getInGrado() {
		return InGrado;
	}
    
    public static String getInvalido() {
		return Invalido;
	}
    
    public static String getInCoePolinomio() {
		return InCoePolinomio;
	}
    public static String getMenu() {
		return Menu;
	}
}//
