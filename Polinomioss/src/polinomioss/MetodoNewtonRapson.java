/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polinomioss;

/**
 *
 * @author diego
 */
public class MetodoNewtonRapson {
     
    public static double metodoNewtonRaphson(double[] coeficientes, double x0) {
    final double TOLERANCIA = 0.0000001; // Tolerancia para la convergencia
    final int MAX_ITERACIONES = 1000;    // Número máximo de iteraciones para evitar ciclos infinitos

    double x = x0;
    int iteracion = 0;

    while (iteracion < MAX_ITERACIONES) {
        // Evaluar el polinomio y su derivada en x
        double fx = ValidarPolinomio.evaluar_polinomio(coeficientes, x);
        double[] derivadaCoef = ValidarPolinomio.derivarPolinomio(coeficientes);
        double dfx = ValidarPolinomio.evaluar_polinomio(derivadaCoef, x);

        // Verificar si la derivada es demasiado pequeña
        if (Math.abs(dfx) < TOLERANCIA) {
            //System.out.println("La derivada es muy pequeña, el método puede no converger.");
            return Double.NaN; // No se puede continuar, retorno NaN
        }

        // Aplicar la fórmula de Newton-Raphson: x1 = x - f(x)/f'(x)
        double x1 = x - fx / dfx;

        // Mostrar el resultado actual
       // System.out.println("Iteración " + iteracion + ": x = " + x1 + ", f(x) = " + fx);

        // Verificar si la solución es lo suficientemente buena
        if (Math.abs(fx) < TOLERANCIA) {
            System.out.println("Raíz aproximada encontrada: x = " + x1);
            return x1;  // Retornar la raíz aproximada
        }
        x = x1;
        iteracion++;
    }
  
    return x;
  }
}//
