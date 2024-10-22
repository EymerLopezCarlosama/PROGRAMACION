package REPASO_JAVA;

//Pedir un número entre 0 y 9.999 y decir cuántas cifras tiene.

import javax.swing.*;

public class EJERCICIO4 {

    public static void main(String[] args) {
        try {
            String numero = JOptionPane.showInputDialog("Introduce un numero en el rango de 0 a 9999:");
            int num = Integer.parseInt(numero);

            if (num >= 0 && num <= 9999) {
                int cifras = String.valueOf(num).length();
                JOptionPane.showMessageDialog(null, "El número " + num + " tiene " + cifras + " cifras.");
            } else {
                JOptionPane.showMessageDialog(null, "El número debe estar en el rango de 0 a 9999.");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Por favor, introduce solo números enteros válidos.");
        }
    }

}
