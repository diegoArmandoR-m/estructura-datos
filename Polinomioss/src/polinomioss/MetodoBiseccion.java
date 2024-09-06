/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polinomioss;

/**
 *
 * @author diego
 */
public class MetodoBiseccion {
    
    public static void encontrarVariasRaices(double[] coeficientes, double x0, double x1, int maxIteraciones) {
        double intervaloMinimo = 0.1; // Separación mínima entre posibles raíces
        double paso = 0.5; // Paso para dividir el intervalo en subintervalos más pequeños

        for (int i = 0; i < maxIteraciones; i++) {
            double nuevoX0 = x0 + i * paso;
            double nuevoX1 = nuevoX0 + paso;
            
            // Asegurar que no se salga del rango original
            if (nuevoX1 > x1) {
                break;
            }
            
            // Buscar una raíz en el subintervalo [nuevoX0, nuevoX1]
            double raiz = biseccionUnaVez(coeficientes, nuevoX0, nuevoX1);

            // Si la raíz encontrada es válida y no está cerca de una raíz existente
            if (!Double.isNaN(raiz)) {
                //System.out.println("Raíz encontrada en el intervalo (" + nuevoX0 + ", " + nuevoX1 + "): " + raiz);
            }
        }
    }

    public static double biseccionUnaVez(double[] coeficientes, double x0, double x1) {
        double tolerancia = 0.0000001;
        
        double fx0 = ValidarPolinomio.evaluar_polinomio(coeficientes, x0);
        double fx1 = ValidarPolinomio.evaluar_polinomio(coeficientes, x1);
        
        // Verificar si ya tenemos una raíz aproximada en los extremos
        if (Math.abs(fx0) < tolerancia) {
            System.out.println("Raíz encontrada en x = " + x0);
            return x0;
        }
        if (Math.abs(fx1) < tolerancia) {
            System.out.println("Raíz encontrada en x = " + x1);
            return x1;
        }
        
        // Calcular el punto medio
        double medio = (x0 + x1) / 2;
        double fmedio = ValidarPolinomio.evaluar_polinomio(coeficientes, medio);
        
        // Mostrar el resultado actual
        //System.out.println("x0 = " + x0 + ", x1 = " + x1 + ", medio = " + medio + ", f(medio) = " + fmedio);
        //System.out.println("fx0 = " + fx0 + ", fx1 = " + fx1);
        
        // Verificar si el punto medio es una raíz exacta o una aproximación suficientemente buena
        if (Math.abs(fmedio) < tolerancia) { // Tolerancia para raíz aproximada
           System.out.println("Raíz encontrada en x = " + medio);
            return medio;
        }

        // Ajustar el intervalo según el signo de f(medio)
        if (fx0 * fmedio < 0) {
            // Cambiar intervalo: x1 = medio
            return biseccionUnaVez(coeficientes, x0, medio);
        } else if (fx1 * fmedio < 0) {
            // Cambiar intervalo: x0 = medio
            return biseccionUnaVez(coeficientes, medio, x1);
        }

        // Si no se cumple ninguna condición (debería ser raro), devolver NaN o un valor de error
        return Double.NaN;
    }

}
