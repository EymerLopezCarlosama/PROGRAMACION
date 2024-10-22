package VECTORES;

import javax.swing.*;

/* Realizar un programa que muestre la siguiente estructura, haciendo uso del for
*
**
***
****
*****
 */

public class EJERCICIO4 {

    public static void main(String[] args) {
        
        try {
            int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de filas"));
            StringBuilder result = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    result.append("*");
                }
                result.append("\n"); // Salto de línea después de cada fila
            }
            JOptionPane.showMessageDialog(null, result.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR! INGRESE UN DATO VALIDO");
        }

    }

}
