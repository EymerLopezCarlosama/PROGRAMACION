package REPASO_JAVA;

//Dado un número entero que se introduce por teclado, determinar si es negativo o superior a 100.

import javax.swing.*;

public class EJERCICIO2 {
    
    public static void main(String[] args) {

        try {
           
            String numero = JOptionPane.showInputDialog("Introduce un número entero:");
            int number = Integer.parseInt(numero);

            if (number < 0 ) {
                JOptionPane.showMessageDialog( null, "El número " + number + " es negativo.");
            } else if(number >0 && number <=100){
                JOptionPane.showMessageDialog(null, "El número " + number + " se encuentra en el intervalo [0,100]");
            }
            else {
                JOptionPane.showMessageDialog(null, "El número " + number + " es mayor que 100.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, introduce un número entero válido.");
        }

    }

}
