package REPASO_JAVA;

/*Dado un número que se introduce por teclado, si es positivo verificar si se encuentra en el intervalo abierto 60 – 90,
 de lo contrario emitir un mensaje de error.*/

import javax.swing.*;

public class EJERCICIO7 {

    public static void main(String[] args) {
        String numero = JOptionPane.showInputDialog("Introduce un número entero:");
        try {
            
            int number = Integer.parseInt(numero);
            if (number > 0) {
                if (number > 60 && number < 90) {
                    JOptionPane.showMessageDialog(null, "El número " + number + " se encuentra en el intervalo abierto (60, 90).");
                } else {
                    JOptionPane.showMessageDialog(null, "El número " + number + " no se encuentra en el intervalo abierto (60, 90).");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El número " + number + " no es positivo.");
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "ERROR: Por favor, introduzca un valor valido");

        }
    }

}
