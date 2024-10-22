package VECTORES;

import javax.swing.*;

// Pedir números por pantalla hasta que alguno sea mayor a 500.

public class EJERCICIO1 {

    public static void main(String[] args) {
        
        try {
            
        int num;
        do {
            num = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número: "));
        } while (num < 500);

        JOptionPane.showMessageDialog(null,"El número " + num + " es mayor que 500.");

        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"ERROR! INGRESE UN DATO VALIDO");
    }

    }

}
