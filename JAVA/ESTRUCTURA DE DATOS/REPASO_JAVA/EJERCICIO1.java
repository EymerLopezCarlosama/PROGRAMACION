package REPASO_JAVA;

//Dado un número entero que se introduce por teclado, determinar si se encuentra en el intervalo cerrado [51 - 100]

import javax.swing.*;

public class EJERCICIO1 {

    public static void main(String[] args) {
        
        String numero = JOptionPane.showInputDialog("Introduce un número entero:");

        try {
            
            int number = Integer.parseInt(numero);

            if (number >= 51 && number <= 100) {
                JOptionPane.showMessageDialog( null, "El número " + number + " se encuentra en el intervalo cerrado [51, 100].");
            } else {
                JOptionPane.showMessageDialog(null, "El número " + number + " no se encuentra en el intervalo cerrado [51, 100].");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, introduce un número entero válido.");
        }
    }

}
