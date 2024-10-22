package VECTORES;

import javax.swing.*;

/* Listar números desde el 100 hasta el 0, pero teniendo como restricción que solo se
imprimirá de 25 en 25. Resultado: 100 – 75 – 50 - 25 */

public class EJERCICIO5 {

    public static void main(String[] args) {

        try {
            StringBuilder result = new StringBuilder();
            for (int i = 100; i >= 0; i -= 25) {
                result.append(i);
                if (i > 0) {
                    result.append(" - ");
                }
            }
            JOptionPane.showMessageDialog(null, result.toString());        
        } catch (Exception e) {
            System.out.println("ERROR! INGRESE UN DATO VALIDO");
        }
    }

}
