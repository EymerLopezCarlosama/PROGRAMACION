package VECTORES;

import javax.swing.*;

/* DEFINIR UN VECTOR CON LOS NUMEROS 3,5,11,13 y invertirlos e imprimirlo mediante ventanas emergentes*/

public class EJEMPLO4_1 {

    public static void main(String[] args) {
        
        int[] vector = {3,5,11,13};

        for (int i = 0; i < vector.length/2; i++) {
            int temp = vector[i];
            vector[i] = vector[vector.length - i - 1];
            vector[vector.length - i - 1] = temp;
        }

        // Crear un StringBuilder para construir el mensaje de salida
        StringBuilder result = new StringBuilder("Vector invertido: ");
        
        // Iterar sobre cada elemento del vector
        for (int i = 0; i < vector.length; i++) {
            // Añadir el elemento actual al StringBuilder
            result.append(vector[i]);
            
            // Si no es el último elemento, añadir una coma y un espacio
            if (i < vector.length - 1) {
                result.append(", ");
            }
        }
        JOptionPane.showMessageDialog(null, result.toString());

    }

}
