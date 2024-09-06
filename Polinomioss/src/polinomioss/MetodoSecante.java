/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polinomioss;

/**
 *
 * @author diego
 */
public class MetodoSecante {
    public static double metodo_secantes(double[] coeficientes, double x0, double xf) {
    final double TOLERANCIA = 0.0000001; // Definir la tolerancia

    // Evaluar el polinomio en los puntos x0 y xf
    double fx0 = ValidarPolinomio.evaluar_polinomio(coeficientes, x0);
    double fx1 = ValidarPolinomio.evaluar_polinomio(coeficientes, xf);

    // Verificar si alguna de las evaluaciones ya es suficientemente cercana a cero
    if (Math.abs(fx0) < TOLERANCIA) {
        return x0;
    } else if (Math.abs(fx1) < TOLERANCIA) {
        return xf;
    }

    // Calcular el nuevo punto usando la fórmula de la secante
    double x2 = xf - (fx1 * (xf - x0)) / (fx1 - fx0);
    //System.out.println("x0: " + x0 + " x2: " + x2);

    // Evaluar el polinomio en el nuevo punto x2
    double fx2 = ValidarPolinomio.evaluar_polinomio(coeficientes, x2);

    // Mostrar el resultado actual
    //System.out.println("x0 = " + x0 + ", xf = " + xf + ", x2 = " + x2 + ", f(x2) = " + fx2);
    //System.out.println("fx0 = " + fx0 + ", fx1 = " + fx1);

    // Verificar si el valor absoluto de f(x2) es menor que la tolerancia
    if (Math.abs(fx2) < TOLERANCIA) {
        System.out.println("Posible raíz encontrada. "+x2);
        return x2;
    }

    // Ajustar el intervalo según el signo de f(x2)
    if (fx0 * fx2 < 0) {
        xf = x2;
    } else if (fx1 * fx2 < 0) {
        x0 = x2;
    } else {
        // Si f(x0) y f(x2) tienen el mismo signo, podemos tomar otro punto para evitar ciclos infinitos
        //System.out.println("El nuevo punto x2 no reduce el intervalo. Se necesita un nuevo intervalo.");
        return Double.NaN; // Indicamos que no se encontró una raíz válida en esta iteración
    }

    // Ajustar intervalos para la siguiente iteración
    return metodo_secantes(coeficientes, x0, xf);
}
}//

