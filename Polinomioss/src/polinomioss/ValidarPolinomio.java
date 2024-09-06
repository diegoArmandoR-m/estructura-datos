/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polinomioss;

/**
 *
 * @author diego
 */
public class ValidarPolinomio {
        public static double evaluar_polinomio(double[] coeficientes, double x) {
        double resultado = 0.0;
        for (int i = 0; i < coeficientes.length; i++) {
            resultado += coeficientes[i] * Math.pow(x, (coeficientes.length) - 1 - i);
        }
        return resultado;
    }
        public static boolean esNumero(String cadena) {
        if (cadena == null || cadena.isEmpty()) {
            return false; // Si la cadena es nula o vacía, no es un número
        }
        // Regex para números enteros y decimales (positivos o negativos)
        String regex = "-?\\d+(\\.\\d+)?";
        return cadena.matches(regex); // Verifica si la cadena coincide con el patrón
    }
        
      public static boolean esNumeroEntero(String cadena) {
        if (cadena == null || cadena.isEmpty()) {
            return false; // Si la cadena es nula o vacía, no es un número entero
        }

        try {
            Integer.parseInt(cadena); // Intenta convertir la cadena a un entero
            return true; // Si la conversión es exitosa, es un número entero
        } catch (NumberFormatException e) {
            return false; // Si ocurre una excepción, no es un número entero
        }
      }
       public static double[] derivarPolinomio(double[] coeficientes) {
        // El grado del polinomio es la longitud del arreglo de coeficientes menos 1
        int grado = coeficientes.length - 1;
        
        // Si el polinomio es constante, su derivada es cero
        if (grado == 0) {
            return new double[]{0.0};
        }
        double[] derivada = new double[grado];

        // Calcular los coeficientes de la derivada
        for (int i = 1; i <= grado; i++) {
            derivada[i - 1] = coeficientes[i] * i;
        }

        return derivada;
    }
}
