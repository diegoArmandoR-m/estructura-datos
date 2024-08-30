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
            ValidarPolinomio validars = new ValidarPolinomio();
    public void raices_metodo_grafico(double[] coeficientes, double valorInicial, double valorFinal, double incremento, double error) {
        double x = valorInicial;
        while (x <= valorFinal) {
            double valorFuncion = validars.evaluar_polinomio(coeficientes, x);
            
            if (Math.abs(valorFuncion) <= error) {
                System.out.println("Raíz encontrada en x = " + x);
            }
            
            x += incremento;
        }
    }
}
