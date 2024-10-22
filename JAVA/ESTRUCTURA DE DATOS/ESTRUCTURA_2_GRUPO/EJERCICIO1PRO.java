package ESTRUCTURA_2_GRUPO;
/* REALIZE UN PROGRAMA QUE PERMITA GUARDAR 5 NOTAS Y QUE A TRAVEZ DE UN MENU PERMITA:
 * REGISTAR LAS NOTAS
 * MOSTRAR LAS NOTAS
 * OBTENER EL PROMEDIO DE LAS NOTAS
 * IMPRIMIR LAS NOTAS MAYORES A 3
  */

import javax.swing.*;

public class EJERCICIO1PRO {

    public static void main(String[] args) {

        float notas[] = new float[5];
        float suma = 0;
        float promedio = 0;
        
        boolean salir = false;
        
        while (!salir) {
            String menu = JOptionPane.showInputDialog("Por favor seleccione una opcion:\n 1.Ingresar notas\n 2.Mostrar notas\n 3.Obtener promedio\n 4.Imprimir notas mayores a 3\n 5.Salir");
            int opcion = Integer.parseInt(menu);
            switch (opcion) {
                case 1:
                    for (int i = 0; i < notas.length; i++) {
                        notas[i] = Float.parseFloat(JOptionPane.showInputDialog("Ingrese la nota " + (i + 1) + ": "));
                    }                
                    break;
                case 2:
                    for (int i = 0; i < notas.length; i++) {
                        JOptionPane.showMessageDialog(null, "La nota " + (i + 1) + " es: " + notas[i]);
                    }
                    break;
                case 3:
                    suma = 0;
                    for (int i = 0; i < notas.length; i++) {
                        suma = suma + notas[i];
                    }
                    promedio = suma / notas.length;
                    JOptionPane.showMessageDialog(null, "El promedio es: " + promedio);
                    break;
                case 4:
                    for (int i = 0; i < notas.length; i++) {
                        if (notas[i] > 3) {
                            JOptionPane.showMessageDialog(null, "La nota " + (i + 1) + " es: " + notas[i]);
                        }
                    }
                    break;
                case 5:
                JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                    salir = true;
                    break;
            
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
    }

}