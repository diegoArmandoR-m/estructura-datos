/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polinomioss;

/**
 *
 * @author diego
 */
public class MetodoGrafico {
    public static void metodo_grafico(double[] coeficientes, double x0, double xf) {
    double incremento = 0.001;
    double tolerancia = 0.0000001;
    int contador = 0;

    while (x0 <= xf) {
        // Evaluar el polinomio en el punto x0
        double valorFuncion = ValidarPolinomio.evaluar_polinomio(coeficientes, x0);

        // Condición de parada: si el valor de la función es exactamente 0, se encontró una raíz exacta
        if (Math.abs(valorFuncion) < tolerancia) {
            System.out.println("Posible raíz encontrada en x = " + x0);
            contador++;
        }

        // Incrementar x0 para la siguiente iteración
        x0 += incremento;
    }

    // Informar si no se encontró ninguna raíz en el intervalo dado
    if (contador == 0) {
        System.out.println("No se encontró ninguna raíz exacta en el intervalo dado.");
    }
  }
}
