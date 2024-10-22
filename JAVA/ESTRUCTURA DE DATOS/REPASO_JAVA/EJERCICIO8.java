package REPASO_JAVA;

/* Una fuente de datos registra varias edades, la edad 0 indica el final del ingreso de datos,
realice un programa para determinar el promedio de las edades ingresadas y además el
porcentaje de personas mayores a los 50 años. */

import javax.swing.*;

public class EJERCICIO8 {

    public static void main(String[] args) {

        int sumaEdades = 0;
        int contadorEdades = 0;
        int contadorMayores50 = 0;

        while (true) {

            try {
                String edad = JOptionPane.showInputDialog("Introduce una edad (0 para finalizar):");
                int edadInt = Integer.parseInt(edad);

                if (edadInt == 0) {
                    break;
                }

                if (edadInt > 0) {
                    sumaEdades += edadInt;
                    contadorEdades++;

                    if (edadInt > 50) {
                        contadorMayores50++;
                        
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Por favor, introduce una edad válida.");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR: Por favor, introduzca un valor valido");

            }
                        
        }

        if (contadorEdades > 0) {
            double promedio = (double) sumaEdades / contadorEdades;
            double porcentajeMayores50 = (double) contadorMayores50 / contadorEdades * 100;

            JOptionPane.showMessageDialog(null, "Promedio de edades: " + promedio + "\nPorcentaje de personas mayores a 50 años: " + porcentajeMayores50 + "%");
        } else {
            JOptionPane.showMessageDialog(null, "No se ingresaron edades válidas.");
            
        }
        
    }

}
