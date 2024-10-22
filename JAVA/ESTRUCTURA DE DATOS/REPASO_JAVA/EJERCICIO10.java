package REPASO_JAVA;

/* Diseñar un algoritmo que imprima la siguiente figura a través de asteriscos
 
    *
   ***
  *****
 *******
********* 

*/

import javax.swing.*;

public class EJERCICIO10 {

    public static void main(String[] args) {
        int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de filas"));

        StringBuilder figura = new StringBuilder(); // Usamos StringBuilder para construir la figura

        for (int i = 1; i <= n; i++) {
            
            for (int j = 1; j <= n - i; j++) {
                figura.append(" ");
            }
            
            for (int k = 1; k <= 2 * i - 1; k++) {
                figura.append("*");
            }
            
            figura.append("\n");
        }

        // Mostrar la figura en una ventana emergente
        JOptionPane.showMessageDialog(null, figura.toString(), "Piramide de Asteriscos", JOptionPane.INFORMATION_MESSAGE);
    }
}

