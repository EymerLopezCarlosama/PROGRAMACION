package VECTORES;

/* Solicitar al ususario el tamaño de un vector de String, 
 * luego solicitar al usuario que ingrese los elementos del vector.
 * Finalmente mostar el vector ingresado con sus respectivos valores y mostar valoresa anidados
 */

import javax.swing.*;

public class EJEMPLO2 {

    public static void main(String[] args) {

        String cantidad = JOptionPane.showInputDialog(null, "Ingrese el tamaño del vector");
        int cantidad_int = Integer.parseInt(cantidad);
        String[] vector = new String[cantidad_int];
        for (int i = 0; i < cantidad_int; i++) {
            vector[i] = JOptionPane.showInputDialog(null, "Ingrese el elemento " + (i + 1));
        }
        String tabla = "";
        for (int i = 0; i < cantidad_int; i++) {
            tabla += "Elemento " + (i + 1) + ": " + vector[i] + "\n";
        }
        JOptionPane.showMessageDialog(null, tabla, "Vector ingresado", JOptionPane.INFORMATION_MESSAGE);

    }

}
