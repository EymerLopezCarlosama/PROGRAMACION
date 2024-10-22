package REPASO_JAVA;

//Pide un número (que debe estar entre 0 y 10) y mostrar la tabla de multiplicar de dicho número.

import javax.swing.*;

public class EJERCICIO5 {
    public static void main(String[] args) {
        try {
            int numero;

            do {
                String num = JOptionPane.showInputDialog(null, "Introduce un número entre 0 y 10:");
                numero = Integer.parseInt(num);

                if (numero < 0 || numero > 10) {
                    JOptionPane.showMessageDialog(null, "Número no válido. Debe estar entre 0 y 10.");
                }
            } while (numero < 0 || numero > 10);

            StringBuilder tabla = new StringBuilder();
            tabla.append("Tabla de multiplicar del ").append(numero).append(":\n");
            for (int i = 1; i <= 10; i++) {
                tabla.append(numero).append(" x ").append(i).append(" = ").append(numero * i).append("\n");
            }

            JOptionPane.showMessageDialog(null, tabla.toString());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, introduce un número entero válido.");
        }
    }
}

