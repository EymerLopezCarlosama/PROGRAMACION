package REPASO_JAVA;

//Realizar un programa que nos pida un número n, y nos diga cuantos números hay entre 1 y n que son primos.

import javax.swing.*;

public class EJERCICIO6 {

    public static void main(String[] args) {

        try {
            int n = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número: "));
            int contador = 0;

            if (n<1) {
                JOptionPane.showMessageDialog(null, "El número debe ser mayor o igual a 1.");
            }

            for (int i = 1; i <= n; i++) {
                if (esPrimo(i)) {
                    contador++;
                }
            }
            JOptionPane.showMessageDialog(null, "Hay " + contador + " números primos entre 1 y " + n + ".");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error: Por favor, ingresa un número entero válido.");
        }
    }

        public static boolean esPrimo(int numero) {
            if (numero <= 1) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(numero); i++) {
                if (numero % i == 0) {
                    return false;
                }
            }
            return true;
        }


}
